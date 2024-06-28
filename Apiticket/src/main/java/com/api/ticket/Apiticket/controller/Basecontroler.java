package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.BaseConnaissance;
import com.api.ticket.Apiticket.Model.ReponseTicket;
import com.api.ticket.Apiticket.service.BaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base/")
@Data
public class Basecontroler {
    @Autowired
    private final BaseService baseService;


    @PostMapping("/creerbase")
    public BaseConnaissance creerbase(@RequestBody BaseConnaissance reponse) {
        return baseService.creerbase(reponse);
    }
    @GetMapping("/listbase")
    public List<BaseConnaissance> list() {
        return baseService.afficheuserbase();
    }
    @PutMapping("/modifierbase/{id}")
    public BaseConnaissance modifier(@PathVariable long id , BaseConnaissance reponse) {
        return baseService.modifierbase(id, reponse);
    }

    @DeleteMapping("/suppbase/{id}")
    String delete(@PathVariable long id ) {

        return   baseService.supprimerbase(id);


}
}
