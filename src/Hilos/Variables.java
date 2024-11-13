/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

/**
 *
 * @author osval
 */
public class Variables
{
    private static int estadoSemáforoVertical;
    private static int estadoSemáforoHorizontal;
    private static int vehiculosEnVertical = 0;
    private static int vehiculosEnHorizontal = 0;

    /**
     * @return the estadoSemáforoVertical
     */
    public static int getEstadoSemáforoVertical()
    {
        return estadoSemáforoVertical;
    }

    /**
     * @param aEstadoSemáforoVertical the estadoSemáforoVertical to set
     */
    public static void setEstadoSemáforoVertical(int aEstadoSemáforoVertical)
    {
        estadoSemáforoVertical = aEstadoSemáforoVertical;
    }

    /**
     * @return the estadoSemáforoHorizontal
     */
    public static int getEstadoSemáforoHorizontal()
    {
        return estadoSemáforoHorizontal;
    }

    /**
     * @param aEstadoSemáforoHorizontal the estadoSemáforoHorizontal to set
     */
    public static void setEstadoSemáforoHorizontal(int aEstadoSemáforoHorizontal)
    {
        estadoSemáforoHorizontal = aEstadoSemáforoHorizontal;
    }

    /**
     * @return the vehiculosEnVertical
     */
    public static int getVehiculosEnVertical()
    {
        return vehiculosEnVertical;
    }

    /**
     * @param aVehiculosEnVertical the vehiculosEnVertical to set
     */
    public static void setVehiculosEnVertical(int aVehiculosEnVertical)
    {
        vehiculosEnVertical = aVehiculosEnVertical;
    }

    /**
     * @return the vehiculosEnHorizontal
     */
    public static int getVehiculosEnHorizontal()
    {
        return vehiculosEnHorizontal;
    }

    /**
     * @param aVehiculosEnHorizontal the vehiculosEnHorizontal to set
     */
    public static void setVehiculosEnHorizontal(int aVehiculosEnHorizontal)
    {
        vehiculosEnHorizontal = aVehiculosEnHorizontal;
    }
}
