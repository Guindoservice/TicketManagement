package com.api.ticket.Apiticket.service;

import com.api.ticket.Apiticket.Model.Admin;

import java.util.List;

public interface AdminService {
   Admin creer (Admin admin);

    List<Admin> afficheuser();

    Admin modifier(Long id, Admin admin);

    String supprimer(Long id);
}
