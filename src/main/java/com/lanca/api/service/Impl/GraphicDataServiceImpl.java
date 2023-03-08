package com.lanca.api.service.Impl;

import com.lanca.api.domain.BillingAvailableDTO;
import com.lanca.api.domain.ExpenseCategoriValuesDTO;
import com.lanca.api.domain.ValuesPerMonthsDTO;
import com.lanca.api.model.BillingLimit;
import com.lanca.api.model.ExpenseCategories;
import com.lanca.api.model.Expenses;
import com.lanca.api.model.Invoice;
import com.lanca.api.repository.BillingLimitRepository;
import com.lanca.api.repository.ExpenseCategoriesRepository;
import com.lanca.api.repository.ExpensesRepository;
import com.lanca.api.repository.InvoiceRepository;
import com.lanca.api.service.GraphicDataService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class GraphicDataServiceImpl implements GraphicDataService {

    public String[] months = {"JAN.", "FEV.", "MAR.", "ABR.", "MAI.", "JUN.", "JUL.", "AGO.", "SET.", "OUT.", "NOV.", "DEZ."};

    @Autowired
    private BillingLimitRepository billingLimitRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    @Autowired
    private ExpenseCategoriesRepository expenseCategoriesRepository;

    public BillingAvailableDTO graphicBillingAvailable(Integer year){
        List<BillingLimit> billingLimitList = billingLimitRepository.findAll();
        BillingLimit billingLimit = billingLimitList.get(0);

        BigDecimal totalInvoiceValue = invoiceRepository.sumInvoiceValue(year);

        BillingAvailableDTO billingAvailableDTO = new BillingAvailableDTO();
        billingAvailableDTO.setBillingLimit(billingLimit.getLimit());
        if(totalInvoiceValue != null){
            billingAvailableDTO.setTotalPosted(totalInvoiceValue);
        } else {
            billingAvailableDTO.setTotalPosted(BigDecimal.valueOf(0));
        }

        return billingAvailableDTO;
    }

    @Override
    public List<ValuesPerMonthsDTO> graphicInvoiceMonths(Integer year) {
        List<Invoice> invoiceList = invoiceRepository.invoicePerYear(year);
        List<ValuesPerMonthsDTO> invoicePerMonthsList = new ArrayList<ValuesPerMonthsDTO>();

        for (int index = 0; index < 12; index++){
            ValuesPerMonthsDTO invoicePerMonthsDTO = new ValuesPerMonthsDTO();
            invoicePerMonthsDTO.setMonth(months[index].toUpperCase());
            invoicePerMonthsDTO.setValueMonth(BigDecimal.valueOf(0));
            invoicePerMonthsList.add(invoicePerMonthsDTO);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MMM");
        invoiceList.forEach(invoice -> {
            String month = sdf.format(invoice.getReceiptDate()).toUpperCase();
            Integer indexInvoicePerMonths = ArrayUtils.indexOf(months, month);

            if(indexInvoicePerMonths > -1){
                double valueInvoiceMonthDouble = invoicePerMonthsList.get(indexInvoicePerMonths).getValueMonth().doubleValue();
                double valueInvoiceDouble = invoice.getValueInvoice().doubleValue();

                invoicePerMonthsList.get(indexInvoicePerMonths)
                        .setValueMonth(BigDecimal.valueOf(valueInvoiceMonthDouble += valueInvoiceDouble));
            }
        });

        return invoicePerMonthsList;
    }

    @Override
    public List<ValuesPerMonthsDTO> graphicExpensePerYear(Integer year) {
        List<Expenses> expenseList = expensesRepository.expensePerYear(year);
        List<ValuesPerMonthsDTO> expensePerMonthsList = new ArrayList<ValuesPerMonthsDTO>();

        for (int index = 0; index < 12; index++){
            ValuesPerMonthsDTO invoicePerMonthsDTO = new ValuesPerMonthsDTO();
            invoicePerMonthsDTO.setMonth(months[index].toUpperCase());
            invoicePerMonthsDTO.setValueMonth(BigDecimal.valueOf(0));
            expensePerMonthsList.add(invoicePerMonthsDTO);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MMM");
        expenseList.forEach(expense -> {
            String month = sdf.format(expense.getPayDay()).toUpperCase();
            Integer indexExpensePerMonths = ArrayUtils.indexOf(months, month);

            if(indexExpensePerMonths > -1){
                double valueInvoiceMonthDouble = expensePerMonthsList.get(indexExpensePerMonths).getValueMonth().doubleValue();
                double valueInvoiceDouble = expense.getExpenseAmount().doubleValue();

                expensePerMonthsList.get(indexExpensePerMonths)
                        .setValueMonth(BigDecimal.valueOf(valueInvoiceMonthDouble += valueInvoiceDouble));
            }
        });

        return expensePerMonthsList;
    }

    @Override
    public List<ExpenseCategoriValuesDTO> graphicExpensePerCategori(Integer year) {
        List<ExpenseCategories> expenseCategoriesList = expenseCategoriesRepository.findAll();
        List<Expenses> expenseList = expensesRepository.expensePerYear(year);
        List<ExpenseCategoriValuesDTO> expenseCategoriValueList = new ArrayList<ExpenseCategoriValuesDTO>();

        for (int index = 0; index < expenseCategoriesList.size(); index++){
            ExpenseCategoriValuesDTO expenseCategoriValuesDTO = new ExpenseCategoriValuesDTO();
            expenseCategoriValuesDTO.setExpenseCategories(expenseCategoriesList.get(index));
            expenseCategoriValuesDTO.setValueTotalCategori(BigDecimal.valueOf(0));
            expenseCategoriValueList.add(expenseCategoriValuesDTO);
        }

        expenseList.forEach(expense -> {
            Integer indexExpenseCategori = expenseCategoriesList.indexOf(expense.getExpenseCategori());

            if(indexExpenseCategori > -1){
                double valueSumExpenseCategori = expenseCategoriValueList.get(indexExpenseCategori).getValueTotalCategori().doubleValue();
                double valueCurrentExpense = expense.getExpenseAmount().doubleValue();

                expenseCategoriValueList.get(indexExpenseCategori).setValueTotalCategori(BigDecimal.valueOf(valueSumExpenseCategori += valueCurrentExpense));
            }
        });

        return expenseCategoriValueList;
    }


    public List<ValuesPerMonthsDTO> graphicSimpleSwing(Integer year){
        List<ValuesPerMonthsDTO> invoiceList = this.graphicInvoiceMonths(year);
        List<ValuesPerMonthsDTO> expenseList = this.graphicExpensePerYear(year);
        List<ValuesPerMonthsDTO> simpleSwingList = new ArrayList<>();

        for (int index = 0; index < invoiceList.size(); index++){
            ValuesPerMonthsDTO newValue = new ValuesPerMonthsDTO();
            newValue.setMonth(invoiceList.get(index).getMonth());

            double invoiceDouble = invoiceList.get(index).getValueMonth().doubleValue();
            double expenseDouble = expenseList.get(index).getValueMonth().doubleValue();
            newValue.setValueMonth(BigDecimal.valueOf(invoiceDouble - expenseDouble));

            simpleSwingList.add(newValue);
        }

        return  simpleSwingList;
    }
}
