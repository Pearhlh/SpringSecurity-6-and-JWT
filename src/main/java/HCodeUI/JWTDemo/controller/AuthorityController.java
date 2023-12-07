package HCodeUI.JWTDemo.controller;

import HCodeUI.JWTDemo.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/change")
public class AuthorityController {
    private final AuthorityService authorityService;
    private final AuditorAware<Long> auditorAware;
    private final Logger logger = LoggerFactory.getLogger(AuthorityService.class);

    @PostMapping("/authority")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<RegisterRequest> updateRole(@RequestParam String username, @RequestParam String role) {
        return ResponseEntity.ok(authorityService.updateRole(username, role));
    }
}
