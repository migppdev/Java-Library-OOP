package view;
import javax.swing.JFrame;
public class LibraryUI {
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Mi Primera Ventana Swing");

		// 2. Define lo que pasa al cerrar la ventana (importante!)
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 3. Define el tamaño de la ventana
		ventana.setSize(400, 300);

		// 4. Hace visible la ventana
		ventana.setVisible(true);
	}

}
