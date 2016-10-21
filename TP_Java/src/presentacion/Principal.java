package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import util.ApplicationException;
import javax.swing.JDesktopPane;


public class Principal {

	
	private JFrame frame;
	private JDesktopPane desktopPane;

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
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnCargarPersonajes = new JButton("Cargar Personajes ");
		btnCargarPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarPersonaje();
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnCargarPersonajes);
		
		
		
		JButton btnIniciarPartida = new JButton("Iniciar Partida");
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					combate();
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
		panel.add(btnIniciarPartida);
	}
	public void cargarPersonaje()throws ApplicationException {
		ABMCPersonaje abm = new ABMCPersonaje(); //instancio el formulario
		this.desktopPane.add(abm);
	}
	public void combate() throws ApplicationException{
		Combat comb = new Combat();//instancio el formulario
		this.desktopPane.add(comb);
	}
	

}
