package src.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import src.server.appservice.EBgestorAero;
import src.server.appservice.EBgestorAuth;
import src.server.appservice.EBgestorPagos;
import src.server.dao.EBgestorDAO;
import src.server.dto.Persona;
import src.server.dto.Reserva;
import src.server.dto.Usuario;
import src.server.dto.Vuelo;
import src.server.dto.VueloAssembler;
import src.server.gateway.Flight_JSON;

public class EBManager extends UnicastRemoteObject implements IEBManager{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serverName;
	
	public EBManager(String[] args) throws RemoteException 
	{
		super();
		this.serverName = args[2];
		System.out.println("Probando EBManager");
		EBgestorAero.getGestorAero().setArgs(args);
		EBgestorAuth.getGestorAuth().setArgs(args);
		EBgestorPagos.getGestorPagos().setArgs(args);
		EBgestorDAO.getGestorDAO();
	}
	
	@Override
	public boolean iniciarSesion(String correo, String contrasenya) throws RemoteException {
		boolean inicio = EBgestorAuth.getGestorAuth().iniciarSesion(correo, contrasenya);
		if (inicio){
				EBgestorDAO.getGestorDAO().indicarSesionDAO(correo);
		}
		return inicio;

	}

	@Override
	public boolean registrarse(String nombre, String apellidos, String correo)	throws RemoteException {
		boolean registro = EBgestorAuth.getGestorAuth().registrarse(nombre, apellidos, correo);
		if (registro){
				EBgestorDAO.getGestorDAO().anyadirUsuario(nombre, apellidos, correo);
				EBgestorDAO.getGestorDAO().indicarSesionDAO(correo);
		}
		return registro;
	}

	@Override
	public void introducirPersonaReserva(int dni, String nombre, String apellidos) throws RemoteException {
		
		//Este hay que mirar bien donde meterlo. Este metodo no tiene que estar conectado
		//Con el gestor pagos, es algo que debemos gestionar internamente. Una vez que hayamos
		//acabado de meter todas las personas, en el clicaremos en aceptar y llamaremos al 
		//metodo hacer reserva. Este ultimo si que estara conectado al gestorPagos.
	}

	@Override
	public void hacerReserva(String codVuelo, String correo, ArrayList<Persona> pasajeros) throws RemoteException {
		EBgestorDAO.getGestorDAO().anyadirReserva(codVuelo, pasajeros);
		
	}

	@Override
	public void pagarVisa(String nomTitular, int numTarj, Date venc, int cvc) throws RemoteException{
		EBgestorPagos.getGestorPagos().pagarVisa(nomTitular, numTarj, venc, cvc);
		
		//Esto es lo que se haria en caso de tener acceso a la BD
//		if(EBgestorPagos.getGestorPagos().pagarVisa(nomTitular, numTarj, venc, cvc)!= "False"){
//			EBgestorDAO.getGestorDAO().anyadirReserva(cod_vuelo);
//		}
		
	}

	@Override
	public void pagarPayPal(String email, String contrasenya) throws RemoteException{
		EBgestorPagos.getGestorPagos().pagarPayPal(email, contrasenya);
		
		//Esto es lo que se haria en caso de tener acceso a la BD
//		if(EBgestorPagos.getGestorPagos().pagarPayPal(email, contrasenya)!= "False"){
//			EBgestorDAO.getGestorDAO().anyadirReserva(cod_vuelo);
//		}
	}

	@Override
	public ArrayList<Vuelo> buscarVuelos(Object[] parametros_busqueda) throws RemoteException{
		return VueloAssembler.assemble(EBgestorAero.getGestorAero().getVuelos(parametros_busqueda));
	}

	@Override
	public ArrayList<Vuelo> getVuelos() throws RemoteException {
		System.out.println("Ha pasado por EBManager");
		return VueloAssembler.assemble(EBgestorAero.getGestorAero().getVuelos());
	}
	
	public String comprobacionConexion() throws RemoteException {
		return "Conexion establecida con el servidor.";
	}
	public String getName() {
		return serverName;
	}
	
	public void anyadirUsuario(String nombre, String apellido, String correo) throws RemoteException {
		EBgestorDAO.getGestorDAO().anyadirUsuario(nombre, apellido, correo);
	}

	public void eliminarUsuario(Usuario usu)throws RemoteException {
		EBgestorDAO.getGestorDAO().eliminarUsuario(usu);
	}
	public void actualizarUsuario(String correo, String nombre, String apellido)throws RemoteException {
		EBgestorDAO.getGestorDAO().actualizarUsuario(correo, nombre, apellido);
	}
	public void actualizarReserva(Reserva actu)throws RemoteException {
		EBgestorDAO.getGestorDAO().actualizarReserva(actu);
	}

	public ArrayList<Usuario> selectUsuarios()throws RemoteException {
		return EBgestorDAO.getGestorDAO().selectUsuarios();
	}

	public ArrayList<Reserva> selectReservas()throws RemoteException {
		return EBgestorDAO.getGestorDAO().selectReservas();
	}

	@Override
	public void indicarSesionDAO(String correo, String contrasenya) throws RemoteException {
		EBgestorDAO.getGestorDAO().indicarSesionDAO(correo);		
	}
	
}