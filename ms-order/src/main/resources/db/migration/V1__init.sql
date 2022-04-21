create table orders(
        order_id            bigserial primary key,
        user_id             bigint not null,
        price               int,
        address             varchar(300)
);

insert into orders (user_id, price, address) values
(1, 0, 'dfdsfdsfds'), (2, 0, 'dsfdsfasfbdfg'), (3, 0, 'fvdfbzsed`f');

create table order_items(
        id                  bigserial primary key,
        order_id            bigint NOT NULL references (order_id),
        product_id          bigint not null,
        quantity            int,
        price               int,
        total_price         int
);

insert into order_items (order_id, product_id, quantity, price, total_price) values
(1, 1, 5, 1000, 10000),
(1, 2, 2, 500, 10000),
(2, 1, 10, 1000, 10000),
(2, 3, 15, 1000, 10000);



