package src.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import src.client.controller.EBController;

import java.awt.Font;

public class frmPago extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane = new JPanel();
	ImageIcon VisaImagen;
	ImageIcon VisaIcono;
	ImageIcon PayPalImagen;
	ImageIcon PayPalIcono;
	private File imagen;
	
	private JDateChooser fechaHoy;
	private Calendar actual;
	private EBController controller;
	
	private JTextField titulartxt;
	private JTextField n_tarjetatxt;
	JDateChooser vencimientoDate;
	private JPasswordField cvctxt;
	
	private JTextField emailtxt;
	private JPasswordField contxt;

	public frmPago(EBController controller, float cantidad)
	{
		this.controller = controller;
		fechaHoy = new JDateChooser();
		actual=new GregorianCalendar();
		fechaHoy.setCalendar(actual);
		setTitle("Pasarela de pago");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imagen = new File("..\\..\\resources\\img\\Logo EasyBooking_Azul.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagen.getAbsolutePath()));
		setResizable(false);
		setBounds(0, 100, 600, 431);
		setContentPane(VentanaInicial());
		
		//cargaProperties();
		this.addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
	}
	
	public JPanel VentanaInicial()
	{
		contentPane.removeAll();
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
	    Color azulFondo = new Color (0, 76, 109);
	    contentPane.setBackground(azulFondo);
		ImageIcon logo= new ImageIcon("..\\..\\resources\\img\\Logo EasyBooking_Azul.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(342, 140,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg);
		setBounds(0, 100, 600, 431);
		
		VisaImagen = new ImageIcon("..\\..\\resources\\img\\VISA.png");
		
		JButton btnPayPal = new JButton("PayPal");
		btnPayPal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPayPal.setBounds(203, 227, 168, 103);
		
		PayPalImagen = new ImageIcon("..\\..\\resources\\img\\PayPal.png");
		PayPalIcono = new ImageIcon(PayPalImagen.getImage().getScaledInstance(btnPayPal.getWidth(), btnPayPal.getHeight(), Image.SCALE_DEFAULT));
		btnPayPal.setIcon(PayPalIcono);
		btnPayPal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonPayPal(evt);
			}
		});
		contentPane.add(btnPayPal);
		
		
		JButton btnVISA = new JButton("VISA");
		btnVISA.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVISA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVISA.setBounds(203, 90, 168, 103);
		VisaIcono = new ImageIcon(VisaImagen.getImage().getScaledInstance(btnVISA.getWidth(), btnVISA.getHeight(), Image.SCALE_DEFAULT));
		btnVISA.setIcon(VisaIcono);
		btnVISA.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonVisa(evt);
			}
		});
		contentPane.add(btnVISA);
		
		JLabel lblSeleccioneMtodoDe = new JLabel("Seleccione m\u00E9todo de pago");
		lblSeleccioneMtodoDe.setForeground(Color.WHITE);
		lblSeleccioneMtodoDe.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSeleccioneMtodoDe.setBounds(152, 29, 324, 35);
		contentPane.add(lblSeleccioneMtodoDe);
		this.repaint();
		return contentPane;
	}
	
	public JPanel PayPal()
	{
		contentPane.removeAll();
	
		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("..\\..\\resources\\img\\PayPal.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(196, 80,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);
		EasyBooking.setBounds(5, 5, 180, 150);
		contentPane.add(EasyBooking);
		setBounds(0, 100, 600, 331);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(25, 250, 180, 23);
		btnAtras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonAtras(evt);
			}
		});
		contentPane.add(btnAtras);
		
		JLabel email = new JLabel("Email:");
		email.setForeground(Color.white);
		email.setBounds(285, 90, 160, 25);
		contentPane.add(email);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(375, 90, 160, 25);
		contentPane.add(emailtxt);		
		
		
		JLabel con = new JLabel("Contrasena:");
		con.setForeground(Color.white);
		con.setBounds(270, 130, 160, 25);
		contentPane.add(con);
		
		contxt = new JPasswordField();
		contxt.setBounds(375, 130, 160, 25);
		contentPane.add(contxt);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(420, 160, 97, 25);
		btnPagar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonPagarPayPal(evt);
			}
		});
		contentPane.add(btnPagar);
		
		this.repaint();
		return contentPane;
	}

	/**
	 * Este es el panel que se visualizara si escogemos la opcion de registro.
	 * Borra el panel inicial, y despues de haber definido este panel con todos sus elementos,
	 * ensenya el panel de registro de usuarios.
	 * @return panel de registro de usuarios.
	 */
	public JPanel Visa()
	{
		contentPane.removeAll();
		
		setBounds(0, 100, 600, 331);
		
		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("..\\..\\resources\\img\\VISA.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(196, 80,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);
		EasyBooking.setBounds(5, 5, 180, 150);
		contentPane.add(EasyBooking);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(25, 250, 180, 23);
		btnAtras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonAtras(evt);
			}
		});
		contentPane.add(btnAtras);
		
		JLabel titular = new JLabel("Nombre titular tarjeta:");
		titular.setForeground(Color.white);
		titular.setBounds(215, 45, 140, 25);
		contentPane.add(titular);
		
		titulartxt = new JTextField();
		titulartxt.setBounds(375, 45, 160, 25);
		contentPane.add(titulartxt);
		
		JLabel n_tarjeta = new JLabel("Num. tarjeta:");
		n_tarjeta.setForeground(Color.white);
		n_tarjeta.setBounds(285, 90, 160, 25);
		contentPane.add(n_tarjeta);
		
		n_tarjetatxt = new JTextField();
		n_tarjetatxt.setBounds(375, 90, 160, 25);
		contentPane.add(n_tarjetatxt);
		
		JLabel vencimiento = new JLabel("Vencimiento tarjeta:");
		vencimiento.setForeground(Color.white);
		vencimiento.setBounds(225, 135, 160, 25);
		contentPane.add(vencimiento);
		
