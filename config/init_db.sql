create table person
(
    uuid         char(36) not null
        constraint person_pk
            primary key,
    name        text     not null,
    create_date text     not null,
    update_date text     not null
);

create table organization
(
    uuid        char(36) not null
        constraint organization_pk
            primary key,
    name        text     not null,
    info        text     not null,
    create_date text     not null,
    update_date text     not null
);

create table phone_number
(
    id            serial   not null
        constraint phone_number_pk
            primary key,
    contacts_uuid char(36) not null,
    number        text     not null
);

create table gender
(
    id          serial   not null
        constraint gender_pk
            primary key,
    person_uuid char(36) not null,
    gender      text     not null
);

create table contacts
(
    id       serial   not null
        constraint contacts_pk
            primary key,
    all_uuid char(36) not null,
    name     text     not null
);