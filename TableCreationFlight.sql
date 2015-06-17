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
                                                                                
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-01 00:00:00', 'JFK', '2015-09-01 12:00:00', 120.0, 150, 0, 0, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('KBP', '2015-09-10 00:00:00', 'JFK', '2015-09-10 12:00:00', 140.0, 37, 0, 0, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('JFK', '2015-09-01 23:00:00', 'KBP', '2015-09-02 11:00:00', 120.0, 150, 0, 0, 0);
insert into FLIGHT (DEPARTURE, DEPARTURETIME, ARRIVAL, ARRIVALTIME, TICKETPRICE, TICKETSTOTAL, TICKETSBOOKED,TICKETSSOLD, DELETED) values ('JFK', '2015-09-10 23:00:00', 'KBP', '2015-09-11 11:00:00', 140.0, 37, 0, 0, 0);