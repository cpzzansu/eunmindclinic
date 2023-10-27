<template>
  <q-layout view="hHh lpR fFf">
    <q-header class="main-header text-white" elevated height-hint="98">
      <q-toolbar>
        <q-btn dense flat icon="menu" round @click="toggleLeftDrawer" />

        <q-toolbar-title>
          <q-avatar>
            <img src="/images/logo-small.png" />
          </q-avatar>
          은헌정 정신건강의원 관리 페이지
        </q-toolbar-title>
      </q-toolbar>

      <q-tabs align="left">
        <q-route-tab label="Page One" to="/page1" />
        <q-route-tab label="Page Two" to="/page2" />
        <q-route-tab label="Page Three" to="/page3" />
      </q-tabs>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" bordered show-if-above side="left">
      <!-- drawer content -->
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import { ref } from "vue";

export default {
  setup() {
    const leftDrawerOpen = ref(false);

    return {
      leftDrawerOpen,
      toggleLeftDrawer() {
        leftDrawerOpen.value = !leftDrawerOpen.value;
      },
    };
  },
};
</script>
<style>
.main-header {
  background-image: url("/images/main-banner.png");
}
</style>
