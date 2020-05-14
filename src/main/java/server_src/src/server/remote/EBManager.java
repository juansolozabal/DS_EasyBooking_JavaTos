package src.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import src.server.appservice.EBgestorAero;
import src.server.appservice.EBgestorAuth;
import src.server.appservice.EBgestorPagos;
import src.server.dao.EBgestorDAO;
import src.server.dto.Persona;
import src.server.dto.Vuelo;

public class EBManager extends UnicastRemoteObject implements IEBManager{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serverName;
	private EBgestorPagos gestorPagos;
	private EBgestorAuth gestorAuth;
	private EBgestorAero gestorAero;
	private EBgestorDAO gestorDAO;
	
	
	public EBManager(String serverName) throws RemoteException 
	{
		super();
		this.serverName = serverName;
	}
	
	@Override
	public void iniciarSesion(String nomUsuario, String correo, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarse(String nombre, String apellidos, String correo, String nomUsuario, String contrasenya)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void introducirPersonaReserva(int dni, String nombre, String apellidos) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hacerReserva(int codVuelo, String nomUsuario, ArrayList<Persona> pasajeros) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pagarVisa(String nomTitular, int numTarj, Date venc, int cvc) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pagarPayPal(String email, String contrasenya) throws RemoteException{
	
		// TODO Auto-generated method stub
		
	}
	
	public String comprobacionConexion() throws RemoteException 
	{
		return "Conexion establecida con el servidor.";
	}

	public String getName() 
	{
		return serverName;
	}

	@Override
	public ArrayList<Vuelo> buscarVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vuelo> getVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
