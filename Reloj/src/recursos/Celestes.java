package recursos;

import java.io.File;

import javax.swing.ImageIcon;

import intefaces.I_Recursos;

public class Celestes implements I_Recursos {

	private ImageIcon[] numeros;
	private ImageIcon separador;
	
	public Celestes() {
		this.numeros= new ImageIcon[10];
		this.obtenerImagenes();
	}
	
	private void obtenerImagenes() {
		String ruta= "Numeros" + File.separator + "Celeste" + File.separator;
		for (int i=0;i<10;i++) {
			this.numeros[i] = new ImageIcon(ruta + i + ".PNG");
		}
		this.separador  = new ImageIcon(ruta + "Separador.PNG");
	}


	@Override
	public ImageIcon getNumero(int num) {
		return this.numeros[num];
	}

	@Override
	public ImageIcon getSeparador() {
		return this.separador;
	}


}
