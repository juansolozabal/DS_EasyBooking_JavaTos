package src.client.gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;

import src.client.controller.*;
import src.server.dto.Persona;

public class frmPasajeros extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCalendar calendarVuelta;
	private File imagen;
	private EBController controller;
	private boolean reservado;
	JTextField textField, textField_1, textField_2;
	private static int j=1;
	private static int numeroPasajeros=0;
	Color azulFondo, azulClaro;
	JButton sig, btnNewButton;
	ArrayList<Persona>pasajeros=new ArrayList<>();
	private float cantidadAPagar;
	private String email, concepto, codVueloReserva;
	
	public frmPasajeros (EBController controller, int numPasajeros, float cantidadAPagar, String correo, String codVueloReserva)
	{
		this.controller = controller;
		this.cantidadAPagar = cantidadAPagar;
		this.email = correo;
		this.codVueloReserva = codVueloReserva;
		numeroPasajeros=numPasajeros;
		concepto = new String();
		VentanaInicial();				
	}
	
	private void VentanaInicial()
	{
		azulFondo = new Color (0, 76, 109);
	    azulClaro = new Color (184, 205, 218);
		imagen = new File("..\\..\\resources\\img\\Logo EasyBooking_Azul.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagen.getAbsolutePath()));
		setResizable(false);
		setTitle("Datos de Pasajeros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 237);
		
		contentPane = new JPanel();
	    contentPane.setBackground(azulFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sig = new JButton("Siguiente ");
		sig.setBounds(140, 160, 120, 25);
		sig.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt1) {
				buttonSiguiente(evt1);
			}
		});
		
		
		btnNewButton = new JButton("Pasar a pagar");
		btnNewButton.setBounds(280, 160, 120, 25);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt2) {
				buttonPagar(evt2);
			}
		});
		contentPane.add(sig);
		contentPane.add(btnNewButton);	
		
		JLabel lblDatosDelPasajero = new JLabel("Datos del pasajero " + j+ " de " + numeroPasajeros);
		lblDatosDelPasajero.setForeground(Color.white);
		lblDatosDelPasajero.setBounds(12, 13, 152, 27);
		getContentPane().add(lblDatosDelPasajero);
				
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(56, 53, 92, 21);
		getContentPane().add(lblNewLabel);
				
		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setForeground(Color.white);
		lblApellido.setBounds(56, 87, 92, 21);
		getContentPane().add(lblApellido);
				
		JLabel lblDni = new JLabel("DNI");
		lblDni.setForeground(Color.white);
		lblDni.setBounds(56, 124, 92, 21);
		getContentPane().add(lblDni);
				
		textField = new JTextField();
		textField.setBounds(160, 52, 236, 22);
		textField.setBackground(azulClaro);
		getContentPane().add(textField);
		textField.setColumns(10);
				
		textField_1 = new JTextField();
		textField_1.setBounds(160, 86, 236, 22);
		textField_1.setBackground(azulClaro);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
				
		textField_2 = new JTextField();
		textField_2.setBounds(160, 121, 236, 22);
		textField_2.setBackground(azulClaro);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);	

		System.out.println("Pasajero "+j+" de "+ numeroPasajeros );
		if(j<numeroPasajeros)
		{
			System.out.println(j);
			sig.setEnabled(true);
			btnNewButton.setEnabled(false);
		}else{
			sig.setEnabled(false);
			btnNewButton.setEnabled(true);
		}
	}
	
	private void buttonSiguiente(ActionEvent evt1)
	{
		try{
		Persona pasajero = new Persona(Integer.parseInt(textField_2.getText()), textField.getText(), textField_1.getText());
		pasajeros.add(pasajero);
		
		contentPane.removeAll();

		j++;
		VentanaInicial();
		contentPane.revalidate();
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(contentPane, "Introduzca los datos correctamente.","Atencion", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void buttonPagar(ActionEvent evt2)
	{
		try{
			//salvaProperties();
			// TODO hay que pensar como hacer esto. Hay que recoger esto de arriba, quizas
			//haya que crear una lista auxiliar en la que se guardan los datos de los 
			//pasajeros. Otra forma mas sencilla es meter los pasajeros de uno en uno
			// darle aceptar y que se vacien los campos y se llame a introducirPersonaReserva
//			frmPago pago = new frmPago(controller, cantidadAPagar);
			concepto = concepto();
			controller.pagarPayPal(email, cantidadAPagar, concepto, codVueloReserva, pasajeros);
//			pago.setVisible(true);
			this.setVisible(false);
		} catch(Exception e)
		{
			JOptionPane.showMessageDialog(contentPane, "Introduzca los datos correctamente.","Atencion", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private String concepto() {
		
		int conYesNo = JOptionPane.showConfirmDialog(contentPane, "¿Desea introducir concepto al pago que se va a efectuar?");
		if (conYesNo==0) return JOptionPane.showInputDialog(contentPane, "Introduzca el concepto: ");
		else{return "";}
		
	}
		
}
