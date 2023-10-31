<template>
  <div class="row justify-center col-12">
    <div class="notice-detail-div col-10 col-md-8">
      <div class="row notice-title-div">
        <div class="notice-number">{{ rowData.number }}</div>
        <div class="notice-title">{{ rowData.noticeBoardTitle }}</div>
        <div class="notice-regist-date justify-end">
          {{ rowData.registDate }}
        </div>
      </div>
      <div class="notice-content" v-html="rowData.noticeBoardContent" />
    </div>
  </div>
</template>
<script setup>
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import axios from "axios";
import { useStore } from "vuex";

const route = useRoute();
const store = useStore();
const rowData = ref({});

onMounted(async () => {
  const rowId = route.params.id;
  try {
    const response = await axios.get(`/noticeBoardDetail?id=${rowId}`);
    response.data.number = sessionStorage.getItem("number");

    rowData.value = response.data;
  } catch (error) {
    console.error("Error fetching notice board detail:", error);
  }
});
</script>
<style scoped>
.notice-title-div {
  background-color: rgba(240, 246, 242, 1);
  border-top: 3px rgba(20, 148, 115, 1) solid;
  height: 62px;
}
.notice-detail-div {
  font-size: 18px;
  font-weight: 500;
  border: 1px rgba(240, 246, 242, 1) solid;
  color: #333333;
}
.notice-number {
  display: flex;
  width: 130px;
  justify-content: center;
  align-items: center;
}
.notice-title {
  flex-grow: 1;
  display: flex;
  width: 130px;
  padding-left: 30px;
  justify-content: left;
  align-items: center;
}
.notice-regist-date {
  display: flex;
  width: 200px;
  justify-content: center;
  align-items: center;
  font-weight: 400;
  color: rgba(51, 51, 51, 0.5);
}
.notice-content {
  padding: 50px;
  color: #333333;
}
</style>
