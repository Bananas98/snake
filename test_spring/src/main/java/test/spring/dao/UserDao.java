package test.spring.dao;

import test.spring.entity.User;
import java.util.List;

public interface UserDao {

        void save(User user);
        User getById(int id);
        List<User> findAll();
        void update(User user);
        void delete(int id);
}
