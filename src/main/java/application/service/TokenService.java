package application.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private static final String SECRET = "sua_chave_secreta_muito_segura";
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        Instant expiry = now.plus(1, ChronoUnit.DAYS);
        
        return JWT.create()
                .withIssuer("API Cursos")
                .withSubject(authentication.getName())
                .withIssuedAt(now)
                .withExpiresAt(expiry)
                .sign(ALGORITHM);
    }
}