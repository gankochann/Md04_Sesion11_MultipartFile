package ra.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import ra.com.dto.UserRegisterDto;
import ra.com.dto.UserloginDto;
import ra.com.model.User;
import ra.com.repository.ipm.UserRepoIpm;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepoIpm userRepoIpm;
    @Autowired
    private CloudanaryService cloudanaryService;
    @Transactional
    public boolean createUser(UserRegisterDto userRegisterDto, Errors errors){
        boolean emailExist = userRepoIpm.isExistEmail(userRegisterDto.getEmail());
        boolean isExisted = false;
        boolean usernameExist = userRepoIpm.isExitsUserName(userRegisterDto.getUsername());
        if(emailExist){
            errors.rejectValue("email", "email.isExist" , "vui long nhap lai email");
            isExisted = true;
        }
        if(usernameExist){
            errors.rejectValue("username", "username.isExist" , "vui long nhap lai username");
            isExisted = true;
        }
        if(!isExisted){
            String avataUrl = cloudanaryService.upload(userRegisterDto.getAvata());
            User user = new User(
                    userRegisterDto.getId(),
                    userRegisterDto.getUsername(),
                    userRegisterDto.getPassword(),
                    userRegisterDto.getEmail(),
                    avataUrl
            );
            return userRepoIpm.addUser(user);
        }else {
            return false;
        }
    }

    public User login(UserloginDto userloginDto) {
        return userRepoIpm.login(userloginDto.getUsername(), userloginDto.getPassword());
    }
}
