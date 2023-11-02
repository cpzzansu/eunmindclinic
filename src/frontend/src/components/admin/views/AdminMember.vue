<template>
  <div>
    <div class="content-div">
      <h2 style="font-weight: 700">계정 관리</h2>
      <div class="row">
        <q-btn :label="numberOfRequestMember" color="red-5" />
      </div>
    </div>

    <div class="q-pa-md">
      <q-table
        title="계정 현황"
        :rows="rows"
        :columns="columns"
        row-key="id"
        @row-click="handleRowClick"
      />
    </div>
  </div>
  <q-dialog v-model="modifyModal">
    <q-card style="width: 700px; max-width: 80vw">
      <q-card-section>
        <div class="q-pa-md">
          <div class="text-h5">계정관리</div>
        </div>
      </q-card-section>
      <q-card-section>
        <div class="q-pa-md">
          <div class="text-h6">아이디 : {{ modifyUsername }}</div>
        </div>
        <div class="q-pa-md" style="max-width: 300px">
          <div class="q-gutter-md">
            <q-select
              outlined
              v-model="modifyRole"
              :options="roleSelectOption"
              label="계정 권한"
            />
          </div>
        </div>
      </q-card-section>
      <q-card-actions align="right" class="bg-white text-teal">
        <q-btn
          flat
          color="red"
          label="삭제하기"
          v-close-popup
          @click="deleteRole"
        />
        <q-btn flat label="수정하기" @click="roleModify" />
      </q-card-actions>
    </q-card>
  </q-dialog>
  <div class="q-pa-md q-gutter-sm">
    <q-dialog v-model="confirm" persistent>
      <q-card>
        <q-card-section class="row items-center">
          <span class="q-ml-sm">{{ modifyRole }} 권한을 부여하시겠습니까?</span>
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="아니오" color="primary" v-close-popup />
          <q-btn flat label="예" color="primary" @click="confirmYes" />
        </q-card-actions>
      </q-card>
    </q-dialog>
    <q-dialog v-model="deleteConfirm" persistent>
      <q-card>
        <q-card-section class="row items-center">
          <span class="q-ml-sm"
            >{{ modifyUsername }} 계정을 정말로 삭제하시겠습니까?</span
          >
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="아니오" color="primary" v-close-popup />
          <q-btn flat label="예" color="primary" @click="deleteMember" />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </div>
</template>
<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const rows = ref([]);
const numberOfRequestMember = ref("");

const router = useRouter();
const modifyModal = ref(false);
const confirm = ref(false);
const deleteConfirm = ref(false);

const modifyId = ref(0);
const modifyUsername = ref("");
const modifyRole = ref("");

const roleSelectOption = ref(["권한 없음", "관리자"]);

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
    name: "userName",
    label: "아이디",
    align: "center",
    field: "username",
  },
  {
    name: "name",
    label: "이름",
    align: "center",
    field: "name",
  },
  {
    name: "email",
    label: "이메일",
    align: "center",
    field: "email",
  },
  {
    name: "role",
    label: "계정 권한",
    align: "center",
    field: (row) => (row.role === null ? "권한 요청 중" : "관리자"),
    style: "width: 100px",
  },
];

onMounted(async () => {
  const token = localStorage.getItem("accessToken");
  let requestMember = null;
  let number = 1;
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.get("/getMemberList");
      console.log(response.data);
      requestMember = response.data.filter((key) => key.role === null);
      rows.value = response.data.map((obj, index) => ({
        ...obj,
        number: index + 1,
      }));

      console.log(rows.value[0].number);
    } catch (error) {
      console.log(error);
    }
  } else {
    alert("로그인이 필요한 기능입니다.");
  }

  numberOfRequestMember.value = "회원가입 요청 수 : " + requestMember.length;
});

const handleRowClick = (event, row) => {
  const role = row.role;
  if (role === null) {
    modifyRole.value = "권한 없음";
  } else {
    modifyRole.value = "관리자";
  }
  modifyUsername.value = row.username;
  modifyId.value = row.id;

  modifyModal.value = true;
};

const roleModify = () => {
  confirm.value = true;
};

const confirmYes = async () => {
  const data = {
    id: Number(modifyId.value),
    role: modifyRole.value === "권한 없음" ? null : "ADMIN",
  };

  const token = localStorage.getItem("accessToken");
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.post("/memberRoleChange", data);

      router.go(0);
    } catch (error) {
      console.log(error);
    }
  } else {
    alert("로그인이 필요한 기능입니다.");
  }
};

const deleteRole = () => {
  deleteConfirm.value = true;
};

const deleteMember = async () => {
  const token = localStorage.getItem("accessToken");
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.delete("/memberDelete", {
        params: { id: Number(modifyId.value) },
      });

      router.go(0);
    } catch (error) {
      console.log(error);
    }
  } else {
    alert("로그인이 필요한 기능입니다.");
  }
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
