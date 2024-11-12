/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vista.VentanaPrincipal;

/**
 *
 * @author osval
 */
public class CarrosVertical extends Thread
{

    private JLabel contenedor;
    private JLabel contadorVertical;
    private JFrame ventana;
    private JPanel panelCentral;
    private boolean ejecutandose = true;
    private int x;

    public CarrosVertical(JLabel contenedor, JPanel panelCentral, JFrame ventana, int x)
    {
        this.contenedor = contenedor;
        this.contadorVertical = contadorVertical;
        this.ventana = ventana;
        this.panelCentral = panelCentral;
        this.x = x;
    }

    @Override
    public void run()
    {
        int y = 0;
        while (isEjecutandose())
        {
            y += 5;
            getContenedor().setBounds(getX(), y, getContenedor().getWidth(), getContenedor().getHeight());
            getContenedor().repaint();

            try
            {
                Thread.sleep(50);
            } catch (Exception e)
            {
                System.out.println("Error...");
            }

            if (y <= -40)
            {
                setEjecutandose(false);
            }

            while (Variables.getEstadoSemáforoVertical() == 2 && y >= 150)
            {
                y += 5;
                getContenedor().setBounds(getX(), y, getContenedor().getWidth(), getContenedor().getHeight());
                getContenedor().repaint();
                try
                {
                    Thread.sleep(50);
                } catch (Exception e)
                {
                    System.out.println("Error");
                }
            }
            while (Variables.getEstadoSemáforoVertical()== 2)
            {
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException ex)
                {
                    System.out.println("Error");
                }
            }
            while (Variables.getEstadoSemáforoVertical()== 0 && getX() <= 150)
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
        ((VentanaPrincipal) getVentana()).actualizaContadorVertical();
        getPanelCentral().remove(getContenedor());
        getPanelCentral().repaint();
    }

    public void detener()
    {
        setEjecutandose(false);
    }
;

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
     * @return the contadorVertical
     */
    public JLabel getContadorVertical()
    {
        return contadorVertical;
    }

    /**
     * @param contadorVertical the contadorVertical to set
     */
    public void setContadorVertical(JLabel contadorVertical)
    {
        this.contadorVertical = contadorVertical;
    }

    /**
     * @return the ventana
     */
    public JFrame getVentana()
    {
        return ventana;
    }

    /**
     * @param ventana the ventana to set
     */
    public void setVentana(JFrame ventana)
    {
        this.ventana = ventana;
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
     * @return the x
     */
    public int getX()
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x)
    {
        this.x = x;
    }

}
