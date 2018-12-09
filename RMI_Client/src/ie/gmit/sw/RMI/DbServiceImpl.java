package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.RMI.DbService;

public class DbServiceImpl extends UnicastRemoteObject implements DbService {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement sqlStatement;

	protected DbServiceImpl() throws RemoteException, SQLException {
		super();
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire?useSSL=false", "root", "");
	}

	@Override
	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");

		sqlStatement = connection.createStatement();

		List<Order> List = new ArrayList<Order>();
		String strSelect = "select * from orders";

		ResultSet rset = sqlStatement.executeQuery(strSelect);

		while (rset.next()) { 
			String rentId = rset.getString("rentId");
			String custId = rset.getString("custId");
			String carReg = rset.getString("carReg");
			Date date = rset.getDate("date");
			int numDays = rset.getInt("numDays");
			
			Order s = new Order(rentId, custId, carReg, date, numDays);
			List.add(s);
		}
		return List;
	}

	@Override
	public String create(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
