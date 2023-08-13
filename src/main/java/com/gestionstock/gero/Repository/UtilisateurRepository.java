package com.gestionstock.gero.Repository;

import com.gestionstock.gero.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByUsername(String username);

/*
    @Query(value = "SELECT * FROM utilisateur u where u.username like :username", nativeQuery = true)
    Utilisateur getUserByUsername(@Param("username")String username);
*/



}
