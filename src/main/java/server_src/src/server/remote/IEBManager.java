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

	public void iniciarSesion(String correo, String contrasenya) throws RemoteException;
	public void registrarse(String nombre, String apellidos, String correo) throws RemoteException;
	public void introducirPersonaReserva(int dni, String nombre, String apellidos) throws RemoteException;
	public void hacerReserva(int codVuelo, String nomUsuario, ArrayList<Persona> pasajeros) throws RemoteException;
	public void pagarPayPal(String email, String contrasenya) throws RemoteException;
	public void pagarVisa(String nomTitular, int numTarj, Date venc, int cvc) throws RemoteException;
	public ArrayList<Vuelo> buscarVuelos(Date fecha, String nomOrigen, String nomDestino) throws RemoteException; //Se buscan vuelos en un fecha especifica
	public ArrayList<Vuelo> getVuelos() throws RemoteException; //Al arranque del programa se recogeran todos los vuelos
	public String comprobacionConexion() throws RemoteException;
	public void anyadirUsuario(Usuario usu);
	public void anyadirReservaAUsuario (Usuario usu, Reserva res);
	public void eliminarUsuario(Usuario usu);
	public void actualizarUsuario(Usuario actu);
	public void actualizarReserva(Reserva actu);
	public ArrayList<Usuario> selectUsuarios();
	public ArrayList<Reserva> selectReservas();
}
