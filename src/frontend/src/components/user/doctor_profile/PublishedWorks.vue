<template>
  <div class="col-10 col-md-8 activities-div">
    <div id="publishWorks" class="q-pa-md activities-table">
      <q-table
        :columns="columns"
        :pagination="myInitialPagination"
        :rows="rows"
        :rows-per-page-options="[0]"
        hide-header
        hide-pagination
        row-key="id"
      />
    </div>
  </div>
</template>
<script>
import { computed, defineComponent, onMounted, ref } from "vue";
import FooterDiv from "@/components/user/footer/FooterDiv.vue";
import NavigationButtonDiv from "@/components/user/navi_btn/NavigationButtonDiv.vue";
import NavigationBar from "@/components/user/navi/NavigationBar.vue";
import DoctorProfileNavigation from "@/components/user/doctor_profile/DoctorProfileNavigation.vue";
import { useStore } from "vuex";

export default defineComponent({
  components: {
    DoctorProfileNavigation,
    NavigationBar,
    NavigationButtonDiv,
    FooterDiv,
  },
  setup() {
    const store = useStore();
    const pubs = ref([]);

    onMounted(() => {
      pubs.value = store.state.pubs;
      console.log(pubs.value);
    });

    const columns = [
      {
        name: "idx",
        align: "left",
        field: (row) => row.publishedWorks,
        format: (val) => `${val}`,
        style: "width: 45px",
      },
    ];

    const rows = computed(() => pubs.value);

    return {
      pubs,
      columns,
      rows,
      myInitialPagination: {
        rowsPerPage: 0,
      },
    };
  },
});
</script>
<style scoped>
.activities-div {
  margin-bottom: 156px;
  margin-top: 0px;
  padding: 25px 15px;
  background-color: rgba(240, 246, 242, 1);
}
.activities-table {
  padding: 0px 0px;
  background-color: rgba(240, 246, 242, 1);
  max-height: 564px;
  overflow-y: auto;
}
.activities-table::-webkit-scrollbar {
  width: 7px;
  margin-right: 10px;
}
.activities-table::-webkit-scrollbar-track {
  background: rgba(240, 246, 242, 1);
}
.activities-table::-webkit-scrollbar-thumb {
  background: rgba(21, 71, 38, 0.3);
  border-radius: 8px;
}
.activities-table .q-table__card {
  border-bottom: none;
}
.activities-table .q-table tbody td {
  background-color: rgba(240, 246, 242, 1);
  font-size: 16px;
  font-weight: 400;
  height: 28px;
  padding: 0px 0px 0px 20px;
}
.activities-table .q-table td:first-child {
  font-size: 18px;
  font-weight: 700;
  padding-left: 0px;
}
</style>
