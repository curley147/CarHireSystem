package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ie.gmit.sw.Model.Order;

public class DbServiceImpl extends UnicastRemoteObject implements DbService {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement sqlStatement;
	private PreparedStatement prepStatement;

	protected DbServiceImpl() throws RemoteException, SQLException {
		super();
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carorders?useSSL=false", "root", "");
	}

	public List<Order> read() throws RemoteException, SQLException {
		System.out.println("In read");

		sqlStatement = connection.createStatement();

		List<Order> List = new ArrayList<Order>();
		String strSelect = "select * from orders";

		ResultSet rset = sqlStatement.executeQuery(strSelect);

		while (rset.next()) { 
			int rentId = rset.getInt("rentId");
			int custId = rset.getInt("custId");
			int carReg = rset.getInt("carReg");
			Date date = rset.getDate("date");
			
			Order s = new Order(rentId, custId, carReg, date);
			List.add(s);
		}
		return List;
	}

	public void create(Order o) throws RemoteException, SQLException {
		System.out.println("In create");

		//System.out.println("Inserting into sql: " + o.getCustId() + "   " + o.getCarReg()/* + "   " + o.getDate()*/);
		String strCreate = "insert into orders (custId, carReg, date) values (?, ?, curdate())";

		prepStatement = connection.prepareStatement(strCreate);
		
		prepStatement.setInt(1, o.getCustId());
		prepStatement.setInt(2, o.getCarReg());
		
		prepStatement.execute();
		prepStatement.close();
		System.out.println("order inserted");
	}

	public void update(Order o) throws RemoteException, SQLException {

		System.out.println("In update");

		System.out.println("Updating in sql: "+ o.getRentId() + o.getCustId() + "   " + o.getCarReg()/* + "   " + o.getDate()*/);
		String strUpdate = "update orders set custId=?, carReg=?, date=curdate() where rentId=?";

		prepStatement = connection.prepareStatement(strUpdate);
		
		prepStatement.setInt(1, o.getCustId());
		prepStatement.setInt(2, o.getCarReg());
		prepStatement.setInt(3, o.getRentId());
		
		prepStatement.execute();
		prepStatement.close();
		System.out.println("order updated");
	}

	public String delete(Order o) throws RemoteException, SQLException {
		System.out.println("In delete");

		System.out.println("deleting from db- customer details: " + o.getCustId() + "   " + o.getCarReg()/* + "   " + o.getDate()*/);
		String strDelete = "delete from orders where rentId=?";

		prepStatement = connection.prepareStatement(strDelete);
		
		prepStatement.setInt(1, o.getRentId());
		
		//prepStatement.setString(3, o.getDate());
		
		prepStatement.executeUpdate();
		prepStatement.close();
		//connection.close();

		return "order deleted";
	}

	

}
