package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.repository.AdminRepository;
import com.api.ticket.Apiticket.service.AdminService;
import com.api.ticket.Apiticket.service.MailService;
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
    @Autowired
    MailService mailService;

    @Override
    public Admin creer(Admin admin) {


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

        // sauvegarder l'email
        mailService.sendSimpleMail(
                admin.getEmail(),
                "Votre compte a été crée " + admin.getNom() +
                " Votre mode mot de passe est " + admin.getPassword()

                );
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
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

                    // pour modifier le compte
                    mailService.sendSimpleMail(
                            admin.getEmail(),
                            "Votre compte a été Modifier " + admin.getNom() +
                                    " Votre mode mot de passe est " + admin.getPassword()

                    );
                    return adminRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Pas d'admin"));
    }

    @Override
    public String supprimer(Long id) {
        adminRepository.deleteById(id);
        return "Admin a été supprimer !";
    }
}
