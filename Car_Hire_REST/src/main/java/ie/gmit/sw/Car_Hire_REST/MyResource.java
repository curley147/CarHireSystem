package ie.gmit.sw.Car_Hire_REST;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ie.gmit.sw.RMI.DbService;

/**
 * Root resource (exposed at "myResource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws RemoteException 
     * @throws NotBoundException 
     * @throws MalformedURLException 
     * @throws SQLException 
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{num}")
    public String getIt(@PathParam("num") String s) throws RemoteException, MalformedURLException, NotBoundException, SQLException {
        DbService ds = (DbService) Naming.lookup("rmi://127.0.0.1:1099/dbService");
        ds.read();
		return s;
        		
    }
}
