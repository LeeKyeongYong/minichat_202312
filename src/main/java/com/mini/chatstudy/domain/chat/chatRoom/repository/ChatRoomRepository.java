package com.mini.chatstudy.domain.chat.chatRoom.repository;

import com.mini.chatstudy.domain.chat.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

}