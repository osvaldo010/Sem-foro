/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author osval
 */
public class VentanaInicio extends JFrame
{
    JButton botonCerrar, botonMinizar, botonComenzar;
    JLabel textoTitulo, textoSemaforo;
    JPanel panelNorte, panelCentral;
    GridBagConstraints restricciones;
    Image imagen;

    public VentanaInicio()
    {
        this.setSize(700, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        
        componentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void componentes()
    {
        this.add(componentesPanelNorte(), BorderLayout.NORTH);
        this.add(componentesPanelCentral(), BorderLayout.CENTER);
    }
    
    public JPanel componentesPanelCentral()
    {
        panelCentral = new JPanel(new GridBagLayout());
        
        panelCentral.setBackground(Color.GRAY);
        
        restricciones = new GridBagConstraints();
        textoSemaforo = new JLabel("Proyecto Semáforos");
        textoSemaforo.setFont(new Font("Arial", Font.BOLD, 40));
        
        restricciones.insets = new Insets(10, 0, 10, 0);
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        panelCentral.add(textoSemaforo, restricciones);
        
        botonComenzar = new JButton("Comenzar");
        botonComenzar.setFont(new Font("Arial", Font.BOLD, 30));
        botonComenzar.setBackground(Color.GREEN);
        
        botonComenzar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
                dispose();
            }
        });
        
        restricciones.insets = new Insets(100, 0, 40, 0);
        restricciones.gridy = 1;
        panelCentral.add(botonComenzar, restricciones);
        
        return panelCentral;
    }
    
    public JPanel componentesPanelNorte()
    {
        panelNorte = new JPanel();
        panelNorte.setLayout(new GridBagLayout());
        
        panelNorte.setBackground(Color.BLUE);
        
        restricciones = new GridBagConstraints();
        restricciones.insets = new Insets(8, 5, 8, 5);
        
        textoTitulo = new JLabel("Proyecto Semáforos");
        textoTitulo.setForeground(Color.WHITE);
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.weightx = 1.0;
        restricciones.anchor = GridBagConstraints.CENTER;
        panelNorte.add(textoTitulo, restricciones);
        
        botonMinizar = new JButton("-");
        botonMinizar.setBackground(Color.YELLOW);
        restricciones.gridx = 1;
        restricciones.weightx = 0.0;
        panelNorte.add(botonMinizar, restricciones);
        
        botonCerrar = new JButton("X");
        botonCerrar.setBackground(Color.red);
        restricciones.gridx = 2;
        panelNorte.add(botonCerrar, restricciones);
        
        botonCerrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        botonMinizar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setState(JFrame.ICONIFIED);
            }
        });
        
        return panelNorte;
    }
}
