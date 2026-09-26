create schema dukes;
create schema beans;

create table dukes.categories (
    id UUID primary key,
    name varchar(255) not null,
    description varchar(255) not null
);

create table beans.categories (
    id UUID primary key,
    name varchar(255) not null,
    description varchar(255) not null
);