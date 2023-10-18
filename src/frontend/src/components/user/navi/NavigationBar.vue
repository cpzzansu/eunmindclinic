<template>
  <div class="row justify-center">
    <div class="navigation-bar-div col-md-8 row">
      <img class="nav-logo" src="/images/big.png" />
      <navi-menu></navi-menu>
      <navi-menu></navi-menu>
      <navi-menu></navi-menu>
      <navi-menu></navi-menu>
      <navi-menu></navi-menu>
      <navi-menu></navi-menu>
      <navi-menu></navi-menu>
    </div>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import NaviMenu from "@/components/user/navi/NaviMenu.vue";

export default defineComponent({
  components: { NaviMenu },
});
</script>
<style scoped>
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
</style>
