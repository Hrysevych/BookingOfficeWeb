drop table ticket;

create table ticket (
id int not null generated always as identity,
flightId int constraint flight_fk references flight,
firstName varchar(60) not null,
lastName varchar(60) not null,
passport varchar(60) not null,
orderId int constraint ordering_fk references ordering,
primary key (id)
);