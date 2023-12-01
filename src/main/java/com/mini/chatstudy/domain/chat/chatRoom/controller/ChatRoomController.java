package com.mini.chatstudy.domain.chat.chatRoom.controller;

import com.mini.chatstudy.domain.chat.chatMessage.entity.ChatMessage;
import com.mini.chatstudy.domain.chat.chatMessage.service.ChatMessageService;
import com.mini.chatstudy.domain.chat.chatRoom.entity.ChatRoom;
import com.mini.chatstudy.domain.chat.chatRoom.service.ChatRoomService;
import com.mini.chatstudy.global.rsData.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chat/room")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    private final SimpMessagingTemplate messagingTemplate;

    @GetMapping("/${roomId}")
    @ResponseBody
    public String showRoom(@PathVariable final long roomId, final String writerName, Model model){
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

    @Setter
    @Getter
    public static class WriteRequestBody{
        private String writerName;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class WriteResponseBody{
       private ChatMessage message;
    }

    @GetMapping("/list")
    @ResponseBody
    public String showList(Model model){
        List<ChatRoom> chatRooms = chatRoomService.findAll();
        model.addAttribute("chatRooms",chatRooms);
        return "domain/chat/chatRoom/list";
    }

    @PostMapping("/{roomId}/write")
    @ResponseBody
    public RsData<?> write(@PathVariable final long roomId, @RequestBody final WriteRequestBody requestBody){
        ChatMessage chatMessage =  chatRoomService.write(roomId,requestBody.getWriterName(),requestBody.getContent());
        RsData<WriteResponseBody> writeRs=RsData.of("S-1","%d번 메세지를 작성하였습니다.".formatted(chatMessage.getId()),new WriteResponseBody(chatMessage.getId()));
        messagingTemplate.convertAndSend("/topic/chat/room/"+roomId+"/messageCreated",writeRs);
        return RsData.of("S-1","성공");
    }

    @Getter
    @AllArgsConstructor
    public static class GetMessagesAfterResponseBody{
        private List<ChatMessage> messages;
    }

    @GetMapping("/{roomId}/messageAfter/{afterId}")
    @ResponseBody
    public RsData<GetMessagesAfterResponseBody> getMessageAfter(@PathVariable final long roomId,@PathVariable final long afterId){
        List<ChatMessage> messages = chatMessageService.findByChatRoomIdAndIdAfter(roomId,afterId);
        return RsData.of("S-1","%d개의 메세지를 가져왔습니다.".formatted(messages.size()),new GetMessagesAfterResponseBody(messages));
    }
}
