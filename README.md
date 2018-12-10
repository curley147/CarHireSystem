# CarHireSystem
A RESTful Car Hire Booking System using JAX-RS, Java RMI and JAXB

This system consists of 3 eclipse projects: a Java EE project called RestCarHire, a Java project called RMI_CLient ans a Spring Boot Application called bookingClient.

The system uses the  JAX-RS/Jersey, Java RMI and JAXB frameworks to create a Restful architecture which allows CRUD functionality to the user via a web client page.

## Software Required
-Java EE version of Eclipse
-Apache tomcat server v7.0
-Spring Boot
-wamp64

## Creating and Populating the database
When wamp64 is installed open up the mySQL console and run the commands in the SQL file in the repository
This will create a database with 3 tables that will be accessible by the RESTful application.

## Tomcat Server
A copy of the server I used while developing this project is also available in the repository or it can also be downloaded from the Apache website https://tomcat.apache.org/

##Running the project without Spring Boot
-To run the project, right-click on the RestCarHire project and navigate to 'Run' which opens another mwenu from which you select 'Run on Server'
-Next, right-click on the RMI_Client project and select 'Run as a Java Application.
-This will open the web app in the eclipse browser and display the CRUD functions to the user.
-The links for Create Order, Update Order and Delete Order only work with the spring application but you can view the contents of the database from the Read Orders link and it will be displayed in XML format

##Running the project with Spring Boot
-When using Spring Boot, the tomcat server is not required. Right-click on the bookingClient project and select 'Run as Spring Boot Application' this will start spring in the background/console.
-Open up a browser and in the url bar at the top enter 127.0.0.1:6060 (6060 is the port used by spring app)
-This will display the CRUD functionality to the user which is not working correctly at this time. The functionality of the project can be teste using Postman which will be explained below.

##Testing the project using Postman
-Postman is a Google Chrome extension that allows developers to send data via http methods in various formats including XML. 
-Enter the URL 127.0.0.1:8080/webapi/myresource/readOrder in the URL bar. The last string readOrder must be changed depending on what the user wants (i.e readOrder to view the orders, createOrder to add an order, updateOrder to update an order and deleteOrder to delete an order) 
-Next you have to choose the http method which correlates to the CRUD functions outlined above. GET for the readOrder URL, POST for the createOrder URL, PUT for the updateOrder URL and DELETE for the deleteOrder URL
-Click on send and it will send the XML object as a body of the http request which will change the database accordingly
-Check the changes using 'SELECT * FROM orders' in the mySQL console.
