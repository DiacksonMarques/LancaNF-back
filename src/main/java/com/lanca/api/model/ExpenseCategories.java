package com.lanca.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "EXPENSE_CATEGORIES")
public class ExpenseCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "NAME_CATEGORI", nullable = false)
    private String nameCategori;

    @Column(name = "DESCRIPTION_CATEGORI", nullable = false, length = 5000)
    private String descriptionCategori;

    @Column(name = "FILED", nullable = false)
    private boolean filed = true;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNameCategori() {
        return nameCategori;
    }

    public void setNameCategori(String nameCategori) {
        this.nameCategori = nameCategori;
    }

    public String getDescriptionCategori() {
        return descriptionCategori;
    }

    public void setDescriptionCategori(String descriptionCategori) {
        this.descriptionCategori = descriptionCategori;
    }

    public Boolean getFiled() {
        return filed;
    }

    public void setFiled(Boolean filed) {
        this.filed = filed;
    }
}
