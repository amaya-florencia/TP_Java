package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Personaje;
import negocio.CtrlABMCPersonaje;
import negocio.CtrlPartida;
import util.ApplicationException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Combat {

	private JFrame frame;
	private JTextField txtNombre1;
	private JLabel lblPersonaje1;
	private JLabel lblPersonaje2;
	private JLabel lblEnergiaAtaque;
	private JLabel lblVida;
	private JLabel lblEnergia;
	private JLabel lblDefensa;
	private JLabel lblEvasion;
	
	private JTextField txtEvasion1;
	private JTextField txtDefensa1;
	private JTextField txtEnergia1;
	private JTextField txtVida1;
	
	private JSpinner spnEnergiaAtaque1;
	private JLabel lblEnergiaAtaque2;
	private JLabel lblVida2;
	private JLabel lblEnergia2;
	private JLabel lblDefensa2;
	private JLabel lblEvasion2;
	
	private JTextField txtEvasion2;
	private JTextField txtDefensa2;
	private JTextField txtEnergia2;
	private JTextField txtVida2;
	
	private JSpinner spnEnergiaAtaque2;
	private JTextField txtNombre2;
	private JLabel lblNombre2;
	private JButton btnBuscar;
	private JButton btnAtaque;
	private JButton btnEvasion;
	private JButton btnInicio;
	
	
	private CtrlPartida ctrlPartida;
	
	private CtrlABMCPersonaje ctrlPersonaje;
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Combat() {
		
		initialize();
		ctrlPersonaje = new CtrlABMCPersonaje();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Combate");
		frame.setBounds(100, 100, 729, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		txtNombre1 = new JTextField();
		txtNombre1.setColumns(10);
		
		JLabel lblNombre1 = new JLabel("Personaje 1 ");
		lblNombre1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblEnergiaAtaque = new JLabel("Energia de Ataque");
		
		lblVida = new JLabel("Vida");
		
		lblEnergia = new JLabel("Energia");
		
		lblDefensa = new JLabel("Defensa");
		
		lblEvasion = new JLabel("Evasion");
		
		txtEvasion1 = new JTextField();
		txtEvasion1.setEditable(false);
		txtEvasion1.setColumns(10);
		
		txtDefensa1 = new JTextField();
		txtDefensa1.setEditable(false);
		txtDefensa1.setColumns(10);
		
		txtEnergia1 = new JTextField();
		txtEnergia1.setEditable(false);
		txtEnergia1.setColumns(10);
		
		txtVida1 = new JTextField();
		txtVida1.setEditable(false);
		txtVida1.setColumns(10);
		
		spnEnergiaAtaque1 = new JSpinner();
		spnEnergiaAtaque1.setEnabled(false);
		
		lblEnergiaAtaque2 = new JLabel("Energia de Ataque");
		
		lblVida2 = new JLabel("Vida");
		
		lblEnergia2 = new JLabel("Energia");
		
		lblDefensa2 = new JLabel("Defensa");
		
		lblEvasion2 = new JLabel("Evasion");
		
		txtEvasion2 = new JTextField();
		txtEvasion2.setEditable(false);
		txtEvasion2.setColumns(10);
		
		txtDefensa2 = new JTextField();
		txtDefensa2.setEditable(false);
		txtDefensa2.setColumns(10);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setEditable(false);
		txtEnergia2.setColumns(10);
		
		txtVida2 = new JTextField();
		txtVida2.setEditable(false);
		txtVida2.setColumns(10);
		
		spnEnergiaAtaque2 = new JSpinner();
		spnEnergiaAtaque2.setEnabled(false);
		
		txtNombre2 = new JTextField();
		txtNombre2.setColumns(10);
		
		lblNombre2 = new JLabel("Personaje 2");
		lblNombre2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscar();
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnAtaque = new JButton("Ataque");
		btnAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtaque.setEnabled(false);
		
		btnEvasion = new JButton("Evasion");
		btnEvasion.setEnabled(false);
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					turno();
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnergiaAtaque, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(93)
							.addComponent(spnEnergiaAtaque1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVida, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(105)
							.addComponent(txtVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnergia, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(89)
							.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDefensa, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(85)
							.addComponent(txtDefensa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEvasion, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(88)
							.addComponent(txtEvasion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombre1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtNombre1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtaque)
						.addComponent(btnEvasion)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnInicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBuscar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnergia2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergiaAtaque2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(57)
									.addComponent(spnEnergiaAtaque2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombre2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(spnEnergiaAtaque2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida2))
							.addGap(18)
							.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(lblEnergia2))
						.addComponent(lblEnergiaAtaque2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblEnergiaAtaque))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(spnEnergiaAtaque1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnInicio)))
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblVida))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnAtaque)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(lblEnergia))
										.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(lblDefensa))
										.addComponent(txtDefensa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(lblEvasion))
										.addComponent(txtEvasion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnEvasion))))
					.addGap(62))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private void buscar() throws ApplicationException {
		Personaje per1= ctrlPersonaje.buscarPersonajePorNombre(this.txtNombre1.getText());
		
		Personaje per2= ctrlPersonaje.buscarPersonajePorNombre(this.txtNombre2.getText());
		
		this.mapearAFormulario(per1, per2);
		
	}
	public void mapearAFormulario(Personaje p1,Personaje p2) {
		
		this.lblPersonaje1.setText(p1.getNombrePersonaje());
		this.txtVida1.setText(String.valueOf(p1.getVida()));
		this.txtEnergia1.setText(String.valueOf(p1.getEnergia()));
		this.txtDefensa1.setText(String.valueOf(p1.getDefensa()));
		this.txtEvasion1.setText(String.valueOf(p1.getEvasion()));
		
		this.lblPersonaje2.setText(p2.getNombrePersonaje());
		this.txtVida2.setText(String.valueOf(p2.getVida()));
		this.txtEnergia2.setText(String.valueOf(p2.getEnergia()));
		this.txtDefensa2.setText(String.valueOf(p2.getDefensa()));
		this.txtEvasion2.setText(String.valueOf(p2.getEvasion()));
		
	}
	
	private void turno() throws ApplicationException {
		
		Personaje per1 = ctrlPersonaje.buscarPersonajePorNombre(this.txtNombre1.getText());
		Personaje per2 = ctrlPersonaje.buscarPersonajePorNombre(this.txtNombre2.getText());
		Personaje pAtaque = ctrlPartida.turno(per1 ,per2);
		if(pAtaque.getNombrePersonaje()==this.lblPersonaje1.getText()){
			this.spnEnergiaAtaque2.setEnabled(true);	
			this.btnAtaque.setEnabled(true);
		}else{
			this.spnEnergiaAtaque1.setEnabled(true);	
			this.btnAtaque.setEnabled(true);
		}
	}
	

}
