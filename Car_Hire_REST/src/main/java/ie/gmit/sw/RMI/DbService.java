package ie.gmit.sw.RMI;

import java.rmi.*;
import java.sql.SQLException;
import java.util.List;

import ie.gmit.sw.Model.Order;

//interface with CRUD functionality
public interface DbService extends Remote {

	// creates a booking 
	public String create(String s) throws RemoteException;
	//reads all the bookings 
	//public void read() throws RemoteException;
	public List<Order> read() throws RemoteException, SQLException;
	//update a booking
	public String update(String s) throws RemoteException;
	//delete a booking 
	public String delete(String s) throws RemoteException;
}
