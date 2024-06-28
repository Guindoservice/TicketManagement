package com.api.ticket.Apiticket.service;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.repository.AdminRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Data
public class ServiceUtilisateur implements UserDetailsService {

    @Autowired
    private  final AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Admin> utilisateur = adminRepository.findByEmail(email);

        if (utilisateur.isPresent()){
            var obj = utilisateur.get();
            return User.builder()
                    .username(obj.getEmail())
                    .password(obj.getPassword())
                    .roles(obj.getRole())
                    .build();

        }else {
            throw new UsernameNotFoundException(email);
        }
    }
    private String[]getRole(Admin admin){
        if (admin.getRole()==null){
            return new String[] {"ADMIN"};
        }
        return  admin.getRole().split(",");

    }

}
