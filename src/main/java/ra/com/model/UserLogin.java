package ra.com.model;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserLogin {
    @NotBlank(message = "khong dc de trong")
    private String username;
    @NotBlank(message = "khong duoc de trong")
    private String password;
}
