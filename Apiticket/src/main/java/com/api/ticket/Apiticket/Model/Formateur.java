package com.api.ticket.Apiticket.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "formateur")
@Data
public class Formateur extends Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   @ManyToOne
   Admin admin;

}
