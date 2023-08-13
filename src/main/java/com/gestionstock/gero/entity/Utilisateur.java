package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUtilisateur;

    @Column(nullable = false, length = 45)
    private String username;

    @Column(nullable = false, length = 45)
    private String NomUtilisateur;

    @Column(nullable = false, length = 45)
    private String PrenomUtilisateur;

    @Column( length = 15)
    private String TelUtilisateur;

    @Column(length = 45)
    private String AdresseUtilisateur;

    @Column(length = 45)
    private String EmailUtilisateur;

    @Column(nullable = false, length = 255)
    private String MotdePasse;

    /*@Column( length = 20)
    private String time;*/

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(length = 20)
    private String Rolest;
/*
    @CreatedDate
    private Date CreatedDate;

    @LastModifiedDate
    private Date ModifiedDate;
*/


}
