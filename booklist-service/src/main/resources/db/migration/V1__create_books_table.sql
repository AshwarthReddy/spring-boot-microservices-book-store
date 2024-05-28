create
sequence book_id_seq start
with 1 increment by 50;

create table books
(
    id          bigint default nextval('book_id_seqs') not null,
    code        text                                   not null unique,
    name        text                                   not null,
    description text,
    image_url   text,
    price       numeric                                not null,
    primary key (id)
);