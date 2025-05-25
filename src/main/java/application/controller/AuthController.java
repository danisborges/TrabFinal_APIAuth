package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Aluno;
import application.service.TokenService;
import application.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private AuthService authService;

    @PostMapping
    public String auth(@RequestBody AuthDTO authDTO) {
        var authToken = new UsernamePasswordAuthenticationToken(
            authDTO.email(), 
            authDTO.senha()
        );
        
        var authentication = authManager.authenticate(authToken);
        
        Aluno aluno = (Aluno) authentication.getPrincipal();
        
        return tokenService.generateToken(aluno);
    }
}

record AuthDTO(String email, String senha) {}