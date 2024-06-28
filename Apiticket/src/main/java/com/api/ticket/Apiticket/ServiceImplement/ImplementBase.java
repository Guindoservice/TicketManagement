package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.BaseConnaissance;
import com.api.ticket.Apiticket.repository.BaseReponsitory;
import com.api.ticket.Apiticket.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementBase implements BaseService {
    @Autowired
    private BaseReponsitory baseService;
    @Override
    public BaseConnaissance creerbase(BaseConnaissance connaissance) {
        return baseService.save(connaissance);
    }

    @Override
    public List<BaseConnaissance> afficheuserbase() {
        return baseService.findAll();
    }

    @Override
    public BaseConnaissance modifierbase(Long id, BaseConnaissance connaissance) {
        return baseService.findById(id)
                .map(b ->{
                    b.setApprenant(connaissance.getApprenant());
                    b.setFormateur(connaissance.getFormateur());
                    b.setDescription(connaissance.getDescription());
                    b.setDate(connaissance.getDate());
                    return baseService.save(b);
                }) .orElseThrow(() -> new RuntimeException("Base 'existe pas"));
    }

    @Override
    public String supprimerbase(Long id) {
        baseService.deleteById(id);
        return "la base est supprimer";
    }
}
