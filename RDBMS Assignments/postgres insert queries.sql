insert into users values(1,'Shirish babbur','xyz123','bbshirish@gmail.com');
insert into users values(2,'Shirish parsekar','xyz12','shirishp@gmail.com');
insert into users values(3,'ram sharma','z123','rams@gmail.com');
insert into users values(4,'krish oak','yz123','krisho@gmail.com');
insert into users values(5,'joy deep','rt12','joyd@gmail.com');

insert into products values(1,'brush');
insert into products values(2,'toothpaste');
insert into products values(3,'mirror');
insert into products values(4,'pen');
insert into products values(5,'Nexus 5');

insert into product_details values(1,'red',15.00);
insert into product_details values(1,'blue',15.00);
insert into product_details values(1,'green',15.00);
insert into product_details values(5,'red',15000.00);
insert into product_details values(5,'black',15000.00);
insert into product_details values(2,null,10.00);
insert into product_details values(3,null,10.00);
insert into product_details values(4,'blue',10.00);
insert into product_details values(4,'red',10.00);

insert into orders values('12345678',1,'2016-8-10');
insert into orders values('13245678',2,'2016-8-11');
insert into orders values('14325678',3,'2016-8-12');

insert into ordered_products values('12345678',1,'red',15.00);
insert into ordered_products values('12345678',2,null,15.00);
insert into ordered_products values('12345678',4,'red',10.00);
insert into ordered_products values('12345678',5,'black',15000.00);
insert into ordered_products values('13245678',1,'green',15.00);
insert into ordered_products values('13245678',2,null,10.00);
insert into ordered_products values('13245678',3,null,10.00);

insert into coupons(1,15);
insert into coupons(2,10);
insert into coupons(3,5);
insert into coupons(4,0);

insert into payments values(1,null,'Net Banking','done successfully');
insert into payments values(2,1,'Credit card','done successfully');
insert into payments values(3,2,'Devit card','done successfully');

insert into transactions values(1,'12345678',1);
insert into transactions values(2,'13245678',2);
insert into transactions values(3,'14325678',3);

--function to check name for no digits
create or replace function name_check()
returns trigger as
$$
begin
select regexp_replace(new.name,'[^a-zA-Z]','','g');
return new;
end;
$$
language 'plpgsql';

--trigger for name checking while inserting
 create trigger check_name before insert on Users
 for each row
 execute procedure name_check();


-- View: public.report

-- DROP VIEW public.report;

CREATE OR REPLACE VIEW public.report AS
 SELECT a.order_id,
    min(orders.date_of_order) AS order_date,
    array_agg(a.products_id) AS product_ids,
    array_to_string(array_agg(a.product_name), ','::text) AS product_names,
    array_agg(a.total_amount) AS product_price,
    sum(a.total_amount) AS order_total,
    min(users.name::text) AS user_name,
    min(users.email::text) AS user_email
   FROM orders
     JOIN ( SELECT products.id AS products_id,
            ordered_products.order_id,
            products.name AS product_name,
            ordered_products.price AS total_amount
           FROM ordered_products
             JOIN products ON ordered_products.product_id = products.id) a ON a.order_id::text = orders.id::text
     JOIN users ON orders.user_id = users.id
  GROUP BY a.order_id;

ALTER TABLE public.report
    OWNER TO postgres;


CREATE OR REPLACE VIEW public.order_details AS
 SELECT a.orders_id,
    a.date_of_order,
    coupons.discount,
    a.total_amount - a.total_amount * 0.01 * coupons.discount::numeric AS payable_amount,
    payments.status,
    payments.type
   FROM transactions
     JOIN ( SELECT orders.id AS orders_id,
            orders.date_of_order,
            sum(ordered_products.price) AS total_amount
           FROM orders
             JOIN ordered_products ON orders.id::text = ordered_products.order_id::text
          GROUP BY orders.id) a ON a.orders_id::text = transactions.order_id::text
     JOIN payments ON transactions.payment_id = payments.id
     JOIN coupons ON payments.coupon_id = coupons.id;

ALTER TABLE public.order_details
    OWNER TO postgres;




--function for monthly report
REATE OR REPLACE FUNCTION public.report_generator()
    RETURNS SETOF "TABLE(order_id character varying, order_date date, product_ids integer[], product_names text, product_price numeric[], order_total numeric, user_name text, user_email text)"
    LANGUAGE 'plpgsql'
    COST 100.0

AS $function$

begin 
return query select * from report where report.order_date>(current_date-30);
end;

$function$;

ALTER FUNCTION public.report_generator()
    OWNER TO postgres;

--get report
select * from report_generator();
