import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import LD.Reserva;
import LD.Usuario;

public class MainBD {

	public static void main(String[] args) 
	{
		/*
		 * USUARIO
		 * - dni
		 * - nombre
		 * - apellido
		 * - correo
		 * - pin
		 * - id_aeropuerto
		 * 
		 * RESERVA
		 * - id_reserva (viene dado por datanucleus)
		 * - precio
		 * 
		 * PERSONA
		 * - dni
		 * - nombre
		 * - apellido
		 */
		try
        {
			PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			
			//Insert data in the DB
			PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
			Transaction transaction = persistentManager.currentTransaction();				
			
			try
            {
			    transaction.begin();
			    
			    Usuario usuario1 = new Usuario(72839127, "Juan", "Solozabal", "juansolozabal@gmail.com", 3654, 123);
			    Reserva reserva1= new Reserva(256);
			    
			    usuario1.getReservas().add(reserva1);		    
			    persistentManager.makePersistent(usuario1);
			    
			    System.out.println("- Inserted into db: " + reserva1.getId_reserva());
			    
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
			
			
			//Select data using a Query
			persistentManager = persistentManagerFactory.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
				
			try
            {
			    transaction.begin();
	
			    @SuppressWarnings("unchecked")
				Query<Reserva> ReservasQuery = persistentManager.newQuery("SELECT FROM " + Reserva.class.getName() + " WHERE precio < 150.00 ORDER BY precio ASC");
			    
			    for (Reserva reserva : ReservasQuery.executeList()) 
			    {
			        System.out.println("- Selected from db: " + reserva.getId_reserva());
			        persistentManager.deletePersistent(reserva);
			        System.out.println("- Deleted from db: " + reserva.getId_reserva());
			    }
	
			    transaction.commit();
			}

			catch(Exception ex)
			{
				System.err.println("* Exception executing a query: " + ex.getMessage());
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

		catch (Exception ex)
        {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}

}
