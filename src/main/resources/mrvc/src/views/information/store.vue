<template>
  <div class="my-store">
    <div class="title"><i class="el-icon-star-on">收藏列表</i></div>
    <el-table :data="storeList" style="width: 100%" class="main-table">
      <el-table-column label="电影名" width="500" class="table">
        <template slot-scope="scope">
          <span
            style="margin-left: 10px"
            @click="handleDetails(scope.row.movie.movieId)"
            class="movieName"
            >{{ scope.row.movie.movieName }}</span
          >
          <!-- 这个span后面要换成跳转链接到电影详情页 -->
        </template>
      </el-table-column>
      <el-table-column label="操作" class="table">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
      <span>是否从收藏中删除该电影</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirmDelete">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getStoreData, postDeleteStore } from "@/api/storeMovie";
import store from "@/store";

export default {
  name: "MyStore",
  data() {
    return {
      uid: 1,
      dialogVisible: false,
      singleStore: { store_id: 1, index: 1 },
      storeList: [
        {
          storeId: 1,
          userId: 21,
          movie: {
            movieName: "1",
            movieId: 1,
          },
        },
      ],
    };
  },
  methods: {
    handleDelete(index, item) {
      this.dialogVisible = true;
      this.singleStore.index = index;
      this.singleStore.store_id = item.storeId;
    },
    async confirmDelete() {
      this.dialogVisible = false;
      const res = await postDeleteStore(this.singleStore.store_id);
      this.storeList.splice(this.singleStore.index, 1);
      console.log(this.singleStore.index);
      this.$message.success("删除成功");
      console.log(res);
    },
    handleDetails(id) {
      this.$router.push(
        {
          path: "/moviedetails",
          query: {
            id: id,
          },
        },
        () => {},
        () => {}
      );
    },
  },
  async created() {
    this.uid = store.getters.getUserId; //创建页面时，拿取uid然后发起请求获取收藏信息
    const res = await getStoreData(store.getters.getUserId);
    this.storeList = res.data;
    console.log(res);
  },
};
</script>

<style scoped lang="less">
.my-store {
  width: 100%;
  height: 100%;
  padding: 20px;
  padding-top: 10px;

  .title {
    height: 50px;
    line-height: 50px;
    padding-left: 0px;
    border-bottom: 1px solid #ddd;
    color: #00a1d6;
    font-size: 18px;
  }
  .main-table {
    width: 100%;
    height: 720px;

    overflow-y: scroll;
    .movieName:hover {
      cursor: pointer;
    }
  }
}
</style>