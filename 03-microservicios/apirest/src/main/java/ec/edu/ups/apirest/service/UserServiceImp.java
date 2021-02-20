package ec.edu.ups.apirest.service;

import ec.edu.ups.apirest.dao.IUserDao;
import ec.edu.ups.apirest.dao.UserDaoImp;
import ec.edu.ups.apirest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }
}
