package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdArticle;

    @Column(nullable = false, length = 45)
    private String LibelleArticle;

    @Column( length = 100)
    private String DescriptionArticle;

    @Column(nullable = false, length = 10)
    private int PrixAchat;

    @Column(nullable = false, length = 10)
    private int PrixVente;

    @Column(nullable = false, length = 10)
    private int Stock;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date CreatedDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ModifiedDate;

}
