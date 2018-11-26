package ie.gmit.sw.Car_Hire_REST;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DbServiceSetup {
 
	public static void main(String[] args) throws Exception {
		// Create an instance of the database service
		DbService ds = new DbServiceImpl();

		// Create RMI registry on port 1099
		LocateRegistry.createRegistry(1099);

		// Add/bind our remote object to the registry with the human-readable name databaseService
		Naming.rebind("dbService", ds);
		
		System.out.println("Server Ready");
	}
 
}
