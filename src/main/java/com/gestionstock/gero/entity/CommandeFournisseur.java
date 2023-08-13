package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Data
public class CommandeFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCommandeF;

    @ManyToOne
    @JoinColumn(name = "IdArticle")
    private Article IdArticle;

    @ManyToOne
    @JoinColumn(name = "IdFournisseur")
    private  Fournisseur IdFournisseur;

    @Column(length = 45)
    private String etat;

    @Column(nullable = false, length = 10)
    private int Quantite;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date CreatedDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ModifiedDate;


}
