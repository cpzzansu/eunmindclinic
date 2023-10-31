<template>
  <div class="content-div">
    <h2 style="font-weight: 700">갤러리 관리</h2>
    <div class="row">
      <q-btn :label="numberOfGallerys" color="brown-5" />
      <q-btn
        class="addBtn"
        color="primary"
        label="사진추가"
        @click="galleryAdd"
      />
      <!-- 사진 넣는 input -->
      <input
        ref="fileInput"
        style="display: none"
        type="file"
        @change="galleryUpload"
      />
    </div>
    <div class="q-pa-md">
      <q-table
        :columns="columns"
        :filter="filter"
        :rows="rows"
        bordered
        flat
        grid
        hide-header
        hide-pagination
        row-key="name"
        title="Gallerys"
      >
        <!-- 이미지를 렌더링하기 위한 슬롯 -->
        <template v-slot:item="props">
          <q-card>
            <q-card-section>
              <!-- 이미지를 렌더링하는 부분 -->
              <q-img
                :src="props.row.imageSourcePath"
                alt="Image"
                style="width: 250px"
              />
              <div class="q-mt-md row justify-end">
                <q-btn label="수정" @click="handleEdit(props.row)" />
                <q-btn
                  color="negative"
                  label="삭제"
                  @click="handleDelete(props.row.id)"
                />
              </div>
            </q-card-section>
            <!-- 필요한 경우 여기에 추가적인 카드 섹션 또는 다른 내용을 추가할 수 있습니다 -->
          </q-card>
        </template>
      </q-table>
    </div>
  </div>
  <q-dialog v-model="card">
    <q-card class="my-card" style="width: 700px; max-width: 80vw">
      <q-img :src="modifyImage" />

      <q-card-section class="row">
        <q-btn
          color="white"
          label="이미지 선택"
          text-color="black"
          @click="modifyInputClick"
        />
        <q-btn
          class="modify-btn"
          color="deep-orange"
          label="수정하기"
          @click="galleryModify"
        />
        <input
          ref="modifyInput"
          style="display: none"
          type="file"
          @change="modifyInputChange"
        />
      </q-card-section>

      <q-separator />
    </q-card>
  </q-dialog>
</template>
<script setup>
import { computed, onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const galleryImages = ref([]);
const numberOfGallerys = ref("");
const router = useRouter();
const card = ref(false);

// 사진 input 변수
const fileInput = ref(null);

// 사진 추가 버튼 클릭 함수
const galleryAdd = () => {
  fileInput.value.click();
};
// 갤러리 사진 업로드 함수
const galleryUpload = async (event) => {
  const formData = new FormData();
  const file = event.target.files[0];
  formData.append("file", file);

  const token = localStorage.getItem("accessToken");
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.post("/galleryAdd", formData);
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

onMounted(async () => {
  const token = localStorage.getItem("accessToken");

  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.get("/getGallery");
      const databaseImageLists = [];
      const number = response.data.length;
      numberOfGallerys.value = `총 사진 수 : ${number}`;
      response.data.forEach((data) => {
        databaseImageLists.push(data);
      });

      galleryImages.value = databaseImageLists;
    } catch (error) {
      console.log(error);
    }
  } else {
    alert("로그인이 필요한 기능입니다.");
  }
});
const rows = computed(() => galleryImages.value);
const columns = [
  {
    name: "desc",
    required: true,
    label: "이미지",
    field: (row) => row.imageSourcePath,
    sortable: true,
  },
  {
    name: "calories",
    align: "center",
    label: "Calories",
    field: "calories",
    sortable: true,
  },
  { name: "fat", label: "Fat (g)", field: "fat", sortable: true },
  { name: "carbs", label: "Carbs (g)", field: "carbs" },
];

const modifyImage = ref("");
const modifyInput = ref(null);
const modifyId = ref("");

const modifyInputChange = (event) => {
  const file = event.target.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = (e) => {
      modifyImage.value = e.target.result;
    };
    reader.readAsDataURL(file);
  }
};

const modifyInputClick = () => {
  modifyInput.value.click();
};

const handleEdit = (row) => {
  modifyImage.value = row.imageSourcePath;
  modifyId.value = row.id;
  card.value = true;
};

const handleDelete = async (id) => {
  const token = localStorage.getItem("accessToken");
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.delete("/deleteGallery", {
        params: { id: id },
      });
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

const galleryModify = async () => {
  const file = modifyInput.value.files[0];
  const id = modifyId.value;

  const formData = new FormData();
  formData.append("file", file);
  formData.append("id", id);
  console.log(file);
  if (file === undefined) {
    alert("이미지가 선택되지 않았습니다. 이미지를 선택 후 다시 시도해주세요.");
    return;
  }

  const token = localStorage.getItem("accessToken");
  if (token) {
    try {
      axios.defaults.headers.common["Authorization"] = `Bearer ${token}`;
      const response = await axios.put("/modifyGallery", formData);
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
.modify-btn {
  margin-left: auto;
}
</style>
