package src.server.gateway;

public interface IGatewayAuth {

	public boolean LogIn(String email, String password) throws Exception;
	public long createUser(String nombre, String apellido, String email) throws Exception;
	public boolean changePassword(String nombre, String passOld, String passNew) throws Exception;
	public boolean deleteUser(String email, String password) throws Exception;
	
}