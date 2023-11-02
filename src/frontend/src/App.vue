<template>
  <q-layout view="hHh lpR fFf">
    <page-container>
      <router-view />
    </page-container>
  </q-layout>
</template>

<script>
export default {
  components: {},
  setup() {
    return {};
  },
};
</script>
<style>
body {
  font-family: "Noto Sans KR", "Apple SD Gothic Neo", sans-serif;
}
.q-btn-dropdown .q-btn-dropdown__arrow {
  display: none;
}
.dropdown-menu-btn .q-btn-dropdown__arrow {
  display: none;
}
</style>
