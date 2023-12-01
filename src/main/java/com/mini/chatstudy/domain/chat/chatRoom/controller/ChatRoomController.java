package com.mini.chatstudy.domain.chat.chatRoom.controller;

import com.mini.chatstudy.domain.chat.chatRoom.entity.ChatRoom;
import com.mini.chatstudy.domain.chat.chatRoom.service.ChatRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chat/room")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("/${roomId}")
    @ResponseBody
    public String showRoom(@PathVariable final long roomId, final String writerName,Model model){
        ChatRoom room = chatRoomService.findById(roomId).get();
        model.addAttribute("room",room);
        return "domain/chat/chatRoom/room";
    }

    @GetMapping("/make")
    @ResponseBody
    public String showMake(){
        return "domain/chat/chatRoom/make";
    }

    @PostMapping("/make")
    public String make(final String name){
        chatRoomService.make(name);
        return "redirect:/chat/room/list";
    }

    @GetMapping("/list")
    @ResponseBody
    public String showList(Model model){
        List<ChatRoom> chatRooms = chatRoomService.findAll();
        model.addAttribute("chatRooms",chatRooms);
        return "domain/chat/chatRoom/list";
    }

    @PostMapping("/{roomId}/write")
    public String write(@PathVariable final long roomId,final String writerName,final String content){
     chatRoomService.write(roomId,writerName,content);
     return "redirect:/chat/room/"+roomId;
    }
}
