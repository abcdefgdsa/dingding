package com.example.myapp.domain.chat;

import lombok.Data;

import java.util.List;

@Data
public class ReplyDTO extends Reply{

    List<ReplyDTO> childrenNodes;
}
