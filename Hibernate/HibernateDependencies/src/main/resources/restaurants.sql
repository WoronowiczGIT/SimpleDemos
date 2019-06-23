create table restaurants(
id int primary key auto_increment,
name varchar(25) unique,
employees int,
opening_date date
);
insert into restaurants values(default,"cafe",5,"2011-11-25");
insert into restaurants values(default,"posh restaurant",55,"2018-11-25");
insert into restaurants values(default,"kebap",8,"2000-11-25");
insert into restaurants values(default,"bistro",2,"2017-11-25");