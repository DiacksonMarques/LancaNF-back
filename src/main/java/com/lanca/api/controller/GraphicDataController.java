package com.lanca.api.controller;

import com.lanca.api.domain.BillingAvailableDTO;
import com.lanca.api.domain.ExpenseCategoriValuesDTO;
import com.lanca.api.domain.ValuesPerMonthsDTO;
import com.lanca.api.service.GraphicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
public class GraphicDataController {

    @Autowired
    private GraphicDataService graphicDataService;

     @GetMapping("/api/graphic/billingAvailable/{year}")
        public BillingAvailableDTO graphicBillingAvailable(@PathVariable Integer year){
            return graphicDataService.graphicBillingAvailable(year);
    }


    @GetMapping("/api/graphic/invoiceMonths/{year}")
    public List<ValuesPerMonthsDTO> graphicInvoiceMonths(@PathVariable Integer year){
        return graphicDataService.graphicInvoiceMonths(year);
    }

    @GetMapping("/api/graphic/expenseMonths/{year}")
    public List<ValuesPerMonthsDTO> graphicExpenseMonths(@PathVariable Integer year){
        return graphicDataService.graphicExpensePerYear(year);
    }

    @GetMapping("/api/graphic/expensePerCategori/{year}")
    public List<ExpenseCategoriValuesDTO> graphicExpensePerCategori(@PathVariable Integer year){
        return graphicDataService.graphicExpensePerCategori(year);
    }

    @GetMapping("/api/graphic/simpleSwing/{year}")
    public List<ValuesPerMonthsDTO> graphicSimpleSwing(@PathVariable Integer year){
        return graphicDataService.graphicSimpleSwing(year);
    }


}
