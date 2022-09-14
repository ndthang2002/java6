create database java6_Store
go
use java6_Store
go
drop table java6_Store
create table Students(
email nvarchar(50),
fullname nvarchar(50),
marks float,
gender bit ,
country nvarchar(2)
)
insert into Students values
('nguyendinhthang@gmail.com','nguyen dinh thang','10',1,'VN')
select*from Students