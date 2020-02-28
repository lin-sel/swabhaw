use Swabhav;

create table Organizer ( 
	organizerid int primary key,
    name varchar(100) not null,
    location varchar(100) not null
);

create table Exhibition (
	exhibitionid int primary key not null,
    name varchar(100) not null,
    location varchar(100) not null,
    organizer int not null, 
    foreign key (organizer) references Organizer(organizerid)
);

create Table Visitor (
	visitorid int primary key not null,
    name varchar(100) not null,
    address varchar(120) not null,
    exhibition int not null,
    foreign key (exhibition) references Exhibition(exhibitionid)
);

insert into Organizer values (1, "GS Marketing", "Kolkata");

insert into Exhibition values (120, "International Trade Fair", "Gujrat", 1);
insert into Exhibition values (190, "IIMTF", "Banglore", 1);

insert into Visitor values (101, "ABC", "Mumbai", 120),(103, "XYZ","Banglore",190),(109,"PQR","Kolkata", 190);

select * from Organizer;
select * from Exhibition;
select * from Visitor;

Select v.name, e.name , o.name 
from Visitor as v
join Exhibition as e 
on v.exhibition = e.exhibitionid
join Organizer as o
on e.organizer = o.organizerid
-- where e.name = "IIMTF"