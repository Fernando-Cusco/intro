package ec.edu.ups.apirest.dao;

import ec.edu.ups.apirest.entity.User;

import java.util.List;

public interface IUserDao {
    public List<User> findAll();

    public User findById(int id);

    public void save(User user);

    public void deleteById(int id);
}
