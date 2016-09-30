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
import java.awt.Color;

public class SeleccionarPersonajes {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtVida;
	private JTextField txtEnergia;
	private JTextField txtDefensa;
	private JTextField txtEvasion;
	private JTextField txtNombre2;
	private JTextField txtVida2;
	private JTextField txtEnergia2;
	private JTextField txtDefensa2;
	private JTextField txtEvasion2;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public SeleccionarPersonajes() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 874, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPersonaje1 = new JLabel("Personaje 1");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblVida = new JLabel("Vida:");
		
		JLabel lblEnergia = new JLabel("Energia:");
		
		JLabel lblDefensa = new JLabel("Defensa:");
		
		JLabel lblEvasion = new JLabel("Evasion:");
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
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
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		
		JButton btnContinuar = new JButton("Continuar");
		
		JLabel lblPersonaje = new JLabel("Personaje 2");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JButton btnSeleccionar_1 = new JButton("Seleccionar");
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		
		JLabel lblVida_1 = new JLabel("Vida:");
		
		JLabel lblEnergia_1 = new JLabel("Energia:");
		
		JLabel lblDefensa_1 = new JLabel("Defensa:");
		
		JLabel lblEvasion_1 = new JLabel("Evasion:");
		
		txtNombre2 = new JTextField();
		txtNombre2.setColumns(10);
		
		txtVida2 = new JTextField();
		txtVida2.setColumns(10);
		
		txtEnergia2 = new JTextField();
		txtEnergia2.setColumns(10);
		
		txtDefensa2 = new JTextField();
		txtDefensa2.setColumns(10);
		
		txtEvasion2 = new JTextField();
		txtEvasion2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(lblPersonaje1)
					.addPreferredGap(ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
					.addComponent(lblPersonaje)
					.addGap(338))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnContinuar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEvasion)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblVida)
										.addComponent(lblEnergia)
										.addComponent(lblDefensa))
									.addGap(74)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtEvasion, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(txtVida, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(txtEnergia, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
										.addComponent(txtDefensa, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(btnSeleccionar)))
							.addGap(135)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
									.addComponent(btnSeleccionar_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre_1)
										.addComponent(lblVida_1)
										.addComponent(lblEnergia_1)
										.addComponent(lblDefensa_1)
										.addComponent(lblEvasion_1))
									.addGap(65)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtVida2, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(txtNombre2, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(txtEnergia2, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(txtDefensa2, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addComponent(txtEvasion2, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))))
					.addGap(58)
					.addComponent(btnCancelar)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPersonaje1)
						.addComponent(lblPersonaje))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSeleccionar)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSeleccionar_1))
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEvasion)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre)
								.addComponent(lblNombre_1)
								.addComponent(txtNombre2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVida)
								.addComponent(lblVida_1)
								.addComponent(txtVida2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnergia)
								.addComponent(lblEnergia_1)
								.addComponent(txtEnergia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDefensa)
								.addComponent(lblDefensa_1)
								.addComponent(txtDefensa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEvasion_1)
								.addComponent(txtEvasion2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnContinuar)
						.addComponent(btnCancelar))
					.addGap(20))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
