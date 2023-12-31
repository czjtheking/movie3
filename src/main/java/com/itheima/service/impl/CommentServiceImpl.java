package com.itheima.service.impl;
import com.itheima.dao.CommentDao;
import com.itheima.domain.Comment;
import com.itheima.domain.Movie;
import com.itheima.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao CommentMapper;


    @Override
    public void commit(Comment comment) {
        CommentMapper.saveComment(comment);
    }

    @Override
    public void deletecomment(Comment comment) {
        CommentMapper.deletecomment(comment);
    }

    @Override
    public Movie query1(Movie movie) {
        return CommentMapper.query1(movie);
    }

    @Override
    public List<Comment> query2(Movie movie) {
        return CommentMapper.query2(movie);
    }
}
