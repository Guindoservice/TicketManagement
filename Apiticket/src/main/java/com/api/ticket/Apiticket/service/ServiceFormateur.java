package com.api.ticket.Apiticket.service;


import com.api.ticket.Apiticket.Model.Formateur;

import java.util.List;

public interface ServiceFormateur {
    Formateur createFormateur(Formateur formateur);

    List<Formateur> getFormateurs();

    Formateur UpdateFormateur( Long id, Formateur formateur);

    String deleteFormateur(Long id);
}
