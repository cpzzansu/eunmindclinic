<template>
  <div class="navi-menu" :class="{ 'navi-active': naviActive }">
    <RouterLink :to="linkTo" class="menu-link">{{ menu }}</RouterLink>
  </div>
</template>
<script setup>
import { defineProps } from "vue";

const props = defineProps({
  menu: String,
  linkTo: String,
  naviActive: Boolean,
});
</script>
<style scoped>
.navi-menu {
  font-family: "Noto Sans KR", "Apple SD Gothic Neo", sans-serif;
  font-size: 18px;
  font-weight: 500;
  margin: 0px auto;
  height: 100%;
  align-items: center;
  display: flex;
}
.navi-active {
  border-top: 2px #154726 solid;
  font-weight: 700;
}
.navi-menu:hover {
  border-top: 2px #154726 solid;
  font-weight: 700;
}
.menu-link {
  text-decoration: none;
  color: #154726;
}
</style>
