/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author osval
 */
public class VentanaPrincipal extends JFrame
{
    JButton botonCerrar;
    JPanel panelNorte;

    public VentanaPrincipal()
    {
        this.setSize(850, 650);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        
        this.setUndecorated(true);

        componentes();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void componentes()
    {
        this.add(componentesPanelNorte(), BorderLayout.NORTH);
    }

    public JPanel componentesPanelNorte()
    {
        panelNorte = new JPanel();
        
        panelNorte.setBackground(Color.CYAN);
        panelNorte.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        botonCerrar = new JButton("Cerrar");

        botonCerrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        panelNorte.add(new JButton("Boton1"));
        panelNorte.add(botonCerrar);
        
        return panelNorte;
    }
}
