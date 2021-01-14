create table contacts
(
    uuid        char(36) not null
        constraint contacts_pk
            primary key,
    name        text     not null,
    create_date text     not null,
    update_date text     not null
);

create table phone_number
(
    id           serial   not null
        constraint phone_number_pk
            primary key,
    contact_uuid char(36) not null
        constraint phone_number_contacts_uuid_fk
            references contacts
            on update restrict on delete cascade,
    number       text     not null
);

create table type_contact
(
    id             serial not null
        constraint type_contact_pk
            primary key,
    name           text   not null,
    personal_field text   not null
);

create table contact_info
(
    id              serial   not null
        constraint contact_info_pk
            primary key,
    contact_uuid    char(36) not null
        constraint contact_info_contacts_uuid_fk
            references contacts
            on update restrict on delete cascade,
    type_contact_id integer  not null
        constraint contact_info_type_contact_id_fk
            references type_contact
            on update restrict on delete set null,
    do_action       text     not null
);

insert into type_contact (id, name, personal_field)
VALUES ('1', 'Person', 'Gender(men/woman)'),
       ('2', 'Organization', 'Information');