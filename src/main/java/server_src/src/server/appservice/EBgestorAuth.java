package src.server.appservice;

import src.server.dto.Usuario;
import src.server.gateway.AuthToSystem;

public class EBgestorAuth {

	private AuthToSystem authGway;
	private static EBgestorAuth gestorAuth = null;

	private EBgestorAuth(){}
	
//	private EBgestorAuth(String[] args) {
//		this.authGway = new AuthToSystem(args[0], args[1]);
//	}

	public static EBgestorAuth getGestorAuth()
	{
		synchronized(EBgestorAuth.class)
		{
			if (gestorAuth == null) gestorAuth = new EBgestorAuth();
		}
		return gestorAuth;
	}
	
	public void setArgs(String[] args)
	{
		authGway = new AuthToSystem(args);
	}
	
	public boolean iniciarSesion (String correo, String contrasenya)
	{
		try {
			boolean confirmacion = this.authGway.LogIn(correo, contrasenya);
			if (confirmacion==false)
			{
				System.out.println("Inicio sesion no permitida");
				return false;
			}
			else
			{
				System.out.println("Inicio sesion exitoso");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean registrarse (String nombre, String apellidos, String correo)
	{
		try {
			long contrasenya = 0;
			contrasenya = this.authGway.createUser(nombre, apellidos, correo);
			boolean confirmacion = false;
			if(contrasenya!=0)confirmacion=true;
			if (confirmacion==false)
			{
				System.out.println("Registro no permitido");
				return false;
			}
			else
			{
				System.out.println("Registro exitoso");
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
