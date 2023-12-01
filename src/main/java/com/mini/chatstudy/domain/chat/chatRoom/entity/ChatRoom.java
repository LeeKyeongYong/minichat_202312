package com.mini.chatstudy.domain.chat.chatRoom.entity;

import com.mini.chatstudy.global.jpa.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@Setter
@NoArgsConstructor(access=PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "chatRoom",cascade=CascadeType.ALL,orphanRemoval=true)
    @Builder.Default
    @ToString.Exclude
    private List<ChatMessage> chatMessages = new ArrayList<>();

    public void writeMessage(String writerName,String content){
        ChatMessage chatMessage = ChatMessage
                .builder()
                .chatRoom(this)
                .writerName(writerName)
                .content(content)
                .build();
        chatMessages.add(chatMessage);
    }

}
