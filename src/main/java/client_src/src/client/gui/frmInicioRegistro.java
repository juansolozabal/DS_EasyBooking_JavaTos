package src.client.gui;


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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import src.client.controller.EBController;


public class frmInicioRegistro extends JFrame
{
	private EBController controller;
	JPanel contentPane = new JPanel();
	private JButton btnIniciarSesion;
	private JButton btnRegistrarse;
	private JTextField t2, t3;
	private JPasswordField contrausutxt;
	private JTextField nomusutxt;
	private JTextField corretxt;
	private JTextField apetxt;
	private JTextField nomtxt;
	private JTextField dnitxt;
	private JLabel nombre, apellido, correo, dni;
	private static boolean loginResult;
	private static String correoSesion;


	public frmInicioRegistro(EBController controller)
	{
		this.controller = controller;
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

	/*
	 * Este es el content pane que se visualizara primero en la ventana que hemos creado. 
	 * Cuando escojamos alguna de las dos opciones que se nos dan, se borrara este panel
	 * y se visualizara otro.
	 * @return panel a visualizar.
	 */
	public JPanel VentanaInicial()
	{
		contentPane.removeAll();
//		setLocationRelativeTo(null);
		contentPane.setLayout(null);
	    Color azulFondo = new Color (0, 76, 109);
	    contentPane.setBackground(azulFondo);

		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("..\\..\\resources\\img\\Logo EasyBooking_Azul.png");
		Image image = logo.getImage();
		Image newimg = image.getScaledInstance(342, 140,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);
		EasyBooking.setBounds(140, 53, 537, 203);
		contentPane.add(EasyBooking);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(100, 267, 180, 23);
		btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonIniciarSesion(evt);
			}
		});
		contentPane.add(btnIniciarSesion);
		
		
		btnRegistrarse= new JButton("Registrarse");
		btnRegistrarse.setBounds(319, 267, 180, 23);
		btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonRegistrarse(evt);
			}
		});
		contentPane.add(btnRegistrarse);
		
		this.repaint();
		return contentPane;
	}
	

	/**
	 * Este es el panel que se visualizara si escogemos la opcion de inicio de sesion.
	 * Borra el panel inicial, y despues de haber definido este panel con todos sus elementos,
	 * ensenya el panel de inicio de sesion.
	 * @return panel de inicio de sesion.
	 */
	public JPanel IniciarSesion()
	{
		contentPane.removeAll();
	
		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("..\\..\\resources\\img\\Logo EasyBooking_Azul.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(196, 80,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);
		EasyBooking.setBounds(5, 5, 180, 150);
		contentPane.add(EasyBooking);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel i2 = new JLabel("Direccion de correo electronico:");
		i2.setForeground(Color.white);
		i2.setBounds(130, 130, 200, 50);
		t2 = new JTextField(15);
		t2.setBounds(320, 150,150,20);
		
		JLabel i3 = new JLabel("Contrasenya:");
		i3.setForeground(Color.white);
		i3.setBounds(240, 200,200,50);
		t3 = new JPasswordField(15);
		t3.setBounds(320, 220,150,20);
		
		contentPane.add(i2);
		contentPane.add(t2);
		contentPane.add(i3);
		contentPane.add(t3);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(200, 280, 180, 25);
		btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonIniciarSesion2(evt);
			}
		});
		contentPane.add(btnIniciarSesion);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(394, 359, 180, 23);
		btnAtras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonAtras(evt);
			}
		});
		contentPane.add(btnAtras);
		
		this.repaint();
		return contentPane;
	}

	/**
	 * Este es el panel que se visualizara si escogemos la opcion de registro.
	 * Borra el panel inicial, y despues de haber definido este panel con todos sus elementos,
	 * ensenya el panel de registro de usuarios.
	 * @return panel de registro de usuarios.
	 */
	public JPanel Registrarse()
	{
		contentPane.removeAll();
		
		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("..\\..\\resources\\img\\Logo EasyBooking_Azul.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(196, 80,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);
		EasyBooking.setBounds(5, 5, 180, 150);
		contentPane.add(EasyBooking);
		
		nombre = new JLabel("Nombre:");
		nombre.setForeground(Color.white);
		nombre.setBounds(215, 30, 80, 25);
		contentPane.add(nombre);
		
		nomtxt = new JTextField();
		nomtxt.setBounds(275, 30, 160, 25);
		contentPane.add(nomtxt);
		
		apellido = new JLabel("Apellidos:");
		apellido.setForeground(Color.white);
		apellido.setBounds(215, 90, 160, 25);
		contentPane.add(apellido);
		
		apetxt = new JTextField();
		apetxt.setBounds(275, 90, 160, 25);
		contentPane.add(apetxt);
		
		correo = new JLabel("Correo electronico:");
		correo.setForeground(Color.white);
		correo.setBounds(155, 150, 160, 25);
		contentPane.add(correo);
		
		corretxt = new JTextField();
		corretxt.setBounds(275, 150, 160, 25);
		contentPane.add(corretxt);
		
		JButton btnMeterUsuarios = new JButton("Registrarse");
		btnMeterUsuarios.setBounds(205, 320, 180, 25);
		btnMeterUsuarios.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonRegistrarse2(evt);
			}
		});
		contentPane.add(btnMeterUsuarios);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(394, 359, 180, 23);
		btnAtras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonAtras(evt);
			}
		});
		contentPane.add(btnAtras); 
		
		this.repaint();
		return contentPane;
	}
	
	private void buttonIniciarSesion(ActionEvent evt)
	{
		//salvaProperties();
		setContentPane(IniciarSesion());
		//cargaProperties();
		contentPane.revalidate();
	}

	private void buttonIniciarSesion2(ActionEvent evt)
	{
		this.setVisible(false);
		loginResult = controller.iniciarSesion(t2.getText().toString(), t3.getText().toString());
		if (loginResult==true)
			{
				//aqui un controller para decirle al dao quien ha iniciado sesion
				JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso!");
				frmPasajeros datosPasajeros = new frmPasajeros(controller, frmListaVuelos.getNumPasajeros());
				datosPasajeros.setVisible(true);
			}
		else JOptionPane.showMessageDialog(null, "Inicio de sesion fallido.");

	}
	
	private void buttonRegistrarse(ActionEvent evt)
	{
		//salvaProperties();
		setContentPane(Registrarse());
		//cargaProperties();
		contentPane.revalidate();
	}
	
	private void buttonRegistrarse2(ActionEvent evt)
	{
		this.setVisible(false);
		loginResult = controller.registrarse(nomtxt.getText(), apetxt.getText(), corretxt.getText());
		if (loginResult==true)
		{
			correoSesion=corretxt.getText();
			JOptionPane.showMessageDialog(contentPane, "Registro exitoso!");
			frmPasajeros datosPasajeros = new frmPasajeros(controller, frmListaVuelos.getNumPasajeros());
			datosPasajeros.setVisible(true);
			correoSesion="";
		}
	else JOptionPane.showMessageDialog(contentPane, "Registro fallido.");
	}
	
	private void buttonAtras(ActionEvent evt)
	{
		//salvaProperties();
		setContentPane(VentanaInicial());
		//cargaProperties();
		contentPane.revalidate();
	}

	public static boolean getLoginResult() {
		return loginResult;
	}
	public static String getCorreoSesion() {
		return correoSesion;
	}
}
