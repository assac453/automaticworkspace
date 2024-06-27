drop table if exists clients;
drop table if exists employment_info;
drop table if exists requests;
drop table if exists contracts;
drop index if exists idx_clients_contact_phone;
drop index if exists idx_clients_name;
drop index if exists idx_clients_passport;

create table clients
(
    id                   serial primary key,
    first_name           varchar(255)   not null,
    last_name            varchar(255)   not null,
    middle_name          varchar(255),
    passport             varchar(10)    not null,
    family_status        boolean        not null,
    registration_address varchar(255)   not null,
    contact_phone        varchar(11)    not null,
    request_amount       decimal(12, 2) not null
);

create table employment_info
(
    id           serial primary key,
    work_period  int          not null,
    position     varchar(255) not null,
    organization varchar(255) not null,
    clients_id   int references clients (id) on delete cascade
);

create table requests
(
    id              serial primary key,
    approved_amount decimal(12, 2) not null,
    approved_term   int            not null,
    approved_status boolean        not null,
    client_id       int references clients (id) on delete cascade
);

create table contracts
(
    id            serial primary key,
    signed_date   date    not null,
    signed_status boolean not null,
    request_id    int references requests (id) on delete cascade
);

create index idx_clients_contact_phone on clients(contact_phone);
create index idx_clients_passport on clients(passport);
create index idx_clients_name on clients(last_name, first_name, middle_name);
