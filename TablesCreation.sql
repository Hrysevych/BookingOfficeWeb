drop table ticket;
drop table ordering;
drop table person;
drop table flight;

create table flight (
id int not null generated always as identity,
departure varchar(10) not null,
departureTime timestamp not null,
arrival varchar(10) not null,
arrivalTime timestamp not null,
ticketPrice double not null,
ticketsTotal int not null,
ticketsBooked int not null,
ticketsSold int not null,
deleted int not null,
primary key (id)
);

create table person (
id int not null generated always as identity,
email varchar(60) not null,
passwordHash int not null,
firstName varchar(60) not null,
lastName varchar(60) not null,
role int not null,
active int not null, 
primary key (id)
);

create table ordering (
id int not null generated always as identity,
buyerId int constraint person_fk references person,
payed int not null,
validDate date not null,
primary key (id)
);

create table ticket (
id int not null generated always as identity,
flightId int constraint flight_fk references flight,
firstName varchar(60) not null,
lastName varchar(60) not null,
passport varchar(60) not null,
orderId int constraint ordering_fk references ordering,
primary key (id)
);

insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-01 00:00:00', 'JFK', '2015-09-01 12:00:00', 120.0, 150, 20, 10, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-10 00:00:00', 'JFK', '2015-09-10 12:00:00', 140.0, 37, 10, 10, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('JFK', '2015-09-01 23:00:00', 'KBP', '2015-09-02 11:00:00', 120.0, 150, 30, 15, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('JFK', '2015-09-10 23:00:00', 'KBP', '2015-09-11 11:00:00', 140.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-01 00:00:00', 'RTM', '2015-09-11 11:00:00', 140.0, 37, 9, 27, 0);

insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('security@bookingoffice.com', 1216985755, 'Rambo', 'Terminator', 4, 1);
insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('mcfly.marty@bttf.com', 1216985755, 'Marty', 'McFly', 0, 0);

insert into ORDERING (BUYERID, PAYED, VALIDDATE) VALUES (2, 0, '2015-07-15');

insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (1, 'Osama', 'bin Laden', 'taliban001', 1);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (5, 'Bloodimir', 'Putler', 'vatnik666', 1);
