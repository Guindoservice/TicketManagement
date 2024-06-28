package com.api.ticket.Apiticket.service;

import com.api.ticket.Apiticket.Model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket soumettre (Ticket ticket);

    List<Ticket> liste();

    Ticket modifier ( Long id,Ticket ticket);

    String supprimer (Long id);
}
