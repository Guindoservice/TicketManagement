package com.api.ticket.Apiticket.repository;

import com.api.ticket.Apiticket.Model.Apprenant;
import com.api.ticket.Apiticket.Model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    Optional<Formateur> findByEmail(String email);
}
