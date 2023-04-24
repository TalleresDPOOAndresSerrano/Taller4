package uniandes.dpoo.taller4.interfaz;	

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Casilla extends JPanel implements MouseListener {
    private int fila;
    private int columna;
    private boolean iluminada;
    private PanelTablero panelTablero;

    public Casilla(int pFila, int pColumna, boolean pIluminada, PanelTablero pPanelTablero) {
        fila = pFila;
        columna = pColumna;
        iluminada = pIluminada;
        setBackground(Color.YELLOW);
        setLayout(new BorderLayout());
        addMouseListener(this);
        JLabel imagen = new JLabel(new ImageIcon("./data/luz.png"));
        if (!pIluminada) {
            imagen.setOpaque(true);        }
        imagen.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagen.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(imagen, BorderLayout.CENTER);
        panelTablero=pPanelTablero;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (iluminada) {
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        panelTablero.hacerJugada(fila,columna);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}