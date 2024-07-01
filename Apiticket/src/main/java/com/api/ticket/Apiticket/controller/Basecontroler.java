package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.BaseConnaissance;
import com.api.ticket.Apiticket.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base/")
@Tag(name = "Base de connaissance ", description = "La base de connaissance pour les question fréquents")
@Data
public class Basecontroler {
    @Autowired
    private final BaseService baseService;

    @Operation(summary = "Pour créer une base de connaissanse")
    @PostMapping("/creerbase")
    public BaseConnaissance creerbase(@RequestBody BaseConnaissance reponse) {
        return baseService.creerbase(reponse);
    }
    @Operation(summary = "Pour afficher la liste  des  bases de connaissanse")
    @GetMapping("/listbase")
    public List<BaseConnaissance> list() {
        return baseService.afficheuserbase();
    }
    @Operation(summary = "Pour Modifier une base de connaissanse")
    @PutMapping("/modifierbase/{id}")
    public BaseConnaissance modifier(@PathVariable long id , BaseConnaissance reponse) {
        return baseService.modifierbase(id, reponse);
    }
    @Operation(summary = "Pour Supprimer,, une base de connaissanse")
    @DeleteMapping("/suppbase/{id}")
    String delete(@PathVariable long id ) {

        return   baseService.supprimerbase(id);


}
}
