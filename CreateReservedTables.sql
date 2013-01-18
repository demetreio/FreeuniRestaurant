-- chemtan baza aris mysql, anu ro shedixar sul tavidan "use mysql" unda chawero. paroli ar adevs. 

use mysql;

CREATE TABLE ReservedTables ( id INT, reserveInfo VARCHAR(100) default "000000000000000000000000000000", PRIMARY KEY (id)); // id aris magidis identifikatori, xolo reservInfo aris 
-- 30 sigrdzis bitstringi, sadac inaxeba ori dgis informacia, titoshi 15 saatia. 1 weria im saatis shesabamis indeqsze, roca magida
-- aris dakavebuli.

