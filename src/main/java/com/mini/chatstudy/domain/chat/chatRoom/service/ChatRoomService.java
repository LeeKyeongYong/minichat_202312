package com.mini.chatstudy.domain.chat.chatRoom.service;

import com.mini.chatstudy.domain.chat.chatRoom.entity.ChatRoom;
import com.mini.chatstudy.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public void make(String name){
        //ChatRoom chatRoom = new ChatRoom(name);
        ChatRoom chatRoom=ChatRoom.builder()
                .name(name)
                .build();
        chatRoomRepository.save(chatRoom);
    }
    public List<ChatRoom> findAll(){
        return chatRoomRepository.findAll();
    }
}
