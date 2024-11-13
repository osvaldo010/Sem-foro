/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.CarrosHorizontalInicio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/IconoPrograma.png")));
        this.setSize(700, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        
        componentes();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {
                iniciarVehiculosHorizontal();   
            }
        });
    }
    
    public void componentes()
    {
        this.add(componentesPanelNorte(), BorderLayout.NORTH);
        this.add(componentesPanelCentral(), BorderLayout.CENTER);
    }
    
    public JPanel componentesPanelCentral()
    {
        Border margen = new EmptyBorder(0, 0, 0, 0);
        Border bordeColor = new LineBorder(Color.decode("#051d40"), 5); 
        this.getRootPane().setBorder(BorderFactory.createCompoundBorder(bordeColor, margen));
        
        panelCentral = new JPanel(new GridBagLayout());
        
        panelCentral.setBackground(Color.decode("#fdf8f0"));
        
        restricciones = new GridBagConstraints();
        textoSemaforo = new JLabel("Proyecto Semáforos");
        textoSemaforo.setFont(new Font("Arial", Font.BOLD, 40));
        textoSemaforo.setForeground(Color.decode("#051d40"));
        
        restricciones.insets = new Insets(100, 0, 100, 0);
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        panelCentral.add(textoSemaforo, restricciones);
        
        botonComenzar = new JButton("Comenzar");
        botonComenzar.setFont(new Font("Arial", Font.BOLD, 24));
        botonComenzar.setBackground(Color.decode("#051d40"));
        botonComenzar.setForeground(Color.decode("#fdf8f0")); //blanco-gris
        botonComenzar.setFocusPainted(false); 
        
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
        
        panelNorte.setBackground(Color.decode("#051d40"));
        
        restricciones = new GridBagConstraints();
        restricciones.insets = new Insets(8, 5, 8, 5);
        
        textoTitulo = new JLabel("");
        textoTitulo.setForeground(Color.decode("#424242"));
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.weightx = 1.0;
        restricciones.anchor = GridBagConstraints.CENTER;
        panelNorte.add(textoTitulo, restricciones);
        
        botonMinizar = new JButton("-");
        botonMinizar.setBackground(Color.decode("#eee41a"));
        botonMinizar.setForeground(Color.decode("#151515")); //negro
        botonMinizar.setFocusPainted(false); 
        restricciones.gridx = 1;
        restricciones.weightx = 0.0;
        panelNorte.add(botonMinizar, restricciones);
        
        botonCerrar = new JButton("x");
        botonCerrar.setBackground(Color.decode("#cc0c0c"));
        botonCerrar.setForeground(Color.WHITE);
        botonCerrar.setFocusPainted(false); 
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
    
    public Image getIconImage()
    {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/IconoPrograma.png"));
        return retValue;
    }
    
    public void iniciarVehiculosHorizontal()
    {
            new SwingWorker<Void, Void>()
            {
                @Override
                protected Void doInBackground() throws Exception
                {
                    int num = 10;
                    for (int i = 0; i < num; i++)
                    {
                        Random rand = new Random();
                        int numRand = rand.nextInt(3) + 1;
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/Carro" + numRand + ".PNG")).getImage().getScaledInstance(64, 64, 0);
                        JLabel carro = new JLabel(new ImageIcon(imagen));
                        carro.setBounds(840, 222, 64, 64);
                        SwingUtilities.invokeLater(() -> panelCentral.add(carro));
                        new CarrosHorizontalInicio(carro, panelCentral, 222, VentanaInicio.this).start();

                        Thread.sleep(3000);
                    }
                    return null;
                }
            }.execute();
        
    }
}
