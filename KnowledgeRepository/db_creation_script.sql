drop database KNOWLEDGE_REPOSITORY;

CREATE DATABASE `KNOWLEDGE_REPOSITORY` DEFAULT CHARACTER SET utf8 ;

use  KNOWLEDGE_REPOSITORY;

CREATE TABLE `PRODUCT` (
  `ID` bigint(20) NOT NULL,
  `PRODUCT_NAME` varchar(45) NOT NULL DEFAULT '0',
  `PARENT_ID` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_PARENT_ID` (`PARENT_ID`),
  CONSTRAINT `FK_PARENT_ID` FOREIGN KEY (`PARENT_ID`) REFERENCES `PRODUCT` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) 
ENGINE=InnoDB 
DEFAULT CHARSET=utf8;

ALTER TABLE `knowledge_repository`.`product` DROP FOREIGN KEY `FK_PARENT_ID` ;
ALTER TABLE `knowledge_repository`.`product` CHANGE COLUMN `PARENT_ID` `PARENT_ID` BIGINT(20) NULL DEFAULT '0'  , 
  ADD CONSTRAINT `FK_PARENT_ID`
  FOREIGN KEY (`PARENT_ID` )
  REFERENCES `knowledge_repository`.`product` (`ID` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('1', 'Product 1', null);
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('2', 'Product 2', null);
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('3', 'Product 11', '1');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('4', 'Product 12', '1');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('5', 'Product 21', '2');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('6', 'Product 22', '2');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('7', 'Product 111', '3');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('8', 'Product 112', '3');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('9', 'Product 121', '4');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('10', 'Product 122', '4');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('11', 'Product 211', '5');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('12', 'Product 212', '5');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('13', 'Product 221', '6');
INSERT INTO `knowledge_repository`.`product` (`ID`, `PRODUCT_NAME`, `PARENT_ID`) VALUES ('14', 'Product 222', '6');
