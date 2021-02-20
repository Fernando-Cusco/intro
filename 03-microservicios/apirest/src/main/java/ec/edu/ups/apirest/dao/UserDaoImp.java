package ec.edu.ups.apirest.dao;

import ec.edu.ups.apirest.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session cs = entityManager.unwrap(Session.class);
        Query<User> query = cs.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User findById(int id) {
        Session cs = entityManager.unwrap(Session.class);
        User user = cs.get(User.class, id);
        return user;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(int id) {
        Session cs = entityManager.unwrap(Session.class);
        Query<User> query = cs.createQuery("delete from User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
