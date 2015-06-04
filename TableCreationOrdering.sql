create table ordering (
id int not null generated always as identity,
buyerId int not null,
payed int not null,
validDate date not null,
primary key (id)
)