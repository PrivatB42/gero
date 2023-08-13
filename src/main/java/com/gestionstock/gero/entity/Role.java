package com.gestionstock.gero.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRole;

    @Column(nullable = false, length = 20)
    private String LibelleRole;

    @CreatedDate
    private Date CreatedDate;

    @LastModifiedDate
    private Date ModifiedDate;

}
