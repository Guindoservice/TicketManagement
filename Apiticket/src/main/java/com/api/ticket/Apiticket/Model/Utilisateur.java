package com.api.ticket.Apiticket.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
@MappedSuperclass



public abstract class Utilisateur {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String nom;
    private String email;
    private String password;
    private String role;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
