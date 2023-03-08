package com.lanca.api.controller;

import com.lanca.api.model.Company;
import com.lanca.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/api/companys")
    public List<Company> getCompanyAll(){
        return companyService.getAllCompany();
    }

    @GetMapping("/api/company/{id}")
    public Optional<Company> getCompany(@PathVariable("id") Long id){
        return companyService.getByIdCompany(id);
    }

    @PostMapping("/api/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody Company company) {
        return companyService.insertCompany(company);
    }

    @PutMapping("/api/company")
    public Company update(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/api/company/{id}")
    public void delete(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
    }
}
