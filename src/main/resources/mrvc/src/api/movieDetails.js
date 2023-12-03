import request from '@/utils/request'


//提交评论
export const newComment = (userId, movieId, userName, context, date) => {
  return request.post("/movie/comment", { //这个路径后面要修改
    userId,
    movieId,
    userName,
    context,
    date
  });
}

//提交收藏
export const storeMovie = (userId, movieId) => {
  return request.post("/movie/store", {
    userId,
    movieId,
  })
}

//提交评分
export const rateMovie = (userId, movieId, rateNum) => {
  return request.post("/movie/rate", {
    userId,
    movieId,
    rateNum,
  })
}

// 请求电影信息
export const getMovieDetails = (movieId) => {
  return request.post("/movie/details", {
    movieId,
  })
}

//删除评论
export const deleteComments = (commentId) => {
  return request.post("/movie/delcomment", {
    commentId
  })
}