package com.gestionstock.gero.Service;

import com.gestionstock.gero.Repository.UtilisateurRepository;
import com.gestionstock.gero.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository repo;

    @Autowired private BCryptPasswordEncoder encoder;

    public void SaveUtilisateur(Utilisateur utilisateur){
        utilisateur.setMotdePasse(encoder.encode(utilisateur.getMotdePasse()));
        repo.save(utilisateur);
    }

    public List<Utilisateur> findAll(){
        return repo.findAll();
    }

    public Utilisateur findById(Integer id){
        Optional<Utilisateur> utilisateur = repo.findById(id);
        return utilisateur.orElseThrow();
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }

}
