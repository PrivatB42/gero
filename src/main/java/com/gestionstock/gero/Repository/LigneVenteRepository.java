package com.gestionstock.gero.Repository;

import com.gestionstock.gero.entity.LigneVente;
import com.gestionstock.gero.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {

    List<LigneVente> findByIdventelc(Vente vente);

}
