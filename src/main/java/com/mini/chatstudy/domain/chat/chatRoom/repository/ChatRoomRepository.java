package com.mini.chatstudy.domain.chat.chatRoom.repository;

import com.mini.chatstudy.domain.chat.chatRoom.entity.ChatRoom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatRoomRepository {
    private long lastChatRoomId=0;
    private List<ChatRoom> chatRooms = new ArrayList<>();

    public ChatRoom save(ChatRoom chatRoom){
        chatRoom.setId(++lastChatRoomId);
        chatRooms.add(chatRoom);
        return chatRoom;
    }

    public List<ChatRoom> findAll(){
        return chatRooms;
    }

}
