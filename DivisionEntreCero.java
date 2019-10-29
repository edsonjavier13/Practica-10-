import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DivisionEntreCero extends JFrame implements ActionListener{
	private JTextField campoEntrada1, campoEntrada2, campoSalida;
	private int numero1, numero2, resultado;

	// configurar GUI
	public DivisionEntreCero(){
		super("Demostracion de excepciones");

		// obtener panel de contenido y establecer su esquema
		Container contenedor = getContentPane();
		contenedor.setLayout(new GridLayout(3,2));

		// establecer etiqueta y campoEntrada1
		contenedor.add(
			new JLabel("Escriba el numerador ", SwingConstants.RIGHT));
		campoEntrada1 = new JTextField();
		contenedor.add(campoEntrada1);

		// establecer etiqueta y campoEntrada2
		contenedor.add(
			new JLabel("Escriba el denominador y oprima Enter ", SwingConstants.RIGHT));
		campoEntrada2 = new JTextField();
		contenedor.add(campoEntrada2);
		campoEntrada2.addActionListener(this);

		// establecer etiqueta y campos de salida
		contenedor.add(new JLabel ("RESULTADO ", SwingConstants.RIGHT));
		campoSalida = new JTextField();
		contenedor.add(campoSalida);

		setSize(425, 100);
		setVisible(true);
	}

	// procesar eventos de la GUI
	public void actionPerformed(ActionEvent evento){
		campoSalida.setText("");

		// leer dos números y calcular el cociente
		try{
			numero1 = Integer.parseInt(campoEntrada1.getText());
			numero2 = Integer.parseInt(campoEntrada2.getText());

			resultado = cociente(numero1, numero2);
			campoSalida.setText(String.valueOf(resultado));
		}catch(NumberFormatException excepcionFormato){
			JOptionPane.showMessageDialog(this, "Debe escribir dos enteros", "Formato de numero invalido", JOptionPane.ERROR_MESSAGE);
		}catch(ArithmeticException excepcionAritmetica){
			JOptionPane.showMessageDialog(this, excepcionAritmetica.toString(), "Excepcion aritmetica", JOptionPane.ERROR_MESSAGE);
		}

	}

	public int cociente(int numerador, int denominador) throws ArithmeticException {
		return numerador/denominador;
	}

	public static void main (String[] args){
		DivisionEntreCero aplicacion = new DivisionEntreCero();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}