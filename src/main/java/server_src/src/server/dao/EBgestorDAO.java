package src.server.dao;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import src.server.appservice.EBgestorAuth;
import src.server.dto.Persona;
import src.server.dto.Reserva;
import src.server.dto.Usuario;

public class EBgestorDAO {

	static PersistenceManagerFactory persistentManagerFactory;
	//Insert data in the DB
	static PersistenceManager persistentManager;				
	static Transaction transaction;

	private static EBgestorDAO gestorDAO = null;
	private static ArrayList<Usuario> usus = new ArrayList<Usuario>();
	private static ArrayList<Reserva> reses;
	private static Usuario usuarioSesion;

	private EBgestorDAO(){}
	
	public static EBgestorDAO getGestorDAO()
	{
		synchronized(EBgestorDAO.class)
		{
			if (gestorDAO == null) gestorDAO = new EBgestorDAO();
		}
		return gestorDAO;
	}	
	
	public void anyadirUsuario(String nombre, String apellido, String correo)
	{
		try
        {
			//Duda con la linea que viene a continuacion
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
		    transaction.begin();		    
		    
		    Usuario usu = new Usuario(nombre, apellido, correo);
		    //Persistimos los datos en la BD
		    persistentManager.makePersistent(usu);

		    //Imprimimos lo que hemos introducido en la BD
		    System.out.println("- Inserted into db: " + usu.getNombre());
		    
		    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
		}
		
		finally
		{		
			try {
				if (transaction.isActive()) 
				{
			        transaction.rollback();
			    }
			}
			catch (NullPointerException n) {
				System.out.println("Ha pasado por el catch del DAO.");
			}
		    
		    persistentManager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void anyadirReserva(String cod_vuelo, ArrayList<Persona> pasajeros)
	{
		try
        {
			//Duda con la linea que viene a continuacion
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
		    transaction.begin();		    
		    
		    Reserva res = new Reserva(cod_vuelo);
		    res.addPersonasRes(pasajeros);
		    usuarioSesion.getReservas().add(res);
		    //Persistimos los datos en la BD
		    persistentManager.makePersistent(res);

		    //Imprimimos lo que hemos introducido en la BD
		    System.out.println("- Inserted into db: " + res.getId_reserva());
		    for(Persona p: res.getPersonasRes()) {
		    	System.out.println("- Inserted into db passenger: " + p.getNombre() + " " + p.getApellido());
		    }
		    
		    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception inserting user into db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
	}
	
	public void eliminarUsuario(Usuario usu)
	{
		try
        {
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			transaction = persistentManager.currentTransaction();
		    transaction.begin();
		    
		    Usuario eliminar = persistentManager.getObjectById(Usuario.class, usu.getCorreo());
			persistentManager.deletePersistent(eliminar);
			System.out.println("- Deleted from DB:" + usu.getNombre());
			
		    
		    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception deleting data into db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
	}
	
	
	public void actualizarUsuario(String correo, String nombre, String apellido)
	{
		try
        {
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			transaction = persistentManager.currentTransaction();

			//Esta de aqui abajo es la manera en la que estaba antes
		 	transaction.begin();		 	
		    usuarioSesion.setCorreo(correo);
		    usuarioSesion.setNombre(nombre);
		    usuarioSesion.setNombre(apellido);
		    System.out.println("Actualizacion realizada.");
			
		    //Imprimimos lo que hemos introducido en la BD
		    System.out.println("- Updated Usuario: " + usuarioSesion.getNombre());			   
			    
		    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception updating data into db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
	}

	public void actualizarReserva(Reserva actu)
	{
		try
        {
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			transaction = persistentManager.currentTransaction();

			//Esta de aqui abajo es la manera en la que estaba antes
		 	transaction.begin();
		    Reserva reserva1 = persistentManager.getObjectById(Reserva.class, "21");
		    reserva1.setPrecio(200);
		    System.out.println("Reserva actualizada");
			
//			transaction.begin();
//			Reserva eliminar = persistentManager.getObjectById(Usuario.class, actu.getId_reserva());
//			persistentManager.deletePersistent(eliminar);
//		    //Persistimos los datos en la BD
//		    persistentManager.makePersistent(actu);

		    //Imprimimos lo que hemos introducido en la BD
		    System.out.println("- Updated Reserva: " + actu.getId_reserva());			   
			    
		    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception updating data into db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
	}
	
	public ArrayList<Usuario> selectUsuarios()
	{
		try
        {
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			transaction = persistentManager.currentTransaction();
			System.out.println("");
			transaction.begin();
			@SuppressWarnings("unchecked")
			Query <Usuario> q1 = persistentManager.newQuery("SELECT FROM " + Usuario.class.getName());
		    for (Usuario aux : q1.executeList()) {
				usus.add(aux);
			}
		    transaction.commit();
		    
		}

        catch(Exception ex)
		{
			System.err.println("* Exception selecting data into db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
		return usus;
	}
	
	public ArrayList<Reserva> selectReservas()
	{
		try
        {
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			transaction = persistentManager.currentTransaction();
			System.out.println("");
			transaction.begin();
			@SuppressWarnings("unchecked")
			Query <Reserva> q1 = persistentManager.newQuery("SELECT FROM " + Reserva.class.getName());
		    for (Reserva aux : q1.executeList()) {
				reses.add(aux);
			}
		    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception selecting data into db: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
		return reses;
	}
	
	public void indicarSesionDAO(String correo)
	{
		try{
		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
		transaction.begin();
		usuarioSesion = persistentManager.getObjectById(Usuario.class, correo);
	    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception indicando sesion DAO: " + ex.getMessage());
		}
		
		finally
		{		    
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
	}	
}
