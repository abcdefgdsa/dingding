package com.example.myapp.service.chat;

import com.example.myapp.domain.chat.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myapp.domain.chat.CommentVO;

import java.util.List;

/**
 *
 */
public interface CommentService extends IService<Comment> {


    /**
     * 新增评论
     */
    boolean addComment(Comment comment);

    /**
     * 根据项目id来查询评论内容
     */
    List<Comment>  selectComments(Integer baseId);

    List<CommentVO> buildCommentVOList(Integer baseId);

}
