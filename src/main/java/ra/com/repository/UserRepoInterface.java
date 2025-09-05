package ra.com.repository;

import ra.com.model.User;

public interface UserRepoInterface {
    boolean isExistEmail(String  email);

    boolean addUser(User user);

    User login(String username , String password);
}
