INSERT INTO brand (id, name) VALUES (1, 'ZARA');

INSERT INTO product (id, name) VALUES (35455, 'Product 35455');

INSERT INTO price_rate (id, description) VALUES
    (1, 'Price Rate 1'),
    (2, 'Price Rate 2'),
    (3, 'Price Rate 3'),
    (4, 'Price Rate 4');

INSERT INTO price (brand_id, start_date, end_date, price_rate_id, product_id, priority, price_value, currency) VALUES
    (1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR'),
    (1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR'),
    (1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR'),
    (1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR');