/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelsistema;

import javax.swing.JOptionPane;

/**
 *
 * @author sanlo
 */
public class HotelSistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Habitaciones hotel = new Habitaciones(); //Iniciar habitaciones

        int opcion;
        do {
            String menu = "Hotel Patitos \n\n"
                    + "1) Ver habitaciones\n"
                    + "2) Asignar una habitacion\n"
                    + "3) Habitacion limpia o sucia\n"
                    + "4) Cambiar precio\n"
                    + "5) Resumen\n"
                    + "6) Salir\n";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    hotel.mostrarEstadoHabitaciones();//Ver el estado inicial
                    break;
                case 2:
                    hotel.reservarHabitacion();//Asignar una habitación     
                    break;
                case 3:
                    hotel.limpiarHabitacion();//Poner si esta limpia o sucia
                    break;
                case 4:
                    hotel.cambiarPrecio(); //Cambiar precio
                    break;
                case 5:
                    hotel.resumen(); //resumen
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");//Salirse
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 6);
    }

}
