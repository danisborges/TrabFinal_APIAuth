package application.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dto.LoginRequest;
import application.dto.LoginResponse;
import application.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public LoginResponse auth(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha());
        
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        
        String token = tokenService.generateToken(authentication);
        
        return new LoginResponse(token);
    }
}