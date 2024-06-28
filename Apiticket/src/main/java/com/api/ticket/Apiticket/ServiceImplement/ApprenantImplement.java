package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.Apprenant;
import com.api.ticket.Apiticket.Model.Formateur;
import com.api.ticket.Apiticket.repository.ApprenantRepository;
import com.api.ticket.Apiticket.repository.FormateurRepository;
import com.api.ticket.Apiticket.service.ServiceApprenant;
import com.api.ticket.Apiticket.service.ServiceFormateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service

public class ApprenantImplement implements ServiceApprenant {
    @Autowired
    private ApprenantRepository apprenantRepository;
    @Override
    public Apprenant createFormateur(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> getFormateurs() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant UpdateFormateur(Long id, Apprenant apprenant) {
        return apprenantRepository.findById(id).map((a)->{
        a.getAdmin();
        return apprenantRepository.save(a);
        }).orElseThrow();

    }

    @Override
    public String deleteFormateur(Long id) {
        apprenantRepository.deleteById(id);
        return "";
    }
}
