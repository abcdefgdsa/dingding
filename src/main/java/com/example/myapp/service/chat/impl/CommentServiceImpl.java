package com.example.myapp.service.chat.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myapp.domain.chat.Comment;
import com.example.myapp.domain.chat.CommentVO;
import com.example.myapp.domain.chat.Reply;
import com.example.myapp.domain.chat.ReplyDTO;
import com.example.myapp.service.chat.CommentService;
import com.example.myapp.mapper.chat.CommentMapper;
import com.example.myapp.service.chat.ReplyService;
import com.example.myapp.utils.BaseContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {

    @Autowired
    public ReplyService replyService;


    @Override
    public boolean addComment(Comment comment) {
        //设置评论的userId 人名和评论时间
        comment.setUserId(BaseContext.getCurrentUserAndUnion().getUserId());
        comment.setUserName(BaseContext.getCurrentUserAndUnion().getUserName());
        comment.setCreateTime(LocalDateTime.now());
        return save(comment);
    }

    @Override
    public List<Comment> selectComments(Integer baseId) {

        //先找到第一层级的评论内容
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Comment::getBaseId, baseId);
        List<Comment> commentList = list(wrapper);


      /*  List<CommentVO> resultList = commentList.stream().map(comment -> {
            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(comment, commentVO);

            //找到评论第一层级的回复
            List<Reply> replies = replyService.selectReply(comment.getCommentId());

            List<ReplyDTO> replyDTOList = replies.stream().map(reply -> {
                ReplyDTO replyDTO = new ReplyDTO();
                BeanUtils.copyProperties(reply, replyDTO);
                return replyDTO;
            }).collect(Collectors.toList());

            commentVO.setReplys(replyDTOList);
            return commentVO;
        }).collect(Collectors.toList());*/


        //TODO 把回复表也加上 返回CommentVO
        return commentList;
    }

    public List<CommentVO> buildCommentVOList(Integer baseId) {
        List<Comment> comments=selectComments(baseId);
        List<CommentVO> result = new ArrayList<>();

        List<Reply> replies = replyService.selectAll();
        // 遍历评论
        for (Comment comment : comments) {
            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(comment, commentVO);

            // 递归构建回复
            List<ReplyDTO> replyDTOList = buildReplyDTOList(comment.getCommentId(), replies);
            commentVO.setReplys(replyDTOList);

            result.add(commentVO);
        }

        return result;
    }

    private List<ReplyDTO> buildReplyDTOList(String commentId, List<Reply> replies) {
        List<ReplyDTO> result = new ArrayList<>();

        // 遍历回复
        for (Reply reply : replies) {
            if (commentId.equals(reply.getFrontId())) {
                ReplyDTO replyDTO = new ReplyDTO();
                BeanUtils.copyProperties(reply, replyDTO);

                // 递归构建子回复
                List<ReplyDTO> childrenNodes = buildReplyDTOList(reply.getReplyId(), replies);
                replyDTO.setChildrenNodes(childrenNodes);

                result.add(replyDTO);
            }
        }

        return result;
    }

}




