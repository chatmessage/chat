package ru.rgordeev.chat.services;

import ru.rgordeev.chat.entities.Message;
import ru.rgordeev.chat.entities.User;
import ru.rgordeev.chat.repositories.MessageRepository;
import ru.rgordeev.chat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public Message saveAndAnswer(Message message) {
        Message answer = new Message(message.getFrom(), message.getTo(),
                message.getMessage());

        messageRepository.save(message);
        return messageRepository.save(answer);
    }

    public List<Message> history(Map<String, String> params) {
        User myself = userRepository.findByToken(params.get("token"));
        User opponent = userRepository.findByLogin(params.get("toLogin"));
        if (myself == null || opponent == null) {
            return new ArrayList<>();
        }

        String mySelfLogin = myself.getLogin();
        String opponentLogin = opponent.getLogin();
        return messageRepository.findByFromOrToOrderById(mySelfLogin, opponentLogin);
    }
}
