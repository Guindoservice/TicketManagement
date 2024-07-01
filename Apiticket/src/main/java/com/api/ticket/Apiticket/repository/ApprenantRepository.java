package com.api.ticket.Apiticket.repository;

import com.api.ticket.Apiticket.Model.Admin;
import com.api.ticket.Apiticket.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    Optional<Apprenant> findByEmail(String email);
}
