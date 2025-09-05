package ra.com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserRegisterDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "vui long khong de trong")
    private String username;

    @NotBlank(message = "vui long khong de trong")
    private String password;

    @NotBlank(message = "vui long khong de trong")
    private String email;

    private MultipartFile avata;
}
