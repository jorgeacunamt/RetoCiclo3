package com.usa.ciclo3reto.cicloreto.service;

import com.usa.ciclo3reto.cicloreto.model.Message;
import com.usa.ciclo3reto.cicloreto.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if(message.getId()==null){
            return messageRepository.save(message);
        }else {
            Optional<Message> tmpMessage=messageRepository.getMessage(message.getId());
            if (tmpMessage.isEmpty()){
                return messageRepository.save(message);
            }else {
                return message;
            }
        }
    }

    public Message update(Message message){
        if (message.getId()!=null){
            Optional<Message> tmpMessage=messageRepository.getMessage(message.getId());
            if (!tmpMessage.isEmpty()){
                return messageRepository.save(message);
            }
        }
        return null;
    }

    public boolean deleteMessage(int id){
        Boolean aBoolean=getMessage(id).map(message -> {
            messageRepository.delete(message);;
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
