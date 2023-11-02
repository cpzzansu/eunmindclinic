<template>
  <div>
    <div class="content-div">
      <h2 style="font-weight: 700">공지사항 관리</h2>
      <div class="row">
        <q-btn :label="numberOfNotice" color="brown-5" />
        <q-btn
          class="addBtn"
          color="primary"
          label="공지사항 추가"
          @click="medium = true"
        />
        <!-- 사진 넣는 input -->
      </div>
    </div>

    <div class="q-pa-md">
      <q-table
        title="게시판"
        :rows="rows"
        :columns="columns"
        row-key="id"
        @row-click="handleRowClick"
      />
    </div>
  </div>
  <q-dialog v-model="medium">
    <q-card style="width: 700px; max-width: 80vw">
      <q-card-section>
        <div class="q-pa-md">
          <div class="text-h6">공지사항 추가</div>
        </div>
      </q-card-section>

      <q-card-section>
        <div class="q-pa-md">
          <input
            v-model="noticeTitle"
            class="notice-title-input"
            placeholder="제목을 입력하세요"
          />
          <div class="row items-center">
            <q-checkbox v-model="noticeCheck" />
            <div>공지 여부</div>
          </div>
        </div>
        <div class="q-pa-md q-gutter-sm">
          <q-editor
            v-model="editor"
            min-height="5rem"
            :toolbar="[
              ['left', 'center', 'right', 'justify'],
              ['bold', 'italic', 'strike', 'underline'],
              [
                {
                  label: $q.lang.editor.formatting,
                  icon: $q.iconSet.editor.formatting,
                  list: 'no-icons',
                  options: ['p', 'h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'code'],
                },
              ],
            ]"
            :placeholder="`공지 내용을 입력하세요.`"
          >
          </q-editor>
        </div>
      </q-card-section>
      <q-card-actions align="right" class="bg-white text-teal">
        <q-btn
          flat
          color="red"
          label="취소"
          v-close-popup
          @click="noticeCancle"
        />
        <q-btn flat label="등록" @click="noticeAdd" />
      </q-card-actions>
    </q-card>
  </q-dialog>
  <q-dialog v-model="modifyModal">
    <q-card style="width: 700px; max-width: 80vw">
      <q-card-section>
        <div class="q-pa-md">
          <div class="text-h6">공지사항 추가</div>
        </div>
      </q-card-section>

      <q-card-section>
        <div class="q-pa-md">
          <input
            v-model="modifyRowTitle"
            class="notice-title-input"
            placeholder="제목을 입력하세요"
          />
          <div class="row items-center">
            <q-checkbox v-model="modifyRowNoticeCheck" />
            <div>공지 여부</div>
          </div>
        </div>
        <div class="q-pa-md q-gutter-sm">
          <q-editor
            v-model="modifyRowContent"
            min-height="5rem"
            :toolbar="[
              ['left', 'center', 'right', 'justify'],
              ['bold', 'italic', 'strike', 'underline'],
              [
                {
                  label: $q.lang.editor.formatting,
                  icon: $q.iconSet.editor.formatting,
                  list: 'no-icons',
                  options: ['p', 'h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'code'],
                },
              ],
            ]"
            :placeholder="`공지 내용을 입력하세요.`"
          >
          </q-editor>
        </div>
      </q-card-section>
      <q-card-actions align="right" class="bg-white text-teal">
        <q-btn
          flat
          color="red"
          label="삭제하기"
          v-close-popup
          @click="noticeDelete"
        />
        <q-btn flat label="수정하기" @click="noticeModify" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>
<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const rows = ref([]);
const numberOfNotice = ref("");
const medium = ref(false);
const editor = ref("");
const noticeTitle = ref("");
const noticeCheck = ref(false);
const router = useRouter();
const modifyModal = ref(false);
const modifyRowTitle = ref("");
const modifyRowContent = ref("");
const modifyRowNoticeCheck = ref(false);

const columns = [
  {
    name: "id",
    label: "번호",
    align: "center",
    field: (row) => row.number,
    format: (val) => `${val}`,
    style: "width: 100px",
  },
  {
    name: "notice_check",
    label: "공지여부",
    align: "center",
    field: (row) => (row.noticeCheck === 1 ? "O" : "X"),
    format: (val) => `${val}`,
    style: "width: 100px",
  },
  {
    name: "notice_board_title",
    label: "제목",
    align: "left",
    field: "noticeBoardTitle",
  },
  {
    name: "regist_date",
    label: "날짜",
    align: "center",
    field: "registDate",
    style: "width: 130px",
  },
  {
    name: "view_count",
    label: "조회",
    align: "center",
    field: "viewCount",
    style: "width: 100px",
  },
];

onMounted(async () => {
  const response = await axios.get("/noticeBoardList");
  let number = 1;

  response.data.forEach((item) => {
    item.registDate = item.registDate.split("T")[0];
  });

  rows.value = Object.keys(response.data).map((key) => {
    return { ...response.data[key], number: number++ }; // 새로운 객체를 생성하여 반환
  });

  rows.value.reverse();

  numberOfNotice.value = "게시글 수 : " + rows.value.length;
});

const noticeCancle = () => {
  editor.value = "";
  noticeTitle.value = "";
};

const noticeAdd = async () => {
  const data = {
    noticeBoardTitle: noticeTitle.value,
    noticeBoardContent: editor.value,
    noticeCheck: noticeCheck.value === false ? 0 : 1,
  };

  const token = localStorage.getItem("accessToken");
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.post("/noticeAdd", data);
      if (response.status === 200) {
        router.go(0);
      }
    } catch (error) {
      console.log(error);
    }
  } else {
    alert("로그인이 필요한 기능입니다.");
  }
};

const modifyRowId = ref("");
const handleRowClick = (event, row) => {
  modifyRowTitle.value = row.noticeBoardTitle;
  modifyRowContent.value = row.noticeBoardContent;
  modifyRowNoticeCheck.value = row.noticeCheck === 1 ? true : false;
  modifyRowId.value = row.id;

  modifyModal.value = true;
};

const noticeModify = async () => {
  const data = {
    id: Number(modifyRowId.value),
    noticeBoardTitle: modifyRowTitle.value,
    noticeBoardContent: modifyRowContent.value,
    noticeCheck: modifyRowNoticeCheck.value === true ? 1 : 0,
  };

  const token = localStorage.getItem("accessToken");
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      console.log(data);
      const response = await axios.post("/noticeModify", data);
      if (response.status === 200) {
        router.go(0);
      }
    } catch (error) {
      console.log(error);
    }
  } else {
    alert("로그인이 필요한 기능입니다.");
  }
  s;
};
</script>
<style scoped>
.content-div {
  margin: 30px;
  font-weight: 700;
  color: #333333;
}
.addBtn {
  margin-left: auto;
}
.q-editor {
  border: none;
  color: #333333;
}
.notice-title-input {
  border: none;
  color: #333333;
  font-size: 25px;
  width: 100%;
  margin-bottom: 15px;
}
.notice-title-input:focus {
  outline: none;
}
</style>
