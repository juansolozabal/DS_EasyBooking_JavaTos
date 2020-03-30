import java.awt.List;
import java.util.ArrayList;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import LD.Reserva;
import LD.Usuario;

public class MainDB {
		static PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Insert data in the DB
		static PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();				
		static Transaction transaction = persistentManager.currentTransaction();
	
		public static void main(String[] args) {

		try
        {
			Anyadir();
			Eliminar();
			Actualizar();
			Select();
        }
		catch (Exception ex)
        {
			System.err.println("* Exception: " + ex.getMessage());
		}
	}
		
		
		public static void Anyadir()
		{
			try
            {
			    transaction.begin();
			    
			    //Anyadimos usuario 1 a nivel local
			    Usuario usuario1 = new Usuario(72839127, "Juan", "Solozabal", "juansolozabal@gmail.com", 3654, 123);
			    //Anyadimos reserva 1 a nivel local
			    Reserva reserva1= new Reserva(256);
			    //Asignamos la reserva 1 al usuario 1
			    usuario1.getReservas().add(reserva1);
			    //Persistimos los datos en la BD
			    persistentManager.makePersistent(usuario1);
			    persistentManager.makePersistent(reserva1);
			    //Imprimimos lo que hemos introducido en la BD
			    System.out.println("- Inserted into db: " + reserva1.getId_reserva());
			    System.out.println("- Inserted into db: " + usuario1.getNombre());
			    
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
		public static void Eliminar()
		{
			try
            {
			    transaction.begin();
			    
			    //Anyadimos usuario 1 a nivel local
			    Usuario usuario1 = new Usuario(72839127, "Juan", "Solozabal", "juansolozabal@gmail.com", 3654, 123);
			    //Anyadimos reserva 1 a nivel local
			    Reserva reserva1= new Reserva(256);
			    //Asignamos la reserva 1 al usuario 1
			    usuario1.getReservas().add(reserva1);
			    //Persistimos los datos en la BD
			    persistentManager.makePersistent(usuario1);
			    persistentManager.makePersistent(reserva1);
			    //Imprimimos lo que hemos introducido en la BD
			    System.out.println("- Inserted into db: " + reserva1.getId_reserva());
			    System.out.println("- Inserted into db: " + usuario1.getNombre());
			    
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
		public static void Actualizar()
		{
			try
            {
			    transaction.begin();
			    
			    //Anyadimos usuario 1 a nivel local
			    Usuario usuario1 = new Usuario(72839127, "Juan", "Solozabal", "juansolozabal@gmail.com", 3654, 123);
			    //Anyadimos reserva 1 a nivel local
			    Reserva reserva1= new Reserva(256);
			    //Asignamos la reserva 1 al usuario 1
			    usuario1.getReservas().add(reserva1);
			    //Persistimos los datos en la BD
			    persistentManager.makePersistent(usuario1);
			    persistentManager.makePersistent(reserva1);
			    //Imprimimos lo que hemos introducido en la BD
			    System.out.println("- Inserted into db: " + reserva1.getId_reserva());
			    System.out.println("- Inserted into db: " + usuario1.getNombre());
			    
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
		public static void Select()
		{
			try
            {
			    transaction.begin();
			    
			    //Anyadimos usuario 1 a nivel local
			    Usuario usuario1 = new Usuario(72839127, "Juan", "Solozabal", "juansolozabal@gmail.com", 3654, 123);
			    //Anyadimos reserva 1 a nivel local
			    Reserva reserva1= new Reserva(256);
			    //Asignamos la reserva 1 al usuario 1
			    usuario1.getReservas().add(reserva1);
			    //Persistimos los datos en la BD
			    persistentManager.makePersistent(usuario1);
			    persistentManager.makePersistent(reserva1);
			    //Imprimimos lo que hemos introducido en la BD
			    System.out.println("- Inserted into db: " + reserva1.getId_reserva());
			    System.out.println("- Inserted into db: " + usuario1.getNombre());
			    
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

}
