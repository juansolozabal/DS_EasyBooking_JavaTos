package src.server.gateway;

public interface IGatewayAuth {
	public void makeGetRequest();
	public void makePutRequest();
	public void makePostRequest();
	public void iniciarSesion (String correo, String contrasenya);
	public void registrarse (String nombre, String apellidos, String correo);
}
