package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int IdArticle;

   /* @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, length = 45)
    private String reference;*/

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

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date CreatedDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ModifiedDate;

}
