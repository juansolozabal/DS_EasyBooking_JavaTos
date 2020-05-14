package src.client.gui;


import java.awt.Button;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.client.controller.EBController;

public class frmLogotipoInicial extends JFrame
{
	private JPanel contentPane;
	private File imagen;
	private EBController controller;

	
	public frmLogotipoInicial(EBController controller)
	{
		this.controller = controller;
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
		button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonEntrar(evt);
			}
		});
	}

	private void buttonEntrar(ActionEvent evt)
	{
		frmListaVuelos lista = new frmListaVuelos(controller);
		lista.setVisible(true);
		this.setVisible(false);
	}
}
