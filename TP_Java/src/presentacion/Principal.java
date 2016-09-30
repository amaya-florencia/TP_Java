package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnCargarPersonajes = new JButton("Cargar Personajes ");
		btnCargarPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPersonaje();
				
			}
		});
		panel.add(btnCargarPersonajes);
		
		
		
		JButton btnIniciarPartida = new JButton("Iniciar Partida");
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarPersonajes();
			}
		});
		panel.add(btnIniciarPartida);
	}
	public void cargarPersonaje(){
		ABMCPersonaje abm = new ABMCPersonaje();
	}
	public void seleccionarPersonajes(){
		SeleccionarPersonajes partida = new SeleccionarPersonajes();
	}
	

}
