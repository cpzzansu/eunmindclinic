<template>
  <div class="col-10 col-md-8">
    <div class="q-pa-md clinic-hours-table">
      <q-table
        :columns="columns"
        :pagination="myInitialPagination"
        :rows="rows"
        :rows-per-page-options="[0]"
        hide-pagination
        row-key="name"
        style="border-top: 3px rgba(20, 148, 115, 1) solid"
      />
    </div>
  </div>
</template>

<script>
const columns = [
  {
    name: "name",
    label: "요일",
    align: "center",
    field: (row) => row.name,
    format: (val) => `${val}`,
  },
  {
    name: "monday",
    label: "월",
    align: "center",
    field: "monday",
  },
  { name: "tuesday", label: "화", align: "center", field: "tuesday" },
  { name: "wednesday", label: "수", align: "center", field: "wednesday" },
  { name: "thursday", label: "목", align: "center", field: "thursday" },
  { name: "friday", label: "금", align: "center", field: "friday" },
  {
    name: "saturday",
    align: "center",
    label: "토",
    field: "saturday",
  },
];

const rows = [
  {
    name: "오전",
    monday: "O",
    tuesday: "O",
    wednesday: "O",
    thursday: "O",
  },
  {
    name: "오후",
    monday: "O",
    tuesday: "O",
    wednesday: "O",
    thursday: "O",
  },
];

export default {
  setup() {
    return {
      columns,
      rows,
      myInitialPagination: {
        rowsPerPage: 0,
      },
    };
  },
};
</script>
<style>
.clinic-hours-table {
  width: 100%;
  font-weight: 500;
  font-size: 18px;
}
.q-table__card {
  border-radius: 0px;
  box-shadow: none;
  border-bottom: 1px rgba(21, 71, 38, 0.5) solid;
}
.q-table th {
  background-color: rgba(240, 246, 242, 1);
  border-bottom: 1px rgba(240, 246, 242, 1) solid;
  height: 62px;
  font-weight: 500;
  font-size: 18px;
}
.q-table td {
  border-bottom: 1px rgba(240, 246, 242, 1) solid;
  border-right: 1px rgba(240, 246, 242, 1) solid;
}
.q-table tbody td {
  font-weight: 500;
  font-size: 18px;
  height: 62px;
}
.q-table td:last-child {
  border-right: none;
}
.q-table td:first-child {
  color: #149473; /* 바디의 맨 좌측 컬럼 글자색을 빨간색으로 변경 */
}
</style>
