package src.client.gui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	public frmPasajeros (EBController controller, int numPasajeros)
	{
		this.controller = controller;
	    Color azulFondo = new Color (0, 76, 109);
	    Color azulClaro = new Color (184, 205, 218);
		imagen = new File("src\\main\\resources\\img\\Logo EasyBooking_Azul.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagen.getAbsolutePath()));
		setResizable(false);
		setTitle("Datos de Pasajeros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 577);
		
		contentPane = new JPanel();
	    contentPane.setBackground(azulFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		int offset = 0;
		int j = 1;
		
		JButton sig = new JButton("Siguiente ");
		sig.setBounds(260, numPasajeros*161, 150, 25);
		sig.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt1) {
				buttonSiguiente(evt1);
			}
		});
		
		
		JButton btnNewButton = new JButton("Pasar a pagar");
		btnNewButton.setBounds(260, numPasajeros*161, 150, 25);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt2) {
				buttonPagar(evt2);
			}
		});
		
		do {
			do{
				if(j<numPasajeros){
					contentPane.add(sig);
				}else{
					contentPane.remove(sig);
					contentPane.add(btnNewButton);
				}
				
				JLabel lblDatosDelPasajero = new JLabel("Datos del Pasajero " + j);
				lblDatosDelPasajero.setForeground(Color.white);
				lblDatosDelPasajero.setBounds(12, 13+offset, 152, 27);
				getContentPane().add(lblDatosDelPasajero);
						
				JLabel lblNewLabel = new JLabel("Nombre");
				lblNewLabel.setForeground(Color.white);
				lblNewLabel.setBounds(56, 53+offset, 92, 21);
				getContentPane().add(lblNewLabel);
						
				JLabel lblApellido = new JLabel("Apellidos");
				lblApellido.setForeground(Color.white);
				lblApellido.setBounds(56, 87+offset, 92, 21);
				getContentPane().add(lblApellido);
						
				JLabel lblDni = new JLabel("DNI");
				lblDni.setForeground(Color.white);
				lblDni.setBounds(56, 124+offset, 92, 21);
				getContentPane().add(lblDni);
						
				textField = new JTextField();
				textField.setBounds(160, 52+offset, 116, 22);
				textField.setBackground(azulClaro);
				getContentPane().add(textField);
				textField.setColumns(10);
						
				textField_1 = new JTextField();
				textField_1.setBounds(160, 86+offset, 116, 22);
				textField_1.setBackground(azulClaro);
				getContentPane().add(textField_1);
				textField_1.setColumns(10);
						
				textField_2 = new JTextField();
				textField_2.setBounds(160, 121+offset, 116, 22);
				textField_2.setBackground(azulClaro);
				getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				offset+=150;
				
			}while(reservado);
			j++;
			contentPane.remove(textField);
			contentPane.remove(textField_1);
			contentPane.remove(textField_2);
			reservado=false;
		} while (j!=numPasajeros);
		
	}
	
	private void buttonSiguiente(ActionEvent evt1)
	{
		controller.introducirPersonaReserva(Integer.parseInt(textField_2.getText()), textField.getText(), textField_1.getText());
		reservado=true;
	}
	
	private void buttonPagar(ActionEvent evt2)
	{
		//salvaProperties();
		// TODO hay que pensar como hacer esto. Hay que recoger esto de arriba, quizas
		//haya que crear una lista auxiliar en la que se guardan los datos de los 
		//pasajeros. Otra forma mas sencilla es meter los pasajeros de uno en uno
		// darle aceptar y que se vacien los campos y se llame a introducirPersonaReserva
		//controller.introducirPersonasReserva(dni, nombre, apellidos);
		reservado=true;
		frmPago pago = new frmPago(controller);
		pago.setVisible(true);
	}
		
}
