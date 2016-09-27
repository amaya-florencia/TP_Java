package presentacion;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import entidades.*;
import negocio.*;
import util.ApplicationException;
import util.SuperLogger;
import javax.swing.SpinnerNumberModel;

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
		ctrl = new CtrlABMCPersonaje();
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
		txtIdPersonaje.setEnabled(false);
		txtIdPersonaje.setEditable(false);
		txtIdPersonaje.setColumns(10);
		txtIdPersonaje.setBounds(107, 11, 130, 15);
		frame.getContentPane().add(txtIdPersonaje);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10); 
		txtNombre.setBounds(107, 57, 130, 15);
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
		
		spVida = new JSpinner();
		spVida.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spVida.setBounds(179, 101, 58, 20);
		frame.getContentPane().add(spVida);
		
		spEnergia = new JSpinner();
		spEnergia.setBounds(179, 150, 58, 20);
		frame.getContentPane().add(spEnergia);
		
		spDefensa = new JSpinner();
		spDefensa.setToolTipText("El m\u00E1ximo de Defensa es de 20 puntos");
		spDefensa.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		spDefensa.setBounds(179, 193, 58, 20);
		frame.getContentPane().add(spDefensa);
		
		spEvasion = new JSpinner();
		spEvasion.setToolTipText("El m\u00E1ximo de Evasion es de 20 puntos");
		spEvasion.setModel(new SpinnerNumberModel(0, 0, 80, 1));
		spEvasion.setBounds(179, 239, 58, 20);
		frame.getContentPane().add(spEvasion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseClicked(MouseEvent e){
				agregar();
			}
		});
		btnGuardar.setBounds(26, 382, 89, 23);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(241, 382, 89, 23);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(241, 8, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(133, 382, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		}
			
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}

	private void notificar(String mensaje, Exception ea, org.apache.logging.log4j.Level warning) {
		notificar(mensaje);
		SuperLogger.logger.log(warning, mensaje, ea);
	}
	
	public Personaje MapearDeFormulario(){
		
		Personaje p = new Personaje();
		if(!this.txtIdPersonaje.getText().isEmpty()) p.setIdPersonaje(Integer.parseInt(txtIdPersonaje.getText()));
		p.setNombrePersonaje(txtNombre.getText());
		p.setVida((int)spVida.getValue());	
		p.setEnergia((int)spEnergia.getValue());
		p.setDefensa((int)spDefensa.getValue());
		p.setEvasion((int)spEvasion.getValue());
						
		return p;
	}
	private void limpiarCampos(){
		this.txtNombre.setText("");
		this.spDefensa.setValue(0);
		this.spEnergia.setValue(0);
		this.spEvasion.setValue(0);
		this.spVida.setValue(0);			
	}
	
	protected void agregar() {
		if (datosValidos()){
			try {
				Personaje p = MapearDeFormulario();
				ctrl.agregar(p);
				notificar("Personaje creado con exito");
				MapearAFormulario(p);
				//limpiarCampos();
			} catch (ApplicationException ae) {
				notificar(ae.getMessage());
			}
		}		
	}
	
	public void MapearAFormulario(Personaje p) {
		
		if(p.getIdPersonaje()>0) txtIdPersonaje.setText(String.valueOf(p.getIdPersonaje()));		
		this.txtNombre.setText(p.getNombrePersonaje());
		this.spVida.setValue(p.getVida());
		this.spEnergia.setValue(p.getEnergia());
		this.spDefensa.setValue(p.getDefensa());
		this.spEvasion.setValue(p.getEvasion());
		
	}
	
	public boolean datosValidos(){
		boolean valido = true;		
		if(txtNombre.getText().trim().length() == 0){
			notificar("Complete el nombre del personaje.");		
			valido = false;
		}
		return valido;
	}	
	
}
		
		
	

	
