create database account_lab7
go
 use account_lab7
 go
  drop table Roles
 create table Roles(
 Id nvarchar(10) primary key,
 Name nvarchar(50)
 )
 drop table Accounts
 create table Accounts(
 Username nvarchar(20) primary key, 
 Password nvarchar(100),
 Fullname nvarchar(50),
 Email nvarchar(50),
 Photo nvarchar(50)
 )
  drop table Authorities
 create table Authorities(
 Id int IDENTITY(1,1),
 Username nvarchar(20),
 Roleid nvarchar(10)
 constraint fk_account
 foreign key(Username)
 references Accounts(Username),
  constraint fk_role
 foreign key(Roleid)
 references Roles(Id)
 )

 insert into Roles values('001','quan ly'),('002','nhan vien'),('003','giam doc'),('004','lao cong')
 insert into Accounts values ('thang','123','nguyen dinh thang','nguyenthnag@gmail.com','hinh1.jpg'),('haha','123','nguyen van ha','gha@gmail.com','hinh2.jpg'),('phuc','123','phuc bon tu','gha@gmail.com','hinh3.jpg')
 insert into Authorities values('thang','002'),('haha','002'),('phuc','003')
 SELECT * FROM Authorities 