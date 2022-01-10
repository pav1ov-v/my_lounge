package com.example.my_lounge.service;

import com.example.my_lounge.dao.MessageRepository;
import com.example.my_lounge.domain.Message;
import com.example.my_lounge.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void addMessage(User user, String text, String tag) {
        Message message = new Message(text, tag, user);

        messageRepository.save(message);
    }

    public Iterable<Message> messageList() {
        return messageRepository.findAll();
    }

    public Iterable<Message> findByTag(String tag) {
        return messageRepository.findByTag(tag);
    }

    public Iterable<Message> getMessages() {
        return messageRepository.findAll();
    }
}
