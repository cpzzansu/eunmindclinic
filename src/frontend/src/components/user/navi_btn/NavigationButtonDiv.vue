<template>
  <div class="navi-btn-div row justify-center">
    <router-link class="link-menu" to="/clinicalDepartments">
      <NavigationButton
        :image-src="'/images/clinical_specialty.png'"
        :navigationButtonTitle="'진료과목'"
      ></NavigationButton>
    </router-link>
    <router-link class="link-menu" to="/clinicalDepartments">
      <NavigationButton
        :image-src="'/images/clinic-time.png'"
        :navigationButtonTitle="'진료시간'"
      ></NavigationButton>
    </router-link>
    <router-link class="link-menu" to="/clinicHours">
      <NavigationButton
        :image-src="'/images/doctors.png'"
        :navigationButtonTitle="'의료진 소개'"
      ></NavigationButton>
    </router-link>
    <router-link class="link-menu" to="/directions">
      <NavigationButton
        :image-src="'/images/come-us.png'"
        :navigationButtonTitle="'오시는 길'"
      ></NavigationButton>
    </router-link>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import NavigationButton from "@/components/user/navi_btn/NavigationButton.vue";

export default defineComponent({
  components: { NavigationButton },
});
</script>
<style scoped>
.navi-btn-div {
  margin-top: 80px;
}
.link-menu {
  text-decoration: none;
}
</style>
