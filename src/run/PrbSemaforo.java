/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package run;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import vista.VentanaInicio;

/**
 *
 * @author osval
 */
public class PrbSemaforo
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            try
            {
                VentanaInicio ventana = new VentanaInicio();
                ventana.setVisible(true);
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error al iniciar el porgrama.");
            }
        });
    }
    
}
