package com.learn.fantasy.controller;

import com.learn.fantasy.config.JwtTokenProvider;
import com.learn.fantasy.entity.Role;
import com.learn.fantasy.entity.UserEntity;
import com.learn.fantasy.repository.UserRepository;
import com.learn.fantasy.service.CustomUserDetailsService;
import com.learn.fantasy.vo.AuthBody;
import com.learn.fantasy.vo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by stepanferubko
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final static Logger LOG = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository users;

    @Autowired
    private CustomUserDetailsService userService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public UserResponse login(@RequestBody AuthBody data) {
        try {
            LOG.log(Level.INFO, data.toString());
            String username = data.getUsername();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, data.getPassword());
            authenticationManager.authenticate(authentication);
            UserEntity userEntity = users.findByEmail(username);
            Set<Role> roles = userEntity.getRoles();
            String token = jwtTokenProvider.createToken(username, roles);
            UserResponse userResponse = new UserResponse();
            userResponse.setUsername(username);
            userResponse.setToken(token);
            return userResponse;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserEntity user) {
        UserEntity userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            throw new BadCredentialsException("UserEntity with username: " + user.getEmail() + " already exists");
        }
        userService.saveUser(user, "ADMIN");
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "UserEntity registered successfully");
        return ok(model);
    }
}
