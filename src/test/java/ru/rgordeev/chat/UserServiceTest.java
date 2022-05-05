package ru.rgordeev.chat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import ru.rgordeev.chat.data.UserData;
import ru.rgordeev.chat.entities.User;
import ru.rgordeev.chat.repositories.UserRepository;
import ru.rgordeev.chat.services.UserService;

@ActiveProfiles(profiles = {"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @BeforeEach
    public void setUp() {
        User user = new User("login");
        userRepository.save(user);
    }

    @Transactional
    @Test
    public void requestTokenTest() {
        User u1 = userRepository.findByLogin("login");
        Assertions.assertTrue(u1 != null);
        String token1 = u1.getToken();
        Assertions.assertTrue(token1 != null);
        UserData userData1 = userService.requestToken("login");
        Assertions.assertTrue(token1.equals(userData1.getToken()));

        UserData userData2 = userService.requestToken("login1");
        User u2 = userRepository.findByLogin("login1");
        Assertions.assertTrue(u2 != null);
        Assertions.assertTrue(userData2.getToken().equals(u2.getToken()));
    }

}
