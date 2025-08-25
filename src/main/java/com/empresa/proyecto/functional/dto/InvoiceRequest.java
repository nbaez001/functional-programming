package com.empresa.proyecto.functional.dto;

import java.time.LocalDate;
import java.util.List;

public record InvoiceRequest(
        Long id,
        String customerName,
        LocalDate date,
        List<InvoiceLineRequest> lines
) {
}