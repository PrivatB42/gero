package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LigneVente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDlc;

    @Column(nullable = false, length = 10)
    private int PrixHtlc;

    @Column(nullable = false, length = 10)
    private int qte;

    @ManyToOne
    @JoinColumn(name = "Idventelc")
    private Vente idventelc;

    @ManyToOne
    @JoinColumn(name = "Idarticlelc")
    private Article Idarticlelc;


}
