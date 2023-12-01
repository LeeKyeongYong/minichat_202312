package com.mini.chatstudy.domain.chat.chatMessage.service;

import com.mini.chatstudy.domain.chat.chatMessage.entity.ChatMessage;
import com.mini.chatstudy.domain.chat.chatRoom.entity.ChatRoom;
import com.mini.chatstudy.domain.chat.chatMessage.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatRoomRepository;

    @Transactional
    public ChatRoom make(String name){
        //ChatRoom chatRoom = new ChatRoom(name);
        ChatRoom chatRoom=ChatRoom.builder()
                .name(name)
                .build();
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }
    public List<ChatRoom> findAll(){
        return chatRoomRepository.findAll();
    }

    @Transactional
    public ChatMessage write(long roomId, String writerName, String content){
        ChatRoom chatRoom = chatRoomRepository.findById(roomId).get();
        //chatRoom.writeMessage(writerName,content);
        ChatMessage chatMessage=chatRoom.writeMessage(writerName,content);
        return chatMessage;
    }

    public Optional<ChatRoom> findById(long roomId){
        return chatRoomRepository.findById(roomId);
    }
}
