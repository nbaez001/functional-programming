package com.empresa.proyecto.functional.dto;

public record InvoiceLineRequest(
        String product,
        Integer quantity,
        Double unitPrice
) {
}