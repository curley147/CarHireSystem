package ie.gmit.sw.RMI;

import java.rmi.*;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;

//interface with CRUD functionality
public interface DbService extends Remote {

	// creates a booking 
	public void create(Order o) throws RemoteException, SQLException;
	//reads all the bookings 
	public List<Order> read() throws RemoteException, SQLException;
	//update a booking
	public void update(Order o) throws RemoteException, SQLException;
	//delete a booking 
	public String delete(Order o) throws RemoteException,SQLException;
	
}
