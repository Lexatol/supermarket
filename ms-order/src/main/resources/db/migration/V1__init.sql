create table orders(
        order_id            bigserial primary key,
        user_id             bigint not null,
        price               int,
        address             varchar(300),
        phone               varchar(50),
        email               varchar(50)
);

create table order_items(
        id                  bigserial primary key,
        order_id            bigint NOT NULL references (order_id),
        product_id          bigint not null,
        quantity            int,
        price               int,
        total_price         int
);




