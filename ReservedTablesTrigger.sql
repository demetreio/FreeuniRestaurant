DELIMITER //
CREATE TRIGGER reserved_table_trig
AFTER INSERT ON tables
FOR EACH ROW 
BEGIN
 declare val int;	
 set val = NEW.id;
 INSERT into reservedtables values(val,"000000000000000000000000000000");
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER reserved_table_trig_del
AFTER DELETE ON tables
FOR EACH ROW 
BEGIN
 declare val int;	
 set val = OLD.id;
 DELETE from reservedtables where id = val;
END;
//
DELIMITER ;