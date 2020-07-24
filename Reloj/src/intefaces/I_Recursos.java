package intefaces;

import javax.swing.ImageIcon;

public interface I_Recursos {
	
	/**
	 * Regresa una imagen con el numero correspondiente<br>
	 * <b>pre: El numero debe ser entre 0 y 9</b><br>
	 * <b> post: busca la imagen con el numero correspondiente</b><br>
	 * @param num : numero entero
	 * @return: Devuelve una imagen
	 */ 
	ImageIcon getNumero(int num) ;
	
	/** 
	 * Se obtiene la imagen con 2 puntos
	 * @return: Devuelve una imagen
	 */
	ImageIcon getSeparador();
	

}
