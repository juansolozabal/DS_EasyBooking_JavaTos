package src.server.gateway;

public interface IGatewayPagos {
	public String makePayment(String email, float amount, String concept) throws Exception;
	public boolean updateCurrency(String email, float amount) throws Exception;
	public long createUser(String nombre, String apellido, String email, float amount) throws Exception;
}
