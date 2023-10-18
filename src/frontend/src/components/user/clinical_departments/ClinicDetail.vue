<template>
  <div
    :style="{ backgroundImage: `url(${backgroundImage})` }"
    class="clinic-detail column justify-center items-center"
  >
    <div class="clinic-detail-title">{{ detailTitle }}</div>
    <div class="clinic-detail-line"></div>
    <div class="row justify-center">
      <div
        :style="{ whiteSpace: 'pre-line' }"
        class="clinic-detail-content col-9 col-md-8 col-lg-6"
      >
        {{ detailContent }}
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
});
</script>
<style scoped>
.clinic-detail {
  background-size: cover;
  height: 476px;
}
.clinic-detail-title {
  font-size: 35px;
  font-weight: 700;
  color: #154726;
  margin-bottom: 40px;
}
.clinic-detail-line {
  width: 80px;
  height: 1px;
  background: #154726;
  margin-bottom: 45px;
}
.clinic-detail-content {
  font-size: 18px;
  font-weight: 500;
  color: #154726;
}
</style>
