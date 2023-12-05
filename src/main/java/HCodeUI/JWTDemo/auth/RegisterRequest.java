package HCodeUI.JWTDemo.auth;

import HCodeUI.JWTDemo.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    @NotBlank(message = "The firstname is required")
    @Size(min = 2,max = 50)
    private String firstname;
    @NotBlank(message = "The lastname is required")
    @Size(min = 2,max = 50)
    private String lastname;
    @NotBlank(message = "The username is required")
    @Size(min = 3,max = 50)
    private String username;
    @NotBlank(message = "The email is required")
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 3,max = 100)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$",message = "The password need to include 1 letter,1 number,1 special character")
    private String password;
    private Role role;
}
