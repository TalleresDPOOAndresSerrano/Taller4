package uniandes.dpoo.taller4.interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelTablero extends JPanel{
	private JLabel imagen;
	private InterfazLightsOut interfaz;
	private int numFilas;
	private ArrayList<Casilla> casillas;
	
	public PanelTablero(InterfazLightsOut pInterfaz,int pNumFilas,boolean[][] tablero) {
		interfaz=pInterfaz;
		setPreferredSize(new Dimension(462,462));
        numFilas=pNumFilas;
        pintarTablero(tablero);
 
    }
	public void pintarTablero(boolean[][] tablero)
	{
		removeAll();
		casillas=new ArrayList<Casilla>();
	    setLayout(new GridLayout(numFilas,numFilas));
	    setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    
	    for (int i=0; i<numFilas;i++)
	    {
	        for (int j=0;j<numFilas;j++)
	        {	     
	        	Casilla casilla=new Casilla(i, j,tablero[i][j],this);
	        	casilla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        	add(casilla);
	        	casillas.add(casilla);
	        	
	        }
	    }
	    revalidate();
        repaint();
	    
	}
	public void hacerJugada(int numFila,int numColumna)
	{
		boolean[][] tablero=interfaz.hacerJugada(numFila, numColumna);
		boolean algunFalso=false;
	    for (int i=0; i<tablero.length;i++)
	    {
	    	for (int j=0; j<tablero[0].length;j++)
	    	{
	    		if (tablero[i][j]==false)
	    		{
	    			algunFalso=true;
	    			break;
	    		}
	    	}
	    }
	    removeAll();
		pintarTablero(tablero);
		revalidate();
        repaint();
	    if (algunFalso==false)
	    {
	    	interfaz.ganar();
	    }
	    
	    
		
	}
	
	

}

