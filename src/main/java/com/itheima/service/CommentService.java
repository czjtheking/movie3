package com.itheima.service;

import com.itheima.domain.Comment;
import com.itheima.domain.Movie;

import java.util.List;

public interface CommentService {
    /**
     * 提交评论
     * @param comment
     */
    void commit(Comment comment);

    /**
     * 删除评论
     * @param comment
     */
    void deletecomment(Comment comment);

    /**
     * 电影请求1
     */
    Movie query1(Movie movie);

    /**
     * 电影请求2
     * @return
     */
    List<Comment> query2(Movie movie);
}
