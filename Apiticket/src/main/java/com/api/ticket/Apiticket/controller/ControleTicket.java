package com.api.ticket.Apiticket.controller;

import com.api.ticket.Apiticket.Model.Ticket;
import com.api.ticket.Apiticket.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket/")
@Data
@Tag(name = "Controlleur Ticket", description = "La soumission des tickets se passe ici")
public class ControleTicket {
    @Autowired
    private final TicketService ticketService;

    @Operation(summary = "Pour soumettre un ticket")
    @PostMapping("/soumettre")
    public Ticket soumettre(@RequestBody Ticket ticket) {
        return ticketService.soumettre(ticket);
    }
    @Operation(summary = "Pour afficher un ticket")
    @GetMapping("/listTicket")
    public List<Ticket> listTicket() {
        return ticketService.liste();
    }
    @Operation(summary = "Pour Modifier un ticket")
    @PutMapping("/modifierTicket/{id}")
    public Ticket modifier(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.modifier(id,ticket);
    }
    @Operation(summary = "Pour supprimer un ticket")
    @DeleteMapping("/suppTicket/{id}")
    public String supp(@PathVariable Long id) {
        return ticketService.supprimer(id);
    }
}
