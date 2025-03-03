package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product("Product A");
        Product product2 = new Product("Product B");

        Item item1 = new Item(product1, new BigDecimal(50), 2, new BigDecimal(100));
        Item item2 = new Item(product2, new BigDecimal(30), 5, new BigDecimal(150));

        Invoice invoice = new Invoice("Invoice001");
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // Then
        assertNotEquals(0, invoiceId);

        // CleanUp
        try {
            invoiceDao.deleteById(invoiceId);
        } catch (Exception e) {
            // do nothing
        }
    }
}