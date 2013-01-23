DELIMITER //
CREATE TRIGGER user_cleanUp_trig
BEFORE DELETE ON user_table

FOR EACH ROW 

BEGIN
 declare usrName varchar(50);	
 declare tableId INT;
 declare userReserve varchar(100);
 declare tableReserveInfo varchar(100);
 declare newReserveInfo varchar(100);
 declare length INT;
 declare k INT;
 
 set k = 0;
 set usrName = OLD.username;
 set tableId = OLD.id;
 set userReserve = OLD.reserveInfo;
 set newReserveInfo = '';
 
 
 SELECT reserveInfo INTO tableReserveInfo from reservedtables where id = tableId;
 
 set length = LENGTH(userReserve);
 
 label1: LOOP
    SET k = k + 1;
    IF k <= length THEN
        IF substring(userReserve, k, 1) = '2' THEN
            set newReserveInfo = CONCAT(newReserveInfo, '0');
        ELSE
            set newReserveInfo = CONCAT(newReserveInfo, substring(tableReserveInfo, k, 1));
        END IF;
        ITERATE label1;
    END IF;
    LEAVE label1;
  END LOOP label1;
 
 UPDATE reservedtables SET reserveInfo = newReserveInfo where id = tableId;
END;
//
DELIMITER ;
