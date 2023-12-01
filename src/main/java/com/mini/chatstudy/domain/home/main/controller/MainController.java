package com.mini.chatstudy.domain.home.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String goToChatRoomList() {
        return "redirect:/chat/room/list";
    }
}