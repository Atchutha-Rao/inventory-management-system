package com.ims.inventorymanagementsystem.security;

import com.ims.inventorymanagementsystem.entities.User;
import com.ims.inventorymanagementsystem.exceptions.NotFoundException;
import com.ims.inventorymanagementsystem.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundException("User Email Not Found"));

        return AuthUser.builder()
                .user(user)
                .build();
    }
}
