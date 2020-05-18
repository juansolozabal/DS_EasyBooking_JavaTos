package src.server.gateway;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;


public class RestClient <T extends DF_Printable> {
	protected Client client;
	protected WebTarget webTarget;
	
	public boolean request_OK (int response_status) {
		return response_status == Status.OK.getStatusCode() ||        // Code: 200
				response_status == Status.CREATED.getStatusCode() ||  // Code: 201
				response_status == Status.ACCEPTED.getStatusCode();   // Code: 202
	}
	
	public RestClient(String hostname, String port) {
		this.client = ClientBuilder.newClient();
		this.webTarget = client.target(String.format("http://%s:%s", hostname, port));
	}
	
	public Invocation.Builder createInvocationBuilder (String resource_URL) throws Exception {
		WebTarget requestController = this.webTarget.path(resource_URL);
		Invocation.Builder invocationBuilder = requestController
				.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		System.out.println("Java Client preparing Jersey request call to " +
				String.format("http://%s:%s%s",
						webTarget.getUri().getHost(),
						webTarget.getUri().getPort(),
						webTarget.getUri().getRawPath()
				));

		return invocationBuilder;
	}
	
	public Response makeGetRequest(Invocation.Builder invocationBuilder) throws Exception
	{
		System.out.println("Sending GET Request");
		return invocationBuilder.get();
	}

	public Response makePostRequest(Invocation.Builder invocationBuilder, T objectToSend) throws Exception
	{
		System.out.println("Content of message to send in POST Request");
		((DF_Printable) objectToSend).print();
		return invocationBuilder.post(Entity.entity(objectToSend, MediaType.APPLICATION_JSON));
	}

	public Response makePutRequest(Invocation.Builder invocationBuilder, T objectToSend) throws Exception
	{
		System.out.println("Content of message to send in PUT Request");
		objectToSend.print();
		return invocationBuilder.put(Entity.entity(objectToSend, MediaType.APPLICATION_JSON));
	}

	public void simplePrint(Response response)
	{
		// From wikipedia "marshalling is the process of transforming the memory representation of an object to a data format suitable for storage or transmission"
		// So unmarshalling means reconverting it back to the object
		// In this method we just print the content of the reply as string

		System.out.println("Java Jersey Client received the following output:");
		System.out.println(response.toString());

		if ( request_OK( response.getStatus() ) ) {
			System.out.println("Successfully made Rest request... ");
			System.out.println("Goint to print response content as string");

			List<String> reply = response.readEntity(new GenericType<List<String>>() { } );
			for (String a: reply) {
				System.out.println(a);
			}

			System.out.println( response.readEntity(String.class) );
		}
		else {
			System.out.println("BadAss error happened. Can't print result.");
		}
	}
}