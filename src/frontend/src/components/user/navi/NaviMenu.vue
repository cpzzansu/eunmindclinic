<template>
  <div class="navi-menu">
    <RouterLink :to="linkTo" class="menu-link">{{ menu }}</RouterLink>
  </div>
</template>
<script setup>
import { defineProps } from "vue";

const props = defineProps({
  menu: String,
  linkTo: String,
});
</script>
<style scoped>
.navi-menu {
  font-family: "Noto Sans KR", "Apple SD Gothic Neo", sans-serif;
  font-size: 18px;
  font-weight: 500;
  margin-left: auto;
  margin-right: auto;
}
.menu-link {
  text-decoration: none;
  color: #154726;
}
</style>
