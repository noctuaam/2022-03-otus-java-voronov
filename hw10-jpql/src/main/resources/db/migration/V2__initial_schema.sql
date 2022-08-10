create table adress
(
    id   bigserial not null primary key,
    street varchar(50)
);

create table phone
(
    id   bigserial not null primary key,
    number varchar(50)
);