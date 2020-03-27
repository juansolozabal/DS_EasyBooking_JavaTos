package LP;

import static COMUN.clsConstantes.CMD_BTN_ENTRAR;
import static COMUN.clsConstantes.CMD_BTN_IR_INICIO_REGISTRO;

import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class frmLogotipoInicial extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private File imagen;
	
	public frmLogotipoInicial()
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspace\\DS_EasyBooking_JavaTos\\src\\main\\resources\\img\\Logo EasyBooking_Azul.png"));
		setTitle("Bienvenid@ a EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 100, 600, 431);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color azulFondo = new Color (0, 76, 109);
		contentPane.setBackground(azulFondo);
		
		JLabel EasyBooking = new JLabel("");
		ImageIcon logo= new ImageIcon("src\\main\\resources\\img\\Logo EasyBooking_Azul.png");
		Image image = logo.getImage(); 
		Image newimg = image.getScaledInstance(342, 140,  java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(newimg); 
		EasyBooking.setIcon(logo);
		EasyBooking.setBounds(140, 53, 537, 203);
		contentPane.add(EasyBooking);
		
		Button button = new Button("Entrar");
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(257, 262, 92, 30);
		contentPane.add(button);
		button.setActionCommand(CMD_BTN_ENTRAR);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		switch(e.getActionCommand())
//		{
//			case CMD_BTN_ENTRAR:
//				frmListaVuelos lista = new frmListaVuelos();
//				lista.setVisible(true);
//				this.setVisible(false);
//				break;
//			default: break;	
//		}	
		
	}
}
