package presentacion;

import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ABMCPersonaje extends JInternalFrame {
	
	private CtrlABMCPersonaje ctrl;
	private JFrame frame;
	private JTextField txtIdPersonaje;
	private JTextField txtNombre;
	private JTextField txtPuntosTotales;
	private JSpinner spVida;
	private JSpinner spEnergia;
	private JSpinner spDefensa;
	private JSpinner spEvasion;	
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private JButton btnModificar;

	public ABMCPersonaje() {		
		initialize();
		ctrl = new CtrlABMCPersonaje();		
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("ABM Personaje");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 418, 484);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		
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
		
		txtIdPersonaje = new JTextField();
		txtIdPersonaje.setEnabled(false);
		txtIdPersonaje.setEditable(false);
		txtIdPersonaje.setColumns(10);
		txtIdPersonaje.setBounds(107, 15, 130, 20);
		frame.getContentPane().add(txtIdPersonaje);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10); 
		txtNombre.setBounds(107, 57, 130, 20);
		frame.getContentPane().add(txtNombre);

		
		txtPuntosTotales = new JTextField();
		txtPuntosTotales.setText("200");
		txtPuntosTotales.setEditable(false);
		txtPuntosTotales.setColumns(10);
		txtPuntosTotales.setBounds(167, 287, 70, 20);
		frame.getContentPane().add(txtPuntosTotales);
		
		spVida = new JSpinner();
		spVida.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spVida.setBounds(179, 101, 58, 20);
		frame.getContentPane().add(spVida);
		
		spEnergia = new JSpinner();
		spEnergia.setBounds(179, 150, 58, 20);
		frame.getContentPane().add(spEnergia);
		
		spDefensa = new JSpinner();
		spDefensa.setToolTipText("El m\u00E1ximo de Defensa es de 20 puntos");
		spDefensa.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spDefensa.setBounds(179, 193, 58, 20);
		frame.getContentPane().add(spDefensa);
		
		spEvasion = new JSpinner();
		spEvasion.setToolTipText("El m\u00E1ximo de Evasion es de 80 puntos");
		spEvasion.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spEvasion.setBounds(179, 239, 58, 20);
		frame.getContentPane().add(spEvasion);
		
		btnGuardar = new JButton("Nuevo");
		btnGuardar.addMouseListener(new MouseAdapter(){
			@Override 
			public void mouseClicked(MouseEvent e){
				agregar();
			}
		});
		btnGuardar.setBounds(25, 352, 100, 23);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(280, 411, 100, 23);
		frame.getContentPane().add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarPersonajePorNombre();
			}
			
		});
		btnBuscar.setBounds(291, 54, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		btnEliminar.setBounds(280, 352, 100, 23);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.setVisible(false);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}

		});
		btnModificar.setBounds(156, 352, 100, 23);
		frame.getContentPane().add(btnModificar);
		btnModificar.setVisible(false);
		
		
		}
	
	public Personaje MapearDeFormulario(){
		Personaje p = new Personaje();
		if(!this.txtIdPersonaje.getText().isEmpty()) p.setIdPersonaje(Integer.parseInt(txtIdPersonaje.getText()));
		p.setNombrePersonaje(txtNombre.getText());
		p.setVida((int)spVida.getValue());	
		p.setEnergia((int)spEnergia.getValue());
		p.setDefensa((int)spDefensa.getValue());
		p.setEvasion((int)spEvasion.getValue());	
		p.setPuntosTotales(Integer.parseInt(txtPuntosTotales.getText()));
		return p;
	}
	
	private void limpiarCampos(){
		this.txtNombre.setText("");
		this.spDefensa.setValue(0);
		this.spEnergia.setValue(0);
		this.spEvasion.setValue(0);
		this.spVida.setValue(0);	
		this.txtPuntosTotales.setText("200");
		this.btnEliminar.setVisible(false);
		this.btnModificar.setVisible(false);
		this.btnGuardar.setVisible(true);
		
		
	}	
	protected void agregar() {
		if (datosValidos()){ //valida que el campo no este vacio
			try {
				this.txtPuntosTotales.setText("200"); // muestro el valor por defecto 
				Personaje p = MapearDeFormulario(); //recupero los valores del formulario
				ctrl.agregar(p); // le envio a la capa logica el personaje a insertar
				MapearAFormulario(p); //lo llamo para que muestre el id
				notificar("Personaje creado con éxito");
				
				limpiarCampos();
		  } catch (ApplicationException ae) {
				notificar(ae.getMessage());
			}
		}		
	}
	
	protected void modificar() {
		if(datosValidos()){
			try {
				Personaje p = MapearDeFormulario();
				MapearAFormulario(p);				
				ctrl.update(p);//lo envio a la capa logica el personaje para que haga el update
				notificar("Personaje modificado con éxito");
				this.limpiarCampos();
				
			} catch (ApplicationException ae) {
				// TODO Auto-generated catch block
				notificar(ae.getMessage());
			}			
		}		
	}
	protected void eliminar() {
		if (datosValidos()){
			try {
				Personaje p = MapearDeFormulario();
				ctrl.eliminar(p);// lo envio a la capa logica el personaje para que haga el delete
				notificar("Personaje eliminado con éxito");				
				limpiarCampos();
		  } catch (ApplicationException ae) {
				notificar(ae.getMessage());
			}
		}		
	}
	
	private void buscarPersonajePorNombre() {		
		try {
			
			this.MapearAFormulario(ctrl.buscarPersonajePorNombre(this.txtNombre.getText()));
			//una vez encontrado deshabilito los botones
			this.btnModificar.setVisible(true);
			this.btnEliminar.setVisible(true);
			this.btnGuardar.setVisible(false);
			
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			notificar(e.getMessage());
		}
	}
	
	public void MapearAFormulario(Personaje p) {		
		if(p.getIdPersonaje()>0) txtIdPersonaje.setText(String.valueOf(p.getIdPersonaje()));		
		this.txtNombre.setText(p.getNombrePersonaje());
		this.spVida.setValue(p.getVida());
		this.spEnergia.setValue(p.getEnergia());
		this.spDefensa.setValue(p.getDefensa());
		this.spEvasion.setValue(p.getEvasion());
		this.txtPuntosTotales.setText(String.valueOf(p.getPuntosTotales()));
		
	}
	
	public boolean datosValidos(){
		boolean valido = true;		
		if(txtNombre.getText().trim().length() == 0){
			notificar("Complete el nombre del personaje.");		
			valido = false;
		}
		return valido;
	}	
	
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}

	private void notificar(String mensaje, Exception ea, org.apache.logging.log4j.Level warning) {
		notificar(mensaje);
		SuperLogger.logger.log(warning, mensaje, ea);
	}
	
}
		
		
	

	
