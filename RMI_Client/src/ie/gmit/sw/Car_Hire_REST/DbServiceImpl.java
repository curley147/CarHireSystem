package ie.gmit.sw.Car_Hire_REST;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DbServiceImpl extends UnicastRemoteObject implements DbService {
	
	private static final long serialVersionUID = 1L;

	protected DbServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String create(String s) throws RemoteException {
		return null;
	}

	@Override
	public void read() throws RemoteException {
		System.out.println("Read method working");
	}

	@Override
	public String update(String s) throws RemoteException {
		return null;
	}

	@Override
	public String delete(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
