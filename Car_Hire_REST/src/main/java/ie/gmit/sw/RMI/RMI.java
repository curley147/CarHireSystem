package ie.gmit.sw.RMI;

import java.rmi.Naming;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class RMI {
	
	private DbService dbs;

	public RMI() throws Exception {
		dbs = (DbService) Naming.lookup("rmi://127.0.0.1:1099/databaseService");

	}
	//read orders
	public List<Order> readOrder() throws Exception {
		return dbs.read();
	}

}
