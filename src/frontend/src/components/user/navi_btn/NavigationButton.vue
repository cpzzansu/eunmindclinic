<template>
  <div class="nav-btn">
    <img :src="imageSrc" class="navi-btn-image" />
    <div class="nav-btn-text text-center">{{ navBtnText }}</div>
    <div class="row justify-center">
      <div class="info-more row justify-center items-center">더 알아보기</div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    imageSrc: String,
    navigationButtonTitle: String,
  },
  setup(props) {
    return {
      imageSrc: props.imageSrc,
      navBtnText: props.navigationButtonTitle,
    };
  },
};
</script>
<style scoped>
.nav-btn {
  margin-left: 8px;
  margin-right: 8px;
}
.navi-btn-image {
  width: 280px;
}
.nav-btn-text {
  font-family: "Noto Sans KR";
  font-weight: 700;
  font-size: 36px;
  color: #333333;
  margin-top: 5px;
}
.info-more {
  width: 140px;
  height: 49px;
  border-radius: 22px;
  background-color: #154726;
  color: #ffffff;
  font-size: 16px;
  font-weight: 700;
  font-family: "Noto Sans KR";
  margin-top: 10px;
  margin-bottom: 80px;
}
</style>
