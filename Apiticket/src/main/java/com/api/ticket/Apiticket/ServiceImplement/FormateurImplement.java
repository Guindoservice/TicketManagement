package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.Formateur;
import com.api.ticket.Apiticket.repository.FormateurRepository;
import com.api.ticket.Apiticket.service.ServiceFormateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class FormateurImplement  implements ServiceFormateur {
    @Autowired
    private FormateurRepository formateurRepository;
    @Override
    public Formateur createFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> getFormateurs() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur UpdateFormateur(Long id, Formateur formateur) {
        return formateurRepository.findById(id).map((a)->{
            a.getAdmin();
            return formateurRepository.save(a);
        }).orElseThrow();

    }

    @Override
    public String deleteFormateur(Long id) {
        formateurRepository.deleteById(id);
        return "Vcompte supprimer";
    }
}
