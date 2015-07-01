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

insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-01 00:00:00', 'JFK', '2015-09-01 12:00:00', 99.0, 150, 20, 10, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-10 00:00:00', 'JFK', '2015-09-10 12:00:00', 88.0, 37, 10, 10, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('JFK', '2015-09-01 23:00:00', 'KBP', '2015-09-02 11:00:00', 77.0, 150, 30, 15, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('JFK', '2015-09-10 23:00:00', 'KBP', '2015-09-11 11:00:00', 92.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('DME', '2015-09-01 00:00:00', 'RTM', '2015-09-01 11:00:00', 100.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBL', '2015-09-01 00:00:00', 'JFK', '2015-09-01 11:00:00', 10.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-01 00:00:00', 'RTM', '2015-09-01 11:00:00', 85.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-01 00:00:00', 'DME', '2015-09-01 01:30:00', 10.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('DME', '2015-09-01 12:00:00', 'KBP', '2015-09-01 13:30:00', 125.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('DME', '2015-09-01 12:00:00', 'JFK', '2015-09-01 23:00:00', 70.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('JFK', '2015-09-01 23:00:00', 'DME', '2015-09-02 10:00:00', 25.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('RDN', '2015-09-01 23:00:00', 'RTM', '2015-09-02 10:00:00', 80.0, 37, 9, 27, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-01 23:00:00', 'DME', '2015-09-02 00:00:00', 80.0, 37, 9, 27, 0);

insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('security@bookingoffice.com', 49, 'Rambo', 'Terminator', 4, 1);
insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('default@user.com', 49, 'default', 'user', 0, 1);
insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('mcfly.marty@bttf.com', 49, 'Marty', 'McFly', 0, 1);
insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('dr.brown@bttf.com', 49, 'Emmet', 'Brown', 0, 1);
insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('administrator@bookingoffice.com', 49, 'Administrator', 'Person', 1, 1);
insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('accountant@bookingoffice.com', 49, 'Accountant', 'Person', 2, 1);
insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values ('analyst@bookingoffice.com', 49, 'Analyst', 'Person', 3, 1);

insert into ORDERING (BUYERID, PAYED, VALIDDATE) VALUES (3, 0, '2015-07-10');
insert into ORDERING (BUYERID, PAYED, VALIDDATE) VALUES (4, 0, '2015-07-16');
insert into ORDERING (BUYERID, PAYED, VALIDDATE) VALUES (2, 0, '2015-07-25');

insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (6, 'Osama', 'bin Laden', 'taliban001', 1);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (6, 'Chuck', 'Norris', 'usa007', 1);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (5, 'Bloodimir', 'Putler', 'vatnik666', 2);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (5, 'Dimon', 'Medved', 'iVatnik', 2);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (5, 'Loshad', 'LavrOff', 'horseman', 2);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (5, 'Dmytro', 'Yarosh', 'ukraine007', 2);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (7, 'Chocolate', 'Zayac', 'presidentUA', 3);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (7, 'Krolik', 'Senia', 'premierUA', 3);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (12, 'Hamske', 'Yayechko', 'urkaDonetsk', 2);
insert into TICKET (FLIGHTID, FIRSTNAME, LASTNAME, PASSPORT, ORDERID) values (13, 'Dmytro', 'Yarosh', 'ukraine007', 2);

