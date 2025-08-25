package com.empresa.proyecto.functional.service;

import com.empresa.proyecto.functional.dto.InvoiceRequest;
import com.empresa.proyecto.functional.dto.InvoiceResponse;
import com.empresa.proyecto.functional.entity.Invoice;
import com.empresa.proyecto.functional.entity.InvoiceLine;
import com.empresa.proyecto.functional.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository repo;

    public InvoiceService(InvoiceRepository repo) {
        this.repo = repo;
    }

    public InvoiceResponse createInvoice(InvoiceRequest req) {
        Invoice invoice = Invoice.builder()
                .id(req.id())
                .customerName(req.customerName())
                .date(req.date())
                .build();
        if (req.lines() != null) {
            List<InvoiceLine> lines = req.lines().stream()
                    .map(l -> InvoiceLine
                            .builder()
                            .product(l.product())
                            .quantity(l.quantity())
                            .unitPrice(l.unitPrice())
                            .invoice(invoice)
                            .build())
                    .toList();
            invoice.setLines(lines);
        }
        return mapToResponse(repo.save(invoice));
    }

    public Optional<InvoiceResponse> getInvoice(Long id) {
        return repo.findById(id).map(this::mapToResponse);
    }

    public Optional<InvoiceResponse> updateInvoice(Long id, InvoiceRequest req) {
        return repo.findById(id).map(existing -> {
            existing.setCustomerName(req.customerName());
            existing.setDate(req.date());
            if (req.lines() != null) {
                List<InvoiceLine> lines = req.lines().stream()
                        .map(l -> InvoiceLine
                                .builder()
                                .product(l.product())
                                .quantity(l.quantity())
                                .unitPrice(l.unitPrice())
                                .invoice(existing)
                                .build())
                        .toList();
                existing.setLines(lines);
            }
            return mapToResponse(repo.save(existing));
        });
    }

    public void deleteInvoice(Long id) {
        repo.deleteById(id);
    }

    public List<InvoiceResponse> listInvoices() {
        return repo.findAll().stream()
                .filter(inv -> inv.getLines() != null && !inv.getLines().isEmpty())
                .map(this::mapToResponse)
                .sorted(Comparator.comparing(InvoiceResponse::grandTotal).reversed())
                .toList();
    }

    private InvoiceResponse mapToResponse(Invoice inv) {
        List<InvoiceLine> validLines = Optional.ofNullable(inv.getLines())
                .stream()
                .flatMap(List::stream)
                .filter(l -> Optional.ofNullable(l.getQuantity()).orElse(0) > 0 &&
                        Optional.ofNullable(l.getUnitPrice()).orElse(0.0) > 0.0)
                .toList();

        double total = validLines.stream()
                .mapToDouble(l -> l.getQuantity() * l.getUnitPrice())
                .sum();

        double tax = total * 0.18;
        double grandTotal = total + tax;

        List<String> products = validLines.stream()
                .map(l -> Optional.ofNullable(l.getProduct()).orElse("UNKNOWN PRODUCT"))
                .filter(p -> !p.isBlank())
                .distinct()
                .sorted()
                .toList();

        double avgLineValue = validLines.stream()
                .mapToDouble(l -> l.getQuantity() * l.getUnitPrice())
                .average()
                .orElse(0.0);

        String mostExpensive = validLines.stream()
                .max(Comparator.comparingDouble(l -> l.getQuantity() * l.getUnitPrice()))
                .map(InvoiceLine::getProduct)
                .orElse("N/A");

        return new InvoiceResponse(
                inv.getId(),
                Optional.ofNullable(inv.getCustomerName()).filter(n -> !n.isBlank()).orElse("Anonymous"),
                Optional.ofNullable(inv.getDate()).orElse(LocalDate.now()),
                products,
                total,
                tax,
                grandTotal,
                avgLineValue,
                mostExpensive
        );
    }
}