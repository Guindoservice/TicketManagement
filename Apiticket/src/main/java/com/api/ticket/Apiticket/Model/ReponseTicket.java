package com.api.ticket.Apiticket.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reponseTicket")
@Data
public class ReponseTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Ticket ticket;
    private String status;
    private String reponseTicket;
    private String dateReponse;
   private String Priorse;
   @Enumerated
   private Cate categorie;
   @ManyToOne
   private Formateur formateur;
   @ManyToOne
   private Apprenant apprenant;

}
