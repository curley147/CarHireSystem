create database carOrders;
use carorders;


create table if not exists orders(
	rentId int NOT NULL AUTO_INCREMENT,
	custId int not null,
	carReg int not null,
	date DATE,
	PRIMARY KEY(rentId),
	FOREIGN KEY (custId) REFERENCES Customers(custId),
	FOREIGN KEY (carReg) REFERENCES Cars(carReg)

);



CREATE TABLE if not exists Customers (
	custId int not null,
    name varchar(255),
    licenseNo int,
	PRIMARY KEY(custId)
);



CREATE TABLE if not exists Cars (
	carReg int not null,
    carMake varchar(255),
    carModel varchar(255),
	PRIMARY KEY(carReg)
);

INSERT INTO Customers (custId, name, licenseNo)
VALUES (1, 'Mike Healy', 123),
	   (2, 'Gerry Smith', 456);
     
 
       
   
INSERT INTO Cars (carReg, carMake, carModel)
VALUES (123, 'Ford', 'Escort'),
		(456, 'Toyota', 'Corolla');

       
 
 
INSERT INTO Orders (custId, carReg, date)
VALUES (1,1,CURDATE()),
	   (2,2,CURDATE());
	   
	   