/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.CarrosHorizontal;
import controlador.CarrosVertical;
import controlador.PanelConImagen;
import controlador.Variables;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author osval
 */
public class VentanaPrincipal extends JFrame
{

    JButton botonCerrar, botonMinimizar, botonComenzar;
    JPanel panelNorte, panelSur;
    PanelConImagen panelCentral;
    JLabel textoVehiculosVertical, textoVehiculosHorizontal, contadorVertical, contadorHorizontal, semaforoHorizontal, semaforoVertical, txtsemaforoHorizontal, txtsemaforoVertical;
    GridBagConstraints restricciones;
    Image fondo;
    Timer timerSemaforo, timerContadores;

    public VentanaPrincipal()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/IconoPrograma.png")));
        this.setSize(850, 650);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setBackground(Color.GRAY);

        this.setUndecorated(true);

        fondo = new ImageIcon(getClass().getResource("/imagenes/Calle.JPEG")).getImage();

        componentes();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {
                actualizarSemaforoHorizontal();
                actualizarSemaforoVertical();
                Variables.setVehiculosEnVertical(solicitarVehiculos("vertical"));
                if (Variables.getVehiculosEnVertical() != 0)
                {
                    Variables.setVehiculosEnHorizontal(solicitarVehiculos("horizontal"));
                    contadorVertical.setText(String.valueOf(Variables.getVehiculosEnVertical()));
                    contadorHorizontal.setText(String.valueOf(Variables.getVehiculosEnHorizontal()));
                }
            }
        });
    }

    public int solicitarVehiculos(String orientacion)
    {
        int num = 0;

        boolean esNumeroValido = false;
        String validarNumeros = "^[1-9][0-9]*$";
        Pattern patron = Pattern.compile(validarNumeros);

        while (!esNumeroValido)
        {
            String entrada = JOptionPane.showInputDialog(null, "Introduzca el número de carros en " + orientacion);

            if (entrada == null)
            {
                JOptionPane.showMessageDialog(null, "Operación cancelada");
                VentanaInicio ventana = new VentanaInicio();
                ventana.setVisible(true);
                dispose();
                return 0;
            } else
            {
                Matcher matcher = patron.matcher(entrada);
                if (matcher.matches())
                {
                    esNumeroValido = true;
                    num = Integer.valueOf(entrada);
                } else
                {
                    JOptionPane.showMessageDialog(null, "Entrada no válida. Vuelva a intentarlo.");
                }
            }
        }

        return num;
    }

    public void componentes()
    {
        this.add(componentesPanelNorte(), BorderLayout.NORTH);
        this.add(componentesPanelCentral(), BorderLayout.CENTER);
        this.add(componentesPanelSur(), BorderLayout.SOUTH);
        Border margen = new EmptyBorder(0, 0, 0, 0);
        Border bordeColor = new LineBorder(Color.decode("#051d40"), 5); 
        this.getRootPane().setBorder(BorderFactory.createCompoundBorder(bordeColor, margen));
    }

    public JPanel componentesPanelNorte()
    {
        panelNorte = new JPanel();

        panelNorte.setBackground(Color.decode("#051d40"));
        panelNorte.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        botonCerrar = new JButton("x");
        botonCerrar.setBackground(Color.decode("#cc0c0c"));
        botonCerrar.setForeground(Color.WHITE);
        botonCerrar.setFocusPainted(false); 

        botonCerrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        botonMinimizar = new JButton("-");
        botonMinimizar.setBackground(Color.decode("#eee41a"));
        botonMinimizar.setForeground(Color.decode("#151515"));
        botonMinimizar.setFocusPainted(false); 

        botonMinimizar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setState(JFrame.ICONIFIED);
            }
        });

        panelNorte.add(botonMinimizar);
        panelNorte.add(botonCerrar);

        return panelNorte;
    }

    public JPanel componentesPanelSur()
    {
        panelSur = new JPanel(new GridBagLayout());
        panelSur.setBackground(Color.decode("#fdf8f0"));
        panelSur.setPreferredSize(new Dimension(850, 100));
        
        Border margen = new EmptyBorder(0, 0,0, 0);
        Border bordeColor = new LineBorder(Color.decode("#051d40"), 2); 
        panelSur.setBorder(BorderFactory.createCompoundBorder(bordeColor, margen));

        restricciones = new GridBagConstraints();
        textoVehiculosVertical = new JLabel("Vehículos vertical: ");
        textoVehiculosVertical.setFont(new Font("Arial", Font.PLAIN, 20));
        textoVehiculosVertical.setForeground(Color.decode("#051d40"));
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.insets = new Insets(0, 20, 0, 20);
        panelSur.add(textoVehiculosVertical, restricciones);

        contadorVertical = new JLabel("0");
        contadorVertical.setFont(new Font("Arial", Font.PLAIN, 20));
        contadorVertical.setForeground(Color.decode("#051d40"));
        restricciones.gridx = 1;
        panelSur.add(contadorVertical, restricciones);

        textoVehiculosHorizontal = new JLabel("Vehículos en horizontal: ");
        textoVehiculosHorizontal.setFont(new Font("Arial", Font.PLAIN, 20));
        textoVehiculosHorizontal.setForeground(Color.decode("#051d40"));
        restricciones.gridx = 2;
        panelSur.add(textoVehiculosHorizontal, restricciones);

        contadorHorizontal = new JLabel("0");
        contadorHorizontal.setFont(new Font("Arial", Font.PLAIN, 20));
        contadorHorizontal.setForeground(Color.decode("#051d40"));
        restricciones.gridx = 3;
        panelSur.add(contadorHorizontal, restricciones);

        botonComenzar = new JButton("Comenzar");
        botonComenzar.setFont(new Font("Arial", Font.BOLD, 20));
        botonComenzar.setBackground(Color.decode("#051d40"));
        botonComenzar.setForeground(Color.decode("#fdf8f0"));
        botonComenzar.setFocusPainted(false); 
        restricciones.gridx = 4;

        botonComenzar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                botonComenzar.setEnabled(false);
                iniciarVehiculosHorizontal();
                iniciarVehiculosVertical();
                configurarSemaforoHorizontal();
                configurarSemaforoVertical();
                comprobarContadores();
            }
        });
        panelSur.add(botonComenzar, restricciones);

        return panelSur;
    }

    public JPanel componentesPanelCentral()
    {
        panelCentral = new PanelConImagen("/imagenes/Calle.JPEG");
        panelCentral.setLayout(null);

        semaforoHorizontal = new JLabel();
        semaforoHorizontal.setBounds(100, 50, 128, 128);
        txtsemaforoHorizontal = new JLabel("Horizontal");
        txtsemaforoHorizontal.setBounds(129, 6, 80, 64);
        txtsemaforoHorizontal.setFont(new Font("Arial", Font.BOLD, 14));
        txtsemaforoHorizontal.setForeground(Color.decode("#051d40"));
        
        panelCentral.add(semaforoHorizontal);
        panelCentral.add(txtsemaforoHorizontal);

        semaforoVertical = new JLabel();
        semaforoVertical.setBounds(523, 325, 128, 128);
        txtsemaforoVertical = new JLabel("Vertical");
        txtsemaforoVertical.setBounds(561, 432, 80, 64);
        txtsemaforoVertical.setFont(new Font("Arial", Font.BOLD, 14));
        txtsemaforoVertical.setForeground(Color.decode("#051d40"));

        panelCentral.add(semaforoVertical);
        panelCentral.add(txtsemaforoVertical);

        return panelCentral;
    }

    public void iniciarVehiculosHorizontal()
    {
        if (Variables.getVehiculosEnHorizontal() == 0)
        {
            JOptionPane.showMessageDialog(null, "No hay vehículos en horizontal");
            VentanaInicio ventana = new VentanaInicio();
            ventana.setVisible(true);
            dispose();
        } else
        {
            new SwingWorker<Void, Void>()
            {
                @Override
                protected Void doInBackground() throws Exception
                {
                    int num = Variables.getVehiculosEnHorizontal();
                    for (int i = 0; i < num; i++)
                    {
                        Random rand = new Random();
                        int numRand = rand.nextInt(3) + 1;
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/Carro" + numRand + ".PNG")).getImage().getScaledInstance(64, 64, 0);
                        JLabel carro = new JLabel(new ImageIcon(imagen));
                        carro.setBounds(840, 222, 64, 64);
                        SwingUtilities.invokeLater(() -> panelCentral.add(carro));
                        new CarrosHorizontal(carro, panelCentral, 222, VentanaPrincipal.this).start();

                        while (Variables.getEstadoSemáforoHorizontal() == 0)
                        {
                            Thread.sleep(50);
                        }
                        Thread.sleep(3000);

                    }
                    return null;
                }
            }.execute();
        }
    }
    
    public void iniciarVehiculosVertical()
    {
        if (Variables.getVehiculosEnVertical()== 0)
        {
            JOptionPane.showMessageDialog(null, "No hay vehículos en horizontal");
            VentanaInicio ventana = new VentanaInicio();
            ventana.setVisible(true);
            dispose();
        } else
        {
            new SwingWorker<Void, Void>()
            {
                @Override
                protected Void doInBackground() throws Exception
                {
                    int num = Variables.getVehiculosEnVertical();
                    for (int i = 0; i < num; i++)
                    {
                        Random rand = new Random();
                        int numRand = rand.nextInt(4) + 1;
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/CarroV" + numRand + ".PNG")).getImage().getScaledInstance(64, 64, 0);
                        JLabel carro = new JLabel(new ImageIcon(imagen));
                        carro.setBounds(390, -20, 64, 64);
                        SwingUtilities.invokeLater(() -> panelCentral.add(carro));
                        new CarrosVertical(carro, panelCentral, VentanaPrincipal.this, 390).start();

                        while (Variables.getEstadoSemáforoVertical()== 2)
                        {
                            Thread.sleep(50);
                        }
                        Thread.sleep(3000);

                    }
                    return null;
                }
            }.execute();
        }
    }

    public void actualizaContadorHorizontal()
    {
        Variables.setVehiculosEnHorizontal(Variables.getVehiculosEnHorizontal() - 1);
        contadorHorizontal.setText(String.valueOf(Variables.getVehiculosEnHorizontal()));
    }

    public void configurarSemaforoHorizontal()
    {
        timerSemaforo = new Timer(3010, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Variables.setEstadoSemáforoHorizontal((Variables.getEstadoSemáforoHorizontal() + 1) % 3);
                actualizarSemaforoHorizontal();
            }
        });
        timerSemaforo.start();
    }

    public void actualizarSemaforoHorizontal()
    {
        switch (Variables.getEstadoSemáforoHorizontal())
        {
            case 0:
                semaforoHorizontal.setIcon(new ImageIcon(getClass().getResource("/imagenes/Semaforo1.png")));
                break;
            case 1:
                semaforoHorizontal.setIcon(new ImageIcon(getClass().getResource("/imagenes/Semaforo3.png")));
                break;
            case 2:
                semaforoHorizontal.setIcon(new ImageIcon(getClass().getResource("/imagenes/Semaforo2.png")));
                break;
        }
    }

    public void actualizarSemaforoVertical()
    {
        switch (Variables.getEstadoSemáforoVertical())
        {
            case 0:
                semaforoVertical.setIcon(new ImageIcon(getClass().getResource("/imagenes/Semaforo3.png")));
                break;
            case 1:
                semaforoVertical.setIcon(new ImageIcon(getClass().getResource("/imagenes/Semaforo2.png")));
                break;
            case 2:
                semaforoVertical.setIcon(new ImageIcon(getClass().getResource("/imagenes/Semaforo1.png")));
                break;
        }
    }

    public void actualizaContadorVertical()
    {
        Variables.setVehiculosEnVertical(Variables.getVehiculosEnVertical() - 1);
        contadorVertical.setText(String.valueOf(Variables.getVehiculosEnVertical()));
    }

    public void configurarSemaforoVertical()
    {
        timerSemaforo = new Timer(3000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Variables.setEstadoSemáforoVertical((Variables.getEstadoSemáforoVertical() + 1) % 3);
                actualizarSemaforoVertical();
            }
        });
        timerSemaforo.start();
    }
    
    public void comprobarContadores()
    {
        timerContadores = new Timer(3000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (Variables.getVehiculosEnHorizontal() == 0 && Variables.getVehiculosEnVertical() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Gracias por usar este simulador. El programa se carrará.");
                    System.exit(0);
                }
            }
        });
        timerContadores.start();
    }
}
