package com.api.ticket.Apiticket.ServiceImplement;

import com.api.ticket.Apiticket.Model.Formateur;
import com.api.ticket.Apiticket.Model.Ticket;
import com.api.ticket.Apiticket.repository.TIcketRepository;
import com.api.ticket.Apiticket.service.MailService;
import com.api.ticket.Apiticket.service.TicketService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TicketImplemente implements TicketService {

    @Autowired
    private final TIcketRepository ticketRepository;

    @Autowired
    MailService mailService;



    @Override
    public Ticket soumettre(Ticket ticket) {

        String  message = "Un nouveau ticket vous a été soumit par " + ticket.getApprenant();
        mailService.sendSimpleMail(ticket.getFormateur().getEmail(),message);
        return ticketRepository.save(ticket);


    }

    @Override
    public List<Ticket> liste () {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket modifier(Long id, Ticket ticket) {
        return ticketRepository.findById(id)
                .map(t-> {
                    t.setDescription(ticket.getDescription());
                    t.setDate(ticket.getDate());
                    t.setStatus(ticket.getStatus());
                    t.setApprenant(ticket.getApprenant());
                    return ticketRepository.save(t);
                }).orElseThrow(() -> new RuntimeException(" votre ticket n'est pas disponbile"));



    }

    @Override
    public String supprimer (Long id ) {
        ticketRepository.deleteById(id);
        return "";
    }
}
