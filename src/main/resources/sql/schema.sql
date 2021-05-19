create table if not exists movies
(
    id bigint not null auto_increment primary key,
    name varchar(60) not null
);