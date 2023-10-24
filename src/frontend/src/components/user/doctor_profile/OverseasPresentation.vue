<template>
  <div class="col-10 col-md-8 activities-div">
    <div id="overseas" class="q-pa-md activities-table">
      <q-table
        :columns="columns"
        :pagination="myInitialPagination"
        :rows="rows"
        :rows-per-page-options="[0]"
        hide-header
        hide-pagination
        row-key="id"
      >
        <template v-slot:body-cell-overseasPresentation="props">
          <q-td :props="props" style="white-space: pre-line">
            <span v-html="props.row.overseasPresentation"></span>
          </q-td>
        </template>
      </q-table>
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
    const overseasPresent = ref([]);

    onMounted(() => {
      overseasPresent.value = store.state.overseasPresent;
    });

    const columns = [
      {
        name: "overseasPresentation",
        align: "left",
        field: (row) => row.overseasPresentation,
        format: (val) => `${val}`,
        style: "width: 45px",
      },
    ];

    const rows = computed(() => overseasPresent.value);
    return {
      overseasPresent,
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
#overseas .q-table td:first-child {
  font-size: 16px;
  font-weight: 700;
  padding-left: 0px;
  color: #333333;
  line-height: 29px;
}
</style>
