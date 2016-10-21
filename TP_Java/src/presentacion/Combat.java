package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;

import entidades.Personaje;
import negocio.CtrlABMCPersonaje;
import negocio.CtrlPartida;
import util.ApplicationException;
import util.SuperLogger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Combat extends JFrame {

	private JFrame frame;
	private JTextField txtNombre1;

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
	private JButton btnInicio;
	private JButton btnAtaque;
	private JButton btnDefensa;
	private Personaje per1;
	private Personaje per2;

	
	
	private CtrlPartida ctrlPartida;
	
	private CtrlABMCPersonaje ctrlPersonaje;
	
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
		
		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inicio();
					
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnAtaque = new JButton("Ataque");
		btnAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ataque();
				} catch (ApplicationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtaque.setEnabled(false);
		
		btnDefensa = new JButton("Defensa");
		btnDefensa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defensa();
			}
		});
		btnDefensa.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnergiaAtaque, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addComponent(spnEnergiaAtaque1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombre1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txtNombre1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblEvasion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDefensa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblVida, Alignment.LEADING)
								.addComponent(lblEnergia, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
							.addGap(89)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDefensa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEvasion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtaque)
						.addComponent(btnDefensa)
						.addComponent(btnInicio))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnergiaAtaque2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida2)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblEvasion2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDefensa2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblEnergia2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(38)
									.addComponent(spnEnergiaAtaque2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombre2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(70))
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
						.addComponent(btnInicio))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblEnergiaAtaque))
								.addComponent(spnEnergiaAtaque1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtVida1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnAtaque))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblVida)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEnergia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(lblEnergia)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtDefensa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(lblDefensa)))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(lblEvasion))
										.addComponent(txtEvasion1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnDefensa)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(spnEnergiaAtaque2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblVida2)))
								.addComponent(lblEnergiaAtaque2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion2))))
					.addGap(62))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public Personaje getPer1() {
		return per1;
	}
	public void setPer1(Personaje per1) {
		this.per1 = per1;
	}

	public Personaje getPer2() {
		return per2;
	}
	public void setPer2(Personaje per2) {
		this.per2 = per2;
	}
	
	private void inicio() throws ApplicationException {
		try {
			Personaje per1= ctrlPersonaje.buscarPersonajePorNombre(this.txtNombre1.getText());		
			Personaje per2= ctrlPersonaje.buscarPersonajePorNombre(this.txtNombre2.getText());	
			this.mapearAFormulario(per1, per2);
			this.setPer1(per1);
			this.setPer2(per2);
			ctrlPartida = new CtrlPartida(per1,per2);	
			this.btnInicio.setEnabled(false);
			this.spnEnergiaAtaque1.setEnabled(true);	
			this.btnAtaque.setEnabled(true);
			this.btnDefensa.setEnabled(true);
			
		} catch (ApplicationException e) {
			notificar(e.getMessage());
		}
	}


	public void mapearAFormulario(Personaje p1,Personaje p2) {		
		this.txtNombre1.setEditable(false);
		this.txtVida1.setText(String.valueOf(p1.getVida()));
		this.txtEnergia1.setText(String.valueOf(p1.getEnergia()));
		this.txtDefensa1.setText(String.valueOf(p1.getDefensa()));
		this.txtEvasion1.setText(String.valueOf(p1.getEvasion()));
		
		this.txtNombre2.setEditable(false);
		this.txtVida2.setText(String.valueOf(p2.getVida()));
		this.txtEnergia2.setText(String.valueOf(p2.getEnergia()));
		this.txtDefensa2.setText(String.valueOf(p2.getDefensa()));
		this.txtEvasion2.setText(String.valueOf(p2.getEvasion()));
		
	}

	private void ataque() throws ApplicationException {
		try {
			if (this.spnEnergiaAtaque1.isEnabled()==true){
				int energia = (int)(this.spnEnergiaAtaque1.getValue());
				if(this.getPer1().getEnergia()>=energia){
					this.spnEnergiaAtaque1.setEnabled(false);
					this.spnEnergiaAtaque2.setEnabled(true);
					ctrlPartida.ataque(energia,this.getPer1(),this.getPer2());	
					ctrlPartida.premio(ctrlPartida.getPersonaje2());
				}else{
					notificar("La energia ingresada debe ser menor a " + this.getPer1().getEnergia());					
				}
			}else{
				int energia = (int)(this.spnEnergiaAtaque2.getValue());
				if(this.getPer2().getEnergia()>=energia){
					this.spnEnergiaAtaque2.setEnabled(false);
					this.spnEnergiaAtaque1.setEnabled(true);					
					ctrlPartida.ataque(energia,this.getPer2(),this.getPer1());	
					ctrlPartida.premio(ctrlPartida.getPersonaje2());
					
				}else{
					notificar("La energia ingresada debe ser menor a " + this.getPer2().getEnergia());					
				}
							
			}
		} catch (ApplicationException e) {
			notificar(e.getMessage());
		}finally{
			
			this.actualizarDatos();
		}
				
	}
	public void defensa(){
		
		try {
			if (this.spnEnergiaAtaque1.isEnabled()==true){
				this.spnEnergiaAtaque1.setEnabled(false);
				this.spnEnergiaAtaque2.setEnabled(true);
				ctrlPartida.defensa(this.getPer1());
				
			}else{
				this.spnEnergiaAtaque2.setEnabled(false);
				this.spnEnergiaAtaque1.setEnabled(true);
				ctrlPartida.defensa(this.getPer2());			
				
			}
		} catch (ApplicationException e) {
			
			notificar(e.getMessage());
		}finally{
			this.actualizarDatos();
		}
	}
	public void actualizarDatos(){
		Personaje p1 = ctrlPartida.getPersonaje1();
		Personaje p2 = ctrlPartida.getPersonaje2();
		
		if(p1.getVida()<=0){
			try {
				ctrlPartida.premio(p2);
				this.btnAtaque.setEnabled(false);
				this.btnDefensa.setEnabled(false);
				this.btnInicio.setText("Revancha");
				this.limpiarCampos();
				
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				notificar(e.getMessage());
			}
		}
		if(p2.getVida()<=0){
			try {
				ctrlPartida.premio(p1);
				this.btnAtaque.setEnabled(false);
				this.btnDefensa.setEnabled(false);
				this.btnInicio.setText("Revancha");
				this.limpiarCampos();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				notificar(e.getMessage());
			}
		}
		
		this.txtVida1.setText(String.valueOf(p1.getVida()));
		this.txtEnergia1.setText(String.valueOf(p1.getEnergia()));
		
		this.txtVida2.setText(String.valueOf(p2.getVida()));
		this.txtEnergia2.setText(String.valueOf(p2.getEnergia()));

	}
	
	public void limpiarCampos(){
		
		this.txtDefensa1.setText("");
		this.txtEnergia1.setText("");
		this.txtEvasion1.setText("");
		this.txtNombre1.setText("");
		this.txtVida1.setText("");
		this.spnEnergiaAtaque1.setValue(0);
		
		this.txtDefensa2.setText("");
		this.txtEnergia2.setText("");
		this.txtEvasion2.setText("");
		this.txtNombre2.setText("");
		this.txtVida2.setText("");
		this.spnEnergiaAtaque2.setValue(0);
		
		
	}
	
	
	
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}

	private void notificar(String mensaje, Exception ea, org.apache.logging.log4j.Level warning) {
		notificar(mensaje);
		SuperLogger.logger.log(warning, mensaje, ea);
	}
	
}
