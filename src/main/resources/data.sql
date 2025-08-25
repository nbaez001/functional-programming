INSERT INTO invoices (id, customer_name, date)
VALUES (1, 'ACME Corp', '2025-08-01'),
       (2, 'Tech Solutions', '2025-08-10'),
       (3, 'Global Trading', '2025-08-15');

INSERT INTO invoice_lines (product, quantity, unit_price, invoice_id)
VALUES ('Monitor', 2, 300.0, 1),
       ('Keyboard', 5, 50.0, 1),
       ('Mouse', 3, 25.0, 1);

INSERT INTO invoice_lines (product, quantity, unit_price, invoice_id)
VALUES ('Laptop', 1, 1200.0, 2),
       ('Docking Station', 1, 200.0, 2);

INSERT INTO invoice_lines (product, quantity, unit_price, invoice_id)
VALUES ('Server Rack', 1, 1500.0, 3),
       ('Cooling Fan', 10, 30.0, 3);