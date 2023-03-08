package com.lanca.api.service.Impl;

import com.lanca.api.model.Company;
import com.lanca.api.repository.CompanyRepository;
import com.lanca.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getByIdCompany(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company insertCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.findById(company.getId()).
                map(client -> {
                    return companyRepository.save(company);
                })
                .orElseGet(() -> {
                    return companyRepository.save(company);
                });
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