//		JTextField vencitxt = new JTextField();
//		vencitxt.setBounds(375, 135, 160, 25);
//		contentPane.add(vencitxt);
		
		vencimientoDate = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		vencimientoDate.setBounds(375, 135, 160, 25);
		contentPane.add(vencimientoDate);		
		
		JLabel cvc = new JLabel("Codigo CVC:");
		cvc.setForeground(Color.white);
		cvc.setBounds(270, 180, 160, 25);
		contentPane.add(cvc);
		
		cvctxt = new JPasswordField();
		cvctxt.setBounds(375, 180, 160, 25);
		contentPane.add(cvctxt);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(420, 220, 97, 25);
		btnPagar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonPagarVisa(evt);
			}
		});
		contentPane.add(btnPagar);
		
		this.repaint();
		return contentPane;
	}

	
	private void buttonAtras(ActionEvent evt)
	{
		//salvaProperties();
		setContentPane(VentanaInicial());
		//cargaProperties();
		contentPane.revalidate();
	}
	
	private void buttonPayPal(ActionEvent evt)
	{
		//salvaProperties();
		setContentPane(PayPal());
		//cargaProperties();
		contentPane.revalidate();
	}
	
	private void buttonVisa(ActionEvent evt)
	{
		//salvaProperties();
		setContentPane(Visa());
		//cargaProperties();
		contentPane.revalidate();
	}
	
	private void buttonPagarVisa(ActionEvent evt)
	{
		try{
			vencimientoDate.getDate();
			if (fechaHoy.getDate().compareTo(vencimientoDate.getDate())>0)JOptionPane.showMessageDialog(null, "Lo sentimos, su tarjeta esta caducada.");
//			controller.pagarVisa(titulartxt.getText(), Integer.parseInt(n_tarjetatxt.getText()), vencimientoDate.getDate(), Integer.parseInt(cvctxt.getText()));
		} 
		catch(NullPointerException e1)
		{
			JOptionPane.showMessageDialog(null, "Introduzca una fecha.");
		}
	    //TODO Hacer el resto de comprobaciones

	}
	
	private void buttonPagarPayPal(ActionEvent evt)
	{
		try{
			vencimientoDate.getDate();
			if (fechaHoy.getDate().compareTo(vencimientoDate.getDate())>0)JOptionPane.showMessageDialog(null, "Lo sentimos, su tarjeta esta caducada.");
//			controller.pagarPayPal(emailtxt.getText().toString(), contxt.getText().toString());
		} 
		catch(NullPointerException e1)
		{
			JOptionPane.showMessageDialog(null, "Introduzca una fecha.");
		}
	    //TODO Hacer el resto de comprobaciones
	}
	
	
}