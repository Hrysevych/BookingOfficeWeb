create table Person (
id int not null generated always as identity,
email varchar(60) not null,
password varchar(60) not null,
firstName varchar(60) not null,
lastName varchar(60) not null,
role varchar(30) not null,
active int not null, 
primary key (id)
)