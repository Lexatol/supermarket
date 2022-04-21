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


create TABLE product_comment (
        comment_id          bigserial primary key,
        description         varchar(1000) NOT NULL,
        user_id             bigint NOT NULL,
        product_id          bigint references products(id)
);

insert into product_comment(description, user_id, product_id) values
('отличный телевизор, замечательное качество, гарантия 10 лет',1, 1),
('Лучше ноутбука не бывает, купил за 2000 долларов, а сейчас стоит 3000 уже',2, 1);

