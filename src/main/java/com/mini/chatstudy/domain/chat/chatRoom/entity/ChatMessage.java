package com.mini.chatstudy.domain.chat.chatRoom.entity;

import com.mini.chatstudy.global.jpa.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {

    @ManyToOne
    private ChatRoom chatRoom;

    private String writerName;

    private String content;
}
