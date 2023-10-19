<template>
  <div class="profile-btn-div row col-12 justify-center">
    <RouterLink class="menu-link" to="/doctorProfile">
      <div class="info-more row justify-center items-center">약 력</div>
    </RouterLink>
    <RouterLink class="menu-link" to="/doctorProfile/academicActivities">
      <div class="info-more-second row justify-center items-center">
        학회활동
      </div>
    </RouterLink>
    <RouterLink class="menu-link" to="/doctorProfile/academicPublication">
      <div class="info-more-second row justify-center items-center">논 문</div>
    </RouterLink>
  </div>
</template>
<script></script>
<style scoped>
.info-more {
  width: 140px;
  height: 49px;
  border-radius: 22px;
  background-color: #154726;
  color: #ffffff;
  font-size: 16px;
  font-weight: 700;
  margin: 10px 15px;
}
.info-more-second {
  width: 140px;
  height: 49px;
  border-radius: 22px;
  background-color: rgba(21, 71, 38, 0.05);
  color: #154726;
  font-size: 16px;
  font-weight: 700;
  margin: 10px 15px;
}
.profile-btn-div {
  margin-top: 100px;
}
.menu-link {
  text-decoration: none;
}
</style>
