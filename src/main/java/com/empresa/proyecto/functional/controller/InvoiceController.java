package com.empresa.proyecto.functional.controller;

import com.empresa.proyecto.functional.dto.InvoiceRequest;
import com.empresa.proyecto.functional.dto.InvoiceResponse;
import com.empresa.proyecto.functional.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InvoiceResponse> create(@RequestBody InvoiceRequest req) {
        return ResponseEntity.ok(service.createInvoice(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getOne(@PathVariable Long id) {
        return service.getInvoice(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResponse>> getAll() {
        return ResponseEntity.ok(service.listInvoices());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponse> update(@PathVariable Long id, @RequestBody InvoiceRequest req) {
        return service.updateInvoice(id, req)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}