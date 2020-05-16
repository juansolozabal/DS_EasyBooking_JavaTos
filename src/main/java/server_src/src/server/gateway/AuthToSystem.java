package src.server.gateway;

public class AuthToSystem implements IGatewayAuth{

	private String IP;
	private String PORT;
	
	public AuthToSystem(String IP, String PORT) {
		super();
		this.IP=IP;
		this.PORT=PORT;
	}

	
// TODO Te dejo esto para ti Juanso, disfrutalo.
	@Override
	public void makeGetRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makePutRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makePostRequest() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void iniciarSesion(String correo, String contrasenya) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void registrarse(String nombre, String apellidos, String correo) {
		// TODO Auto-generated method stub
		
	}

}
