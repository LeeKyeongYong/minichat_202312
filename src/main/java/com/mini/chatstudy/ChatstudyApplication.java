package com.mini.chatstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //@CreateDate,@LastModifiedDate를 사용하기위해 필요
public class ChatstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatstudyApplication.class, args);
	}

}
