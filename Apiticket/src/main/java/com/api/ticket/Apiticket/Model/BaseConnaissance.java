package com.api.ticket.Apiticket.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "connaissance")
@Data
public class BaseConnaissance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Description;
    @ManyToOne(fetch = FetchType.EAGER)
    private Ticket ticket;
    @ManyToOne
    private Admin formateur;
    @ManyToOne
    private Admin apprenant;
    private String date;

}
