-- chemtan baza aris mysql, anu ro shedixar sul tavidan "use mysql" unda chawero. paroli ar adevs. 
--copy from vincxa

use mysql;

CREATE TABLE User (username varchar(50) NOT NULL, password varchar(50) NOT NULL, name varchar(50) NOT NULL,surname varchar(50) NOT NULL, info varchar(50) NOT NULL, admin boolean not null default 0, PRIMARY KEY (username));

