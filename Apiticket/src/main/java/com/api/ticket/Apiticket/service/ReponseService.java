package com.api.ticket.Apiticket.service;

import com.api.ticket.Apiticket.Model.ReponseTicket;

import java.util.List;

public interface ReponseService {
    ReponseTicket CreerReponse(ReponseTicket reponse);

    List<ReponseTicket> ListReponse();


    ReponseTicket ModifierReponse(Long id, ReponseTicket reponse);

    String supprimerReponse(Long id);

}
