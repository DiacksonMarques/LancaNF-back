package com.lanca.api.model;

import jakarta.persistence.*;

@Entity
@Table(name="COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "CNPJ", length = 14, nullable = false)
    private String cnpj;

    @Column(name = "COMPANYNAME", nullable = false)
    private String companyName;

    @Column(name = "CORPORATENAME", nullable = false)
    private String corporateName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }
}
