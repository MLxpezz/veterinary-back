package com.veterinary_system;

import com.veterinary_system.user.model.RolEntity;
import com.veterinary_system.user.model.UserEntity;
import com.veterinary_system.user.model.enums.RolEnum;
import com.veterinary_system.user.repository.RolRepository;
import com.veterinary_system.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class VeterinaryApplication {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final RolRepository rolRepository;

    public VeterinaryApplication(UserRepository userRepository, PasswordEncoder passwordEncoder, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolRepository = rolRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(VeterinaryApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init() {
//		return args -> {
//
//			RolEntity superAdminRol = rolRepository.findByName(RolEnum.SUPER_ADMIN)
//					.orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
//
//			UserEntity superAdmin = UserEntity
//					.builder()
//					.email("super-admin@gmail.com")
//					.password(passwordEncoder.encode("12345678"))
//					.roles(Set.of(superAdminRol))
//					.build();
//
//			userRepository.save(superAdmin);
//		};
//	}

}
