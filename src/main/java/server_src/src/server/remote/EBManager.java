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
		return EBgestorAuth.getGestorAuth().iniciarSesion(correo, contrasenya);

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
	public void hacerReserva(int codVuelo, String correo, ArrayList<Persona> pasajeros) throws RemoteException {
		EBgestorPagos.getGestorPagos().hacerReserva(codVuelo, correo, pasajeros);
		
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
		return VueloAssembler.assemble(EBgestorAero.getGestorAero().getVuelos(nomOrigen, nomDestino));
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
	
	public void anyadirUsuario(Usuario usu) throws RemoteException {
		EBgestorDAO.anyadirUsuario(usu);
	}
	public void anyadirReservaAUsuario (Usuario usu, Reserva res) throws RemoteException {
		EBgestorDAO.anyadirReservaAUsuario(usu, res);
	}
	public void eliminarUsuario(Usuario usu)throws RemoteException {
		EBgestorDAO.eliminarUsuario(usu);
	}
	public void actualizarUsuario(Usuario actu)throws RemoteException {
		EBgestorDAO.actualizarUsuario(actu);
	}
	public void actualizarReserva(Reserva actu)throws RemoteException {
		EBgestorDAO.actualizarReserva(actu);
	}

	public ArrayList<Usuario> selectUsuarios()throws RemoteException {
		return EBgestorDAO.selectUsuarios();
	}

	public ArrayList<Reserva> selectReservas()throws RemoteException {
		return EBgestorDAO.selectReservas();
	}
	
}