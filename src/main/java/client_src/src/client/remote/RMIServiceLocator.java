package src.client.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import src.server.remote.IEBManager;

public class RMIServiceLocator
{
	/** 
	 * The Cache - Limitation: one server at a time
	 * Proposed improvement: list of services
	 */
	
	private IEBManager ieb = null;
	private Registry registry;
	private String nameIEBManager;

    /** Creates a new instance of RMIServiceLocator */
    public RMIServiceLocator() { }

    public void setService(String ip, String port, String serviceName) 
    {    
    	try {
			registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
			nameIEBManager = "//" + ip + ":" + port + "/" + serviceName;
			ieb = (IEBManager) registry.lookup(nameIEBManager);
			System.out.println("* Mensaje del servidor: '" + ieb.comprobacionConexion() + "'");

		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public IEBManager getService() 
    {
		try {
			ieb = (IEBManager) registry.lookup(nameIEBManager);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Add your code to return reference to ServiceLocator
    	return ieb;    	
    }
}
