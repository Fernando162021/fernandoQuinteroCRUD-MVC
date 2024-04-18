package com.anahuac.desarrollo.mvc.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.anahuac.desarrollo.mvc.logica.ControllerLibro;

public class CRUD extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton submitButton;  
    private JLabel nombreLabel, autorLabel, isbnLabel ;  
    private JTextField  nombreField, autorField, isbnField;  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD frame = new CRUD();
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
	public CRUD() {
		setTitle("CRUD de Libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);

        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crear panel para la primera pestaña
        JPanel panel1 = new JPanel(new GridLayout(4, 2));

        // Crear label y textField para nombre
        nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(15);

        // Crear label y textField para autor
        autorLabel = new JLabel("Autor:");
        autorField = new JTextField(15);

        // Crear label y textField para ISBN
        isbnLabel = new JLabel("ISBN:");
        isbnField = new JTextField(15);

        // Botón de submit
        submitButton = new JButton("Guardar");
        submitButton.addActionListener(this);

        // Agregar componentes al panel de la primera pestaña
        panel1.add(nombreLabel);
        panel1.add(nombreField);
        panel1.add(autorLabel);
        panel1.add(autorField);
        panel1.add(isbnLabel);
        panel1.add(isbnField);
        panel1.add(submitButton);

        // Agregar el panel a la primera pestaña del JTabbedPane
        tabbedPane.addTab("Agregar Libro", panel1);

        // Crear paneles para las otras tres pestañas
        JPanel panel2 = new JPanel(new GridLayout(4, 2));
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        // Agregar los paneles a las pestañas correspondientes
        tabbedPane.addTab("Buscar libro", panel2);
        tabbedPane.addTab("Modificar libro", panel3);
        tabbedPane.addTab("Eliminar libro", panel4);

        // Agregar el JTabbedPane al JFrame
        add(tabbedPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = nombreField.getText();        
        String autor = autorField.getText();
        String isbn = isbnField.getText();	 
        
        ControllerLibro controller = new ControllerLibro();
        controller.crearLibro(nombre, autor, isbn);
	}

}
