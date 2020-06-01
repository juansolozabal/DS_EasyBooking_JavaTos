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
	
	public boolean registrarse(String nombre, String apellidos, String correo, float amount)
	{
		ieb = rsl.getService();
		try {
			return ieb.registrarse(nombre, apellidos, correo, amount);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al registrarse: " + e.toString());	
			return false;
			}
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
	public void hacerReserva(String codVuelo, String correo, ArrayList<Persona> pasajeros)
	{
		ieb = rsl.getService();
		try {
			ieb.hacerReserva(codVuelo, correo, pasajeros);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al hacer reserva: " + e.toString());		
			}
	}

	
	public void pagarPayPal(String email, float amount, String concepto, String cod_vuelo, ArrayList<Persona> personas) 
	{
		ieb = rsl.getService();
		try {
			ieb.pagarPayPal(email, amount, concepto, cod_vuelo, personas);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al pagar con PayPal: " + e.toString());		
		}
	}
	
	public void pagarVisa(String email, float amount, String concepto, String cod_vuelo, ArrayList<Persona> personas) 
	{
		ieb = rsl.getService();
		try {
			System.out.println("Tamanyo del ArrayList en EBController: " + personas.size());
		    for(Persona p: personas) {
		    	System.out.println("Personas a introducir en EBController: " + p.getNombre() + " " + p.getApellido());
		    }
			ieb.pagarVisa(email, amount, concepto, cod_vuelo, personas);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al pagar con Visa: " + e.toString());		
		}
	}
	
	public void anyadirUsuario(String nombre, String apellido, String correo)
	{
		ieb = rsl.getService();
		try {
			ieb.anyadirUsuario(nombre, apellido, correo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al guardar usuario en BD: " + e.toString());		
		}
	}
	
	public void indicarSesionDAO(String correo, String contrasenya)
	{
		ieb = rsl.getService();
		try {
			ieb.indicarSesionDAO(correo, contrasenya);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println("$ Error al obtener sesion actual de la BD: " + e.toString());		
		}
	}
	
	public static void main(String[] args) throws RemoteException {    	
    	new EBController(args); // Crea una instancia y llama al constructor
    }
}
