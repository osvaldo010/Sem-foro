/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Color;
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

    public VentanaPrincipal()
    {
        this.setSize(850, 600);
        this.setTitle("Semáforo");
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        componentes();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void componentes()
    {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setSize(850, 600);
        panelPrincipal.setBackground(Color.WHITE);
        
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.setBounds(750, 16, 80, 30);
        
        botonCerrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        panelPrincipal.add(botonCerrar);
        
        this.add(panelPrincipal);
    }
}
