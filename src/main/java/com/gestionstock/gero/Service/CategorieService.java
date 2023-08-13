package com.gestionstock.gero.Service;

import com.gestionstock.gero.Repository.CategorieRepository;
import com.gestionstock.gero.entity.Categorie;
import com.gestionstock.gero.entity.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repo;

    public void Save(Categorie categorie){
        repo.save(categorie);
    }

    public List<Categorie> listAll()  {
        return repo.findAll();
    }
    public Categorie findById(Integer id){
        Optional<Categorie> categorie = repo.findById(id);
        return categorie.get();
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }


}
