<template>
  <div class="row justify-center">
    <div class="navigation-bar-div col-md-8 row">
      <RouterLink class="menu-link" to="/"
        ><img class="nav-logo" src="/images/big.png"
      /></RouterLink>
      <navi-menu
        linkTo="/greeting"
        menu="인사말"
        :navi-active="isGreeting"
      ></navi-menu>
      <navi-menu
        linkTo="/clinicalDepartments"
        menu="진료과목"
        :navi-active="isClinicalDepartments"
      ></navi-menu>
      <navi-menu
        linkTo="/clinicHours"
        menu="진료시간"
        :navi-active="isClinicHours"
      ></navi-menu>
      <navi-menu
        linkTo="/doctorProfile"
        menu="의료진 소개"
        :navi-active="isDoctorProfile"
      ></navi-menu>
      <navi-menu
        linkTo="/gallery"
        menu="갤러리"
        :navi-active="isGallery"
      ></navi-menu>
      <navi-menu
        linkTo="/notice"
        menu="공지사항"
        :navi-active="isNotice"
      ></navi-menu>
      <navi-menu
        linkTo="/directions"
        menu="오시는 길"
        :navi-active="isDirections"
      ></navi-menu>
      <div class="q-pa-md dropdown-menu-div">
        <q-btn-dropdown
          flat
          round
          icon="menu"
          no-icon-animation
          class="dropdown-menu-btn"
        >
          <q-list>
            <q-item clickable v-close-popup @click="onGreeting">
              <q-item-section>
                <q-item-label>인사말</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup @click="onClinicalDepartments">
              <q-item-section>
                <q-item-label>진료과목</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup @click="onClinicHours">
              <q-item-section>
                <q-item-label>진료시간</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup @click="onDoctorProfile">
              <q-item-section>
                <q-item-label>의료진 소개</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup @click="onGallery">
              <q-item-section>
                <q-item-label>갤러리</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup @click="onNotice">
              <q-item-section>
                <q-item-label>공지사항</q-item-label>
              </q-item-section>
            </q-item>

            <q-item clickable v-close-popup @click="onDirections">
              <q-item-section>
                <q-item-label>오시는 길</q-item-label>
              </q-item-section>
            </q-item>
          </q-list>
        </q-btn-dropdown>
      </div>
      <div v-if="showDropdownMenu" class="dropdown-menu">
        <navi-menu linkTo="/greeting" menu="인사말"></navi-menu>
        <navi-menu linkTo="/clinicalDepartments" menu="진료과목"></navi-menu>
        <navi-menu linkTo="/clinicHours" menu="진료시간"></navi-menu>
        <navi-menu linkTo="/doctorProfile" menu="의료진 소개"></navi-menu>
        <navi-menu linkTo="/gallery" menu="갤러리"></navi-menu>
        <navi-menu linkTo="/notice" menu="공지사항"></navi-menu>
        <navi-menu linkTo="/directions" menu="오시는 길"></navi-menu>
      </div>
    </div>
  </div>
</template>
<script>
import { computed, defineComponent, ref } from "vue";
import NaviMenu from "@/components/user/navi/NaviMenu.vue";
import { useRoute, useRouter } from "vue-router";

export default defineComponent({
  components: { NaviMenu },
  setup() {
    const showDropdownMenu = ref(false);
    const router = useRouter();
    const route = useRoute();
    const isGreeting = computed(() => route.path === "/greeting");
    const isClinicalDepartments = computed(
      () => route.path === "/clinicalDepartments",
    );
    const isClinicHours = computed(() => route.path === "/clinicHours");
    const isDoctorProfile = computed(() =>
      route.path.startsWith("/doctorProfile"),
    );
    const isGallery = computed(() => route.path === "/gallery");
    const isNotice = computed(() => route.path === "/notice");
    const isDirections = computed(() => route.path === "/directions");

    const toggleDropdownMenu = () => {
      showDropdownMenu.value = !showDropdownMenu.value;
    };

    const onGreeting = () => {
      router.push("/greeting");
    };
    const onClinicalDepartments = () => {
      router.push("/clinicalDepartments");
    };
    const onClinicHours = () => {
      router.push("/clinicHours");
    };
    const onDoctorProfile = () => {
      router.push("/doctorProfile");
    };
    const onGallery = () => {
      router.push("/gallery");
    };
    const onNotice = () => {
      router.push("/notice");
    };
    const onDirections = () => {
      router.push("/directions");
    };

    return {
      toggleDropdownMenu,
      showDropdownMenu,
      onGreeting,
      onClinicalDepartments,
      onClinicHours,
      onDoctorProfile,
      onGallery,
      onNotice,
      onDirections,
      isGreeting,
      isClinicalDepartments,
      isClinicHours,
      isDoctorProfile,
      isGallery,
      isNotice,
      isDirections,
    };
  },
});
</script>
<style scoped>
.dropdown-menu-btn {
  display: none;
}
.nav-logo {
  width: 302px;
  margin-right: 90px;
}
.navigation-bar-div {
  height: 99px;
  padding: 0px 50px 1px 50px;
  align-items: center;
  border-radius: 0px 0px 40px 40px;
  background: #faf3e6;
}
.dropdown-menu-btn {
  margin-left: auto;
}
.dropdown-menu-div {
  margin-left: auto;
  padding: 0px;
}

@media (max-width: 1550px) {
  .nav-logo {
    margin-right: 70px;
  }
  .navi-menu {
    font-size: 16px;
  }
  .navigation-bar-div {
    height: 80px;
  }
}
@media (max-width: 1400px) {
  .nav-logo {
    margin-right: 30px;
  }
  .navi-menu {
    font-size: 15px;
  }
  .navigation-bar-div {
    height: 75px;
  }
}
@media (max-width: 1300px) {
  /* 네비게이션 메뉴 숨기기 */
  .navigation-bar-div > .navi-menu {
    display: none;
  }

  /* 드롭다운 버튼 보여주기 */
  .dropdown-menu-btn {
    display: block;
  }
}
@media (max-width: 875px) {
}
@media (max-width: 580px) {
  .nav-logo {
    width: 250px;
    margin-right: 10px;
  }
  .navigation-bar-div {
    padding: 0px 30px;
  }
}
</style>
