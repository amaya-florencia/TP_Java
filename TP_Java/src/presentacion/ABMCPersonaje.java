package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import entidades.*;
import negocio.*;

public class ABMCPersonaje extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdPersonaje;
	private JTextField txtNombre;
	private JTextField txtPuntosTotales;
	private JTextField txtPuntosRestantes;
	private JSpinner spnVida;
	private JSpinner spnEnergia;
	private JSpinner spnDefensa;
	private JSpinner spnEvasion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaje frame = new ABMCPersonaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private CtrlABMCPersonaje ctrl;
	public ABMCPersonaje() {
		initialize();
		ctrl= new CtrlABMCPersonaje();
	}
	/**
	 * Create the frame.
	 */
	private void initialize() {
		
		setTitle("ABM Personaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdPersonaje = new JLabel("ID Personaje");
		txtIdPersonaje = new JTextField();
		txtIdPersonaje.setEditable(false);
		txtIdPersonaje.setColumns(10);
		
		
		JLabel lblNombre = new JLabel("Nombre");
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblVida = new JLabel("Vida");
		
		JLabel lblEnergia = new JLabel("Energia");
		
		JLabel lblDefensa = new JLabel("Defensa");
		
		JLabel lblEvasion = new JLabel("Evasion");
		
		JLabel lblPuntosTotales = new JLabel("Puntos totales");
		txtPuntosTotales = new JTextField();
		txtPuntosTotales.setEditable(false);
		txtPuntosTotales.setColumns(10);
		
		JLabel lblPuntosRestantes = new JLabel("Puntos restantes");
		txtPuntosRestantes = new JTextField();
		txtPuntosRestantes.setEditable(false);
		txtPuntosRestantes.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				agregar();
			}
		});
		
		JButton btnEliminar = new JButton("Cancelar");
		
		JSpinner spnEnergia = new JSpinner();
		
		JSpinner spnDefensa = new JSpinner();
		
		JSpinner spnEvasion = new JSpinner();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEvasion)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnAceptar)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnEliminar))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblIdPersonaje)
											.addComponent(lblNombre)
											.addComponent(lblPuntosTotales)
											.addComponent(lblEnergia)
											.addComponent(lblDefensa)
											.addComponent(lblPuntosRestantes))
										.addGap(58))
									.addComponent(lblVida))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtPuntosRestantes)
										.addComponent(txtPuntosTotales)
										.addComponent(txtNombre)
										.addComponent(txtIdPersonaje)
										.addComponent(spnVida))
									.addComponent(spnEnergia, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addComponent(spnDefensa, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addComponent(spnEvasion, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdPersonaje)
						.addComponent(txtIdPersonaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuntosTotales)
						.addComponent(txtPuntosTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVida)
						.addComponent(spnVida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnergia)
						.addComponent(spnEnergia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDefensa)
						.addComponent(spnDefensa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEvasion)
						.addComponent(spnEvasion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuntosRestantes)
						.addComponent(txtPuntosRestantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnEliminar))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void agregar() {
		
		
	}
	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();
		p.setNombrePersonaje(this.txtNombre.getText());
		p.setVida(Integer.parseInt(this.spnVida.getValue().toString()));
		p.setDefensa(Integer.parseInt(this.spnDefensa.getValue().toString()));
		p.setEvasion(Integer.parseInt(this.spnEvasion.getValue().toString()));
		return p;
	}
}
