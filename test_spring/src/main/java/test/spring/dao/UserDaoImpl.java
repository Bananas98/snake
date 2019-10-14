package test.spring.dao;


import test.spring.entity.User;
import test.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import test.spring.entity.User;

import java.util.List;
//connection with database
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void save(User user) {
        String sql = "INSERT INTO user (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());

    }

    public User getById(int id) {
        String sql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    public List<User> findAll() {//return all users
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    public void update(User user) {
        String sql = "UPDATE user SET name=?, email=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        jdbcTemplate.update(sql, id);

    }
}