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
    name: "id",
    label: "번호",
    align: "center",
    field: (row) => row.id,
    format: (val) => `${val}`,
    style: "width: 130px",
  },
  {
    name: "notice_title",
    label: "제목",
    align: "center",
    field: "noticeTitle",
  },
  {
    name: "notice_regist_date",
    label: "날짜",
    align: "center",
    field: "noticeRegistDate",
    style: "width: 130px",
  },
  {
    name: "views",
    label: "조회",
    align: "center",
    field: "noticeViews",
    style: "width: 130px",
  },
];

const rows = [
  {
    id: "공지",
    noticeTitle: "공지사항입니다.",
    noticeRegistDate: "2023.10.20",
    noticeViews: "10",
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
  color: #333333; /* 바디의 맨 좌측 컬럼 글자색을 빨간색으로 변경 */
}
</style>
