package com.api.ticket.Apiticket.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "admin")

@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Admin extends Utilisateur{



    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Formateur> formateur;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Apprenant> apprenant;
    @Setter
    @Id
    private Long id;




}
