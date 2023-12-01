package com.mini.chatstudy.domain.chat.chatRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/chat/room")
public class ChatRoomController {
    @GetMapping("/${roomId}")
    @ResponseBody
    public String showRoom(@PathVariable final long roomId, @RequestParam(defaultValue = "NoName")final String writerName){
        return "%d번 채팅방 입니다. writer: %s".formatted(roomId,writerName);
    }

    @GetMapping("/make")
    @ResponseBody
    public String showMake(){
        return "domain/chat/chatRoom/make";
    }
}
