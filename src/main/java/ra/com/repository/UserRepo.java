package ra.com.repository;

import com.mysql.cj.Session;
import org.springframework.stereotype.Repository;
import ra.com.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean fullNameIsExist(String username) {
        Long count = entityManager.createQuery("select count(u.id) from User u where u.username = :username" , Long.class)
                .setParameter("username" , username).getSingleResult();
        return count > 0;
    }

    public User login(String username, String password) {
        User user = entityManager.createQuery("from User u where u.username =: username and u.password =: password" , User.class)
                .setParameter("username" , username)
                .setParameter("password" , password)
                .getSingleResult();
        return user;
    }

    public User register(User user){
        return entityManager.merge(user);
    }

}
