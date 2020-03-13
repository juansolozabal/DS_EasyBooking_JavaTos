
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

import LP.frmInicioRegistro;

public class clsMain 
{
	private static Logger logger = Logger.getLogger( clsMain.class.getName() );
	public static void main(String[] args) 
	{
		logger.setLevel( Level.ALL );  
		try {
			Handler h = new StreamHandler( System.out, new SimpleFormatter() );
			h.setLevel( Level.FINEST );
			logger.addHandler( h );  // Saca todos los errores a out
			logger.addHandler( new FileHandler( "clsMain.log.xml") ); 
		} catch (Exception e) {
			logger.log( Level.SEVERE, e.toString(), e );
		}
		
		frmInicioRegistro frPantalla = new frmInicioRegistro();
		frPantalla.setVisible(true);
		logger.log( Level.INFO, "Ejecutando programa. ");
	}
}
