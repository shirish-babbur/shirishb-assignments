create database ecommerce;

create table users (
id Integer primary key not null,
name varchar(255) not null,
email varchar(255) not null unique,
password varchar(255) not null check(char_length(password)>8)
);

create table products(
id Integer primary key not null,
name varchar(255) not null
);

create table product_details(
product_id Integer references Products(id),
color varchar(10),
price numeric(10,2)
);

create table orders(
id varchar(255) primary key not null check(char_length(id) between 8 and 10),
user_id Integer references Users(id),
date_od_order date
);

create table ordered_products(
order_id varchar(255) references Orders(id),
product_id Integer references Products(id),
product_color varchar(10),
price Numeric(10,2)
);

create table coupons(
id Integer primary key not null,
discount integer not null
);

create table payments(
id Integer primary key not null,
coupon_id Integer references Coupons(id),
type varchar(255) not null,
status varchar(255) not null
);

create table transactions(
id Integer primary key not null,
order_id varchar(255) references Orders(id),
payment_id Integer references Payments(id)
);
