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

alter table client add column address_id bigint
CONSTRAINT fk_address_id REFERENCES address(id);