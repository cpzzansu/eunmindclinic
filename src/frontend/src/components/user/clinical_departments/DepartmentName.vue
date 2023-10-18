<template>
  <div class="department-circle row justify-center items-center">
    {{ departmentName }}
  </div>
</template>
<script>
export default {
  props: { departmentName: String },
};
</script>
<style scoped>
.department-circle {
  width: 250px;
  height: 250px;
  background-color: #149473;
  border-radius: 125px;
  font-weight: 700;
  font-size: 30px;
  color: #ffffff;
  margin: 75px 40px 75px;
}
</style>
