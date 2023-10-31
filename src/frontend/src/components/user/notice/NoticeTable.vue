<template>
  <div class="col-10 col-md-8">
    <div class="q-pa-md clinic-hours-table">
      <q-table
        :columns="columns"
        :pagination="myInitialPagination"
        :rows="filteredRows"
        :rows-per-page-options="[0]"
        hide-pagination
        row-key="id"
        style="border-top: 3px rgba(20, 148, 115, 1) solid"
        @row-click="handleRowClick"
      />
    </div>
    <div class="notice-search-div row col-12 justify-center">
      <select v-model="searchType" class="notice-select-box">
        <option value="noticeBoardTitle">제목</option>
        <option value="noticeBoardContent">내용</option>
      </select>
      <div>
        <input
          v-model="searchTerm"
          class="notice-input-box"
          placeholder="검색어 입력"
          @keyup.enter="performSearch"
        />
      </div>
      <div class="search-btn" @click="performSearch">검색</div>
    </div>
  </div>
</template>

<script>
import { useStore } from "vuex";
import { computed, onMounted, ref } from "vue";
import { useRouter } from "vue-router";

export default {
  setup() {
    const router = useRouter();
    const store = useStore();
    const noticeBoardList = ref([]);
    const searchTerm = ref("");
    const searchType = ref("noticeBoardTitle"); // 분류(제목 또는 내용)

    const filteredRows = ref([]);

    const performSearch = () => {
      if (searchTerm.value.trim() === "") {
        filteredRows.value = [...rows.value];
      } else {
        switch (searchType.value) {
          case "noticeBoardTitle":
            filteredRows.value = rows.value.filter((row) =>
              row.noticeBoardTitle
                .toLowerCase()
                .includes(searchTerm.value.toLowerCase()),
            );
            break;
          case "noticeBoardContent":
            filteredRows.value = rows.value.filter((row) =>
              row.noticeBoardContent
                .toLowerCase()
                .includes(searchTerm.value.toLowerCase()),
            );
            break;
          default:
            filteredRows.value = [...rows.value];
        }
      }
    };

    onMounted(() => {
      noticeBoardList.value = store.state.noticeBoard;
      filteredRows.value = store.state.noticeBoard;
    });

    const columns = [
      {
        name: "id",
        label: "번호",
        align: "center",
        field: (row) => row.number,
        format: (val) => `${val}`,
        style: "width: 130px",
      },
      {
        name: "notice_board_title",
        label: "제목",
        align: "left",
        field: "noticeBoardTitle",
      },
      {
        name: "regist_date",
        label: "날짜",
        align: "center",
        field: "registDate",
        style: "width: 130px",
      },
      {
        name: "view_count",
        label: "조회",
        align: "center",
        field: "viewCount",
        style: "width: 130px",
      },
    ];

    const rows = computed(() => noticeBoardList.value);

    const handleRowClick = (evt, row) => {
      sessionStorage.setItem("number", row.number);
      router.push({
        name: "detail",
        params: { id: row.id },
      });
    };

    const sortMethod = (rows, sortBy, descending) => {
      if (sortBy !== "id") return rows;

      const sortedRows = [...rows].sort((a, b) => {
        if (a[sortBy] === "공지") return -1; // '공지' 값이면 a를 우선순위로 합니다.
        if (b[sortBy] === "공지") return 1; // '공지' 값이면 b를 우선순위로 합니다.
        return descending ? a[sortBy] - b[sortBy] : b[sortBy] - a[sortBy];
      });

      return sortedRows;
    };

    return {
      searchTerm,
      searchType,
      filteredRows,
      performSearch,
      handleRowClick,
      columns,
      rows,
      myInitialPagination: {
        rowsPerPage: 0,
      },
      sortMethod,
    };
  },
};
</script>
<style>
.clinic-hours-table {
  width: 100%;
  font-weight: 500;
  font-size: 18px;
  margin-bottom: 10px;
  color: #333333;
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
  color: #333333;
}
.q-table tbody td {
  font-weight: 500;
  font-size: 18px;
  height: 62px;
  color: #333333;
}
.q-table td:last-child {
  border-right: none;
}
.q-table td:first-child {
  color: #333333; /* 바디의 맨 좌측 컬럼 글자색을 빨간색으로 변경 */
}
.notice-select-box {
  font-family: "Noto Sans KR", "Apple SD Gothic Neo", sans-serif;
  height: 27px;
  width: 105px;
  border-radius: 2px;
  font-size: 14px;
  font-weight: 500;
  margin-right: 10px;
  padding: 0px 10px;
  color: #333333;
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
</style>
