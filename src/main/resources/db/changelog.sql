--liquibase formatted sql

--changeset sp6pat:1
create schema if not exists qsl;

create table if not exists qsl.qsl_cards_to_pickup (
    id              serial primary key,
    callsign        text not null,
    qty             bigint not null,
    last_updated    timestamp not null default now()
);

--changeset sp6pat:2
alter table qsl.qsl_cards_to_pickup add column collected boolean default false;
