<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence row items-center justify-center">
          공지사항
        </div>
      </div>
    </div>
    <div class="detail-content row justify-center">
      <div class="row col-10 col-md-8 justify-end">
        <div class="to-list-div">
          <RouterLink to="/notice" class="to-list">목록</RouterLink>
        </div>
      </div>

      <Detail></Detail>
    </div>
    <FooterDiv></FooterDiv>
  </div>
</template>
<script>
import { defineComponent, ref } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import NoticeTable from "@/components/user/notice/NoticeTable.vue";
import Detail from "@/components/user/notice/Detail.vue";

export default defineComponent({
  components: {
    Detail,
    NoticeTable,
    NavigationBar,
    NavigationButtonDiv,
    FooterDiv,
  },
  setup() {
    return { model: ref(null), options: ["제목", "제목+내용"] };
  },
});
</script>
<style scoped>
/* Your CSS styles here */
.detail-content {
  margin-bottom: 150px;
  height: auto;
  color: #333333;
}
.to-list-div {
  height: 100px;
  display: flex;
  align-items: end;
}
.to-list {
  width: 56px;
  height: 27px;
  background: #333333;
  border-radius: 2px;
  justify-content: center;
  align-items: center;
  gap: 30px;
  display: inline-flex;
  color: #ffffff;
  font-weight: 500;
  font-size: 14px;
  margin-bottom: 20px;
  cursor: pointer;
  text-decoration: none;
}
.main-banner-sentence {
  font-weight: 700;
  font-size: 38px;
  color: #ffffff;
  margin-top: 85px;
  margin-bottom: 27px;
}
.main-banner-div {
  background-image: url("/images/main-banner.png");
  background-position: center;
  background-size: cover;
  height: 330px;
}
@media (max-width: 580px) {
  .main-banner-div {
    height: 250px;
  }
  .main-banner-sentence {
    margin-top: 46px;
    margin-bottom: 8px;
  }
}
</style>
