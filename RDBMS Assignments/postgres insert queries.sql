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

insert into payments values(1,null,'Net Banking','done successfully');
insert into payments values(2,1,'Credit card','done successfully');
insert into payments values(3,2,'Devit card','done successfully');

insert into transactions values(1,'12345678',1);
insert into transactions values(2,'13245678',2);
insert into transactions values(3,'14325678',3);

