package com.api.ticket.Apiticket.service;

import com.api.ticket.Apiticket.Model.Apprenant;

import java.util.List;

public interface ServicesApprenant  {

    Apprenant getApprenant(Apprenant apprenant);

    List<Apprenant> listeApprenants();


    Apprenant updateApprenant(Apprenant apprenant, Long id);

      String deleteApprenant(Long id);

}
