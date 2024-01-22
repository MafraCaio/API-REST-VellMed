package med.voll.API.REST.controller;

import jakarta.validation.Valid;
import med.voll.API.REST.domain.user.DataAuth;
import med.voll.API.REST.domain.user.User;
import med.voll.API.REST.infra.security.Token;
import med.voll.API.REST.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuth data) {
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.tokenGenerate((User) authentication.getPrincipal());
        return  ResponseEntity.ok().body(new Token(tokenJWT));
    }

}
