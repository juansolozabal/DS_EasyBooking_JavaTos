package src.server.appservice;

import src.server.gateway.AuthToSystem;

public class EBgestorAuth {

	private AuthToSystem authGway;

	public EBgestorAuth(String[] args) {
		this.authGway = new AuthToSystem(args[0], args[1]);
	}

	public void iniciarSesion (String correo, String contrasenya)
	{
		this.authGway.iniciarSesion(correo, contrasenya);
	}
	
	public void registrarse (String nombre, String apellidos, String correo)
	{
		this.authGway.registrarse(nombre, apellidos, correo);
	}
	
}
