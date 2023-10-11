package com.todo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
//	add user
	@MessageMapping("/chat.send-message") // the url to envoke
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage)
	{
		
		return chatMessage;
	}
	
	@MessageMapping("/chat.private-message")
	private ChatMessage sendPrivateMessage(@Payload ChatMessage chatMessage)
	{
		messagingTemplate.convertAndSendToUser(chatMessage.getReciever(), "/private", chatMessage);
		return chatMessage;
	}
	
	@MessageMapping("/chat.addUser") // the url to envoke
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor)
	{
		// add user name in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());	
		return chatMessage;
	}
}
