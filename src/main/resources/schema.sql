DROP TABLE IF EXISTS invoice_lines;
DROP TABLE IF EXISTS invoices;

CREATE TABLE invoices (
    id BIGINT PRIMARY KEY,
    customer_name VARCHAR(255),
    date DATE
);

CREATE TABLE invoice_lines (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(255),
    quantity INT,
    unit_price DOUBLE,
    invoice_id BIGINT,
    CONSTRAINT fk_invoice FOREIGN KEY (invoice_id) REFERENCES invoices(id) ON DELETE CASCADE
);