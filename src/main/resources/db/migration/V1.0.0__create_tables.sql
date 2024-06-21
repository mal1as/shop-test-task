create table if not exists product (
    id bigserial primary key,
    name varchar(64) not null,
    price real not null
);

create table if not exists coupon (
    id bigserial primary key,
    type varchar(16) not null,
    code varchar(8) not null unique
);

create table if not exists coupon_fixed (
    coupon_id bigint not null references coupon,
    sum integer not null check ( sum > 0 )
);

create table if not exists coupon_percent (
    coupon_id bigint not null references coupon,
    percent integer not null check ( percent > 0 and percent <= 100)
);

create table if not exists tax (
    id bigserial not null,
    code_pattern varchar(64) not null unique,
    percent integer not null check ( percent > 0 and percent <= 1000)
);