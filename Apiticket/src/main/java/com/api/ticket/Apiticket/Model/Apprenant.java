package com.api.ticket.Apiticket.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "apprenant")
@Data
@DiscriminatorValue("ADMIN")
public class Apprenant extends Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   @ManyToOne
   Admin admin;

}
