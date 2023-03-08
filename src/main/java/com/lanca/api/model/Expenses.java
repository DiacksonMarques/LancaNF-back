package com.lanca.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EXPENSES")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;
}
