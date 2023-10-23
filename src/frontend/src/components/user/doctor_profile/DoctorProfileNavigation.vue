<template>
  <div class="profile-btn-div row col-12 justify-center">
    <RouterLink class="menu-link" to="/doctorProfile">
      <div class="info-more row justify-center items-center" :class="{'active-link': $route.path === '/doctorProfile'}">약 력</div>
    </RouterLink>
    <RouterLink class="menu-link" to="/doctorProfile/academicActivities" v-slot="{isActive}">
      <div class="info-more row justify-center items-center" :class="{'active-link': isActive}">
        학회활동
      </div>
    </RouterLink>
    <RouterLink class="menu-link" to="/doctorProfile/academicPublication" v-slot="{isActive}">
      <div class="info-more row justify-center items-center" :class="{'active-link': isActive}">논 문</div>
    </RouterLink>
  </div>
</template>
<script></script>
<style scoped>
.active-link.info-more{
  background-color: #154726;
  color: #ffffff;
}
.info-more{
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
