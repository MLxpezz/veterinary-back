package com.veterinary_system.security.service;

import com.veterinary_system.common.enums.ApiMessage;
import com.veterinary_system.user.model.UserEntity;
import com.veterinary_system.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new EntityNotFoundException(ApiMessage.USER_NOT_FOUND.getMessage()));

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles()
                .forEach(rol -> {
                    roles.add(new SimpleGrantedAuthority("ROLE_".concat(rol.getName().name())));
                });


        return User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(roles)
                .disabled(!user.isEnabled())
                .build();
    }
}
