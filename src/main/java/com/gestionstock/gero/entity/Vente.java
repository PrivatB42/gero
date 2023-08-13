package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdVente;

    @Column(nullable = false, length = 15)
    private int Totalprix;

    @CreatedDate
    private Date CreatedDate;

    @LastModifiedDate
    private Date ModifiedDate;

}
