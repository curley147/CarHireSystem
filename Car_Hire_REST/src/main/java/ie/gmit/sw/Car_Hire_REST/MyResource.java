package ie.gmit.sw.Car_Hire_REST;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.RMI.DbService;

/**
 * Root resource (exposed at "myResource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 * @throws RemoteException
	 * @throws NotBoundException
	 * @throws MalformedURLException
	 * @throws SQLException
	 */
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN)
	 * 
	 * @Path("/{num}") public String getIt(@PathParam("num") String s) throws
	 * RemoteException, MalformedURLException, NotBoundException, SQLException {
	 * DbService ds = (DbService) Naming.lookup("rmi://127.0.0.1:1099/dbService");
	 * ds.read(); return s;
	 */
	@GET
	@Path("readOrder")
	@Produces(MediaType.APPLICATION_XML)
	public List<Order> getIt() throws MalformedURLException, RemoteException, Exception {

		DbService ds;
		ds = (DbService) Naming.lookup("rmi://127.0.0.1:1099/dbService");

		return ds.read();
		
	}

	@POST
	@Path("createOrder")
	@Consumes(MediaType.APPLICATION_XML)
	public void postIt(Order o) throws MalformedURLException, RemoteException, Exception {

		DbService ds;
		ds = (DbService) Naming.lookup("rmi://127.0.0.1:1099/dbService");
		
		ds.create(o);
		
	}
	
	@DELETE
	@Path("deleteOrder")
	@Consumes(MediaType.APPLICATION_XML)
	public void deleteIt(Order o) throws MalformedURLException, RemoteException, Exception {

		DbService ds;
		ds = (DbService) Naming.lookup("rmi://127.0.0.1:1099/dbService");
		
		ds.delete(o);
		
	}
	
	@PUT
	@Path("updateOrder")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateIt(Order o) throws MalformedURLException, RemoteException, Exception {

		DbService ds;
		ds = (DbService) Naming.lookup("rmi://127.0.0.1:1099/dbService");
		
		ds.update(o);
	}

}
