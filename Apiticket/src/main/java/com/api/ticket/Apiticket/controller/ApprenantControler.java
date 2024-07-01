package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.Apprenant;
import com.api.ticket.Apiticket.repository.ApprenantRepository;
import com.api.ticket.Apiticket.service.ServicesApprenant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addApprenant")
@Tag(name = "Controleur Apprenant",description = "Création du compte des apprenants")
public class ApprenantControler {

    @Autowired
    private ServicesApprenant servicesApprenant;
    @Operation(summary = "Pour créer un compte apprennt")
    @PostMapping("/createAppnt")
    public Apprenant createAppnt(@RequestBody Apprenant apprenant) {
        return  servicesApprenant.getApprenant(apprenant);
    }
    @Operation(summary = "Pour afficher la liste des apprenants")
    @GetMapping("/listAppnt")
    public List<Apprenant> listAppnt() {
        return servicesApprenant.listeApprenants();
    }
    @Operation(summary = "Pour Modifier le compte d'un apprenant")
    @PutMapping ("/updareAppnt/{id}")
    public Apprenant updateAppnt(@RequestBody Apprenant apprenant , @PathVariable Long id) {
        return servicesApprenant.updateApprenant(apprenant, id);
    }
    @Operation(summary = "Pour supprimer un compte d'un apprenant")
    @DeleteMapping("/deletAppnt/{id}")
    public String deleteAppnt(@PathVariable Long id) {
                servicesApprenant.deleteApprenant(id);
                return "Apprenant  a été supprimer !";
    }

}
