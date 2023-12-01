package com.mini.chatstudy.domain.chat.chatMessage.repository;

import com.mini.chatstudy.domain.chat.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatRoom,Long

}
