drop table person;

create table Person (
id int not null generated always as identity,
email varchar(60) not null,
passwordHash int not null,
firstName varchar(60) not null,
lastName varchar(60) not null,
role int not null,
active int not null, 
primary key (id)
);

insert into PERSON (EMAIL, PASSWORDHASH, FIRSTNAME, LASTNAME, ROLE, ACTIVE) values('security@bookingoffice.com', -424098025, 'Rambo', 'Terminator', 4, 1);

