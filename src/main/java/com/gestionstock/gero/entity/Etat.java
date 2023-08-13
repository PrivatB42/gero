package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
public class Etat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdEtat;

    @Column(nullable = false, length = 25)
    private String Libelle;

    @CreatedDate
    private Date CreatedDate;

    @LastModifiedDate
    private Date ModifiedDate;

}
