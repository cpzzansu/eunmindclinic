<template>
  <div class="row justify-center">
    <div class="col-10 col-md-8 notice-detail-div">
      <div class="row notice-title-div">
        <div class="notice-number">공지</div>
        <div class="notice-title">제목</div>
        <div class="notice-regist-date justify-end">2023.10.20</div>
      </div>
      <div class="notice-content">내용</div>
    </div>
  </div>
</template>
<script></script>
<style scoped>
.notice-title-div {
  background-color: rgba(240, 246, 242, 1);
  border-top: 3px rgba(20, 148, 115, 1) solid;
  height: 62px;
}
.notice-detail-div {
  height: 467px;
  font-size: 18px;
  font-weight: 500;
  border: 1px rgba(240, 246, 242, 1) solid;
  color: #333333;
}
.notice-number {
  display: flex;
  width: 130px;
  justify-content: center;
  align-items: center;
}
.notice-title {
  flex-grow: 1;
  display: flex;
  width: 130px;
  padding-left: 30px;
  justify-content: left;
  align-items: center;
}
.notice-regist-date {
  display: flex;
  width: 200px;
  justify-content: center;
  align-items: center;
  font-weight: 400;
  color: rgba(51, 51, 51, 0.5);
}
.notice-content {
  padding: 30px;
}
</style>
