package src.client.controller;

import src.client.remote.RMIServiceLocator;
import src.client.gui.frmLogotipoInicial;
import src.server.remote.IEBManager;
import src.server.dto.Persona;
import src.server.dto.Vuelo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class EBController {

	private RMIServiceLocator rsl;
	private frmLogotipoInicial app;
	private IEBManager ieb;
	
	public EBController(String[] args) throws RemoteException
	{
		// Add your related code for the initialization of the Service Locator
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
        // Add your code for the initialization of the windows		
		app = new frmLogotipoInicial(this);
		
		app.setVisible(true);
	}
	
	public boolean iniciarSesion(String correo, String contrasenya)
	{
		ieb = rsl.getService();
		try {
			return ieb.iniciarSesion(correo, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error iniciando sesion: " + e.toString());
			return false;
		}
	}

	public void introducirPersonaReserva(int dni, String nombre, String apellidos)
	{
		ieb = rsl.getService();
		try {
			ieb.introducirPersonaReserva(dni, nombre, apellidos);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al introducir personas en la reserva: " + e.toString());		
		}
	}
	
	public void registrarse(String nombre, String apellidos, String correo)
	{
		ieb = rsl.getService();
		try {
			ieb.registrarse(nombre, apellidos, correo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al registrarse: " + e.toString());		}
	}
	
	public ArrayList<Vuelo> buscarVuelos(Object[] parametros_busqueda) 
	{
		ieb = rsl.getService();
		try {
			return ieb.buscarVuelos(parametros_busqueda);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al buscar vuelo: " + e.toString());		
			}
		return null;
	}
	
	public ArrayList<Vuelo> getVuelos() {
		ieb = rsl.getService();
		try {
			return ieb.getVuelos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Da error");
			e.printStackTrace();
		}
		return null;
	}
	public void hacerReserva(int codVuelo, String correo, ArrayList<Persona> pasajeros)
	{
		ieb = rsl.getService();
		try {
			ieb.hacerReserva(codVuelo, correo, pasajeros);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al hacer reserva: " + e.toString());		
			}
	}

	
	public void pagarPayPal(String email, String contrasenya) 
	{
		ieb = rsl.getService();
		try {
			ieb.pagarPayPal(email, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al pagar con PayPal: " + e.toString());		
		}
	}
	
	public void pagarVisa(String nomTitular, int numTarj, Date venc, int cvc) 
	{
		ieb = rsl.getService();
		try {
			ieb.pagarVisa(nomTitular, numTarj, venc, cvc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al pagar con Visa: " + e.toString());		
		}
	}
	
	public void anyadirUsuario(int dni,String nombre, String apellido, String correo, int pin, int idAeropuerto)
	{
		ieb = rsl.getService();
		try {
			ieb.anyadirUsuario(dni, nombre, apellido, correo, pin, idAeropuerto);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al guardar usuario en BD: " + e.toString());		
		}
	}
	
	public static void main(String[] args) throws RemoteException {    	
    	new EBController(args); // Crea una instancia y llama al constructor
    }
}
