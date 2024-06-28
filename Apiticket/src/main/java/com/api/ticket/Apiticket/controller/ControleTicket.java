package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.Ticket;
import com.api.ticket.Apiticket.service.TicketService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket/")
@Data
public class ControleTicket {
    @Autowired
    private final TicketService ticketService;


    @PostMapping("/soumettre")
    public Ticket soumettre(@RequestBody Ticket ticket) {

        return ticketService.soumettre(ticket);
    }
    @GetMapping("/listTicket")
    public List<Ticket> listTicket() {
        return ticketService.liste();
    }

    @PutMapping("/modifierTicket/{id}")
    public Ticket modifier(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.modifier(id,ticket);
    }

    @DeleteMapping("/suppTicket/{id}")
    public String supp(@PathVariable Long id) {
        return ticketService.supprimer(id);
    }
}
