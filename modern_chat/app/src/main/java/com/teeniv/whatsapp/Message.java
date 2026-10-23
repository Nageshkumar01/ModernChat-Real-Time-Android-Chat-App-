package com.teeniv.whatsapp;
public class Message {
 public String id, senderId, text, imageUrl; public long timestamp;
 public Message() {}
 public Message(String id,String senderId,String text,String imageUrl,long timestamp){this.id=id;this.senderId=senderId;this.text=text;this.imageUrl=imageUrl;this.timestamp=timestamp;}
}
