/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelConImagen extends JPanel
{

    private Image imagenFondo;

    public PanelConImagen(String rutaImagen)
    {
        this.imagenFondo = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
        this.setPreferredSize(new Dimension(imagenFondo.getWidth(null), imagenFondo.getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this); 
    }
}
