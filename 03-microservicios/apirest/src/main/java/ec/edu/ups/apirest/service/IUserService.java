package ec.edu.ups.apirest.service;

import ec.edu.ups.apirest.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User findById(int id);

    public void save(User user);

    public void deleteById(int id);
}
