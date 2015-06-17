drop table ordering;

create table ordering (
id int not null generated always as identity,
buyerId int constraint person_fk references person,
payed int not null,
validDate date not null,
primary key (id)
);

