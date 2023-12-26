package com.webservice.restful.dao;

import com.webservice.restful.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {

        users.add(new User(++usersCount, "Julio", LocalDate.now().minusYears(28)));
        users.add(new User(++usersCount, "Aaron", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Cesar", LocalDate.now().minusYears(22)));

    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        //Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        //Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(user -> user.getId().equals(id));
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

}
