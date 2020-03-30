
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import LD.Reserva;
import LD.Usuario;

public class MainDB {
		static PersistenceManagerFactory persistentManagerFactory;
		//Insert data in the DB
		static PersistenceManager persistentManager;				
		static Transaction transaction;
	
		public static void main(String[] args) {
			
		persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		persistentManager = persistentManagerFactory.getPersistenceManager();
		transaction = persistentManager.currentTransaction();
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
				persistentManager = persistentManagerFactory.getPersistenceManager();
				transaction = persistentManager.currentTransaction();
			    transaction.begin();
			    
			    //Anyadimos usuarios
			    Usuario usuario1 = new Usuario(72839127, "Juan", "Solozabal", "juansolozabal@gmail.com", 3654, 123);
			    Usuario usuario2 = new Usuario(72555100, "Javier", "Alvarez de Eulate", "javier.a.eulate@gmail.com", 1234, 112);
			    Usuario usuario3 = new Usuario(74632437, "Jon", "Sanchez", "jonsanchez@gmail.com", 6853, 863);
			    Usuario usuario4 = new Usuario(76424685, "Lander", "Pison", "landerpison@gmail.com", 8573, 075);
			    Usuario usuario5 = new Usuario(75739572, "Mikel", "Sanz", "mikelsanz@gmail.com", 9643, 247);
			    Usuario usuario6 = new Usuario(74927593, "Laura", "Gomez", "lauragomez@gmail.com", 1562, 034);
			    Usuario usuario7 = new Usuario(78306823, "Luken", "White", "lukenwhite@gmail.com", 6357, 2535);
			    Usuario usuario8 = new Usuario(72936384, "Lucas", "Eguibar", "lucaseguibar@gmail.com", 2468, 642);
			    Usuario usuario9 = new Usuario(72956385, "Joaquin", "Del Campo", "joaquindelcampo@gmail.com", 2453, 674);
			    Usuario usuario10 = new Usuario(72325229, "Iratxe", "Lizasoain", "iratxelizasoain@gmail.com", 9242, 678);
			    //Anyadimos reservas
			    Reserva reserva1= new Reserva(256);
			    Reserva reserva2= new Reserva(573);
			    Reserva reserva3= new Reserva(764);
			    Reserva reserva4= new Reserva(134);
			    Reserva reserva5= new Reserva(532);
			    Reserva reserva6= new Reserva(845);
			    Reserva reserva7= new Reserva(143);
			    Reserva reserva8= new Reserva(642);
			    Reserva reserva9= new Reserva(120);
			    Reserva reserva10= new Reserva(923);
			    //Asignamos la reserva 1 al usuario 1
			    usuario1.getReservas().add(reserva1);
			    usuario1.getReservas().add(reserva2);
			    usuario2.getReservas().add(reserva3);
			    usuario3.getReservas().add(reserva4);
			    usuario3.getReservas().add(reserva5);
			    usuario3.getReservas().add(reserva6);
			    usuario4.getReservas().add(reserva7);
			    usuario5.getReservas().add(reserva8);
			    usuario6.getReservas().add(reserva9);
			    usuario7.getReservas().add(reserva10);
			    //Persistimos los datos en la BD
			    persistentManager.makePersistent(usuario1);
			    persistentManager.makePersistent(usuario2);
			    persistentManager.makePersistent(usuario3);
			    persistentManager.makePersistent(usuario4);
			    persistentManager.makePersistent(usuario5);
			    persistentManager.makePersistent(usuario6);
			    persistentManager.makePersistent(usuario7);
			    persistentManager.makePersistent(usuario8);
			    persistentManager.makePersistent(usuario9);
			    persistentManager.makePersistent(usuario10);
			    persistentManager.makePersistent(reserva1);
			    persistentManager.makePersistent(reserva2);
			    persistentManager.makePersistent(reserva3);
			    persistentManager.makePersistent(reserva4);
			    persistentManager.makePersistent(reserva5);
			    persistentManager.makePersistent(reserva6);
			    persistentManager.makePersistent(reserva7);
			    persistentManager.makePersistent(reserva8);
			    persistentManager.makePersistent(reserva9);
			    persistentManager.makePersistent(reserva10);
			    //Imprimimos lo que hemos introducido en la BD
			    System.out.println("- Inserted into db: " + usuario1.getNombre());
			    System.out.println("- Inserted into db: " + usuario2.getNombre());
			    System.out.println("- Inserted into db: " + usuario3.getNombre());
			    System.out.println("- Inserted into db: " + usuario4.getNombre());
			    System.out.println("- Inserted into db: " + usuario5.getNombre());
			    System.out.println("- Inserted into db: " + usuario6.getNombre());
			    System.out.println("- Inserted into db: " + usuario7.getNombre());
			    System.out.println("- Inserted into db: " + usuario8.getNombre());
			    System.out.println("- Inserted into db: " + usuario9.getNombre());
			    System.out.println("- Inserted into db: " + usuario10.getNombre());
			    System.out.println("- Inserted into db: " + reserva1.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva2.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva3.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva4.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva5.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva6.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva7.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva8.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva9.getId_reserva());
			    System.out.println("- Inserted into db: " + reserva10.getId_reserva());
			    
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
				persistentManager = persistentManagerFactory.getPersistenceManager();
				transaction = persistentManager.currentTransaction();
			    transaction.begin();
			    
			    Usuario eliminar = persistentManager.getObjectById(Usuario.class, "72325229");
				persistentManager.deletePersistent(eliminar);
				System.out.println("- Deleted from DB: ");
				
			    
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
		public static void Actualizar()
		{
			try
            {
				persistentManager = persistentManagerFactory.getPersistenceManager();
				transaction = persistentManager.currentTransaction();

			 	transaction.begin();
			    Usuario usuario1 = persistentManager.getObjectById(Usuario.class, "72839127");
			    usuario1.setCorreo("juan.solozabal@opendeusto.es");
			    System.out.println("Actualizacion realizada.");
				   
			    Usuario usuario2 = persistentManager.getObjectById(Usuario.class, "72555100");
			    usuario2.setCorreo("javier.a.eulate@opendeusto.es");
			    System.out.println("Actualizacion realizada.");
			    
//			    Reserva reserva1 = persistentManager.getObjectById(Reserva.class, "21");
//			    reserva1.setPrecio(200);
//			    System.out.println("Reserva actualizada");
//				    
//			    Reserva reserva2 = persistentManager.getObjectById(Reserva.class, "22");
//			    reserva2.setPrecio(100);
//			    System.out.println("Reserva actualizada");
				    
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
		public static void Select()
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
					System.out.println("DNI usuario: " + aux.getDni() + " y correo: " + aux.getCorreo());
				}
			    
			    @SuppressWarnings("unchecked")
			    Query <Reserva> q2 = persistentManager.newQuery("SELECT FROM " + Reserva.class.getName());
			    for (Reserva aux : q2.executeList()) {
					System.out.println("Precio reserva" + aux.getPrecio());
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
		}

}
