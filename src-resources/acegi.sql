CREATE TABLE `userinfo` (
  `USER_ID` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(10) NOT NULL,
  `PASSWORD` VARCHAR(30) DEFAULT NULL,
  `ENABLED` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_ID` (`USER_ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
);

COMMIT;

INSERT INTO `userinfo` (`USER_ID`, `USERNAME`, `PASSWORD`, `ENABLED`) VALUES 
  (1,'root','root',1),
  (2,'readonly','readonly',1);
  
CREATE TABLE `authorities` (
  `AUTH_ID` INTEGER(11) NOT NULL DEFAULT '0',
  `AUTHORITY` VARCHAR(255) NOT NULL,
  `AUTH_TYPE` VARCHAR(32) NOT NULL,
  `PROTECTED_RES` VARCHAR(64) NOT NULL,
  `DISPLAY` VARCHAR(64) NOT NULL,
  `NOTE` VARCHAR(64) DEFAULT NULL,
  PRIMARY KEY (`AUTH_ID`),
  UNIQUE KEY `AUTH_ID` (`AUTH_ID`)
);

COMMIT;

INSERT INTO `authorities` (`AUTH_ID`, `AUTHORITY`, `AUTH_TYPE`, `PROTECTED_RES`, `DISPLAY`, `NOTE`) VALUES 
  (1,'AUTH_FUNC_ContactManager.create','FUNCTION','sample.service.IContactManager.create','创建联系人',NULL),
  (2,'AUTH_FUNC_ContactManager.delete','FUNCTION','sample.service.IContactManager.delete','删除联系人',NULL),
  (3,'AUTH_FUNC_ContactManager.getAll','FUNCTION','sample.service.IContactManager.getAll','取联系人列表',NULL),
  (4,'AUTH_FUNC_ContactManager.getById','FUNCTION','sample.service.IContactManager.getById','根据ID取联系人',NULL),
  (5,'AUTH_FUNC_ContactManager.update','FUNCTION','sample.service.IContactManager.update','更新联系人信息',NULL),
  (0,'AUTH_USER','USER','USER','一般用户权限',NULL);

CREATE TABLE `user_auth` (
  `USER_ID` INTEGER(11) NOT NULL DEFAULT '0',
  `AUTH_ID` INTEGER(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`USER_ID`, `AUTH_ID`)
);

COMMIT;

INSERT INTO `user_auth` (`USER_ID`, `AUTH_ID`) VALUES 
  (1,0),
  (1,1),
  (1,2),
  (1,3),
  (1,4),
  (1,5),
  (2,0),
  (2,3),
  (2,4);