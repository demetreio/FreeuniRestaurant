-- es aris procedura romlis sashualebitac kerdzs vucvlit fass.
-- proceduras gadaecema kerdzis ID da axali fasi.

delimiter //

CREATE PROCEDURE ChangePrice(foodID INT, newPrice DOUBLE)
	BEGIN
		UPDATE MENU SET price=newPrice WHERE id=foodID;
	END
    //

delimiter ;