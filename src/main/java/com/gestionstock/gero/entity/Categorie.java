package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCategorie;

    @Column(nullable = false, length = 45)
    private String libellecategorie;

    @Column(nullable = false, length = 45)
    private String Descriptioncategorie;

    /*@OneToMany
    @JoinColumn(name = "categorie_id")
    private List<Article> article;*/

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date CreatedDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ModifiedDate;


}
