package HCodeUI.JWTDemo.entity;

import HCodeUI.JWTDemo.security.jwt.Token;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The firstname is required")
    @Size(min = 2, max = 50)
    private String firstname;
    @NotBlank(message = "The lastname is required")
    @Size(min = 2, max = 50)
    private String lastname;
    @NotBlank(message = "The username is required")
    @Size(min = 3, max = 50)
    private String username;
    @NotBlank(message = "The email is required")
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 3, max = 100)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$", message = "The password need to include 1 letter,1 number,1 special character")
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Token> tokens;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] avatar;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
