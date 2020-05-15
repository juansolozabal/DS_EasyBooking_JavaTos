package src;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import src.server.remote.EBManager;
import src.server.remote.IEBManager;

public class EasyBookingManagerServer {

	public static void main(String[] args) {
		
		if (args.length != 3) 
		{
			System.exit(0);
		}

		if (System.getSecurityManager() == null) 
		{
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		
		try 
		{
			IEBManager EBServer = new EBManager(args[2]);
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			registry.rebind(name,EBServer);		
			System.out.println("- EBProgramManager '" + name + "' active and waiting...");
		} 
		catch (Exception e) 
		{
			System.err.println("$ EBProgramManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
