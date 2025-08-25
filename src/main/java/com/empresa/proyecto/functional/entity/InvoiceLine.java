package com.empresa.proyecto.functional.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoice_lines")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private Integer quantity;
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}