package ra.com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserloginDto {
    @NotBlank(message = "vui long khong de trong")
    private String username;
    @NotBlank(message = "vui long khong de trong")
    private String password;
}
