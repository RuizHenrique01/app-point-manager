create table users(
    id bigint not null auto_increment primary key,
    name varchar(100) not null,
    username varchar(100) not null,
    email varchar(255) not null,
    password varchar(60) not null,
    created_at datetime,
    updated_at datetime
);