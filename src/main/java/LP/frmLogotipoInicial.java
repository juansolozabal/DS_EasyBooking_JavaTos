package LP;

import static COMUN.clsConstantes.CMD_BTN_ENTRAR;
import static COMUN.clsConstantes.CMD_BTN_IR_INICIO_REGISTRO;

import java.awt.Button;
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
		imagen = new File("src\\main\\resources\\img\\Logo EasyBooking_Azul.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagen.getAbsolutePath()));
		setTitle("Bienvenid@ a EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Entrar");
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(454, 367, 79, 24);
		contentPane.add(button);
		button.setActionCommand(CMD_BTN_ENTRAR);
		button.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(imagen.getAbsolutePath()));
		lblNewLabel.setBounds(0, 0, 1039, 427);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
			case CMD_BTN_ENTRAR:
				frmListaVuelos lista = new frmListaVuelos();
				lista.setVisible(true);
				this.setVisible(false);
				break;
			default: break;	
		}	
		
	}
}
