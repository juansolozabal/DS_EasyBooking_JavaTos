package src.server.dao;


import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import src.server.appservice.EBgestorAuth;
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

	private EBgestorDAO(){
		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("../../datanucleus.properties");
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
	}
	
	public static EBgestorDAO getGestorDAO()
	{
		synchronized(EBgestorDAO.class)
		{
			if (gestorDAO == null) gestorDAO = new EBgestorDAO();
		}
		return gestorDAO;
	}	
	
	public static void anyadirUsuario(Usuario usu)
	{
		try
        {
			//Duda con la linea que viene a continuacion
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
		    transaction.begin();		    

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
			if (transaction.isActive()) 
			{
		        transaction.rollback();
		    }
		    
		    persistentManager.close();
		}
	}
	
	public static void anyadirReservaAUsuario (Usuario usu, Reserva res)
	{
		try
        {
			//Duda con la linea que viene a continuacion
			persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
		    transaction.begin();
		    
		    
		    Usuario eliminar = persistentManager.getObjectById(Usuario.class, usu.getDni());
			persistentManager.deletePersistent(eliminar);			
			usu.getReservas().add(res);

		    //Persistimos los datos en la BD
		    persistentManager.makePersistent(usu);

		    //Imprimimos lo que hemos introducido en la BD
		    System.out.println("- Inserted Reserva into Usuario: " + usu.getNombre());
		    
		    transaction.commit();
		}

        catch(Exception ex)
		{
			System.err.println("* Exception inserting data into db: " + ex.getMessage());
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
	public static void eliminarUsuario(Usuario usu)
	{
		try
        {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
		    transaction.begin();
		    
		    Usuario eliminar = persistentManager.getObjectById(Usuario.class, usu.getDni());
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
	
	
	public static void actualizarUsuario(Usuario actu)
	{
		try
        {
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();

//Esta de aqui abajo es la manera en la que estaba antes
//		 	transaction.begin();
//		 	
//		    Usuario usuario1 = persistentManager.getObjectById(Usuario.class, actu.getDni());
//		    usuario1.setCorreo("juan.solozabal@opendeusto.es");
//		    System.out.println("Actualizacion realizada.");
			
			transaction.begin();
			Usuario eliminar = persistentManager.getObjectById(Usuario.class, actu.getDni());
			persistentManager.deletePersistent(eliminar);
		    //Persistimos los datos en la BD
		    persistentManager.makePersistent(actu);

		    //Imprimimos lo que hemos introducido en la BD
		    System.out.println("- Updated Usuario: " + actu.getNombre());			   
			    
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

	public static void actualizarReserva(Reserva actu)
	{
		try
        {
			persistentManager = persistentManagerFactory.getPersistenceManager();
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
			persistentManager = persistentManagerFactory.getPersistenceManager();
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
			persistentManager = persistentManagerFactory.getPersistenceManager();
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
	
	
}
