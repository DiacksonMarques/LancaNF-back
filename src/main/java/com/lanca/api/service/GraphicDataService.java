package com.lanca.api.service;

import com.lanca.api.domain.BillingAvailableDTO;
import com.lanca.api.domain.ExpenseCategoriValuesDTO;
import com.lanca.api.domain.ValuesPerMonthsDTO;

import java.util.List;

public interface GraphicDataService {
    BillingAvailableDTO graphicBillingAvailable(Integer year);

    List<ValuesPerMonthsDTO> graphicInvoiceMonths(Integer year);

    List<ValuesPerMonthsDTO> graphicExpensePerYear(Integer year);

    List<ExpenseCategoriValuesDTO> graphicExpensePerCategori(Integer year);

    List<ValuesPerMonthsDTO> graphicSimpleSwing(Integer year);
}
