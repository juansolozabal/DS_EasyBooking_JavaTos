package LP;

import static COMUN.clsConstantes.CMD_BTN_ATRAS;
import static COMUN.clsConstantes.CMD_BTN_INICIAR_SESION;
import static COMUN.clsConstantes.CMD_BTN_INICIAR_SESION2;
import static COMUN.clsConstantes.CMD_BTN_REGISTRARSE;
import static COMUN.clsConstantes.CMD_BTN_REGISTRARSE2;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class frmInicioRegistro extends JFrame implements ActionListener
{
	JPanel contentPane = new JPanel();
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JPasswordField contrausutxt;
	private JTextField nomusutxt;
	private JTextField corretxt;
	private JTextField apetxt;
	private JTextField nomtxt;


	public frmInicioRegistro()
	{
		setTitle("EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 100, 600, 431);
		setContentPane(VentanaInicial());
		//cargaProperties();
		this.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//salvaProperties();
			}
		});
	}

	/**
	 * Este es el content pane que se visualizará primero en la ventana que hemos creado. 
	 * Cuando escojamos alguna de las dos opciones que se nos dan, se borrará este panel
	 * y se visualizará otro.
	 * @return panel a visualizar.
	 */
	public JPanel VentanaInicial()
	{
		contentPane.removeAll();
		
//		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel EasyBooking = new JLabel("");
		//ImageIcon logo= new ImageIcon("src/imagenes/EasyBooking.png");
		//EasyBooking.setIcon(logo);
		EasyBooking.setBounds(140, 53, 537, 203);
		contentPane.add(EasyBooking);
		//ImageIcon im= new ImageIcon("src/imagenes/bombita.jpg");
	    //this.setIconImage(im.getImage());
	    Color azulFondo = new Color (0, 76, 109);
	    this.setBackground(azulFondo);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBounds(100, 267, 180, 23);
		btnIniciarSesion.setActionCommand(CMD_BTN_INICIAR_SESION);
		btnIniciarSesion.addActionListener(this);
		contentPane.add(btnIniciarSesion);
		
		
		btnRegistrarse= new JButton("Registrarse");
		btnRegistrarse.setBounds(319, 267, 180, 23);
		btnRegistrarse.setActionCommand(CMD_BTN_REGISTRARSE);
		btnRegistrarse.addActionListener(this);
		contentPane.add(btnRegistrarse);
		
		this.repaint();
		return contentPane;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) 
		{
		
		case CMD_BTN_ATRAS:
			//salvaProperties();
			setContentPane(VentanaInicial());
			//cargaProperties();
			contentPane.revalidate();
			break;
			
		case CMD_BTN_INICIAR_SESION :
			//salvaProperties();
			setContentPane(IniciarSesion());
			//cargaProperties();
			contentPane.revalidate();
			break;
			
		case CMD_BTN_REGISTRARSE:
	
			//salvaProperties();
			setContentPane(Registrarse());
			//cargaProperties();
			contentPane.revalidate();
			break;

		case CMD_BTN_INICIAR_SESION2:
		/*	try 
			{
				clsGestor.ComprobarUsuario(t1.getText(), t2.getText(), t3.getText());
				clsGestor.IniciarSesion(t1.getText(), t2.getText());
				this.setVisible(false);
				salvaProperties();
				frmMenuPrincipal frame = new frmMenuPrincipal();
				frame.setVisible(true);
				logger.log( Level.INFO, "Iniciando sesión.");
			} 
			catch (clsUsuarioNoRegistrado e1)
			{
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}				
			break;
		*/
			frmListaVuelos frVuelos = new frmListaVuelos();
			frVuelos.setVisible(true);
			this.setVisible(false);
			break;	
			
			
		case CMD_BTN_REGISTRARSE2:
			
		/*	@SuppressWarnings("deprecation")
			clsUsuario a = new clsUsuario(nomtxt.getText(), apetxt.getText(), corretxt.getText(), nomusutxt.getText(), contrausutxt.getText());
			try {
				clsBaseDeDatos.anyadirFilaATabla(clsBaseDeDatos.getStatement(), a);
				clsGestor.IniciarSesion(nomusutxt.getText(), corretxt.getText());
				logger.log( Level.INFO, "Registrando usuario.");
				this.setVisible(false);
				salvaProperties();
				frmMenuPrincipal frame = new frmMenuPrincipal();
				frame.setVisible(true);
				
			} catch (clsEmailNoValido e1) {
				
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (clsUsuarioRepetido e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
//			this.setVisible(false);
			salvaProperties();
			frmMenuPrincipal frame = new frmMenuPrincipal();
			frame.setVisible(true);
			break;
			}	
		*/
			frmListaVuelos frVuelos2 = new frmListaVuelos();
			frVuelos2.setVisible(true);
			this.setVisible(false);
			break;
		    default: break;	
		}
	}

	/**
	 * Este es el panel que se visualizará si escogemos la opción de inicio de sesión.
	 * Borra el panel inicial, y después de haber definido este panel con todos sus elementos,
	 * enseña el panel de inicio de sesión.
	 * @return panel de inicio de sesión.
	 */
	public JPanel IniciarSesion()
	{
		contentPane.removeAll();
	
		JLabel EasyBooking = new JLabel("");
		/*ImageIcon logo= new ImageIcon("src/imagenes/EasyBooking.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(180, 110,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);*/
		EasyBooking.setBounds(5, 5, 180, 150);
		contentPane.add(EasyBooking);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel i1 = new JLabel("Nombre de Usuario:");
		i1.setBounds(200, 60, 150,50);
		t1 = new JTextField(15);
		t1.setBounds(320, 75,150,20);
		
		JLabel i2 = new JLabel("Dirección de correo electrónico:");
		i2.setBounds(130, 130, 200, 50);
		t2 = new JTextField(15);
		t2.setBounds(320, 150,150,20);
		
		JLabel i3 = new JLabel("Contraseña:");
		i3.setBounds(240, 200,200,50);
		t3 = new JPasswordField(15);
		t3.setBounds(320, 220,150,20);
		
		contentPane.add(i1);
		contentPane.add(t1);
		contentPane.add(i2);
		contentPane.add(t2);
		contentPane.add(i3);
		contentPane.add(t3);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBounds(200, 280, 180, 25);
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setActionCommand(CMD_BTN_INICIAR_SESION2);
		contentPane.add(btnIniciarSesion);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(394, 359, 180, 23);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand(CMD_BTN_ATRAS);
		contentPane.add(btnAtras);
		
		this.repaint();
		return contentPane;
	}

	/**
	 * Este es el panel que se visualizará si escogemos la opción de registro.
	 * Borra el panel inicial, y después de haber definido este panel con todos sus elementos,
	 * enseña el panel de registro de usuarios.
	 * @return panel de registro de usuarios.
	 */
	public JPanel Registrarse()
	{
		contentPane.removeAll();
		
		JLabel EasyBooking = new JLabel("");
		/*ImageIcon logo= new ImageIcon("src/imagenes/EasyBooking.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(180, 110,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);*/
		EasyBooking.setBounds(5, 5, 180, 150);
		contentPane.add(EasyBooking);
		
		JLabel nombre = new JLabel("Nombre:");
		nombre.setBounds(215, 30, 80, 25);
		contentPane.add(nombre);
		
		nomtxt = new JTextField();
		nomtxt.setBounds(275, 30, 160, 25);
		contentPane.add(nomtxt);
		
		JLabel apellido = new JLabel("Apellidos:");
		apellido.setBounds(215, 90, 160, 25);
		contentPane.add(apellido);
		
		apetxt = new JTextField();
		apetxt.setBounds(275, 90, 160, 25);
		contentPane.add(apetxt);
		
		JLabel correo = new JLabel("Correo electrónico:");
		correo.setBounds(155, 150, 160, 25);
		contentPane.add(correo);
		
		corretxt = new JTextField();
		corretxt.setBounds(275, 150, 160, 25);
		contentPane.add(corretxt);
		
		JLabel nomusu = new JLabel("Nombre de usuario:");
		nomusu.setBounds(155, 210, 160, 25);
		contentPane.add(nomusu);
		
		nomusutxt = new JTextField();
		nomusutxt.setBounds(275, 210, 160, 25);
		contentPane.add(nomusutxt);
		
		JLabel contrausu = new JLabel("Contraseña:");
		contrausu.setBounds(195, 270, 160, 25);
		contentPane.add(contrausu);
		
		contrausutxt = new JPasswordField();
		contrausutxt.setBounds(275, 270, 160, 25);
		contentPane.add(contrausutxt);
		
		JButton btnMeterUsuarios = new JButton("Registrarse");
		btnMeterUsuarios.setBounds(205, 320, 180, 25);
		btnMeterUsuarios.setActionCommand(CMD_BTN_REGISTRARSE2);
		btnMeterUsuarios.addActionListener(this);
		contentPane.add(btnMeterUsuarios);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(394, 359, 180, 23);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand(CMD_BTN_ATRAS);
		contentPane.add(btnAtras); 
		
		this.repaint();
		return contentPane;
	}

}
