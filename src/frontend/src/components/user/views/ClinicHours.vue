<template>
  <div class="column">
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          진료시간 안내
        </div>
      </div>
    </div>
    <div class="main-content">
      <div class="clinic-hours-div row justify-center">
        <div class="first-clinic-hours col-10 col-md-8 row items-center">
          <img class="clock-img" src="/images/clock.png" />
          <div class="clinic-hours-time row justify-between col q-col-grow">
            <div class="clinic-hours-title">진료시간<br />안내</div>
            <div class="clinic-hours-line"></div>
            <div class="clinic-hours-time-div q-pa-md column">
              <div class="row">
                <div class="clinic-hours-bold-text column">
                  <div>월요일-목요일</div>
                </div>
                <div class="clinic-hours-medium-text">
                  <div class="row">
                    <div>오전 8시30분 - 오후 6시30분</div>
                    <div>| 공휴일, 국경일 휴무</div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="clinic-hours-bold-text column">
                  <div>점심식사 시간</div>
                </div>
                <div class="clinic-hours-medium-text">
                  <div>오후 1시 - 2시</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <ClinicHoursTable></ClinicHoursTable>
        <div class="row justify-center clinic-phone-div col-10 col-md-8">
          <img src="images/phone.png" style="width: 350px; margin: 10px 10px" />
          <img src="images/fax.png" style="width: 350px; margin: 10px 10px" />
          <img
            src="images/reservation.png"
            style="width: 350px; margin: 0px 10px"
          />
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
import DepartmentName from "@/components/user/clinical_departments/DepartmentName.vue";
import ClinicDetail from "@/components/user/clinical_departments/ClinicDetail.vue";
import ClinicDetailBox from "@/components/user/clinical_departments/ClinicDetailBox.vue";
import ClinicHoursTable from "@/components/user/clinic_hours/ClinicHoursTable.vue";

export default defineComponent({
  components: {
    ClinicHoursTable,
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
.clinic-hours-div {
  margin-top: 150px;
}
.clinic-hours-title {
  font-weight: 700;
  font-size: 35px;
  color: #154726;
}
.clinic-hours-line {
  width: 1px;
  background-color: #154726;
}
.clinic-hours-bold-text {
  font-size: 23px;
  font-weight: 700;
  margin-top: 5px;
  margin-bottom: 5px;
  color: #154726;
}
.clinic-hours-medium-text {
  font-size: 23px;
  font-weight: 500;
  margin-top: 5px;
  margin-bottom: 5px;
  margin-left: 25px;
  color: #154726;
}
.first-clinic-hours {
  margin-bottom: 80px;
}
.clinic-phone-div {
  margin-top: 80px;
  margin-bottom: 180px;
}
.clinic-hours-time-div{
  padding: 16px 0px;
}
.clock-img{
  margin-right: 50px;
}
@media (max-width: 1440px) {
  .clinic-hours-div {
    margin-top: 130px;
  }
}
@media (max-width: 1300px) {
  .clinic-hours-div {
    margin-top: 100px;
  }
}
@media (max-width: 1100px) {
  .clinic-hours-div {
    margin-top: 80px;
  }
}
@media (max-width: 875px) {
  .clinic-hours-div {
    margin-top: 60px;
  }
}
@media (max-width: 580px) {
  .clinic-hours-div {
    margin-top: 50px;
  }
  .main-banner-div {
    height: 250px;
  }
  .main-banner-sentence {
    margin-top: 46px;
    margin-bottom: 8px;
  }
}
</style>
