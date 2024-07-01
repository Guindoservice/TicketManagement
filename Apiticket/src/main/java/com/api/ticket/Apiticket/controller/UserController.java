package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/")
@Data
@Tag(name = "ControllerAdmin",description = "Pour créer des Administrateurs")
public class UserController {

    @Autowired
    private final AdminService adminService;
    @Operation(summary = "Pour créer un compte admin")
    @PostMapping("/Create")
    public Admin Create(@RequestBody Admin admin) {
        return adminService.creer(admin);
    }
    @Operation(summary = "Pour afficher la liste des admins")
    @GetMapping("/liste")
    public List<Admin> liste() {
        return adminService.afficheuser();
    }
    @Operation(summary = "Pour modifer un compte admin")
    @PutMapping("/modifier/{id}")
    public Admin modifier(@PathVariable long id , @RequestBody Admin admin) {
        return  adminService.modifier(id, admin);
    }
    @Operation(summary = "Pour supprimer un compte admin")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable long id) {
        return adminService.supprimer(id);
    }

}
