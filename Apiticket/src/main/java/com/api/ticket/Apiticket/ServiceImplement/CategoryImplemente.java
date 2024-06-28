//package com.api.ticket.Apiticket.ServiceImplement;
//
//import com.api.ticket.Apiticket.Model.ClasseCategorie;
//import com.api.ticket.Apiticket.repository.CategoryRepository;
//import com.api.ticket.Apiticket.service.CategoryService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//@Data
//public class CategoryImplemente implements CategoryService {
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Override
//    public ClasseCategorie creeatCate(ClasseCategorie cate) {
//        return categoryRepository.save(cate);
//    }
//
//    @Override
//    public List<ClasseCategorie> afficheuCatat() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public ClasseCategorie modifierCate(Long id, ClasseCategorie cate) {
//        return null;
//    }
//
//    @Override
//    public String supprimerCate(Long id) {
//        categoryRepository.deleteById(id);
//        return "Categorie supprimer";
//    }
//}
