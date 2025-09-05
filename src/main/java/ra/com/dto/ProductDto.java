package ra.com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDto {
    @NotNull(message = "vui long khong de trong")
    private long id;
    @NotBlank(message = "vui long khong de trong")
    private String productname;
    @NotNull(message = "vui long khong de trong")
    private double price;
    @NotNull(message = "vui long khong de trong")
    private int stock;
    private MultipartFile image;
    private boolean status = true;
}
