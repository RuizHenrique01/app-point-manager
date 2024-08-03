create table projects(
    id bigint not null auto_increment primary key,
    name varchar(100) not null,
    description varchar(255),
    created_at datetime,
    updated_at datetime
);