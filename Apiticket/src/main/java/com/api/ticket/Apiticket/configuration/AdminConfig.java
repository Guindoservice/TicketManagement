package com.api.ticket.Apiticket.configuration;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminConfig {
    @Autowired
    private AdminRepository adminRepository;
    @Bean
    CommandLineRunner   commandLineRunner(PasswordEncoder passwordEncoder){
        return (args) -> {
            if(!adminRepository.findByEmail("guindo8.com@gmail.com").isPresent()){
                Admin admin = new Admin();
                admin.setEmail("guindo8.com@gmail.com");
                admin.setPassword(passwordEncoder.encode("ablo"));
                admin.setRole("ADMIN");
                adminRepository.save(admin);
            }
        };
    }
}
