<template>
  <div
    :style="{ backgroundImage: `url(${backgroundImage})` }"
    class="clinic-detail row justify-center items-center"
  >
    <div class="clinic-detail-title text-center col-12">{{ detailTitle }}</div>
    <div class="col-12 row justify-center">
      <div class="clinic-detail-line text-center"></div>
    </div>
    <div class="box-div row justify-center">
      <div
        :style="{ backgroundColor: `${backgroundColor}`, height: `${height}` }"
        class="clinic-detail-box column justify-center items-center"
      >
        <div class="box-title text-center">{{ leftBoxTitle }}</div>
        <div class="box-content">{{ leftBoxContent }}</div>
      </div>
      <div
        :style="{ backgroundColor: `${backgroundColor}`, height: `${height}` }"
        class="clinic-detail-box column justify-center items-center"
      >
        <div class="box-title text-center">{{ rightBoxTitle }}</div>
        <div class="box-content">{{ rightBoxContent }}</div>
      </div>
    </div>
  </div>
</template>
<script setup>
import { defineProps } from "vue";

const props = defineProps({
  detailTitle: String,
  detailContent: String,
  backgroundImage: String,
  backgroundColor: String,
  leftBoxTitle: String,
  leftBoxContent: String,
  rightBoxTitle: String,
  rightBoxContent: String,
  height: String,
});
</script>
<style scoped>
.clinic-detail {
  background-size: cover;
}
.clinic-detail-title {
  font-size: 35px;
  font-weight: 700;
  margin-top: 60px;
  margin-bottom: 40px;
  color: #154726;
}
.clinic-detail-line {
  width: 80px;
  height: 1px;
  background: #154726;
  margin-bottom: 45px;
}
.clinic-detail-box {
  width: 460px;

  border-radius: 30px;
  margin: 10px 20px;
}
.box-div {
  margin-bottom: 60px;
}
.box-title {
  font-size: 30px;
  font-weight: 700;
  margin-bottom: 35px;
  color: rgba(21, 71, 38, 1);
}
.box-content {
  font-size: 18px;
  font-weight: 500;
  color: rgba(21, 71, 38, 1);
  margin-left: 55px;
  margin-right: 55px;
}
</style>
