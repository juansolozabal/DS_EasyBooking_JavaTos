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
	private EBgestorDAO gestorDAO;
	
	
	public EBManager(String[] args) throws RemoteException 
	{
		super();
		this.serverName = args[2];
		EBgestorAero.getGestorAero().setArgs(args);
		EBgestorAuth.getGestorAuth().setArgs(args);
		EBgestorPagos.getGestorPagos().setArgs(args);
		EBgestorDAO.getGestorDAO();
	}
	
	@Override
	public void iniciarSesion(String correo, String contrasenya) throws RemoteException {
		EBgestorAuth.getGestorAuth().iniciarSesion(correo, contrasenya);
		
	}

	@Override
	public void registrarse(String nombre, String apellidos, String correo)	throws RemoteException {
		EBgestorAuth.getGestorAuth().registrarse(nombre, apellidos, correo);
	}

	@Override
	public void introducirPersonaReserva(int dni, String nombre, String apellidos) throws RemoteException {
		//Este hay que mirar bien donde meterlo. Este metodo no tiene que estar conectado
		//Con el gestor pagos, es algo que debemos gestionar internamente. Una vez que hayamos
		//acabado de meter todas las personas, en el clicaremos en aceptar y llamaremos al 
		//metodo hacer reserva. Este ultimo si que estara conectado al gestorPagos.
	}

	@Override
	public void hacerReserva(int codVuelo, String nomUsuario, ArrayList<Persona> pasajeros) throws RemoteException {
		EBgestorPagos.getGestorPagos().hacerReserva(codVuelo, nomUsuario, pasajeros);
		
	}

	@Override
	public void pagarVisa(String nomTitular, int numTarj, Date venc, int cvc) throws RemoteException{
		EBgestorPagos.getGestorPagos().pagarVisa(nomTitular, numTarj, venc, cvc);
		
	}

	@Override
	public void pagarPayPal(String email, String contrasenya) throws RemoteException{
		EBgestorPagos.getGestorPagos().pagarPayPal(email, contrasenya);
	}

	@Override
	public ArrayList<Vuelo> buscarVuelos(Date fecha, String nomOrigen, String nomDestino) throws RemoteException{
		return EBgestorAero.getGestorAero().buscarVuelos(fecha, nomOrigen, nomDestino);
	}

	@Override
	public ArrayList<Vuelo> getVuelos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String comprobacionConexion() throws RemoteException {
		return "Conexion establecida con el servidor.";
	}
	public String getName() {
		return serverName;
	}
}
