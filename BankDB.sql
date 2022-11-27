create table client
(
    idnp         varchar(13) primary key,
    first_name   varchar(20) not null,
    last_name    varchar(20) not null,
    email        varchar(50) not null,
    phone_number varchar(20) not null
);

create table account
(
    id          int         not null auto_increment primary key,
    client_idnp varchar(13) not null,
    currency    varchar(3)  not null,
    funds       double      not null,
    constraint fk_client_idnp foreign key (client_idnp) references client (idnp)
);

create table operation
(
    id         int         not null auto_increment primary key,
    account_id int         not null,
    amount     double      not null,
    date       varchar(50) not null,
    constraint fk_account_id foreign key (account_id) references account (id)
);