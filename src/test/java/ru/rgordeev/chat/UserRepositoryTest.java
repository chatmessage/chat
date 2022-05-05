package ru.rgordeev.chat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ru.rgordeev.chat.entities.User;
import ru.rgordeev.chat.repositories.UserRepository;

import java.util.List;

@ActiveProfiles(profiles = {"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableTransactionManagement
public class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

    @Test
    @Transactional
    public void saveUserTest() {
        User user = new User("login");
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        Assertions.assertFalse(users.isEmpty());

        System.out.println(user);
    }
}
