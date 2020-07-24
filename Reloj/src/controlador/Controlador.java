package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import recursos.Celestes;
import recursos.Rojos;
import recursos.Verdes;
import vista.VentanaCambiarColor;
import vista.VentanaReloj;

public class Controlador implements ActionListener {
	
	private VentanaReloj vista ;
	private VentanaCambiarColor vistaCambiarColor;
	
	public Controlador() {
		this.vista = new VentanaReloj();
		this.vista.setControlador(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String comando  = arg0.getActionCommand();
		if (comando.equals("INICIAR")) {
			this.vista.Inicia();
		}
		else if (comando.equals("PARAR")) {
			this.vista.Parar();
		}
		else if (comando.equals("CAMBIAR COLOR")) {
			this.vistaCambiarColor= new VentanaCambiarColor();
			this.vistaCambiarColor.setControlador(this);
		}
		else if (comando.equals("ROJO")) {
			this.vistaCambiarColor.dispose();
			this.vista.cambiarColor(new Rojos());
		}
		else if (comando.equals("VERDE")) {
			this.vistaCambiarColor.dispose();
			this.vista.cambiarColor(new Verdes());
		}
		else if (comando.equals("CELESTE")) {
			this.vistaCambiarColor.dispose();
			this.vista.cambiarColor(new Celestes());
		}

	}

}
