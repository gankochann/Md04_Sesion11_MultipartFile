package ra.com.model;

import lombok.*;
import ra.com.validator.usernameIsExist.UserNameIsExist;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true , nullable = false)
    @UserNameIsExist
    private String username;

    @Column( nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String avatar;
}
