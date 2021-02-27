package ec.edu.ups.remedial.biblioteca.clienteREST;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.remedial.biblioteca.modelo.Libro;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reserva extends JFrame {

	private JPanel contentPane;
	private JTextField libroTXT;
	private JTextField nombreTXT;
	private JTextField stockTXT;
	private JTextField estadoTXT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserva frame = new Reserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buscarBNT = new JButton("Buscar Libro");
		buscarBNT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		buscarBNT.setBounds(134, 221, 124, 21);
		contentPane.add(buscarBNT);
		
		libroTXT = new JTextField();
		libroTXT.setBounds(149, 54, 96, 19);
		contentPane.add(libroTXT);
		libroTXT.setColumns(10);
		
		nombreTXT = new JTextField();
		nombreTXT.setColumns(10);
		nombreTXT.setBounds(149, 93, 96, 19);
		contentPane.add(nombreTXT);
		
		stockTXT = new JTextField();
		stockTXT.setColumns(10);
		stockTXT.setBounds(149, 133, 96, 19);
		contentPane.add(stockTXT);
		
		estadoTXT = new JTextField();
		estadoTXT.setColumns(10);
		estadoTXT.setBounds(149, 177, 96, 19);
		contentPane.add(estadoTXT);
	}
	
	void buscar() {
		Libro libro = new Libro();
		LibroCLI lcli = new LibroCLI();
		libro=lcli.getLibro( Integer.parseInt(libroTXT.getText()));
		nombreTXT.setText(libro.getNombreLibro());
		stockTXT.setText(String.valueOf(libro.getStock()));
		estadoTXT.setText(libro.getEstado());
	}
}
