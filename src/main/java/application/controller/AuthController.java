package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Usuario;
import application.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody AuthDTO authDTO) {
        var authToken = new UsernamePasswordAuthenticationToken(
            authDTO.email(), 
            authDTO.senha()
        );
        
        var authentication = authManager.authenticate(authToken);
        
        Usuario usuario = (Usuario) authentication.getPrincipal();
        
        return tokenService.generateToken(usuario);
    }
}

record AuthDTO(String email, String senha) {}