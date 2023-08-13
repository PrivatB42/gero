package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdFournisseur;

    @Column(nullable = false, length = 45)
    private String NomFournisseur;

    @Column(nullable = false, length = 45)
    private int ContactForunisseur;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date CreatedDate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ModifiedDate;

}
