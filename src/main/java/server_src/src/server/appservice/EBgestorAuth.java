package src.server.appservice;

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
	
	public void iniciarSesion (String correo, String contrasenya)
	{
		try {
			this.authGway.LogIn(correo, contrasenya);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registrarse (String nombre, String apellidos, String correo)
	{
		try {
			this.authGway.createUser(nombre, apellidos, correo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
