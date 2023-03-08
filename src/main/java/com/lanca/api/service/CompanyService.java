package com.lanca.api.service;

import com.lanca.api.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompany();

    Optional<Company> getByIdCompany(Long id);

    Company insertCompany(Company company);

    Company updateCompany(Company company);

    void deleteCompany(Long id);
}
