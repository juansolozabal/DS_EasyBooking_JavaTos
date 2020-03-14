package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import static COMUN.clsConstantes.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class frmListaVuelos extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JCalendar calendarVuelta;
	
	public frmListaVuelos() 
	{
		setTitle("Lista de Vuelos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 452);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu inicio = new JMenu("Inicio");
		inicio.setMnemonic(KeyEvent.VK_I); 
		menuBar.add(inicio);
		
		JMenu cuenta = new JMenu("Cuenta");
		cuenta.setMnemonic(KeyEvent.VK_C); 
		menuBar.add(cuenta);
			
		JMenuItem iniciosesion = new JMenuItem("Inicio sesi�n");
		cuenta.add(iniciosesion);
		iniciosesion.setActionCommand(CMD_BTN_IR_INICIO_REGISTRO);
		iniciosesion.addActionListener(this);
		
		JMenuItem registro = new JMenuItem("Registro");
		cuenta.add(registro);
		
		JMenu salir = new JMenu("Salir");
		salir.setMnemonic(KeyEvent.VK_S); 
		menuBar.add(salir);
		
		ButtonGroup idaOidavuelta = new ButtonGroup(); //Para que solo se pueda seleccionar ida o ida y vuelta
		
		JRadioButton btnIdaYVuelta = new JRadioButton("Ida y vuelta");
		btnIdaYVuelta.setBounds(12, 13, 99, 25);
		contentPane.add(btnIdaYVuelta);
		btnIdaYVuelta.setSelected(true);
		idaOidavuelta.add(btnIdaYVuelta);
		
		JRadioButton btnIda = new JRadioButton("Solo ida");
		btnIda.setBounds(123, 13, 97, 25);
		contentPane.add(btnIda);
		idaOidavuelta.add(btnIda);
		
		JComboBox origen = new JComboBox();
		origen.setBounds(12, 51, 99, 22);
		contentPane.add(origen);
		
		JComboBox destino = new JComboBox();
		destino.setBounds(123, 51, 99, 22);
		contentPane.add(destino);
		
		JDateChooser calendarIda = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		calendarIda.setBounds(12, 89, 100, 25);
		contentPane.add(calendarIda);
		//dateChooser.getDate(); para obtener la fecha de la caja
		
		JDateChooser calendarVuelta = new JDateChooser(null, null, null, new JSpinnerDateEditor()); 
		calendarVuelta.setBounds(123, 89, 100, 25);
		contentPane.add(calendarVuelta);
		//dateChooser.getDate(); para obtener la fecha de la caja
		if (btnIda.isSelected()) calendarVuelta.setVisible(false);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(340, 14, 36, 22);
		contentPane.add(spinner);
		if ((Integer)spinner.getValue()>10) JOptionPane.showMessageDialog(null, "Lo sentimos, no puede adquirir m�s de 10 billetes.");
		
		JLabel lblNmeroDeBilletes = new JLabel("N\u00FAmero de billetes:");
		lblNmeroDeBilletes.setBounds(224, 17, 129, 16);
		contentPane.add(lblNmeroDeBilletes);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(234, 50, 97, 25);
		contentPane.add(btnBuscar);
		//TODO no consigo que me salga el menu bar, no s� por qu�. Mi idea era que saliese una opci�n JMenuItem que te lleve a
		// la pantalla de iniciar sesi�n o registro de usuario
		btnBuscar.setActionCommand(CMD_BTN_IR_INICIO_REGISTRO);
		btnBuscar.addActionListener(this);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 127, 385, 2);
		contentPane.add(separator);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(415, 0, 21, 378);
		contentPane.add(scrollBar);
		
		int offset=0;
		int numBusquedas = 5; //ir� cambiando seg�n cu�ntas b�squedas coincidan
		JTextArea textArea_1, textArea, textArea_2, textArea_3, textArea_4, textArea_5;
		JLabel label, label_1;
		JButton btnReservar;
		
		for (int i=0; i<numBusquedas; i++)
		{
		    textArea_1 = new JTextArea();
			textArea_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textArea_1.setBounds(22, 151+offset, 375, 22);
			contentPane.add(textArea_1);
			
			textArea = new JTextArea();
			textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textArea.setBounds(22, 180+offset, 119, 46);
			contentPane.add(textArea);		
			
			textArea_2 = new JTextArea();
			textArea_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textArea_2.setBounds(153, 180+offset, 67, 22);
			contentPane.add(textArea_2);
			
			textArea_3 = new JTextArea();
			textArea_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textArea_3.setBounds(234, 180+offset, 67, 22);
			contentPane.add(textArea_3);
			
			textArea_4 = new JTextArea();
			textArea_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textArea_4.setBounds(153, 204+offset, 67, 22);
			contentPane.add(textArea_4);
			
			textArea_5 = new JTextArea();
			textArea_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			textArea_5.setBounds(234, 204+offset, 67, 22);
			contentPane.add(textArea_5);
			
			label = new JLabel("a");
			label.setBounds(222, 207+offset, 21, 16);
			contentPane.add(label);
			
			label_1 = new JLabel("-");
			label_1.setBounds(222, 186+offset, 21, 16);
			contentPane.add(label_1);
			
			btnReservar = new JButton("Reservar");
			btnReservar.setBounds(305, 179+offset, 92, 47);
			contentPane.add(btnReservar);
			
			offset+=100;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case CMD_BTN_IR_INICIO_REGISTRO:

				break;
			default: break;	
		}	
	}
}
