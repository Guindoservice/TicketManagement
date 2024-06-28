package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.service.AdminService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/")
@Data
public class UserController {

    @Autowired
    private final AdminService adminService;

    @PostMapping("/Create")
    public Admin Create(@RequestBody Admin admin) {
        return adminService.creer(admin);
    }
    @GetMapping("/liste")
    public List<Admin> liste() {
        return adminService.afficheuser();
    }
    @PutMapping("/modifier/{id}")
    public Admin modifier(@PathVariable long id , @RequestBody Admin admin) {
        return  adminService.modifier(id, admin);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable long id) {
        return adminService.supprimer(id);
    }

}
