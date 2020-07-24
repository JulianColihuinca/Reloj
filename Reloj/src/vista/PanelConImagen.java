package vista;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class PanelConImagen extends JPanel {

	private ImageIcon imagen;
	
	
	public PanelConImagen(ImageIcon imagen) {
		setBackground(Color.BLACK);
		this.imagen = imagen;
	}
	
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		if (this.imagen!=null) {
			int dx = (this.getWidth() - this.imagen.getIconWidth())/2;
			int dy = (this.getHeight() - this.imagen.getIconHeight())/2;
			arg0.drawImage(this.imagen.getImage(), dx, dy, null);
		}
	}
	
	

}
