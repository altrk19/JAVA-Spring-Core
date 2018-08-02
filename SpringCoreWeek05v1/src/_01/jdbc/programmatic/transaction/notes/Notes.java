package _01.jdbc.programmatic.transaction.notes;

public class Notes {

}
//sql tablo eklemek için aþaðýdaki kod execute a script edildi.
/*CREATE TABLE `springjdbc`.`address` (
		  `ADDRESSID` INT NOT NULL COMMENT '',
		  `STREET` VARCHAR(20) NULL COMMENT '',
		  `ZIPCODE` VARCHAR(5) NULL COMMENT '',
		  `CITY` VARCHAR(10) NULL COMMENT '',
		  PRIMARY KEY (`ADDRESSID`)  COMMENT '');


		CREATE TABLE `springjdbc`.`person` (
		  `ID` INT NOT NULL COMMENT '',
		  `NAME` VARCHAR(20) NULL COMMENT '',
		  `SURNAME` VARCHAR(20) NULL COMMENT '',
		  `BIRTHYEAR` INT NULL COMMENT '',
		  `ADDRESSID` INT NULL COMMENT '',
		  PRIMARY KEY (`ID`)  COMMENT '');


		ALTER TABLE `springjdbc`.`person`
		ADD FOREIGN KEY (ADDRESSID)
		REFERENCES `springjdbc`.`address`(ADDRESSID)*/


