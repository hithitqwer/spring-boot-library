CREATE TABLE LibraryUser
(
		SysNo INT NOT NULL AUTO_INCREMENT,
    UserId VARCHAR(50) NOT NULL,
    InDate DATE NOT NULL,
    Role VARCHAR(20) NOT NULL,
    Pwd VARCHAR(20) NOT NULL,
    Primary KEY(SysNo)
);

CREATE TABLE LibraryBookGroup
(
		SysNo INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(20) NOT NULL,
    Autor VARCHAR(100) NULL,
    InDate DATE NOT NULL,
    Position INT NULL,
    PRIMARY KEY(SysNo)
);

CREATE TABLE LibraryPosition
(
   	SysNo INT NOT NULL AUTO_INCREMENT,
    VALUE INT NULL,
    PRIMARY KEY(SysNo)
);

CREATE TABLE LibraryBookSKU
(
    SysNo INT NOT NULL AUTO_INCREMENT,
    GroupSysNo INT NOT NULL,
    BookId VARCHAR(200) NOT NULL,
    Status INT NOT NULL,
    Primary KEY(SysNo)
);

CREATE TABLE LibraryBorrowLog
(
    SysNo INT NOT NULL AUTO_INCREMENT,
    BookSysNo INT NOT NULL,
    UserSysNo INT NOT NULL,
    BorrowDate Date NOT NULL,
    ReturnDate DATE NOT NULL,
    Status INT NOT NULL,
    PRIMARY KEY(SysNo)
)