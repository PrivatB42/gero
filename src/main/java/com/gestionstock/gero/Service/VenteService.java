package com.gestionstock.gero.Service;

import com.gestionstock.gero.Repository.VenteRepository;
import com.gestionstock.gero.entity.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    private VenteRepository repo;


    public Vente SaveVente(Vente vente){

        repo.save(vente);

        return vente;
    }

    public List<Vente> AffichVente(){
        return repo.findAll();
    }

    public Vente VenteParID(Integer id){
        Optional<Vente> vente = repo.findById(id);
        return vente.orElseThrow();
    }

}
