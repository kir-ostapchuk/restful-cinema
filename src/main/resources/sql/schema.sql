create table if not exists movies
(
    id bigint not null auto_increment primary key,
    name varchar(60) not null
);

create table if not exists users
(
    id bigint not null auto_increment primary key,
    login varchar(100) not null,
    password varchar(255) not null,
    first_name varchar(60) not null,
    age int not null
);