package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.repository.AdminRepository;
import com.api.ticket.Apiticket.service.AdminService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AdminImplement implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Admin creer(Admin admin) {

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        if (!admin.getEmail().contains("@")){
            throw new RuntimeException(" votre email maque (@)");
        }
        if (!admin.getEmail().contains(".")){
            throw new RuntimeException(" votre email maque (. )");
        }
        Optional<Admin> option= this.adminRepository.findByEmail(admin.getEmail());
        if (option.isPresent()){
            throw new RuntimeException(" cet email exite déjà");
        }
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> afficheuser() {
        return adminRepository.findAll();
    }

    @Override
    public Admin modifier(Long id, Admin admin) {
        return adminRepository.findById(id)
                .map(p ->{
                    p.setNom(admin.getNom());
                    p.setEmail(admin.getEmail());
                    p.setPassword(passwordEncoder.encode(admin.getPassword()));
                    p.setRole(admin.getRole());
                    return adminRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Pas d'admin"));
    }

    @Override
    public String supprimer(Long id) {
        adminRepository.deleteById(id);
        return "Admin a été supprimer !";
    }
}
