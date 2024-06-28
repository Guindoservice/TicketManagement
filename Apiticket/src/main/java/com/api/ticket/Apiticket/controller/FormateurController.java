package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.ReponseTicket;
import com.api.ticket.Apiticket.service.AdminService;
import com.api.ticket.Apiticket.service.MailService;
import com.api.ticket.Apiticket.service.ReponseService;
import com.api.ticket.Apiticket.service.TicketService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur/")
@Data
public class FormateurController {

    @Autowired
    private final ReponseService reponseService;
    private final MailService mailService;
    private AdminService ticketService;



    @PostMapping("/creerReponse")
    public ReponseTicket createReponse(@RequestBody ReponseTicket reponse) {
       // mailService.sendSimpleMail(reponse.getApprenant().getEmail(), "votre ticket a été répondu");
        return reponseService.CreerReponse(reponse);
    }
    @GetMapping("/listReponse")
    public List<ReponseTicket> list() {
        return reponseService.ListReponse();
    }
    @PutMapping("/modifierReponse/{id}")
    public ReponseTicket modifier(@PathVariable long id , ReponseTicket reponse) {
        return reponseService.ModifierReponse(id, reponse);
    }

    @DeleteMapping("/suppReponse/{id}")
   String delete(@PathVariable long id ) {

      return   reponseService.supprimerReponse(id);

    }


}
