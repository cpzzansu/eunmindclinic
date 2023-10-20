<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          병원 갤러리
        </div>
      </div>
    </div>
    <div class="main-content">
      <div class="gallery-title row justify-center col-10 col-md-8">
        병원 갤러리
      </div>
      <div class="gallery-sub-title row justify-center col-10 col-md-8">
        사진으로 은헌정 정신건강의학과의원을 미리 둘러보실 수 있습니다.
      </div>
      <div class="row justify-center">
        <div class="gallery-picture-div col-10 col-md-8">
          <img class="gallery-picture" src="/images/picture-example.png" />
        </div>
      </div>
      <div class="image-list-wrapper row justify-center">
        <div class="image-list col-10 col-md-8">
          <div v-for="image in imageList" :key="image" class="image-item">
            <img :src="image" />
          </div>
        </div>
      </div>
    </div>
    <FooterDiv></FooterDiv>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";

export default defineComponent({
  components: { NavigationBar, NavigationButtonDiv, FooterDiv },
  setup() {
    const image = "/images/picture-example.png";
    const imageList = [
      image,
      image,
      image,
      image,
      image,
      image,
      image,
      image,
      image,
      image,
      image,
    ];
    return {
      imageList,
    };
  },
});
</script>
<style scoped>
/* Your CSS styles here */
.main-content {
  margin-top: 100px;
  color: #333333;
}
.main-banner-sentence {
  font-weight: 700;
  font-size: 38px;
  color: #ffffff;
  margin-top: 85px;
  margin-bottom: 27px;
}
.main-banner-div {
  background-image: url("/images/main-banner.png");
  background-position: center;
  background-size: cover;
  height: 330px;
}
.gallery-title {
  font-size: 35px;
  font-weight: 700;
  margin-bottom: 15px;
}
.gallery-sub-title {
  font-size: 20px;
  font-weight: 500;
  margin-bottom: 100px;
  margin-left: 20px;
  margin-right: 20px;
}
.gallery-picture-div {
  position: relative;
  /* 비율에 따라 높이를 조정하고 싶다면 아래의 padding-bottom 값을 조정하세요.
     예를 들어, 16:9 비율이면 56.25%로 설정. */
  margin-bottom: 50px;
  overflow: hidden;
}
.gallery-picture {
  width: 100%;
}
.image-list {
  display: flex; /* 요소들을 가로로 나열 */
  overflow-x: auto; /* 가로 스크롤 활성화 */
  white-space: nowrap; /* 줄바꿈 방지 */
  padding-bottom: 10px;
}
.image-item img {
  max-height: 132px; /* 높이 제한 (원하시는대로 조절 가능) */
  margin-right: 10px; /* 이미지 사이의 간격 */
}
.image-list-wrapper {
  overflow: hidden;
  margin-bottom: 123px;
}
.image-list::-webkit-scrollbar {
  height: 7px;
}
.image-list::-webkit-scrollbar-track {
  margin-top: 15px;
}
.image-list::-webkit-scrollbar-thumb {
  background: rgba(217, 217, 217, 1);
  border-radius: 10px;
}

@media (max-width: 580px) {
  .main-banner-div {
    height: 250px;
  }
  .main-banner-sentence {
    margin-top: 46px;
    margin-bottom: 8px;
  }
}
</style>
