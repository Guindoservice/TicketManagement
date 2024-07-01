package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.ReponseTicket;
import com.api.ticket.Apiticket.service.AdminService;
import com.api.ticket.Apiticket.service.MailService;
import com.api.ticket.Apiticket.service.ReponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Contoller-Reponse", description = "Contoller pour la création des réponses par un formateur")
@RestController
@RequestMapping("/reponseticket/")
@Data
public class ReponseController {

    @Autowired
    private final ReponseService reponseService;
    private final MailService mailService;
    private AdminService ticketService;


    @Operation(summary = "Création d'une réponse")
    @PostMapping("/creerReponse")
    public ReponseTicket createReponse(@RequestBody ReponseTicket reponse) {
       // mailService.sendSimpleMail(reponse.getApprenant().getEmail(), "votre ticket a été répondu");
        return reponseService.CreerReponse(reponse);
    }
    @Operation(summary = "Pour afficher les liste des réponses ")
    @GetMapping("/listReponse")
    public List<ReponseTicket> list() {
        return reponseService.ListReponse();
    }
    @Operation(summary = "Pour modifier une réponse")
    @PutMapping("/modifierReponse/{id}")
    public ReponseTicket modifier(@PathVariable long id , ReponseTicket reponse) {
        return reponseService.ModifierReponse(id, reponse);
    }
    @Operation(summary = "Pour supprimer une réponse")
    @DeleteMapping("/suppReponse/{id}")
   String delete(@PathVariable long id ) {

      return   reponseService.supprimerReponse(id);

    }


}
