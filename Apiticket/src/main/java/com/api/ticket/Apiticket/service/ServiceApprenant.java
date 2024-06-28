package com.api.ticket.Apiticket.service;


import com.api.ticket.Apiticket.Model.Apprenant;
import com.api.ticket.Apiticket.Model.Formateur;

import java.util.List;

public interface ServiceApprenant {
    Apprenant createFormateur(Apprenant apprenant);

    List<Apprenant> getFormateurs();

    Apprenant UpdateFormateur( Long id, Apprenant apprenant);

    String deleteFormateur(Long id);
}
