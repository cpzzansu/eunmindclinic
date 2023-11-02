<template>
  <q-layout view="hHh lpR fFf">
    <q-header class="main-header text-white" elevated height-hint="98">
      <q-toolbar>
        <q-btn dense flat icon="menu" round @click="toggleLeftDrawer" />

        <q-toolbar-title class="main-font">
          <q-avatar>
            <img src="/images/logo-small.png" />
          </q-avatar>
          은헌정 정신건강의원 관리 페이지
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" bordered show-if-above side="left">
      <!-- drawer content -->
      <q-scroll-area class="fit drawer-menu">
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
      </q-scroll-area>
    </q-drawer>
    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import { ref } from "vue";
import { useRouter } from "vue-router";

export default {
  setup() {
    const router = useRouter();

    const leftDrawerOpen = ref(false);

    const gallery = () => {
      router.push("/adminHome/gallery");
    };

    const notice = () => {
      router.push("/adminHome/notice");
    };

    const member = () => {
      router.push("/adminHome/member");
    };

    return {
      leftDrawerOpen,
      toggleLeftDrawer() {
        leftDrawerOpen.value = !leftDrawerOpen.value;
      },
      gallery,
      notice,
      member,
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
}
.drawer-menu {
  font-size: 18px;
  font-weight: 700;
  color: #333333;
}
.drawer-item {
  margin-top: 10px;
}
</style>
