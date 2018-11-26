package ie.gmit.sw.Car_Hire_REST;

import java.rmi.*;

//interface with CRUD functionality
public interface DbService extends Remote {

	// creates a booking 
	public String create(String s) throws RemoteException;
	//reads all the bookings 
	public void read() throws RemoteException; 
	//update a booking
	public String update(String s) throws RemoteException;
	//delete a booking 
	public String delete(String s) throws RemoteException;
}
