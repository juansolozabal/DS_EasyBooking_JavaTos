package src.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import src.server.dto.Persona;
import src.server.dto.Reserva;
import src.server.dto.Usuario;
import src.server.dto.Vuelo;

public interface IEBManager extends Remote {

	public boolean iniciarSesion(String correo, String contrasenya) throws RemoteException;
	public boolean registrarse(String nombre, String apellidos, String correo) throws RemoteException;
	public void introducirPersonaReserva(int dni, String nombre, String apellidos) throws RemoteException;
	public void hacerReserva(int codVuelo, String correo, ArrayList<Persona> pasajeros) throws RemoteException;
	public void pagarPayPal(String email, String contrasenya) throws RemoteException;
	public void pagarVisa(String nomTitular, int numTarj, Date venc, int cvc) throws RemoteException;
	public ArrayList<Vuelo> buscarVuelos(Object[] parametros_busqueda) throws RemoteException; //Se buscan vuelos en un fecha especifica
	public ArrayList<Vuelo> getVuelos() throws RemoteException; //Al arranque del programa se recogeran todos los vuelos
	public String comprobacionConexion() throws RemoteException;
	public void anyadirUsuario(String nombre, String apellido, String correo)throws RemoteException;
	public void eliminarUsuario(Usuario usu) throws RemoteException;
	public void actualizarUsuario(String correo, String nombre, String apellido) throws RemoteException;
	public void actualizarReserva(Reserva actu) throws RemoteException;
	public ArrayList<Usuario> selectUsuarios() throws RemoteException;
	public ArrayList<Reserva> selectReservas() throws RemoteException;	
	public void indicarSesionDAO(String correo, String contrasenya)throws RemoteException;
}
