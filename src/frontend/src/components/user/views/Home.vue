<template>
  <div>
    <div class="main-banner-div">
      <NavigationBar></NavigationBar>
      <div class="main-banner-phrase">
        <div class="main-banner-sentence text-center">
          건강한 마음, 건강한 몸, 건강한 삶!
        </div>
        <div class="main-banner-english text-center">
          Sound Mind, Sound Body, Sound Life
        </div>
      </div>
    </div>
    <div class="row justify-center">
      <NavigationButtonDiv></NavigationButtonDiv>
    </div>
    <FooterDiv></FooterDiv>
  </div>
</template>

<script>
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";

export default {
  name: "Home",
  components: { FooterDiv, NavigationButtonDiv, NavigationBar },
};
</script>

<style scoped>
/* Your CSS styles here */
.main-banner-phrase {
  margin-top: 450px;
}
.main-banner-english {
  font-weight: 700;
  font-size: 25px;
  color: #ffffff;
}
.main-banner-sentence {
  font-weight: 700;
  font-size: 44px;
  color: #ffffff;
  margin-bottom: 27px;
}
.main-banner-div {
  background-image: url("../../../asset/main-banner.png");
  background-position: center;
  background-size: cover;
  height: 800px;
}

@media (max-width: 1440px) {
  .main-banner-div {
    height: 700px;
  }
  .main-banner-phrase {
    margin-top: 300px;
  }
}
@media (max-width: 1300px) {
  .main-banner-div {
    height: 600px;
  }
  .main-banner-phrase {
    margin-top: 250px;
  }
}
@media (max-width: 1100px) {
  .main-banner-div {
    height: 500px;
  }
  .main-banner-phrase {
    margin-top: 180px;
  }
}
@media (max-width: 875px) {
  .main-banner-div {
    height: 400px;
  }
  .main-banner-phrase {
    margin-top: 125px;
  }
  .main-banner-sentence {
    font-size: 35px;
  }
  .main-banner-english {
    font-size: 20px;
  }
}
@media (max-width: 580px) {
  .main-banner-div {
    height: 250px;
  }
  .main-banner-phrase {
    margin-top: 60px;
  }
  .main-banner-sentence {
    font-size: 20px;
    margin-bottom: 8px;
  }
  .main-banner-english {
    font-size: 10px;
  }
}
</style>
