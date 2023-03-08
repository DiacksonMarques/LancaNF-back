package com.lanca.api.service.Impl;

import com.lanca.api.model.Invoice;
import com.lanca.api.repository.InvoiceRepository;
import com.lanca.api.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> getByIdInvoice(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Invoice insertInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.findById(invoice.getId()).
                map(client -> {
                    return invoiceRepository.save(invoice);
                })
                .orElseGet(() -> {
                    return invoiceRepository.save(invoice);
                });
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<Invoice> historicalRelease(Integer year){
        return invoiceRepository.invoicePerYear(year);
    };
}
