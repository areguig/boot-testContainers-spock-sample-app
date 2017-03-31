create table if not exists characters(
    id serial primary key,
    first_name varchar(32) not null,
    last_name varchar(32) not null,
    show_name varchar(32) not null,
    created timestamp not null default now()
);

truncate characters;