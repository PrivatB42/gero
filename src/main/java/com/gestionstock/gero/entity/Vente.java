package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdVente;

    @Column(nullable = false, length = 15)
    private int Totalprix;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String CreatedDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String ModifiedDate;

}
