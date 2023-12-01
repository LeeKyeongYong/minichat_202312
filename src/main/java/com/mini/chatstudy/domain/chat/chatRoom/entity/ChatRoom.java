package com.mini.chatstudy.domain.chat.chatRoom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access=PROTECTED)
@AllArgsConstructor(access=PROTECTED)
@Builder
@EntityListeners(AutoCloseable.class)
public class ChatRoom {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Getter
    private long id;

    @CreatedDate
    @Getter
    private LocalDateTime createDate;

    @LastModifiedDate
    @Getter
    private LocalDateTime modifyDate;

    @Getter
    private String name;

    @OneToMany(mappedBy = "chatRoom",cascade=CascadeType.ALL,orphanRemoval=true)
    @Builder.Default
    @Getter
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
