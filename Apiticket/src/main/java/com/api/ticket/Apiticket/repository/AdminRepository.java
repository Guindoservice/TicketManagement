package com.api.ticket.Apiticket.repository;

import com.api.ticket.Apiticket.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository <Admin,Long> {
    Optional <Admin> findByEmail(String email);

}
