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
)