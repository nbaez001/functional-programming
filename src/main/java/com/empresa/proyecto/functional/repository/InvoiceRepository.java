package com.empresa.proyecto.functional.repository;

import com.empresa.proyecto.functional.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}