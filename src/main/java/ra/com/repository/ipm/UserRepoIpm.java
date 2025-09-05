package ra.com.repository.ipm;

import org.springframework.stereotype.Repository;
import ra.com.model.User;
import ra.com.repository.UserRepoInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepoIpm implements UserRepoInterface {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean isExistEmail(String email) {
        List<User> userList = entityManager.createQuery("from User u where u.email like :email" , User.class)
                .setParameter("email" , email).getResultList();
        return !userList.isEmpty();
    }

    public boolean isExitsUserName(String username){
        Long count = entityManager.createQuery("select count (u.id) from User u where u.username = : username" , Long.class)
                .setParameter("username",username).getSingleResult();
        return count >0;
    }

    @Override
    public boolean addUser(User user) {
        try {
            entityManager.persist(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            user = entityManager.createQuery("from User u where u.username = :username and u.password = :password" , User.class)
                    .setParameter("username" , username)
                    .setParameter("password" , password)
                    .getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
