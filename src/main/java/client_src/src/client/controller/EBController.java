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

	private RMIServiceLocator rsl = null;
	private frmLogotipoInicial app = null;
	private IEBManager ieb = null;
	
	public EBController(String[] args) throws RemoteException
	{
		// Add your related code for the initialization of the Service Locator
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);
        // Add your code for the initialization of the windows		
		app = new frmLogotipoInicial(this);
	}
	
	public void iniciarSesion(String nomUsuario, String correo, String contrasenya)
	{
		ieb = rsl.getService();
		try {
			ieb.iniciarSesion(nomUsuario, correo, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error iniciando sesion: " + e.toString());		}
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
	
	public void registrarse(String nombre, String apellidos, String correo, String nomUsuario, String contrasenya)
	{
		ieb = rsl.getService();
		try {
			ieb.registrarse(nombre, apellidos, correo, nomUsuario, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al registrarse: " + e.toString());		}
	}
	
	public ArrayList<Vuelo> buscarVuelos()
	{
		ieb = rsl.getService();
		try {
			return ieb.buscarVuelos();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al buscar vuelo: " + e.toString());		
			}
		return null;
	}
	
	public void hacerReserva(int codVuelo, String nomUsuario, ArrayList<Persona> pasajeros)
	{
		ieb = rsl.getService();
		try {
			ieb.hacerReserva(codVuelo, nomUsuario, pasajeros);
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
	
	public static void main(String[] args) throws RemoteException {    	
    	new EBController(args); // Crea una instancia y llama al constructor
    }
}
