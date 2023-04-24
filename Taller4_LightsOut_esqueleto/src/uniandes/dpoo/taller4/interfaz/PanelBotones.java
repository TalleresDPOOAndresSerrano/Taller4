package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelBotones extends JPanel implements ActionListener{
	private InterfazLightsOut interfaz;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop;
	private JButton btnCambiarJugador;
	
	public PanelBotones(InterfazLightsOut pInterfaz)
	{
		interfaz=pInterfaz;
		setBackground(Color.decode("#FFFFFF"));
		setPreferredSize(new Dimension(210,540));
        setLayout(new GridLayout(4,1));
        
        btnNuevo=new JButton("NUEVO");
        btnNuevo.setBackground(Color.decode("#2A89E0"));
        btnNuevo.setForeground(Color.decode("#FFFFFF"));
        btnNuevo.addActionListener(this);
        add(btnNuevo);
        
        btnReiniciar=new JButton("REINICIAR");
        btnReiniciar.setBackground(Color.decode("#2A89E0"));
        btnReiniciar.setForeground(Color.decode("#FFFFFF"));
        btnReiniciar.addActionListener(this);
        add(btnReiniciar);
        
        btnTop=new JButton("TOP-10");
        btnTop.setBackground(Color.decode("#2A89E0"));
        btnTop.setForeground(Color.decode("#FFFFFF"));
        btnTop.addActionListener(this);
        add(btnTop);
        
        btnCambiarJugador=new JButton("CAMBIAR JUGADOR");
        btnCambiarJugador.setBackground(Color.decode("#2A89E0"));
        btnCambiarJugador.setForeground(Color.decode("#FFFFFF"));
        btnCambiarJugador.addActionListener(this);
        add(btnCambiarJugador);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnNuevo))
		{
			interfaz.iniciarTablero();

		}
		else if (e.getSource().equals(btnReiniciar))
		{
			interfaz.reiniciarTablero();
		}
		else if (e.getSource().equals(btnCambiarJugador))
		{
			interfaz.cambiarJugador();
		}
		else if (e.getSource().equals(btnTop))
		{
			interfaz.obtenerTop();
		}
		
	}

}
