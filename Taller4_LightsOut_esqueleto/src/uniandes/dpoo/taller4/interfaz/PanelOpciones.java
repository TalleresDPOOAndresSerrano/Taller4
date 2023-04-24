package uniandes.dpoo.taller4.interfaz;

import java.awt.*;

import javax.swing.*;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class PanelOpciones extends JPanel{
	private InterfazLightsOut interfaz;
	private JLabel lblTamano;
	private JComboBox<String> comboTamanos;
	private JLabel lblDificultad;
	private ButtonGroup bgDificultades;
	private JRadioButton rbFacil;
	private JRadioButton rbMedio;
	private JRadioButton rbDificil;
	
	public PanelOpciones(InterfazLightsOut pInterfaz)
	{
		interfaz=pInterfaz;
		setBackground(Color.decode("#2A89E0"));
		setPreferredSize(new Dimension(672,40));
        setLayout(new GridLayout(1,6));

		
        lblTamano=new JLabel("<html><font color='white'>Tamaño: </html>");
		add(lblTamano);
		
		String[] tamanos= {"3x3","4x4","5x5","6x6","7x7"};
		comboTamanos=new JComboBox<String>(tamanos);
		comboTamanos.setBackground(Color.decode("#FFFFFF"));
		add(comboTamanos);
		
		lblDificultad=new JLabel("<html><font color='white'>Dificultad: </html>");
		add(lblDificultad);
		
		bgDificultades=new ButtonGroup();
		rbFacil=new JRadioButton("Fácil",true);
		rbFacil.setBackground(Color.decode("#2A89E0"));
		rbFacil.setForeground(Color.decode("#FFFFFF"));
		bgDificultades.add(rbFacil);
		rbMedio=new JRadioButton("Medio",false);
		rbMedio.setBackground(Color.decode("#2A89E0"));
		rbMedio.setForeground(Color.decode("#FFFFFF"));
		bgDificultades.add(rbMedio);
		rbDificil=new JRadioButton("Difícil",false);
		rbDificil.setBackground(Color.decode("#2A89E0"));
		rbDificil.setForeground(Color.decode("#FFFFFF"));
		bgDificultades.add(rbDificil);
		add(rbFacil);
		add(rbMedio);
		add(rbDificil);
	}
	
	public int obtenerTamano()
	{
		String strTamano=(String) comboTamanos.getSelectedItem();
		int tamano=Integer.parseInt(String.valueOf(strTamano.charAt(0)));
		return tamano;
	}
	public int obtenerDificultad()
	{
		for (Enumeration<AbstractButton> botones = bgDificultades.getElements(); botones.hasMoreElements();) {
            AbstractButton boton = botones.nextElement();

            if (boton.isSelected()) {
            	String nombre=boton.getText();
                if (nombre.equals("Fácil"))
                {
                	return 10;
                }
                else if (nombre.equals("Medio"))
                {
                	return 20;
                }
                else if (nombre.equals("Difícil"))
                {
                	return 30;
                }
            }
        }

        return 0;
	}

	
	

}
