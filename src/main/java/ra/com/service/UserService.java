package ra.com.service;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.model.User;
import ra.com.model.UserDto;
import ra.com.model.UserLogin;
import ra.com.repository.UserRepo;

import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    CloudinaryService cloudinaryService;

    public boolean checkUserName(String username) {
        return !userRepo.fullNameIsExist(username);
    }

    @Transactional
    public User login(UserLogin userLogin){
        return userRepo.login(userLogin.getUsername(),userLogin.getPassword());
    }

    public User register(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        if(userDto.getImage() != null && !userDto.getImage().isEmpty()){
             String url = cloudinaryService.upload(userDto.getImage());
            user.setAvatar(url);
        }
        return userRepo.register(user);
    }

}
