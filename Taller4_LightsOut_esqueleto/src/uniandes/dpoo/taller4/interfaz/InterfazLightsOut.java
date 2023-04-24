package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import java.awt.HeadlessException;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;


public class InterfazLightsOut extends JFrame{ 
	private PanelOpciones panelOpciones;
	private PanelBotones panelBotones;
	private PanelTablero panelTablero;
	private Tablero mundo;
	private PanelInformacion panelInformacion;
	public Top10 manejadorTop;
	public InterfazLightsOut()
	{
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e)
			{
				try {
					manejadorTop.salvarRecords(new File("./data/top10.csv"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		setTitle( "Ligths Out" );
        setSize( 672, 568 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );
        setLocationRelativeTo( null );
        setLayout(new BorderLayout());
        
        panelOpciones=new PanelOpciones(this);
        add( panelOpciones, BorderLayout.NORTH );
        panelBotones=new PanelBotones(this);
        add(panelBotones,BorderLayout.EAST);
        panelInformacion=new PanelInformacion(this);
        add(panelInformacion,BorderLayout.SOUTH);
        manejadorTop=new Top10();
        manejadorTop.cargarRecords(new File("./data/top10.csv"));
	}
	public void iniciarTablero()
	{
		if (panelTablero!=null)
		{
			remove(panelTablero);
		}
		int dificultad=panelOpciones.obtenerDificultad();
		int tamano=panelOpciones.obtenerTamano();
		mundo=new Tablero(tamano);
		mundo.desordenar(dificultad);
		System.err.println("Número de movimientos para desordenarlo: "+Integer.toString(dificultad));
		boolean[][] tablero=mundo.darTablero();
		panelTablero=new PanelTablero(this, tamano, mundo.darTablero());
        add(panelTablero,BorderLayout.CENTER);
        revalidate();
        repaint();
	}
	public boolean[][] hacerJugada(int fila, int columna)
	{
		mundo.jugar(fila, columna);
	    boolean [][] tablero=mundo.darTablero();
	    return tablero;
	}
	public void reiniciarTablero()
	{
		mundo.reiniciar();
		boolean [][] tablero=mundo.darTablero();
	    panelTablero.pintarTablero(tablero);
	}
	public void cambiarJugador()
	{
		JPanel panelNombre = new JPanel();
		JTextField tfNombre = new JTextField(3);
		panelNombre.add(new JLabel("Ingresar nombre de al menos 3 caracteres:"));
		panelNombre.add(tfNombre);
		while (true)
		{
			String nombre = JOptionPane.showInputDialog(this, "Ingresar nombre de al menos 3 caracteres:");
			if (nombre==null)
			{
				break;
			}
			if (nombre.length() >= 3) {
				if (nombre.length() > 3)
					nombre = nombre.substring(0, 3);
				panelInformacion.actualizarNombre(nombre.toUpperCase().replace(";", "*"));
			    break;
			} else {
				JOptionPane.showMessageDialog(this, "Ingresar nombre de 3 caracteres", "Vuelva a intentarlo", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public void obtenerTop()
	{
		Collection coleccion = manejadorTop.darRegistros();
	    JList<String> lista = new JList<>(new DefaultListModel<>());
	    DefaultListModel<String> modeloLista = (DefaultListModel<String>) lista.getModel();
	    for (Object obj : coleccion) {
	        String elemento = obj.toString();
	        modeloLista.addElement(elemento);
	    }
	    JFrame ventana = new JFrame("Top 10");
	    ventana.add(lista);
	    ventana.pack();
	    ventana.setVisible(true);
	}
	public void ganar()
	{
		int puntaje=mundo.calcularPuntaje();
		JOptionPane.showMessageDialog(this, "Ganó la partida. Puntaje: "+Integer.toString(puntaje), "Victoria", JOptionPane.INFORMATION_MESSAGE);
		String nombre="";
		if (panelInformacion.getNombre().equals("<html><font color='white'> </html>"))
		{
			nombre = JOptionPane.showInputDialog(this, "Ingresar nombre de al menos 3 caracteres para ingresar al top:");
		}
		else
		{
			nombre=panelInformacion.getNombre().substring(26,29);
		}
		manejadorTop.agregarRegistro(nombre,puntaje);
		if (manejadorTop.esTop10(puntaje))
		{
			obtenerTop();
		}
		
	}
	public static void main(String[] args) {
		 try
	        {
	            // Unifica la interfaz para Mac y para Windows.
	            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

	            InterfazLightsOut interfaz = new InterfazLightsOut( );
	            interfaz.setVisible( true );
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace( );
	        }

	}

}
