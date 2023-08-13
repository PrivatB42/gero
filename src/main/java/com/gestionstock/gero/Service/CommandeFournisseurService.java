package com.gestionstock.gero.Service;

import com.gestionstock.gero.Repository.CommandeFournisseurRepository;
import com.gestionstock.gero.entity.CommandeFournisseur;
import com.gestionstock.gero.entity.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeFournisseurService {

    @Autowired
    private CommandeFournisseurRepository repo;

    public void Savecommande(CommandeFournisseur commandeFournisseur){
        repo.save(commandeFournisseur);
    }

    public List<CommandeFournisseur> listcommanderecu()  {
        return repo.listcommanderecu();
    }
    public List<CommandeFournisseur> listencours()  {
        return repo.listcommandeEncours();
    }

    public CommandeFournisseur findById(Integer id){
        Optional<CommandeFournisseur> commande = repo.findById(id);
        return commande.get();
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }




}
