package com.mini.chatstudy.domain.chat.chatRoom.entity;

import lombok.Getter;
import lombok.Setter;

public class ChatRoom {

    @Setter
    @Getter
    private long id;

    @Getter
    private String name;

    public ChatRoom(String name){
        this.name=name;
    }
}
