package com.example.myapp.service.chat.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.chat.Reply;
import com.example.myapp.service.chat.ReplyService;
import com.example.myapp.mapper.chat.ReplyMapper;
import com.example.myapp.utils.BaseContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply>
    implements ReplyService{

    @Override
    public boolean addReply(Reply reply) {
        //设置评论的userId 人名和评论时间
        reply.setUserId(BaseContext.getCurrentUserAndUnion().getUserId());
        reply.setUserName(BaseContext.getCurrentUserAndUnion().getUserName());
        reply.setCreateTime(LocalDateTime.now());
        return save(reply);
    }

    @Override
    public List<Reply> selectReply(String frontId) {
        LambdaQueryWrapper<Reply> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reply::getFrontId,frontId);
        return list(wrapper);
    }

    @Override
    public List<Reply> selectAll() {
        return list();
    }
}




