package com.gestionstock.gero.Repository;

import com.gestionstock.gero.entity.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    @Query(value = "SELECT * FROM commande_fournisseur WHERE etat=\"En_cours\";", nativeQuery = true)
    List<CommandeFournisseur> listcommandeEncours();

    @Query(value = "SELECT * FROM commande_fournisseur WHERE etat=\"reçu\";", nativeQuery = true)
    List<CommandeFournisseur> listcommanderecu();

}
