package HCodeUI.JWTDemo.controller;

import HCodeUI.JWTDemo.auth.RegisterRequest;
import HCodeUI.JWTDemo.entity.Role;
import HCodeUI.JWTDemo.entity.User;
import HCodeUI.JWTDemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityService {
    private final UserRepository userRepository;

    public RegisterRequest updateRole(String username, String role) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IndexOutOfBoundsException("User is not exist"));
        user.setRole(Role.valueOf(role));
        userRepository.save(user);
        return RegisterRequest
                .builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
