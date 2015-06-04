create table ticket (
id int not null generated always as identity,
flightId int not null,
firstName varchar(60) not null,
lastName varchar(60) not null,
buyerID int not null,
orderId int not null,
payed int not null,
primary key (id)
)