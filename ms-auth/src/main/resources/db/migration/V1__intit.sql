--<<<<<<<<<<<<<<<USERS>>>>>>>>>>>>>>>>>>>>>
create table roles (
        id          bigserial primary key,
        name        varchar(300)
);

insert into roles (name) values ('ROLE_ADMIN'), ('ROLE_USER'), ('MANAGER');

create table cashback (
        cash_id              bigserial primary key,
        bonus                int
);

insert into cashback (bonus) values
(10), (20), (30);

create table users (
        id                  bigserial primary key,
        username            varchar(100) NOT NULL,
        email               varchar(200) NOT NULL unique,
        password            varchar(200) NOT NULL,
        cash_id             bigint,
        foreign key (cash_id) references cashback (cash_id)
);

insert into users (username, email, password, cash_id) values
('Petya', 'petya@gmail.com', 100, 1),
('Olya', 'olya@gmail.com', 100, 2),
('Vasya', 'vasya@gmail.com', 100, 3);


create table role_user(
        user_id         bigint not null,
        role_id         bigint not null,
        primary key (user_id, role_id),
        foreign key (user_id) references users(id),
        foreign key (role_id) references roles(id)
);

insert into role_user(user_id, role_id) values
(1, 1), (1, 2), (1, 3), (2, 2), (3, 3);

