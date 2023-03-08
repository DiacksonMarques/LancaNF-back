package com.lanca.api.service;

import com.lanca.api.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> getAllInvoice();

    Optional<Invoice> getByIdInvoice(Long id);

    Invoice insertInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    void deleteInvoice(Long id);

    List<Invoice> historicalRelease(Integer year);

}
