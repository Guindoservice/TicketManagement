package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.Formateur;
import com.api.ticket.Apiticket.service.ServiceFormateur;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addFormateur")
@Tag(name = "Controlleur Formateur",description = "Création des compte Formateur")
public class FormateurController {
    @Autowired
    private ServiceFormateur serviceFormateur;
    @Operation(summary = "Pour Créer un compte d'un formateur")
    @PostMapping("/createFormtr")
    public Formateur addFormateur(@RequestBody Formateur formateur) {
        return serviceFormateur.createFormateur(formateur);

    }
    @Operation(summary = "Pour afficher la liste des formateurs")
    @GetMapping("/listFormtr")
    public List<Formateur> listFormateur() {
        return serviceFormateur.getFormateurs();
    }
    @Operation(summary = "Pour Modifier un compte d'un formateur")
    @PutMapping("/updateFormtr/{id}")
    public Formateur updateFormateur(@RequestBody Formateur formateur,@PathVariable Long id) {
         return serviceFormateur.UpdateFormateur(id,formateur);
    }
    @Operation(summary = "Pour Supprimer un compte d'un formateur")
    @DeleteMapping("/deleteFormtr/{id}")
    public String deleteFormateur(@PathVariable Long id) {
        serviceFormateur.deleteFormateur(id);
        return "Formateur a été supprimre avec succès";
    }
}
