package LP;

import static COMUN.clsConstantes.CMD_BTN_PAGAR;
import static COMUN.clsConstantes.CMD_BTN_REGISTRARSE;

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

public class frmPasajeros extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JCalendar calendarVuelta;
	private File imagen;
	
	public frmPasajeros (int numPasajeros)
	{
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
		JTextField textField, textField_1, textField_2;
		int j = 1;
		for (int i = 0; i < numPasajeros; i++)
		{
			
			// Vamos a hacer la prueba con 3 pasajeros.
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
			j++;
		}
		JButton btnNewButton = new JButton("Pasar a pagar");
		btnNewButton.setBounds(260, numPasajeros*161, 150, 25);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand(CMD_BTN_PAGAR);
		contentPane.add(btnNewButton);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) 
		{
		
		case CMD_BTN_PAGAR:
			//salvaProperties();
			frmPago pago = new frmPago();
			pago.setVisible(true);
			break;
		}
		
	}

	
}
