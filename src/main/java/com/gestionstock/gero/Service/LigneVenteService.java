package com.gestionstock.gero.Service;

import com.gestionstock.gero.Repository.LigneVenteRepository;
import com.gestionstock.gero.entity.LigneVente;
import com.gestionstock.gero.entity.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneVenteService {

    @Autowired
    public LigneVenteRepository ligneVenteRepository;

    public void SaveLV(LigneVente ligneVente){
        ligneVenteRepository.save(ligneVente);
    }

    public List<LigneVente> ListLV(){
        return ligneVenteRepository.findAll();
    }

    public LigneVente findbyId(Integer id){
        Optional<LigneVente> article = ligneVenteRepository.findById(id);
        return article.get();
    }

    public void DeleteLV(Integer id){
        ligneVenteRepository.deleteById(id);
    }

    public List<LigneVente> ListelvByVenteID(Vente vente){
        return ligneVenteRepository.findByIdventelc(vente);
    }

}
