package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.Apprenant;
import com.api.ticket.Apiticket.Model.Formateur;
import com.api.ticket.Apiticket.repository.FormateurRepository;
import com.api.ticket.Apiticket.service.MailService;
import com.api.ticket.Apiticket.service.ServiceFormateur;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
@Data

public class FormateurImplement  implements ServiceFormateur {
    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;

    @Override
    public Formateur createFormateur(Formateur formateur) {

        if (!formateur.getEmail().contains("@")){
            throw new RuntimeException(" votre email maque (@)");
        }
        if (!formateur.getEmail().contains(".")){
            throw new RuntimeException(" votre email maque (. )");
        }
        Optional<Formateur> option= this.formateurRepository.findByEmail(formateur.getEmail());
        if (option.isPresent()){
            throw new RuntimeException(" cet email exite déjà");
        }

        // sauvegarder l'email
        mailService.sendSimpleMail(

                formateur.getEmail(),
                "Votre compte a été crée " + formateur.getNom() +
                        " Votre mode mot de passe est " + formateur.getPassword()
        );
        formateur.setPassword(passwordEncoder.encode(formateur.getPassword()));
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> getFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur UpdateFormateur(Long id, Formateur formateur) {
        return formateurRepository.findById(id).map((p) -> {

            p.setNom(formateur.getNom());
            p.setEmail(formateur.getEmail());
            p.setPassword(passwordEncoder.encode(formateur.getPassword()));
            p.setRole(formateur.getRole());
            // Modification du compte
            // sauvegarder l'email
            mailService.sendSimpleMail(

                    formateur.getEmail(),
                    "Votre compte a été Modifier " + formateur.getNom() +
                            " Votre mode mot de passe est " + formateur.getPassword()
            );
            return formateurRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("pas de formateur pour le moment"));

    }

    @Override
    public String deleteFormateur(Long id) {
        formateurRepository.deleteById(id);
        return "Vcompte supprimer";
    }
}
