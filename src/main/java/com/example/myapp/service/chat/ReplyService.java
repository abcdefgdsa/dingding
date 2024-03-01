package com.example.myapp.service.chat;

import com.example.myapp.domain.chat.Comment;
import com.example.myapp.domain.chat.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface ReplyService extends IService<Reply> {

    /**
     * 新增回复
     */
    boolean addReply(Reply reply);

    /**
     * 根据回复id来查询评论内容
     */
    List<Reply> selectReply(String frontId);

    List<Reply> selectAll();

}
