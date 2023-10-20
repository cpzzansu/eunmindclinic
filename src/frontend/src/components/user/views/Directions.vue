<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          오시는 길
        </div>
      </div>
    </div>
    <div class="main-content row justify-center">
      <div class="map-div col-10 col-md-8">
        <img src="/images/map.png" />
      </div>
      <div
        class="col-9 col-md-7 row justify-center"
        style="margin-bottom: 45px"
      >
        <img
          src="/images/footer-logo.png"
          style="width: 60px; height: 60px; margin-right: 25px"
        />
        <div class="col row justify-between q-col-grow">
          <div class="hospital-address-title row items-center">병원 위치</div>
          <div class="clinic-hours-line"></div>
          <div class="hospital-address row items-center">
            전라북도 전주시 완산구 백제대로 271, 3층(수지빌딩), 중화산동 2가
          </div>
        </div>
      </div>
      <div
        class="col-9 col-md-7 row justify-center"
        style="margin-bottom: 150px"
      >
        <div class="row justify-center items-center">
          <img
            src="/images/car.png"
            style="width: 60px; height: 60px; margin-right: 25px"
          />
        </div>
        <div class="col row justify-between q-col-grow">
          <div class="hospital-address-title row items-center">주차 안내</div>
          <div class="clinic-hours-line"></div>
          <div class="parking-info column">
            <div>• 의원 위치(수지빌딩) 뒷편<br /></div>
            <div>
              • 은헌정 정신건강의학과 의원 전용 ⌜어은 주차장⌟위치 활성창, 주차장
              위치 지도<br />
            </div>
            <div>
              • 거동불편자, 휠체어 사용자는 건물 앞 인도에서 접근 시 램프 이용
              가능
            </div>
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
});
</script>
<style scoped>
/* Your CSS styles here */
.main-content {
  margin-top: 100px;
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
.map-div {
  margin-bottom: 60px;
}
.clinic-hours-line {
  width: 1px;
  background-color: #154726;
}
.hospital-address-title {
  font-size: 35px;
  font-weight: 700;
  color: rgba(21, 71, 38, 1);
}
.hospital-address {
  font-size: 23px;
  font-weight: 500;
  color: rgba(21, 71, 38, 1);
}
.parking-info {
  font-size: 20px;
  font-weight: 500;
  color: rgba(21, 71, 38, 1);
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
