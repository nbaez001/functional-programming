package com.empresa.proyecto.functional.dto;

import java.time.LocalDate;
import java.util.List;

public record InvoiceResponse(
        Long id,
        String customer,
        LocalDate date,
        List<String> products,
        Double amount,
        Double tax,
        Double total
) {
}