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
          <img :src="currentImage" class="gallery-picture" />
          <div class="navigation-button prev" @click="goToPreviousImage">
            <svg
              fill="none"
              height="80"
              viewBox="0 0 80 80"
              width="80"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M53.5357 71.8212C54.4731 70.8836 54.9997 69.612 54.9997 68.2862C54.9997 66.9604 54.4731 65.6889 53.5357 64.7512L28.7857 40.0012L53.5357 15.2512C54.4465 14.3082 54.9505 13.0452 54.9391 11.7342C54.9277 10.4232 54.4019 9.16916 53.4748 8.24212C52.5478 7.31508 51.2937 6.78924 49.9827 6.77785C48.6717 6.76646 47.4087 7.27043 46.4657 8.18123L18.1807 36.4662C17.2434 37.4039 16.7168 38.6754 16.7168 40.0012C16.7168 41.327 17.2434 42.5986 18.1807 43.5362L46.4657 71.8212C47.4034 72.7586 48.6749 73.2852 50.0007 73.2852C51.3265 73.2852 52.5981 72.7586 53.5357 71.8212Z"
                fill="#333333"
                fill-opacity="0.5"
              />
            </svg>
          </div>
          <div class="navigation-button next" @click="goToNextImage">
            <svg
              fill="none"
              height="68"
              viewBox="0 0 39 68"
              width="39"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M1.46427 2.17877C0.526916 3.11641 0.000339347 4.38795 0.00033929 5.71377C0.000339232 7.03959 0.526916 8.31114 1.46427 9.24877L26.2143 33.9988L1.46427 58.7488C0.553479 59.6918 0.0495083 60.9548 0.060899 62.2658C0.0722896 63.5768 0.598134 64.8308 1.52517 65.7579C2.45221 66.6849 3.70628 67.2108 5.01726 67.2221C6.32825 67.2335 7.59126 66.7296 8.53427 65.8188L36.8193 37.5338C37.7566 36.5961 38.2832 35.3246 38.2832 33.9988C38.2832 32.673 37.7566 31.4014 36.8193 30.4638L8.53427 2.17877C7.59663 1.24142 6.32509 0.714842 4.99927 0.714842C3.67345 0.714842 2.40191 1.24142 1.46427 2.17877Z"
                fill="#333333"
                fill-opacity="0.5"
              />
            </svg>
          </div>
        </div>
      </div>
      <div class="image-list-wrapper row justify-center">
        <div class="image-list col-10 col-md-8">
          <div class="moving-div" :style="{ transform: getTransform() }">
            <div
              v-for="(image, index) in imageList"
              :key="image"
              class="image-item"
              :class="{ selected: isSelected(index) }"
            >
              <img :src="image" />
            </div>
          </div>
        </div>
      </div>
    </div>
    <FooterDiv></FooterDiv>
  </div>
</template>
<script>
import { computed, defineComponent, ref, watch } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";

export default defineComponent({
  components: { NavigationBar, NavigationButtonDiv, FooterDiv },
  setup() {
    const currentImageIndex = ref(0);
    const imageList = ref([
      "/images/picture-example.png",
      "/images/avenue-815297_640.jpg",
      "/images/bird-1045954_640.jpg",
      "/images/bridge-53769_640.jpg",
      "/images/fantasy-2049567_640.jpg",
      "/images/flowers-276014_640.jpg",
      "/images/ocean-3605547_640.jpg",
      "/images/road-1072821_640.jpg",
      "/images/road-1072823_640.jpg",
      "/images/sunset-1373171_640.jpg",
      "/images/tree-736885_1280.jpg",
    ]);

    const goToNextImage = () => {
      if (currentImageIndex.value < imageList.value.length - 1) {
        currentImageIndex.value++;
      }
    };

    const goToPreviousImage = () => {
      if (currentImageIndex.value > 0) {
        currentImageIndex.value--;
      }
    };

    const currentImage = computed(() => {
      return imageList.value[currentImageIndex.value];
    });

    const isSelected = (index) => {
      return index === currentImageIndex.value;
    };

    function getTransform() {
      const imageWidth = 235; // 이미지의 너비 (예: 100px)
      const margin = 10; // 이미지 간의 여백 (예: 10px)
      const totalWidth = imageWidth + margin;

      // 이미지 리스트 전체를 translateX로 움직입니다.
      return `translateX(-${currentImageIndex.value * totalWidth}px)`;
    }

    return {
      imageList,
      currentImageIndex,
      goToNextImage,
      goToPreviousImage,
      currentImage,
      isSelected,
      slide: ref(1),
      getTransform,
    };
  },
});
</script>
<style>
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
.moving-div {
  display: flex;
  transition: transform 0.3s ease-in-out;
  align-items: center;
}
.image-list {
  min-height: 210px;
  display: flex; /* 요소들을 가로로 나열 */
  overflow-x: auto; /* 가로 스크롤 활성화 */
  white-space: nowrap; /* 줄바꿈 방지 */
  padding-bottom: 10px;
}
.image-item img {
  width: 235px;
  margin-right: 10px; /* 이미지 사이의 간격 */
  transition:
    transform 0.4s ease,
    margin-right 0.3s ease;
  border-radius: 2px;
}
.image-item.selected img {
  transform: scale(1.3);
  margin-right: 50px;
  border-radius: 2px;
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
.navigation-button {
  position: absolute; /* 이 속성으로 버튼을 이미지 위에 띄웁니다. */
  top: 50%; /* 버튼을 세로 중앙에 배치합니다. */
  transform: translateY(
    -50%
  ); /* 이것은 버튼의 상단을 기준으로 정렬하는 것이 아니라, 버튼의 중앙을 기준으로 정렬합니다. */
  padding: 10px; /* 버튼의 패딩 */
  cursor: pointer; /* 마우스 포인터를 버튼 위에 올리면 포인터 모양으로 변경됩니다. */
  z-index: 1; /* 이미지 위에 버튼이 올라오도록 z-index 값을 지정합니다. */
}
.custom-carousel .q-carousel__slide {
  height: calc(
    100% - 60px
  ); /* 60px는 썸네일의 예상 높이입니다. 조절이 필요할 수 있습니다. */
}

.custom-carousel .q-carousel__navigation {
  position: absolute;
  bottom: -40px;
  left: 50%;
  transform: translateX(-50%);
}

.prev {
  left: 10px; /* 왼쪽 버튼 위치 지정 */
}

.next {
  right: 10px; /* 오른쪽 버튼 위치 지정 */
}
.custom-carousel-container {
  position: relative;
}

.custom-carousel {
  margin-bottom: 50px; /* 썸네일의 높이와 여백을 고려하여 조절해야 합니다. */
}

.custom-thumbnails {
  display: flex;
  justify-content: center;
  gap: 10px; /* 버튼 간의 간격을 조절합니다. */
}

.custom-thumbnails button {
  padding: 5px 10px;
  cursor: pointer;
  border: none;
  background-color: #ddd;
  transition: background-color 0.3s;

  /* 선택된 썸네일의 스타일을 변경하려면 아래 코드를 사용하십시오. */
  /* &:active, &.active {
      background-color: #bbb;
  } */
}

.custom-thumbnails button:hover {
  background-color: #ccc;
}

@media (max-width: 875px) {
  .image-list-wrapper {
    display: none;
  }
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
