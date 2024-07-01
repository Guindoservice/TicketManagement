package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.Model.Apprenant;
import com.api.ticket.Apiticket.repository.ApprenantRepository;
import com.api.ticket.Apiticket.service.MailService;
import com.api.ticket.Apiticket.service.ServicesApprenant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ImplementApprenant implements ServicesApprenant {

    @Autowired
    private ApprenantRepository apprenantRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Override
    public Apprenant getApprenant(Apprenant apprenant) {
        if (!apprenant.getEmail().contains("@")){
            throw new RuntimeException(" votre email maque (@)");
        }
        if (!apprenant.getEmail().contains(".")){
            throw new RuntimeException(" votre email maque (. )");
        }
        Optional<Apprenant> option= this.apprenantRepository.findByEmail(apprenant.getEmail());
        if (option.isPresent()){
            throw new RuntimeException(" cet email exite déjà");
        }

        // sauvegarder l'email
        mailService.sendSimpleMail(
                apprenant.getEmail(),
                "Votre compte a été crée " + apprenant.getNom() +
                        " Votre mode mot de passe est " + apprenant.getPassword()

        );
        apprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> listeApprenants() {

        return apprenantRepository.findAll();
    }



    @Override
    public Apprenant updateApprenant(Apprenant apprenant, Long id) {
        return apprenantRepository.findById(id)
                .map(a->{
                    a.setNom(apprenant.getNom());
                    a.setPassword(passwordEncoder.encode(apprenant.getPassword()));
                    a.setEmail(apprenant.getEmail());
                    // pour modification du compte
                    mailService.sendSimpleMail(
                            apprenant.getEmail(),
                            "Votre compte a été Modifier et voici le compte / " + apprenant.getNom() +
                                    " Votre mode mot de passe est " + apprenant.getPassword()

                    );
                    return apprenantRepository.save(a);
                }) .orElseThrow(() -> new RuntimeException("pas d'apprenant en se moment "));

    }

    @Override
    public String deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);
        return "Apprenant a été supprimer avec succès !";
    }
}
