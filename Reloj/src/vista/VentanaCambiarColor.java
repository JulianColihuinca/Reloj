package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.FlowLayout;

public class VentanaCambiarColor extends JFrame {

	private JPanel contentPane;
	private JButton cambiarVerde;
	private JButton cambiarRojo;
	private JButton cambiarCeleste;
	private ActionListener controlador;
	
	public VentanaCambiarColor() {
		setTitle("Cambiar Color");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 287, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		contentPane.add(panel);
		
		cambiarRojo = new JButton("Rojo");
		panel.add(cambiarRojo);
		this.cambiarRojo.setActionCommand("ROJO");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1);
		
		cambiarVerde = new JButton("Verde");
		panel_1.add(cambiarVerde);
		this.cambiarVerde.setActionCommand("VERDE");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cambiarCeleste = new JButton("Celeste");
		panel_2.add(cambiarCeleste);
		this.cambiarCeleste.setActionCommand("CELESTE");
		this.setVisible(true);
	}

	public void setControlador(ActionListener controlador) {
		this.cambiarCeleste.addActionListener(controlador);
		this.cambiarRojo.addActionListener(controlador);
		this.cambiarVerde.addActionListener(controlador);
		this.controlador = controlador;
	}
	
	
}
