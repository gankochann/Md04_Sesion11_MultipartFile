package ra.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ra.com.validator.usernameIsExist.UserNameIsExist;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    @NotBlank(message = "khong dc de trong")
    @UserNameIsExist(message = "name da ton tai")
    private String username;

    @NotBlank(message = "khoong dc de trong")
    private String password;

    @NotBlank(message = "khong dc de trong")
    private String email;
    private MultipartFile image;
}
