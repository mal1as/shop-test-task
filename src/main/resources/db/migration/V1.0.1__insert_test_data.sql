insert into product values (1, 'Iphone', 100),
                           (2, 'Headphones', 20),
                           (3, 'Case for phone', 10);
SELECT setval('product_id_seq', (SELECT max(id) FROM product), true);

insert into coupon values (1, 'P10', 10),
                          (2, 'P25', 25),
                          (3, 'P100', 100);
SELECT setval('coupon_id_seq', (SELECT max(id) FROM coupon), true);

insert into tax values (1, 'DE[0-9]{9}', 19),
                       (2, 'IT[0-9]{11}', 22),
                       (3, 'GR[0-9]{9}', 24),
                       (4, 'FR[A-Z]{2}[0-9]{9}', 20);
SELECT setval('tax_id_seq', (SELECT max(id) FROM tax), true);
