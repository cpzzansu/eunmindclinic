<template>
  <div class="column">
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          진료과목
        </div>
      </div>
    </div>
    <div class="main-content">
      <div class="department-name-div row justify-center items-center">
        <department-name :department-name="'정신건강의학과'"></department-name>
        <department-name :department-name="'신경과'"></department-name>
        <department-name :department-name="'내과'"></department-name>
      </div>
      <ClinicDetail
        background-image="/images/clinic-detail.png"
        detail-content="우울증, 불안증, 공황장애, 강박증, 적응장애, 신체형장애, 각 종 스트레스로 인한 정신적 문제, 불면증, 코골이, 수면무호흡증, 각 종 수면장애, 치매, 섬망, 각 종 인지(기억)장애, 지적장애, 노인정신장애, 각 종 기질성정신장애, 조현병, 양극성장애(조울증), 각 종 정신장애, 뇌전증(간질), 알코올 의존/중독, 각 종 중독장애, 두부 손상 후유장애(해)평가, 이명, 두통, 뉴로모듈레이션(신경조절, neuromodulation), 정서조절, 행동조절"
        detail-title="세부 진료 영역"
      ></ClinicDetail>
      <ClinicDetail
        background-image="/images/test-background.png"
        detail-content="야간수면다원검사, 양압기CPAP압력검사, 다중수면잠복기검사(기면증검사), 뇌파검사(일반뇌파, 정량화 분석), 자율신경검사, 심전도 검사, 각 종 척도검사, 치매검사, 임상심리/신경심리검사(외부 의뢰), 임상병리검사(외부기관 의뢰), 영상검사(외부 기관 의뢰)"
        detail-title="진단검사 프로그램"
      ></ClinicDetail>
      <ClinicDetailBox
        background-color="rgba(21, 71, 38, 0.05)"
        background-image="/images/healing-program.png"
        detail-title="치료 프로그램"
        height="209px"
        left-box-content="내용을 입력하세요"
        left-box-title="정신과적 상담(정신치료)"
        right-box-content="내용을 입력하세요"
        right-box-title="약물치료"
      ></ClinicDetailBox>
      <ClinicDetailBox
        background-color="rgba(255, 226, 132, 1)"
        background-image="/images/special-clinic.png"
        detail-title="특수치료"
        height="313px"
        left-box-content="인지행동치료(불면증), 광 치료(일주기리듬장애;시차증후군), 경두개직류자극술(tDCS, 우울증 1차 적용), 가상현실행동치료(사회불안장애,Virtual Reality;VR), 구강내장치(수면무호흡증, 외부기관의뢰)"
        left-box-title="비급여"
        right-box-content="양압기처방(수면무호흡증)-건강보험/의료급여 양압기 임대"
        right-box-title="급여"
      ></ClinicDetailBox>
      <ClinicDetail
        background-image="/images/sleeping-clinic.png"
        detail-content="불면증, 코골이/수면무호흡증, 기면증/과다수면증, 하지불안증후군/주기성 사지운동증, 일주기수면리듬장애(시차증후군), 꿈수면행동장애, 몽유병, 악몽, 야경증, 기타 수면장애, 수면다원검사/다중수면잠복기검사, 양압기 처방전(양압기 임대, 건강보험 적용)"
        detail-title="수면 클리닉"
      ></ClinicDetail>
      <div class="text-center col-10">
        <ClinicDetail
          background-image="/images/healing-program.png"
          detail-content="수면다원검사 소개, 다중수면잠복검사 소개
–추가 내용
건강한 수면을 위한 안내 : 수면위생, 각 종 수면장애 소개, 수면자가측정 시행하기-코골이/무호흡증, 불면증, 수면의 질
-별지 참조—추가 내용"
          detail-title="수면검사"
        ></ClinicDetail>
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
import DepartmentName from "@/components/user/clinical_departments/DepartmentName.vue";
import ClinicDetail from "@/components/user/clinical_departments/ClinicDetail.vue";
import ClinicDetailBox from "@/components/user/clinical_departments/ClinicDetailBox.vue";

export default defineComponent({
  components: {
    ClinicDetailBox,
    ClinicDetail,
    DepartmentName,
    NavigationBar,
    NavigationButtonDiv,
    FooterDiv,
  },
});
</script>
<style scoped>
/* Your CSS styles here */
.main-content {
  margin-bottom: 80px;
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
</style>
