package com.gestionstock.gero.Service;

import com.gestionstock.gero.Other.FournisseurNotFoundException;
import com.gestionstock.gero.Repository.FournisseurRepository;
import com.gestionstock.gero.entity.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository repo;

    public void Savefournsseur(Fournisseur fournisseur){
        repo.save(fournisseur);
    }

    public List<Fournisseur> listAll()  {
        return repo.findAll();
    }
    public Fournisseur findById(Integer id){
        Optional<Fournisseur> fournisseur = repo.findById(id);
        return fournisseur.get();
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }



}
