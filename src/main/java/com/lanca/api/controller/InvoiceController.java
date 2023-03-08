package com.lanca.api.controller;

import com.lanca.api.model.Invoice;
import com.lanca.api.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/api/invoices")
    public List<Invoice> getInvoiceAll(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/api/invoice/{id}")
    public Optional<Invoice> getInvoice(@PathVariable("id") Long id){
        return invoiceService.getByIdInvoice(id);
    }

    @GetMapping("/api/invoice/historicalRelease/{year}")
    public List<Invoice> historicalRelease(@PathVariable("year") Integer year){
        return invoiceService.historicalRelease(year);
    }

    @PostMapping("/api/invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice create(@RequestBody Invoice invoice) {
        return invoiceService.insertInvoice(invoice);
    }

    @PutMapping("/api/invoice")
    public Invoice update(@RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(invoice);
    }

    @DeleteMapping("/api/invoice/{id}")
    public void delete(@PathVariable("id") Long id) {
        invoiceService.deleteInvoice(id);
    }
}
