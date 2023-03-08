package com.lanca.api.repository;

import com.lanca.api.model.Invoice;
import com.lanca.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("select sum(in.valueInvoice) from Invoice in where year(in.receiptDate) = :year")
    BigDecimal sumInvoiceValue(Integer year);

    @Query("select in from Invoice in where year(in.receiptDate) = :year")
    List<Invoice> invoicePerYear(Integer year);
}
