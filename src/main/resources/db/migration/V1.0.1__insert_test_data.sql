insert into product values (1, 'Iphone', 100),
                           (2, 'Headphones', 20),
                           (3, 'Case for phone', 10);
SELECT setval('product_id_seq', (SELECT max(id) FROM product), true);

insert into coupon values (1, 'PERCENT', 'P10'),
                          (2, 'PERCENT', 'P25'),
                          (3, 'PERCENT', 'P100'),
                          (4, 'FIXED', 'F50'),
                          (5, 'FIXED', 'F100');
SELECT setval('coupon_id_seq', (SELECT max(id) FROM coupon), true);

insert into coupon_percent values (1, 10),
                                  (2, 25),
                                  (3, 100);

insert into coupon_fixed values (4, 50),
                                (5, 100);

insert into tax values (1, 'DE[0-9]{9}', 'Germany', 19),
                       (2, 'IT[0-9]{11}', 'Italy', 22),
                       (3, 'GR[0-9]{9}', 'Greece', 24),
                       (4, 'FR[A-Z]{2}[0-9]{9}', 'France', 20);
SELECT setval('tax_id_seq', (SELECT max(id) FROM tax), true);
