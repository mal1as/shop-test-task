create table if not exists product (
    id bigserial primary key,
    name varchar(64) not null,
    price real not null
);

create table if not exists coupon (
    id bigserial primary key,
    code varchar(8) not null unique,
    percent integer not null check ( percent > 0 and percent <= 100)
);

create table if not exists tax (
    id bigserial not null,
    code_pattern varchar(64) not null unique,
    percent integer not null check ( percent > 0 and percent <= 1000)
);