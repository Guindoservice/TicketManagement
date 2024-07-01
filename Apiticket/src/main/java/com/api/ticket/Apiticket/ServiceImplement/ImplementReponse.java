package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.ReponseTicket;
import com.api.ticket.Apiticket.repository.ReponseRepository;
import com.api.ticket.Apiticket.service.MailService;
import com.api.ticket.Apiticket.service.ReponseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class ImplementReponse implements ReponseService {

    @Autowired
    private final ReponseRepository reponseRepository;
    @Autowired
    MailService mailService;

    @Override
    public ReponseTicket CreerReponse(ReponseTicket reponse) {
//        String messeage ="Votre ticket a été repondu par M. "+ reponse.getFormateur() ;
//        mailService.sendSimpleMail(reponse.getApprenant().getEmail(),messeage);
        return  reponseRepository.save(reponse);

    }

    @Override
    public List<ReponseTicket> ListReponse() {

        return reponseRepository.findAll();
    }

    @Override
    public ReponseTicket ModifierReponse(Long id, ReponseTicket reponse ) {
        return reponseRepository.findById(id)
                .map(r ->{
                    r.setReponseTicket(r.getReponseTicket());
                    r.setStatus(reponse.getStatus());
                    r.setDateReponse(reponse.getDateReponse());
                    r.setPriorse(reponse.getPriorse());
                    r.setFormateur(reponse.getFormateur());
                    r.setCategorie(reponse.getCategorie());
                    return reponseRepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Reponse n'existe pas"));
    }



    @Override
    public String supprimerReponse(Long id ) {
        reponseRepository.deleteById(id);
        return "La reponse a été supprimé ! par ";
    }
}
