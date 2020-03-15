package LP;

import static COMUN.clsConstantes.CMD_BTN_ATRAS;
import static COMUN.clsConstantes.CMD_BTN_PAGAR;
import static COMUN.clsConstantes.CMD_BTN_PAYPAL;
import static COMUN.clsConstantes.CMD_BTN_VISA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import java.awt.Font;

public class frmPago extends JFrame implements ActionListener {

	JPanel contentPane = new JPanel();
	ImageIcon VisaImagen;
	ImageIcon VisaIcono;
	ImageIcon PayPalImagen;
	ImageIcon PayPalIcono;
	private File imagen;
	
	public frmPago()
	{
		setTitle("Pasarela de pago");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imagen = new File("src\\main\\resources\\img\\Logo EasyBooking_Azul.png");
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
		ImageIcon logo= new ImageIcon("src\\main\\resources\\img\\Logo EasyBooking_Azul.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(342, 140,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg);
		setBounds(0, 100, 600, 431);
		
		VisaImagen = new ImageIcon("src\\main\\resources\\img\\VISA.png");
		
		JButton btnPayPal = new JButton("PayPal");
		btnPayPal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnPayPal.setBounds(203, 227, 168, 103);
		
		PayPalImagen = new ImageIcon("src\\main\\resources\\img\\PayPal.png");
		PayPalIcono = new ImageIcon(PayPalImagen.getImage().getScaledInstance(btnPayPal.getWidth(), btnPayPal.getHeight(), Image.SCALE_DEFAULT));
		btnPayPal.setIcon(PayPalIcono);
		btnPayPal.setActionCommand(CMD_BTN_PAYPAL);
		btnPayPal.addActionListener(this);
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
		btnVISA.setActionCommand(CMD_BTN_VISA);
		btnVISA.addActionListener(this);
		contentPane.add(btnVISA);
		
		JLabel lblSeleccioneMtodoDe = new JLabel("Seleccione m\u00E9todo de pago");
		lblSeleccioneMtodoDe.setForeground(Color.WHITE);
		lblSeleccioneMtodoDe.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSeleccioneMtodoDe.setBounds(152, 29, 324, 35);
		contentPane.add(lblSeleccioneMtodoDe);
		this.repaint();
		return contentPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) 
		{
		
		case CMD_BTN_ATRAS:
			//salvaProperties();
			setContentPane(VentanaInicial());
			//cargaProperties();
			contentPane.revalidate();
			break;
			
		case CMD_BTN_PAYPAL :
			//salvaProperties();
			setContentPane(PayPal());
			//cargaProperties();
			contentPane.revalidate();
			break;
			
		case CMD_BTN_VISA:
	
			//salvaProperties();
			setContentPane(Visa());
			//cargaProperties();
			contentPane.revalidate();
			break;
		}
		
	}
	
	public JPanel PayPal()
	{
		contentPane.removeAll();
	
		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("src\\main\\resources\\img\\PayPal.png");
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
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand(CMD_BTN_ATRAS);
		contentPane.add(btnAtras);
		
		JLabel email = new JLabel("Email:");
		email.setForeground(Color.white);
		email.setBounds(285, 90, 160, 25);
		contentPane.add(email);
		
		JTextField emailtxt = new JTextField();
		emailtxt.setBounds(375, 90, 160, 25);
		contentPane.add(emailtxt);		
		
		
		JLabel con = new JLabel("Contraseña:");
		con.setForeground(Color.white);
		con.setBounds(270, 130, 160, 25);
		contentPane.add(con);
		
		JPasswordField contxt = new JPasswordField();
		contxt.setBounds(375, 130, 160, 25);
		contentPane.add(contxt);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(420, 160, 70, 45);
		contentPane.add(btnPagar);
		
		this.repaint();
		return contentPane;
	}

	/**
	 * Este es el panel que se visualizará si escogemos la opción de registro.
	 * Borra el panel inicial, y después de haber definido este panel con todos sus elementos,
	 * enseña el panel de registro de usuarios.
	 * @return panel de registro de usuarios.
	 */
	public JPanel Visa()
	{
		contentPane.removeAll();
		
		setBounds(0, 100, 600, 331);
		
		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("src\\main\\resources\\img\\VISA.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(196, 80,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);
		EasyBooking.setBounds(5, 5, 180, 150);
		contentPane.add(EasyBooking);
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.setBounds(25, 250, 180, 23);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand(CMD_BTN_ATRAS);
		contentPane.add(btnAtras);
		
		JLabel titular = new JLabel("Nombre titular tarjeta:");
		titular.setForeground(Color.white);
		titular.setBounds(215, 45, 140, 25);
		contentPane.add(titular);
		
		JTextField titulartxt = new JTextField();
		titulartxt.setBounds(375, 45, 160, 25);
		contentPane.add(titulartxt);
		
		JLabel n_tarjeta = new JLabel("Nº tarjeta:");
		n_tarjeta.setForeground(Color.white);
		n_tarjeta.setBounds(285, 90, 160, 25);
		contentPane.add(n_tarjeta);
		
		JTextField n_tarjetatxt = new JTextField();
		n_tarjetatxt.setBounds(375, 90, 160, 25);
		contentPane.add(n_tarjetatxt);
		
		JLabel vencimiento = new JLabel("Vencimiento tarjeta:");
		vencimiento.setForeground(Color.white);
		vencimiento.setBounds(225, 135, 160, 25);
		contentPane.add(vencimiento);
		
//		JTextField vencitxt = new JTextField();
//		vencitxt.setBounds(375, 135, 160, 25);
//		contentPane.add(vencitxt);
		
		JDateChooser calendarIda = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		calendarIda.setBounds(375, 135, 160, 25);
		contentPane.add(calendarIda);		
		
		JLabel cvc = new JLabel("Código CVC:");
		cvc.setForeground(Color.white);
		cvc.setBounds(270, 180, 160, 25);
		contentPane.add(cvc);
		
		JPasswordField cvctxt = new JPasswordField();
		cvctxt.setBounds(375, 180, 160, 25);
		contentPane.add(cvctxt);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(420, 220, 70, 45);
		contentPane.add(btnPagar);
		
		this.repaint();
		return contentPane;
	}
}