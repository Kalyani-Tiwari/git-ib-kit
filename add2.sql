CREATE OR REPLACE PROCEDURE add2
(one IN int(10),
 two IN int(10),
 result OUT int(10))
AS
BEGIN
  result := one + two;
END;
