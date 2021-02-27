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
import javax.swing.JLabel;

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
		setBounds(100, 100, 724, 484);
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
		
		JLabel lblNewLabel = new JLabel("Codigo Libro");
		lblNewLabel.setBounds(56, 57, 88, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(56, 96, 68, 13);
		contentPane.add(lblNombre);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(56, 136, 68, 13);
		contentPane.add(lblStock);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(56, 180, 68, 13);
		contentPane.add(lblEstado);
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
