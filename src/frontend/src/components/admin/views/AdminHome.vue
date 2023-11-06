<template>
  <q-layout view="hHh lpR fFf">
    <q-header class="main-header text-white" elevated height-hint="98">
      <q-toolbar>
        <q-btn dense flat icon="menu" round @click="toggleLeftDrawer" />

        <q-toolbar-title class="main-font" @click="toAdmainHome">
          <q-avatar>
            <img src="/images/logo-small.png" />
          </q-avatar>
          은헌정 정신건강의원 관리 페이지
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" bordered show-if-above side="left">
      <!-- drawer content -->
      <q-scroll-area class="fit drawer-menu flex flex-column">
        <div class="flex-auto">
          <q-item class="drawer-item" v-ripple clickable @click="gallery">
            <q-item-section avatar>
              <q-icon />
            </q-item-section>
            <q-item-section> 갤러리 관리 </q-item-section>
          </q-item>
          <q-item v-ripple clickable @click="notice">
            <q-item-section avatar>
              <q-icon />
            </q-item-section>
            <q-item-section> 공지사항 관리 </q-item-section>
          </q-item>
          <q-item v-ripple clickable @click="member">
            <q-item-section avatar>
              <q-icon />
            </q-item-section>
            <q-item-section> 계정 관리 </q-item-section>
          </q-item>
        </div>

        <q-item v-ripple clickable @click="logout">
          <q-item-section avatar>
            <q-icon />
          </q-item-section>
          <q-item-section> 로그아웃 </q-item-section>
        </q-item>
      </q-scroll-area>
    </q-drawer>
    <q-page-container>
      <router-view />
      <div v-if="isAtAdminHome">
        <div class="content-div">
          <h3 style="font-weight: 700">관리자 페이지입니다.</h3>
          <div class="main-content row justify-start">
            <div class="q-pa-md col-5">
              <div class="q-gutter-y-md column">
                <q-input
                  v-model="memberId"
                  class="member-id-input"
                  label="아이디"
                  readonly
                  outlined
                />
                <q-input
                  v-model="memberEmail"
                  class="member-id-input"
                  label="이메일"
                  outlined
                />
                <q-btn
                  label="email 변경"
                  outline
                  style="color: #149473; height: 50px; margin-bottom: 10px"
                  @click="changeEmail"
                />
              </div>
            </div>
          </div>
        </div>
      </div>
    </q-page-container>
  </q-layout>
</template>

<script>
import { computed, onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

export default {
  setup() {
    const router = useRouter();
    const route = useRoute();
    const memberId = ref("");
    const memberEmail = ref("");

    const leftDrawerOpen = ref(false);
    const isAtAdminHome = computed(() => route.path === "/adminHome");

    const gallery = () => {
      router.push("/adminHome/gallery");
    };

    const notice = () => {
      router.push("/adminHome/notice");
    };

    const member = () => {
      router.push("/adminHome/member");
    };

    const logout = () => {
      localStorage.removeItem("accessToken");
      router.push("/admin");
    };

    const toAdmainHome = () => {
      router.push("/adminHome");
    };

    onMounted(async () => {
      memberId.value = sessionStorage.getItem("memberId");

      const response = await axios.get("/getMember", {
        params: {
          username: memberId.value,
        },
      });

      memberEmail.value = response.data.email;
    });

    const changeEmail = () => {};

    return {
      leftDrawerOpen,
      toggleLeftDrawer() {
        leftDrawerOpen.value = !leftDrawerOpen.value;
      },
      gallery,
      notice,
      member,
      logout,
      isAtAdminHome,
      toAdmainHome,
      memberId,
      memberEmail,
      changeEmail,
    };
  },
};
</script>
<style scoped>
.main-header {
  background-image: url("/images/main-banner.png");
  height: 100px;
  padding-top: 20px;
}
.main-font {
  font-size: 40px;
  font-weight: 700;
  cursor: pointer;
}
.drawer-menu {
  font-size: 18px;
  font-weight: 700;
  color: #333333;
}
.drawer-item {
  margin-top: 10px;
}
.content-div {
  margin: 30px;
  font-weight: 700;
  color: #333333;
}
</style>
