package presentacion;


import java.awt.EventQueue;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entidades.*;
import negocio.*;
import util.ApplicationException;
import util.SuperLogger;



public class ABMCPersonaje {
	private CtrlABMCPersonaje ctrl;
	
	private JFrame frame;
	private JTextField txtIdPersonaje;
	private JTextField txtNombre;
	private JTextField txtPuntosTotales;
	private JTextField txtPuntosRestantes;
	private JSpinner spVida;
	private JSpinner spEnergia;
	private JSpinner spDefensa;
	private JSpinner spEvasion;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaje window = new ABMCPersonaje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ABMCPersonaje() {
		initialize();
		ctrl= new CtrlABMCPersonaje();
	}
	/**
	 * 	 * Initialize the contents of the frame.

	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("ABM Personaje");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 356, 467);
		frame.getContentPane().setLayout(null);

		
		JLabel lblIdPersonaje = new JLabel("ID Personaje");
		lblIdPersonaje.setBounds(12,12, 70, 15);
		frame.getContentPane().add(lblIdPersonaje);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 58, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(12, 104, 70, 15);
		frame.getContentPane().add(lblVida);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(12, 150, 70, 15);
		frame.getContentPane().add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(12, 196, 70, 15);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblEvasion = new JLabel("Evasion");
		lblEvasion.setBounds(12, 242, 70, 15);
		frame.getContentPane().add(lblEvasion);
				
		JLabel lblPuntosTotales = new JLabel("Puntos totales");
		lblPuntosTotales.setBounds(12, 288, 70, 15);
		frame.getContentPane().add(lblPuntosTotales);
		
		JLabel lblPuntosRestantes = new JLabel("Puntos restantes");
		lblPuntosRestantes.setBounds(12, 334, 97, 15);
		frame.getContentPane().add(lblPuntosRestantes);
		
		txtIdPersonaje = new JTextField();
		txtIdPersonaje.setEditable(false);
		txtIdPersonaje.setColumns(10);
		txtIdPersonaje.setBounds(167, 11, 70, 15);
		frame.getContentPane().add(txtIdPersonaje);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10); 
		txtNombre.setBounds(167, 57, 70, 15);
		frame.getContentPane().add(txtNombre);

		
		txtPuntosTotales = new JTextField();
		txtPuntosTotales.setEditable(false);
		txtPuntosTotales.setColumns(10);
		txtPuntosTotales.setBounds(167, 287, 70, 15);
		frame.getContentPane().add(txtPuntosTotales);
		
		txtPuntosRestantes = new JTextField();
		txtPuntosRestantes.setEditable(false);
		txtPuntosRestantes.setColumns(10);
		txtPuntosRestantes.setBounds(167, 333, 70, 15);
		frame.getContentPane().add(txtPuntosRestantes);
		
		JSpinner spVida = new JSpinner();
		spVida.setBounds(208, 101, 29, 20);
		frame.getContentPane().add(spVida);
		
		JSpinner spEnergia = new JSpinner();
		spEnergia.setBounds(208, 150, 29, 20);
		frame.getContentPane().add(spEnergia);
		
		JSpinner spDefensa = new JSpinner();
		spDefensa.setBounds(208, 193, 29, 20);
		frame.getContentPane().add(spDefensa);
		
		JSpinner spEvasion = new JSpinner();
		spEvasion.setBounds(208, 239, 29, 20);
		frame.getContentPane().add(spEvasion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseClicked(MouseEvent e){
				agregar();
			}
		});
		btnAceptar.setBounds(63, 382, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(208, 382, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		}
			
	private void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}

	private void notificar(String mensaje, Exception ea, org.apache.logging.log4j.Level warning) {
		notificar(mensaje);
		SuperLogger.logger.log(warning, mensaje, ea);
	}
	public Personaje MapearDeFormulario(){
		
		Personaje p = new Personaje();
		p.setNombrePersonaje(txtNombre.getText());
		p.setVida((int)spVida.getValue());
		p.setDefensa((int)spDefensa.getValue());
		p.setEvasion((int)spEvasion.getValue());
		
		return p;
	}
	private void limparCampos(){
		txtNombre.setText("");
		spDefensa.setValue(0);
		spEnergia.setValue(0);
		spEvasion.setValue(0);
		spVida.setValue(0);			
	}
	
	private void agregar() {
		
		try {
			ctrl.agregar(MapearDeFormulario());
			limparCampos();
		} catch (ApplicationException ae) {
			notificar(ae.getMessage());
		}
	
}
	
	public boolean datosValidos(){
		boolean valido=true;
		int def = (int)spDefensa.getValue();
		int eva = (int)spEvasion.getValue();
		if(txtNombre.getText().trim().length()==0){
			notificar("Complete el campo");		
			valido=false;
		}
		if(def > 80){
			notificar("La defensa no puede superar los 80 puntos");
			valido=false;
		}
		if(eva > 20){
			notificar("La evasion no puede superar los 20 puntos");
		}
		return valido;
	}	

		
	
}
		
		
	

	
