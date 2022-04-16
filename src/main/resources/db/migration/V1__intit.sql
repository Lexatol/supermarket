--<<<<<<<<<<<<<<<USERS>>>>>>>>>>>>>>>>>>>>>
create TABLE cashback (
        cash_id              bigserial primary key,
        bonus                int
);

insert into cashback (bonus) values
(10), (20), (30);

create TABLE users
(
        id                  bigserial primary key,
        username            varchar(100) NOT NULL,
        email               varchar(200) NOT NULL unique,
        password            varchar(200) NOT NULL,
        cash_id             bigint,
        foreign key (cash_id) references cashback (cash_id)
);

insert into  users (username, email, password, cash_id) values
('Petya', 'petya@gmail.com', 100, 1),
('Olya', 'olya@gmail.com', 100, 2),
('Vasya', 'vasya@gmail.com', 100, 3);


--<<<<<<<<<<<<<<<<PRODUCTS>>>>>>>>>>>>>>>>>>>>>>

create TABLE categories (
        id              bigserial primary key,
        title           varchar(200)
);

insert into  categories (title) values
('TV'), ('Laptop'), ('Phone');

create TABLE products (
        id              bigserial primary key,
        title           varchar(100) NOT NULL,
--        image
        price           int NOT NULL,
        description     varchar(500)
);

insert into products (title, price, description) values
('tv samsung', 2000, 'TV samsung. Made in Corea'),
('macbook', 2500, 'Laptop made in USA'),
('iphone', 1000, '');

create TABLE product_category (
        product_id      bigint NOT NULL,
        category_id     bigint NOT NULL,
        primary key (product_id, category_id),
        foreign key (product_id) references products(id),
        foreign key (category_id) references categories(id)
);

insert into product_category (product_id, category_id) values
(1, 1), (2, 2), (3, 3),
(1, 2);

