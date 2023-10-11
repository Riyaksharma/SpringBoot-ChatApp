package com.todo.demo.controller;


public class ChatMessage {
	
	private String content;
	private String sender;
	private String reciever;
	
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	private MessageTypes type;
	
	
	public enum MessageTypes
	{
		CHAT,
		JOIN,
		LEAVE
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public MessageTypes getType() {
		return type;
	}
	public void setType(MessageTypes type) {
		this.type = type;
	}
	

	
}
