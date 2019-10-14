package test.spring.service;
import  test.spring.entity.User;
import java.util.List;

public interface UserService {
//for business logic
    List<User> findAll();

    void save(User user) throws Exception;

    User getById(int id);

    void update(User user);

    void delete(int id);
}