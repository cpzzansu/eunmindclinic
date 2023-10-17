<template>
  <div class="footer-div row items-center justify-center">
    <footer-info></footer-info>
  </div>
</template>
<script>
import { defineComponent } from "vue";
import FooterInfo from "@/components/user/footer/FooterInfo.vue";

export default defineComponent({
  components: { FooterInfo },
});
</script>
<style>
.footer-div {
  height: 280px;
  background-color: #149473;
}
</style>
