/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vista.VentanaPrincipal;

/**
 *
 * @author osval
 */
public class CarrosHorizontal extends Thread
{

    private JLabel contenedor;
    private JPanel panelCentral;
    JFrame ventana;
    private boolean ejecutandose = true;
    private int y;

    public CarrosHorizontal(JLabel contenedor, JPanel panelCentral, int y, JFrame ventana)
    {
        this.contenedor = contenedor;
        this.y = y;
        this.panelCentral = panelCentral;
        this.ventana = ventana;
    }

    @Override
    public synchronized void run()
    {
        int x = 864;
        while (isEjecutandose())
        {
            x -= 5;
            getContenedor().setBounds(x, getY(), getContenedor().getWidth(), getContenedor().getHeight());
            getContenedor().repaint();
            try
            {
                Thread.sleep(50);
            } catch (Exception e)
            {
                System.out.println("Error...");
            }

            if (x <= -40)
            {
                setEjecutandose(false);
            }

            if (Variables.getEstadoSemáforoHorizontal() == 2 && x >= 650)
            {
                while (Variables.getEstadoSemáforoHorizontal() == 2 && x >= 650)
                {
                    x -= 5;
                    getContenedor().setBounds(x, getY(), getContenedor().getWidth(), getContenedor().getHeight());
                    getContenedor().repaint();
                    try
                    {
                        Thread.sleep(50);
                    } catch (InterruptedException ex)
                    {
                        System.out.println("Error");
                    }
                }
                while (Variables.getEstadoSemáforoHorizontal() == 2)
                {
                    try
                    {
                        Thread.sleep(50);
                    } catch (InterruptedException ex)
                    {
                        System.out.println("Error");
                    }
                }
            }

            while (Variables.getEstadoSemáforoHorizontal() == 0 && x >= 600)
            {
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException ex)
                {
                    System.out.println("Error");
                }
            }
        }
        ((VentanaPrincipal) ventana).actualizaContadorHorizontal();
        getPanelCentral().remove(contenedor);
        getPanelCentral().repaint();
    }

    /**
     * @return the contenedor
     */
    public JLabel getContenedor()
    {
        return contenedor;
    }

    /**
     * @param contenedor the contenedor to set
     */
    public void setContenedor(JLabel contenedor)
    {
        this.contenedor = contenedor;
    }

    /**
     * @return the ejecutandose
     */
    public boolean isEjecutandose()
    {
        return ejecutandose;
    }

    /**
     * @param ejecutandose the ejecutandose to set
     */
    public void setEjecutandose(boolean ejecutandose)
    {
        this.ejecutandose = ejecutandose;
    }

    /**
     * @return the y
     */
    public int getY()
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * @return the panelCentral
     */
    public JPanel getPanelCentral()
    {
        return panelCentral;
    }

    /**
     * @param panelCentral the panelCentral to set
     */
    public void setPanelCentral(JPanel panelCentral)
    {
        this.panelCentral = panelCentral;
    }
}
