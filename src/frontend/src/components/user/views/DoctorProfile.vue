<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          의료진 소개
        </div>
      </div>
    </div>
    <div class="main-content row justify-center">
      <DoctorProfileNavigation></DoctorProfileNavigation>

      <div v-if="!hasChildRoute" class="doctor-profile-div row col-10 col-md-8">
        <div class="col-4">
          <img src="/images/mask-group.png" style="width: 243px" />
        </div>
        <div class="col-8 column">
          <div class="row">
            <div class="doctor-name">은 헌 정</div>
            <div class="doctor-title">정신건강의학과 원장</div>
          </div>
          <div class="profile-content">
            전북대학교 의과대학 졸업<br />
            전북대학교 대학원 의학석사/의학박사<br />
            건양대학교 대학원 경영학박사<br />
            대전을지병원 인턴수료<br />
            대한민국 육군군의관 복무(예비역 대위)<br />
            예수병원 신경정신과 전공의 수료<br />
            대한민국 의사면허/정신과(정신건강의학과) 전문의<br />
            대한민국 국가유공자(전공상 군경)<br />
            미국 조지아주립대학병원 신경과 임상신경생리학 연수(뇌전증수술, 뇌파,
            수면다원검사)<br />
            미국정신의학회/미국뇌전증학회/국제알츠하이머학회 국제회원 역임<br />
            대한노인정신의학회 노인정신건강인증의<br />
            대한신경정신의학회 경력인정 임상뇌파인증의<br />
            수면다원검사정도관리위원회 수면다원검사 교육이수<br />
            전북대학교 의과대학/의학전문대학원 외래교수 역임, 서남의대 교수
            역임<br />
            대한신경정신의학회 전북지회/한국정신신체의학회/전북노인정신의학회
            회장 역임<br />
            예수병원 임상과장(30년)/대자인병원 진료과장(2년) 재직<br />
            대한뇌전증학회 상임운영위원/한국정신신체의학회
            임상뇌파위원장/대한신경정신의학회 임상뇌파정도관리이사/<br />
            한국수면학회 정보이사/ 사단법인 마음나누리 이사<br />
          </div>
        </div>
      </div>
      <router-view></router-view>
    </div>
    <FooterDiv></FooterDiv>
  </div>
</template>
<script>
import { computed, defineComponent } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import DoctorProfileNavigation from "@/components/user/doctor_profile/DoctorProfileNavigation.vue";
import { useRoute } from "vue-router";

export default defineComponent({
  components: {
    DoctorProfileNavigation,
    NavigationBar,
    NavigationButtonDiv,
    FooterDiv,
  },
  setup() {
    const route = useRoute();

    const hasChildRoute = computed(() => {
      return route.path !== "/doctorProfile";
    });

    return {
      hasChildRoute,
    };
  },
});
</script>
<style scoped>
/* Your CSS styles here */
.main-content {
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
@media (max-width: 580px) {
  .main-banner-div {
    height: 250px;
  }
  .main-banner-sentence {
    margin-top: 46px;
    margin-bottom: 8px;
  }
}
.doctor-name {
  font-size: 40px;
  font-weight: 900;
}
.doctor-profile-div {
  margin-top: 100px;
  margin-bottom: 150px;
  color: #333333;
}
.doctor-title {
  font-size: 24px;
  font-weight: 700;
  margin-left: 20px;
  margin-bottom: 5px;
  display: flex;
  align-items: end;
}
.profile-content {
  margin-top: 35px;
  font-size: 16px;
  font-weight: 400;
  line-height: 26px;
}
</style>
