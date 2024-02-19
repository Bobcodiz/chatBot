package com.bootcamp.application.chatBot.services;

import com.bootcamp.application.chatBot.dtos.LoginRequest;
import com.bootcamp.application.chatBot.dtos.RegistrationRequest;
import com.bootcamp.application.chatBot.models.Role;
import com.bootcamp.application.chatBot.models.User;
import com.bootcamp.application.chatBot.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.bootcamp.application.chatBot.models.Role.USER;

@Service
@AllArgsConstructor
public class UserRegDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegistrationRequest request){
        User user = new User();
        Role role = USER;
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        user = userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()

        ));
        User user = userRepository.findUserByUsername(request.getUsername()).orElseThrow(()
        ->new UsernameNotFoundException("user not existing"));
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);

    }
}
