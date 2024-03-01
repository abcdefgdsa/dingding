package com.example.myapp.controller.chat;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.MyValues;
import com.example.myapp.domain.chat.Comment;
import com.example.myapp.domain.chat.CommentVO;
import com.example.myapp.domain.project.approval.shengtai.Shengtai;
import com.example.myapp.exception.ApprovalException;
import com.example.myapp.service.ActivitiService;
import com.example.myapp.service.chat.CommentService;
import com.example.myapp.service.project.approval.shengtai.ShengtaiService;
import com.example.myapp.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    public CommentService commentService;

    /**
     * 根据项目id查询评论内容
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam Integer baseId){
        List<CommentVO> commentVOS = commentService.buildCommentVOList(baseId);
        return AjaxResult.success(commentVOS);
    }

    /**
     * 新增评论内容
     */
    @PostMapping("/addComment")
    public AjaxResult addApproval(@RequestBody Comment comment) {

        BaseContext.setCurrentUserAndUnion("12345","admin","905992062");
        boolean flag = commentService.addComment(comment);
        return AjaxResult.success();
    }


}
