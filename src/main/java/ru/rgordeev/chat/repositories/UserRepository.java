package ru.rgordeev.chat.repositories;

import ru.rgordeev.chat.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findAll();

    User findByLogin(String login);

    User findByToken(String token);

}
