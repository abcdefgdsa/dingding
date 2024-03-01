package com.example.myapp.domain.chat;

import lombok.Data;

import java.util.List;

@Data
public class CommentVO extends Comment{

    List<ReplyDTO>  replys;
}
