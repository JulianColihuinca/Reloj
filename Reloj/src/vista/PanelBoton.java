package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelBoton extends JPanel {

	private JLabel nombreLabel ;
	
	public PanelBoton(String texto) {
		setBackground(Color.BLACK);
		setLayout(null);
		
		nombreLabel = new JLabel("");
		nombreLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		nombreLabel.setForeground(Color.WHITE);
		nombreLabel.setBounds(161, 132, 143, 36);
		add(nombreLabel);
	}
	
	public String getLabel() {
		return this.nombreLabel.getText();
	}
	
	public void setLabel(String texto) {
		this.nombreLabel.setText(texto);
	}
	
	
	
}
