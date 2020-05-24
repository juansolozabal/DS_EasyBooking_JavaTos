package src.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

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
import com.toedter.calendar.JTextFieldDateEditor;

import src.client.controller.EBController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SingleSelectionModel;
import javax.swing.JComboBox;

import src.server.dto.Aeropuerto;
import src.server.dto.Vuelo;

public class frmListaVuelos extends JFrame{
	private JPanel contentPane;
	private JDateChooser calendarIda, calendarVuelta, fechaHoy;
	private File imagen;
	private static int numPasajeros;
	private JSpinner spinner;
	private Calendar actual;
	private JRadioButton btnIda, btnIdaYVuelta;
	private JComboBox origen, destino;
	private EBController controller;
	private int numBusquedas = 0, index=0; //ira cambiando segun cuantas busquedas coincidan
	private ArrayList<Vuelo> vuelosCargados;
	private HashSet<Aeropuerto> aeropuertosCargados;
	private Object[] parametros_busqueda;
	private JTextArea precio, ciudades, fecha, hora, cod_aero_origen, cod_aero_destino;
	private Color azulFondo, azulClaro;
	JButton sig, ant;

	public frmListaVuelos(EBController controller) 
	{
		System.out.println("Se mete en el constructor.");
		this.controller = controller;
		if(vuelosCargados==null)cargarVuelos();
		else buscarVuelos();
		cargarAeropuertos();

		
		VentanaInicial();	
		
	}
	
	
	private void VentanaInicial()
	{
		fechaHoy = new JDateChooser();
		actual=new GregorianCalendar();
		fechaHoy.setCalendar(actual);
	    azulFondo = new Color (0, 76, 109);
	    azulClaro = new Color (184, 205, 218);
		imagen = new File("..\\..\\resources\\img\\Logo EasyBooking_Azul.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(imagen.getAbsolutePath()));
		setResizable(false);
		setTitle("Lista de Vuelos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 347); 		
		
		contentPane = new JPanel();
	    contentPane.setBackground(azulFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup idaOidavuelta = new ButtonGroup(); //Para que solo se pueda seleccionar ida o ida y vuelta
		
		btnIdaYVuelta = new JRadioButton("Ida y vuelta");
		btnIdaYVuelta.setBackground(azulFondo);
		btnIdaYVuelta.setForeground(Color.white);
		btnIdaYVuelta.setBounds(12, 13, 99, 25);
		btnIdaYVuelta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonIdaYVuelta(evt);
			}
		});
		contentPane.add(btnIdaYVuelta);
		btnIdaYVuelta.setSelected(true);
		idaOidavuelta.add(btnIdaYVuelta);
		
		btnIda = new JRadioButton("Solo ida");
		btnIda.setBackground(azulFondo);
		btnIda.setForeground(Color.white);
		btnIda.setBounds(123, 13, 97, 25);
		btnIda.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonIda(evt);
			}
		});
		contentPane.add(btnIda);	
		idaOidavuelta.add(btnIda);
		
		origen = new JComboBox();
		destino = new JComboBox();
		for(Aeropuerto a: aeropuertosCargados) {
			origen.addItem(a);
			destino.addItem(a);

		}
		origen.setBackground(azulClaro);
		origen.setBounds(12, 51, 99, 22);
		contentPane.add(origen);
		
		destino.setBackground(azulClaro);
		destino.setBounds(123, 51, 99, 22);
		contentPane.add(destino);
		
		calendarIda = new JDateChooser(null, null, null, new JSpinnerDateEditor());
		calendarIda.setBackground(azulClaro);
		calendarIda.setBounds(12, 89, 100, 25);
		contentPane.add(calendarIda);
		
		calendarVuelta = new JDateChooser(null, null, null, new JSpinnerDateEditor()); 
		calendarVuelta.setForeground(azulClaro);
		calendarVuelta.setBounds(123, 89, 100, 25);
		contentPane.add(calendarVuelta);
	
		JLabel nBusquedas = new JLabel("N\u00FAmero de busquedas: " + numBusquedas);
		nBusquedas.setForeground(Color.white);
		nBusquedas.setBounds(234, 89, 150, 25);
		contentPane.add(nBusquedas);
		
		spinner = new JSpinner();
		spinner.getEditor().getComponent(0).setBackground(azulClaro);
		spinner.setBounds(340, 14, 36, 22);
		contentPane.add(spinner);
		numPasajeros = (Integer) spinner.getValue();
		
		JLabel lblNmeroDeBilletes = new JLabel("N\u00FAmero de billetes:");
		lblNmeroDeBilletes.setForeground(Color.white);
		lblNmeroDeBilletes.setBounds(224, 17, 129, 16);
		contentPane.add(lblNmeroDeBilletes);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(234, 50, 97, 25);
		btnBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonBuscarVuelos(evt);
			}
		});
		contentPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 127, 385, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(true);
		scrollPane.setVisible(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(420, 0, 18, 516);
		contentPane.add(scrollPane);
		
		int indexAux = index +1;
		JLabel vueloIndex = new JLabel("Vuelo "+indexAux+" de "+ numBusquedas);
		vueloIndex.setForeground(Color.white);
		vueloIndex.setBounds(22, 151, 375, 22);
		contentPane.add(vueloIndex);
		
		int offset=30;
		JLabel label, label_1;
		JButton btnReservar;
		
		if (index<numBusquedas)
		{
		    precio = new JTextArea();
			precio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			precio.setBackground(azulClaro);
			precio.setBounds(22, 151+offset, 375, 22);
			precio.setText("Precio: " + Long.toString(vuelosCargados.get(index).getPrice()));
			precio.setEditable(false);
			contentPane.add(precio);
			
			ciudades = new JTextArea();
			ciudades.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			ciudades.setBackground(azulClaro);
			ciudades.setBounds(22, 180+offset, 119, 46);
			ciudades.setText(
					"Asientos totales: " + vuelosCargados.get(index).getNum_asientos_tot() + "\n" + 
					"Asientos libres: " + vuelosCargados.get(index).getNum_asientos_disp());
			ciudades.setEditable(false);
			contentPane.add(ciudades);		
			
			fecha = new JTextArea();
			fecha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			fecha.setBackground(azulClaro);
			fecha.setBounds(153, 180+offset, 67, 22);
			fecha.setText(vuelosCargados.get(index).getFecha_salida());
			fecha.setEditable(false);
			contentPane.add(fecha);
			
			hora = new JTextArea();
			hora.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			hora.setBackground(azulClaro);
			hora.setBounds(234, 180+offset, 67, 22);
			String hora_salida = vuelosCargados.get(index).getFecha_salida_con_horas().toString().substring(11, 16);
			hora.setText(hora_salida);
			hora.setEditable(false);
			contentPane.add(hora);
			
			cod_aero_origen = new JTextArea();
			cod_aero_origen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			cod_aero_origen.setBackground(azulClaro);
			cod_aero_origen.setBounds(153, 204+offset, 67, 22);
			cod_aero_origen.setText(vuelosCargados.get(index).getAeropuerto_origen().getNom_aeropuerto());
			cod_aero_origen.setEditable(false);
			contentPane.add(cod_aero_origen);
			
			cod_aero_destino = new JTextArea();
			cod_aero_destino.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			cod_aero_destino.setBackground(azulClaro);
			cod_aero_destino.setBounds(234, 204+offset, 67, 22);
			cod_aero_destino.setText(vuelosCargados.get(index).getAeropuerto_destino().getNom_aeropuerto());
			cod_aero_destino.setEditable(false);
			contentPane.add(cod_aero_destino);
			
			label = new JLabel("a");
			label.setForeground(Color.white);
			label.setBounds(222, 207+offset, 21, 16);
			contentPane.add(label);
			
			label_1 = new JLabel("-");
			label_1.setForeground(Color.white);
			label_1.setBounds(222, 186+offset, 21, 16);
			contentPane.add(label_1);
			
			btnReservar = new JButton("Reservar");
			btnReservar.setBounds(305, 179+offset, 92, 47);
			contentPane.add(btnReservar);
			btnReservar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					buttonReservar(evt);
				}
			});

		}
		
		sig = new JButton("Siguiente ");
		sig.setBounds(223, 234+offset, 120, 22);
		sig.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt1) {
				buttonSiguiente(evt1);
			}
		});
		
		
		ant = new JButton("Anterior ");
		ant.setBounds(53, 234+offset, 120, 22);
		ant.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt2) {
				buttonAnterior(evt2);
			}
		});
		contentPane.add(sig);
		contentPane.add(ant);
		if(index==numBusquedas-1)sig.setEnabled(false);
		if(index==0)			 ant.setEnabled(false);

	}
	private void buttonSiguiente(ActionEvent evt1)
	{
		contentPane.removeAll();
		index++;
		VentanaInicial();
		contentPane.revalidate();
	}
	
	private void buttonAnterior(ActionEvent evt1)
	{
		contentPane.removeAll();
		index--;
		VentanaInicial();
		contentPane.revalidate();
	}
	
	private void cargarVuelos() {
		System.out.println("Ha pasado por el metodo cargarVuelos.");
		vuelosCargados = new ArrayList<Vuelo>();
		vuelosCargados = controller.getVuelos();
		numBusquedas = vuelosCargados.size();
		System.out.println("El numero de vuelos cargados es: " + numBusquedas);
	}
	

	private void buscarVuelos()
	{

		contentPane.removeAll();
		index=0;
		parametrosBusqueda();

		vuelosCargados = controller.buscarVuelos(parametros_busqueda);
		numBusquedas = vuelosCargados.size();

		for(int i=0; i<numBusquedas; i++)
		{

			System.out.println(vuelosCargados.get(i).getAeropuerto_origen().getNom_aeropuerto()+ " a " +
					vuelosCargados.get(i).getAeropuerto_destino().getNom_aeropuerto()+
			" del dia "+ vuelosCargados.get(i).getFecha_salida());
		}
		VentanaInicial();
		contentPane.revalidate();
		
	}
	
	private void parametrosBusqueda () {
		
		
		String aeropuerto_origen = origen.getSelectedItem().toString();
		String aeropuerto_destino = destino.getSelectedItem().toString();
		String fechaIda;
		System.out.println("Sacando la fecha obtenida del JCalendar por pantalla:");
		System.out.println(calendarIda.getDate().toString());
		if(calendarIda.getDate()!=null) {
			Date date = calendarIda.getDate();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			fechaIda = dateFormat.format(date);
		}
		else {
			fechaIda = null;
			JOptionPane.showMessageDialog(null, "Lo sentimos, debe seleccionar una fecha de ida.");
		}
		System.out.println("Buscando de " + aeropuerto_origen + " a " + aeropuerto_destino + " para el dia "+ fechaIda);

		int free_seats = numPasajeros;
		
		
		parametros_busqueda = new Object[5];
		parametros_busqueda[0] = aeropuerto_origen;
		parametros_busqueda[1] = aeropuerto_destino;
		parametros_busqueda[2] = free_seats;
		parametros_busqueda[3] = 20000.0; // No filtraremos por precio, de ahi que pongamos un precio maximo demasiado alto.
		parametros_busqueda[4] = fechaIda;
		
	}
	
	private void cargarAeropuertos() {
		System.out.println("Ha pasado por el metodo cargarAeropuertos.");
		aeropuertosCargados = new HashSet<Aeropuerto>();
		for (Vuelo vuelo: vuelosCargados) {
			aeropuertosCargados.add(vuelo.getAeropuerto_origen());
			aeropuertosCargados.add(vuelo.getAeropuerto_destino());
		}
	}
	
	private void buttonIda(ActionEvent evt)
	{
		if(btnIda.isSelected()) calendarVuelta.setVisible(false);
	}
	
	private void buttonIdaYVuelta(ActionEvent evt)
	{
		if(btnIda.isSelected()==false) calendarVuelta.setVisible(true);
	}
	
	private void buttonLogotipoInicial(ActionEvent evt)
	{
		frmLogotipoInicial portada = new frmLogotipoInicial(controller);
		portada.setVisible(true);
		this.setVisible(false);
	}
	
	private void buttonIrInicioRegistro(ActionEvent evt)
	{
		frmInicioRegistro inicioregistro = new frmInicioRegistro(controller);
		inicioregistro.setVisible(true);
	}
	
	private void buttonBuscarVuelos(ActionEvent evt)
	{
		buscarVuelos();
	}
	
	private void buttonReservar(ActionEvent evt)
	{
		numPasajeros=(Integer)spinner.getValue();	
		boolean idaCorrecta=false;
		try
		{
			calendarIda.getDate();
			if(numPasajeros<=0)JOptionPane.showMessageDialog(null, "Lo sentimos, debe seleccionar al menos un pasajero.");
			else if (numPasajeros>10)JOptionPane.showMessageDialog(null, "Lo sentimos, no puede adquirir mas de 10 billetes.");
			else if (fechaHoy.getDate().compareTo(calendarIda.getDate())>0)JOptionPane.showMessageDialog(null, "Lo sentimos, no puede seleccionar una fecha de ida anterior a la de hoy.");
			else
			{
				idaCorrecta=true;
				if(btnIda.isSelected())
				{
					frmInicioRegistro inicioregistro = new frmInicioRegistro(controller);
					inicioregistro.setVisible(true);
				}
			}
		}
		catch(NullPointerException e1)
		{
			JOptionPane.showMessageDialog(null, "Introduzca correctamente la fecha de ida.");
		}
		try
		{
			calendarVuelta.getDate();
			if (fechaHoy.getDate().compareTo(calendarVuelta.getDate())>0)JOptionPane.showMessageDialog(null, "Lo sentimos, no puede seleccionar una fecha de vuelta anterior a la de hoy.");
			else if (calendarIda.getDate().compareTo(calendarVuelta.getDate())>0)JOptionPane.showMessageDialog(null, "Lo sentimos, no puede seleccionar una fecha de vuelta anterior a la de ida.");
			else
			{
				if (idaCorrecta==true && btnIdaYVuelta.isSelected())
				{
					frmInicioRegistro inicioregistro = new frmInicioRegistro(controller);
					inicioregistro.setVisible(true);
				}
			}
		}
		catch(NullPointerException e1)
		{
			JOptionPane.showMessageDialog(null, "Introduzca correctamente la fecha de vuelta.");
		}
	}

	public static int getNumPasajeros() {
		return numPasajeros;
	}	
}
