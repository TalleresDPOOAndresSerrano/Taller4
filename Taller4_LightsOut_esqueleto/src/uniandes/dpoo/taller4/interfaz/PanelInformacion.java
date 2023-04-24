package uniandes.dpoo.taller4.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformacion extends JPanel{
	private InterfazLightsOut interfaz;
	private JLabel lblJugadas;
	private JLabel lblNumeroJugadas;
	private JLabel lblJugador;
	private JLabel lblNombreJugador;
	public PanelInformacion(InterfazLightsOut pInterfaz)
	{
		interfaz=pInterfaz;
		setBackground(Color.decode("#2A89E0"));
		setPreferredSize(new Dimension(672,40));
        setLayout(new GridLayout(1,4));
        
        lblJugadas=new JLabel("<html><font color='white'>Jugadas: </html>");
		add(lblJugadas);
		
		lblNumeroJugadas=new JLabel("<html><font color='white'>0 </html>");
		add(lblNumeroJugadas);
		
		lblJugador=new JLabel("<html><font color='white'>Jugador: </html>");
		add(lblJugador);
		
		lblNombreJugador=new JLabel("<html><font color='white'> </html>");
		add(lblNombreJugador);
	}
	public void actualizarNombre(String nombre)
	{
		lblNombreJugador.setText("<html><font color='white'>" +nombre+"</html>");
	}
	public String getNombre()
	{
		return lblNombreJugador.getText();
	}
	public void actualizarJugadas(int jugadas)
	{
		lblNumeroJugadas.setText("<html><font color='white'>" +Integer.toString(jugadas)+"</html>");
	}

}
