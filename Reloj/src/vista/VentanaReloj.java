package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import intefaces.I_Recursos;
import recursos.Verdes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class VentanaReloj extends JFrame implements MouseListener,Runnable{

	private JPanel contentPane;
	private JPanel botonIniciar,botonParar ;
	private ActionListener controlador;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private PanelConImagen panelHora1;
	private PanelConImagen panelHora2;
	private PanelConImagen panelSeparador1;
	private PanelConImagen panelMinutos1;
	private PanelConImagen panelMinutos2;
	private PanelConImagen panelSeparador2;
	private PanelConImagen panelSegundos1;
	private PanelConImagen panelSegundos2;
	private JPanel panel_12;
	private I_Recursos recurso = new Verdes();
	
	private boolean estado;
	private JButton iniciarBoton;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton pararBoton;
	private JPanel panel_6;
	private JButton cambiarColor;
	
	public VentanaReloj() {
		this.setTitle("Clock");
		this.estado =false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setMinimumSize(new Dimension(640,400));
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(Color.BLACK);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(3, 0, 0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panelCentral.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 9, 0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panelCentral.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 10, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_2.add(panel_3);
		
		panelHora1 = new PanelConImagen(null);
		panel_2.add(panelHora1);
		
		panelHora2 = new PanelConImagen(null);
		panel_2.add(panelHora2);
		
		panelSeparador1 = new PanelConImagen(null);
		panel_2.add(panelSeparador1);
		
		panelMinutos1 = new PanelConImagen(null);
		panel_2.add(panelMinutos1);
		
		panelMinutos2 = new PanelConImagen(null);
		panel_2.add(panelMinutos2);
		
		panelSeparador2 =new PanelConImagen(null);
		panel_2.add(panelSeparador2);
		
		panelSegundos1 = new PanelConImagen(null);
		panel_2.add(panelSegundos1);
		
		panelSegundos2 = new PanelConImagen(null);
		panel_2.add(panelSegundos2);
		
		panel_12 = new JPanel();
		panel_12.setBackground(Color.BLACK);
		panel_12.setForeground(Color.BLACK);
		panel_2.add(panel_12);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panelCentral.add(panel);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.BLACK);
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		botonIniciar = new JPanel();
		botonIniciar.setBackground(Color.BLACK);
		panelSur.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panelSur.add(panel_4);
		
		iniciarBoton = new JButton("Iniciar");
		panel_4.add(iniciarBoton);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		panelSur.add(panel_5);
		
		cambiarColor = new JButton("Cambiar Color");
		panel_5.add(cambiarColor);
		this.cambiarColor.setActionCommand("CAMBIAR COLOR");
		
		botonParar = new JPanel();
		botonParar.setBackground(Color.BLACK);
		this.botonParar.repaint();
		this.setVisible(true);
		this.iniciarBoton.setActionCommand("INICIAR");
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.BLACK);
		panelSur.add(panel_6);
		
		pararBoton = new JButton("Parar");
		panel_6.add(pararBoton);
		this.pararBoton.setActionCommand("PARAR");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		PanelBoton fuente = (PanelBoton)arg0.getSource();
		String comando= fuente.getLabel().toUpperCase();
		ActionEvent e =new ActionEvent(fuente,0,comando);
		this.controlador.actionPerformed(e);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void run() {
		while (this.estado) {
			Calendar calendario =Calendar.getInstance();
			int hora =calendario.get(Calendar.HOUR_OF_DAY);
			int minutos = calendario.get(Calendar.MINUTE);
			int segundos = calendario.get(Calendar.SECOND);
			this.panelHora1.setImagen(this.recurso.getNumero(hora/10));
			this.panelHora2.setImagen(this.recurso.getNumero(hora%10));
			this.panelMinutos1.setImagen(this.recurso.getNumero(minutos/10));
			this.panelMinutos2.setImagen(this.recurso.getNumero(minutos%10));
			this.panelSegundos1.setImagen(this.recurso.getNumero(segundos/10) );
			this.panelSegundos2.setImagen(this.recurso.getNumero(segundos%10) );
			this.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
	}
	
	/**
	 * Cambia el color del display
	 * <br> pre: El recurso debe ser distinto de null<\br>
	 * <br> post: Cambia de color y muestra si el estado es true sino apretar la tecla iniciar<\br>
	 * @param recurso: parametro en el cual se setea una clase que implementa I_Recurso
	 */
	
	public void cambiarColor(I_Recursos recurso) {
		this.recurso= recurso;
		if (this.estado) {
			Calendar calendario =Calendar.getInstance();
			int hora =calendario.get(Calendar.HOUR_OF_DAY);
			int minutos = calendario.get(Calendar.MINUTE);
			int segundos = calendario.get(Calendar.SECOND);
			this.panelHora1.setImagen(this.recurso.getNumero(hora/10));
			this.panelHora2.setImagen(this.recurso.getNumero(hora%10));
			this.panelMinutos1.setImagen(this.recurso.getNumero(minutos/10));
			this.panelMinutos2.setImagen(this.recurso.getNumero(minutos%10));
			this.panelSegundos1.setImagen(this.recurso.getNumero(segundos/10) );
			this.panelSegundos2.setImagen(this.recurso.getNumero(segundos%10) );
			this.panelSeparador1.setImagen(this.recurso.getSeparador());
			this.panelSeparador2.setImagen(this.recurso.getSeparador());
		}
		else {
			this.panelHora1.setImagen(null);
			this.panelHora2.setImagen(null);
			this.panelSeparador1.setImagen(null);
			this.panelSeparador2.setImagen(null);
			this.panelMinutos1.setImagen(null);
			this.panelMinutos2.setImagen(null);
			this.panelSegundos1.setImagen(null);
			this.panelSegundos2.setImagen(null);
			this.repaint();
		}
		
	}
	
	/**
	 * Setea el estado a true , setea las imagenes de los separadores y inicia el hilo que es el mismo objeto
	 */
	
	public void Inicia() {
		this.panelSeparador1.setImagen(this.recurso.getSeparador());
		this.panelSeparador2.setImagen(this.recurso.getSeparador());
		this.estado =true;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	/**
	 *  Cambia el estado a false y saca las imagenes
	 */
	
	public void Parar() {
		this.panelHora1.setImagen(null);
		this.panelHora2.setImagen(null);
		this.panelSeparador1.setImagen(null);
		this.panelSeparador2.setImagen(null);
		this.panelMinutos1.setImagen(null);
		this.panelMinutos2.setImagen(null);
		this.panelSegundos1.setImagen(null);
		this.panelSegundos2.setImagen(null);
		this.repaint();
		this.estado=false;
	}
	
	/**
	 * Añade un controlador a la vista
	 * <br>pre: controlador distinto de null<\b>
	 * <br>post: Añadir todos los botones para que sean controlada la vista<\br>
	 * @param controlador: parametro de tipo ActionListener, la cual controla la vista
	 */

	public void setControlador(ActionListener controlador) {
		this.iniciarBoton.addActionListener(controlador);
		this.pararBoton.addActionListener(controlador);
		this.cambiarColor.addActionListener(controlador);
		this.controlador = controlador;
	}
	
	

}
