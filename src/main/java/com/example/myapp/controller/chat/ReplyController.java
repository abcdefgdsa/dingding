package com.example.myapp.controller.chat;


import com.example.myapp.controller.interceptor.TokenRequired;
import com.example.myapp.domain.AjaxResult;
import com.example.myapp.domain.chat.Comment;
import com.example.myapp.domain.chat.Reply;
import com.example.myapp.service.chat.CommentService;
import com.example.myapp.service.chat.ReplyService;
import com.example.myapp.utils.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@TokenRequired
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    public ReplyService replyService;

    /**
     * 根据上一条回复的id查询回复内容
     * @return
     */
    @GetMapping("/select")
    public AjaxResult select(@RequestParam String frontId){
        List<Reply> replys = replyService.selectReply(frontId);
        return AjaxResult.success(replys);
    }

    /**
     * 新增评论内容
     */
    @PostMapping("/addReply")
    public AjaxResult addApproval(@RequestBody Reply reply) {

        BaseContext.setCurrentUserAndUnion("12345","admin","905992062");
        boolean flag = replyService.addReply(reply);
        return AjaxResult.success();
    }


}
