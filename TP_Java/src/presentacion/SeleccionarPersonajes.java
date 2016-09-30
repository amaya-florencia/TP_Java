package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import negocio.CtrlABMCPersonaje;
import entidades.Personaje;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SeleccionarPersonajes {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	
	private CtrlABMCPersonaje ctrl;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public SeleccionarPersonajes() {
		initialize();
		ctrl = new CtrlABMCPersonaje();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 505, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPersonaje1 = new JLabel("Personaje 1");
		lblPersonaje1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblVida = new JLabel("Vida:");
		
		JLabel lblEnergia = new JLabel("Energia:");
		
		JLabel lblDefensa = new JLabel("Defensa:");
		
		JLabel lblEvasion = new JLabel("Evasion:");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtVida = new JTextField();
		txtVida.setEditable(false);
		txtVida.setEnabled(false);
		txtVida.setText("");
		txtVida.setColumns(10);
		
		txtEnergia = new JTextField();
		txtEnergia.setEditable(false);
		txtEnergia.setEnabled(true);
		txtEnergia.setText("");
		txtEnergia.setColumns(10);
		
		txtDefensa = new JTextField();
		txtDefensa.setEditable(false);
		txtDefensa.setColumns(10);
		
		txtEvasion = new JTextField();
		txtEvasion.setEditable(false);
		txtEvasion.setColumns(10);
		
		JButton btnContinuar = new JButton("Continuar");
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarPersonajePorNombre();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEvasion)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblVida)
										.addComponent(lblEnergia)
										.addComponent(lblDefensa))
									.addGap(74)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEvasion, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
										.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
										.addComponent(txtVida, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
										.addComponent(txtEnergia, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
										.addComponent(txtDefensa, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
									.addGap(18))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblPersonaje1)
									.addGap(77)))
							.addComponent(btnBuscar))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(197)
							.addComponent(btnCancelar)
							.addGap(89)
							.addComponent(btnContinuar)))
					.addGap(254))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(lblPersonaje1)
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEvasion)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre)
								.addComponent(btnBuscar))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa))
							.addGap(28)
							.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnContinuar))
					.addGap(20))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void buscarPersonajePorNombre(){
		
		 this.MapearAFormulario(ctrl.buscarPersonajePorNombre(this.MapearDeFormulario().getNombrePersonaje()));
		
	}
	public void MapearAFormulario(Personaje p){
		//if(p.getIdPersonaje()>0) txtIdPersonaje.setText(String.valueOf(p.getIdPersonaje()));		
		this.txtNombre.setText(p.getNombrePersonaje());
		this.txtDefensa.setText(String.valueOf(p.getDefensa()));
		this.txtEnergia.setText(String.valueOf(p.getEnergia()));
		this.txtEvasion.setText(String.valueOf(p.getEvasion()));
		this.txtVida.setText(String.valueOf(p.getVida()));	
	}
	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();
		//if(!this.txtIdPersonaje.getText().isEmpty()) p.setIdPersonaje(Integer.parseInt(txtIdPersonaje.getText()));
		p.setNombrePersonaje(txtNombre.getText());
		p.setVida(Integer.valueOf(txtVida.getText()));	
		p.setEnergia(Integer.valueOf(txtEnergia.getText()));
		p.setDefensa(Integer.valueOf(txtDefensa.getText()));
		p.setEvasion(Integer.valueOf(txtEvasion.getText()));
						
		return p;
	}
}
