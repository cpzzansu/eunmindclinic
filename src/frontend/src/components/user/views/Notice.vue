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
    <div class="main-content row justify-center">
      <div class="speaker">
        <img src="/images/Speaker.png" style="width: 90px" />
      </div>
      <div class="notice-title col-12 text-center">공지사항</div>
      <div class="notice-sub-title col-12 text-center">
        은헌정 정신건강의학과의원의 소식을 전해드립니다.
      </div>
      <NoticeTable></NoticeTable>
      <div class="notice-search-div row col-12 justify-center">
        <select class="notice-select-box">
          <option disabled selected value="">분류</option>
          <option value="title">제목</option>
          <option value="title-content">제목+내용</option>
        </select>
        <div><input class="notice-input-box" placeholder="검색어 입력" /></div>
        <div class="search-btn">검색</div>
      </div>
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

export default defineComponent({
  components: { NoticeTable, NavigationBar, NavigationButtonDiv, FooterDiv },
  setup() {
    return { model: ref(null), options: ["제목", "제목+내용"] };
  },
});
</script>
<style scoped>
/* Your CSS styles here */
.main-content {
  margin-top: 100px;
  color: #333333;
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
.speaker {
  margin-bottom: 30px;
}
.notice-title {
  font-size: 35px;
  font-weight: 700;
  margin-bottom: 15px;
}
.notice-sub-title {
  font-size: 20px;
  font-weight: 500;
  margin-bottom: 80px;
}
.notice-select-box {
  font-family: "Noto Sans KR", "Apple SD Gothic Neo", sans-serif;
  height: 27px;
  width: 91px;
  border-radius: 2px;
  font-size: 14px;
  font-weight: 500;
  margin-right: 10px;
  padding: 0px 10px;
}
.notice-input-box {
  font-family: "Noto Sans KR", "Apple SD Gothic Neo", sans-serif;
  width: 200px;
  height: 27px;
  font-size: 14px;
  font-weight: 500;
  padding: 0px 10px;
}
.search-btn {
  color: #ffffff;
  font-size: 14px;
  font-weight: 500;
  background-color: #333333;
  border-radius: 2px;
  width: 56px;
  height: 27px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.notice-search-div {
  margin-bottom: 150px;
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
