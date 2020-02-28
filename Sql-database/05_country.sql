use Swabhav;


-- create table 

select * from REGIONS;

alter table REGIONS add constraint PK_REGIONS_ID primary key(REGION_ID); 

alter table COUNTRIES add constraint FOREIGN_KEY_REGION_ID foreign key (REGION_ID)  references REGIONS(REGION_ID);

CREATE TABLE LOCATIONS( 
	LOCATION_ID    int not null,
    STREET_ADDRESS VARCHAR(40),
    POSTAL_CODE    VARCHAR(12),
    CITY       VARCHAR(30) NOT NULL,
    STATE_PROVINCE VARCHAR(25),
    COUNTRY_ID     CHAR(2)
);


alter table LOCATIONS add constraint LOACTION_ID_PK primary key (LOCATION_ID);
alter table LOCATIONS add constraint FOREIGN_KEY_COUNTRIES_ID foreign key (COUNTRY_ID) references COUNTRIES(COUNTRY_ID);

INSERT INTO REGIONS VALUES( 1, 'Europe'),( 2, 'Americas'),( 3, 'Asia'),( 4, 'Middle East and Africa');  


INSERT INTO COUNTRIES VALUES( 'IT', 'Italy', 1),( 'JP', 'Japan', 3),( 'US', 'United States of America', 2),
( 'CA', 'Canada', 2),( 'CN', 'China', 3),( 'IN', 'India', 3),( 'AU', 'Australia', 3),( 'ZW', 'Zimbabwe',4);

INSERT INTO COUNTRIES VALUES( 'SG', 'Singapore', 3),( 'UK', 'United Kingdom', 1),( 'FR', 'France', 1),( 'DE', 'Germany', 1),
( 'ZM', 'Zambia', 4),( 'EG', 'Egypt', 4),( 'BR', 'Brazil', 2),( 'CH', 'Switzerland', 1);

INSERT INTO COUNTRIES VALUES( 'NL', 'Netherlands', 1),( 'MX', 'Mexico', 2),( 'KW', 'Kuwait', 4),
( 'IL', 'Israel', 4),( 'DK', 'Denmark', 1),( 'HK', 'HongKong', 3),( 'NG', 'Nigeria', 4),
( 'AR', 'Argentina', 2),( 'BE', 'Belgium', 1);

INSERT INTO LOCATIONS VALUES( 1000, '1297 Via Cola di Rie', '00989', 'Roma', NULL, 'IT'),( 1100, '93091 Calle della Testa', '10934', 'Venice', NULL, 'IT'),
( 1200, '2017 Shinjuku-ku', '1689', 'Tokyo', 'Tokyo Prefecture', 'JP'),( 1300, '9450 Kamiya-cho', '6823', 'Hiroshima', NULL, 'JP'),
( 1400, '2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),( 1500, '2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US'),
( 1600, '2007 Zagora St', '50090', 'South Brunswick', 'New Jersey', 'US'),( 1700, '2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
( 1800, '147 Spadina Ave', 'M5V 2L7', 'Toronto', 'Ontario', 'CA'),( 1900, '6092 Boxwood St', 'YSW 9T2', 'Whitehorse', 'Yukon', 'CA');

insert into LOCATIONS values (9802,'M.V. Road', 400065, 'Mumbai', 'Maharashtra', 'IN');

select * from REGIONS r
join COUNTRIES c
ON r.REGION_ID = c.REGION_ID
join LOCATIONS s
ON c.COUNTRY_ID = s.COUNTRY_ID
where s.CITY = "Mumbai";

select r.REGION_NAME from REGIONS r 
left join COUNTRIES c
ON r.REGION_ID = c.REGION_ID
where c.COUNTRY_ID is null;


select c.COUNTRY_NAME from COUNTRIES c
left join LOCATIONS l
ON c.COUNTRY_ID = l.COUNTRY_ID
where l.CITY is null;


select r.REGION_NAME, c.COUNTRY_NAME, s.STATE_PROVINCE from REGIONS r
join COUNTRIES c
ON r.REGION_ID = c.REGION_ID
join LOCATIONS s
ON c.COUNTRY_ID = s.COUNTRY_ID;

select * from REGIONS;

create table foo (
	id int not null,
    name varchar(20)
);

insert into foo values (1, "ABC"),(40,"PQR");

insert into foo values (2, "XYZ");

select * from foo;

alter table foo add constraint primary key (id);

