package com.mini.chatstudy.domain.chat.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatRoomController {
    @GetMapping("/chat/room/${roomId}")
    @ResponseBody
    public String showRoom(@PathVariable final long roomId, @RequestParam(defaultValue = "NoName")final String writerName){
        return "%d번 채팅방 입니다. writer: %s".formatted(roomId,writerName);
    }
}
