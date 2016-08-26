package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Partida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida frame = new Partida();
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
	public Partida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonaje1 = new JLabel("Personaje 1");
		lblPersonaje1.setBounds(58, 29, 96, 14);
		contentPane.add(lblPersonaje1);
		
		JLabel lblPersonaje2 = new JLabel("Personaje 2");
		lblPersonaje2.setBounds(274, 29, 96, 14);
		contentPane.add(lblPersonaje2);
		
		JComboBox cmbPersonaje1 = new JComboBox();
		cmbPersonaje1.setBounds(34, 54, 143, 20);
		contentPane.add(cmbPersonaje1);
		
		JComboBox cmbPersonaje2 = new JComboBox();
		cmbPersonaje2.setBounds(227, 54, 143, 20);
		contentPane.add(cmbPersonaje2);
	}
}
