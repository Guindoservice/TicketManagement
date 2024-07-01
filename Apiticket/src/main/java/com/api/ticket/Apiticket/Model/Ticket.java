package com.api.ticket.Apiticket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     private String titre;
     private String description;
     private String date;

     @Enumerated
     private Statut status;
     @ManyToOne
     @JoinColumn(name = "apprenant_id")
     private Apprenant apprenant;
     @ManyToOne
     @JoinColumn(name = "formateur_id")
     private  Formateur formateur;
}
