/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelsistema;

import javax.swing.JOptionPane;

/**
 *
 * @author sanlo
 */
public class Habitaciones {

    private String[][] numeroHabitacion = new String[3][4];//3 pisos con 4 habitaciones cada uno
    private String[][] tipoHabitacion = new String[3][4];//Para poner los tipos de habitacion
    private double[][] precio = new double[3][4];//Para poner los precios
    private String[][] estado = new String[3][4];//Para poner los estados

    public Habitaciones() {
        precargarHabitaciones();
    }

    private void precargarHabitaciones() {
        for (int i = 0; i < numeroHabitacion.length; i++) {
            for (int j = 0; j < numeroHabitacion[i].length; j++) {
                numeroHabitacion[i][j] = ((i + 1) + (j + 1)) + ""; //Los numeros de las habitaciones

                if (i == 0) {//Tipo y precio segun piso
                    tipoHabitacion[i][j] = "Simple";
                    precio[i][j] = 30000;
                } else if (i == 1) {
                    tipoHabitacion[i][j] = "Doble";
                    precio[i][j] = 50000;
                } else {
                    tipoHabitacion[i][j] = "VIP";
                    precio[i][j] = 80000;
                }

                estado[i][j] = "Libre";//Iniciar todas como libre
            }
        }
    }

    public void mostrarEstadoHabitaciones() {
        String mensaje = "Habitaciones del Hotel Patitos\n\n";

        for (int i = 0; i < numeroHabitacion.length; i++) {
            mensaje += "Piso " + (i + 1) + ":\n"; //Muestra el numero de habitacion
            for (int j = 0; j < numeroHabitacion[i].length; j++) { //Muestra info habitacion
                mensaje += "Habitación: " + numeroHabitacion[i][j] + " Tipo: " + tipoHabitacion[i][j] + "Precio: " + precio[i][j] + " Estado: " + estado[i][j] + "\n";
            }
            mensaje += "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void reservarHabitacion() {
        int pisoIngresado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del piso:"));//Ingresar piso y habitacion
        int habitacionIngresada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la habitacion:"));

        int fila = pisoIngresado - 1; //Para que no de error se le resta 1
        int columna = habitacionIngresada - 1;

        if (fila >= 0 && fila < numeroHabitacion.length && columna >= 0 && columna < numeroHabitacion[0].length) {
            if (estado[fila][columna].equalsIgnoreCase("Libre") || estado[fila][columna].equalsIgnoreCase("Sucia") || estado[fila][columna].equalsIgnoreCase("Ocupada")) {
                estado[fila][columna] = "Ocupada";//Para poder poner ocupado
                JOptionPane.showMessageDialog(null, " Se asigno esta habitacion " + numeroHabitacion[fila][columna]);
            } else {
                JOptionPane.showMessageDialog(null, "Este piso o habitacion no existe");
            }
        }
    }

    public void limpiarHabitacion() {
        int pisoIngresado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del piso: ")); //Poner piso y habitacion
        int habitacionIngresada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la habitación: "));
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 para marcar limpio y 2 para marcar que está sucio: "));

        int fila = pisoIngresado - 1; // Para que no dé error se le resta 1 como en la matriz
        int columna = habitacionIngresada - 1;

        if (fila >= 0 && fila < numeroHabitacion.length && columna >= 0 && columna < numeroHabitacion[0].length) {
            switch (opcion) { //Elegir si poner limpio o sucio
                case 1:
                    if (estado[fila][columna].equalsIgnoreCase("Libre") || estado[fila][columna].equalsIgnoreCase("Sucia") || estado[fila][columna].equalsIgnoreCase("Ocupada")) {
                        estado[fila][columna] = "Limpia"; //Para poner como limpio
                        JOptionPane.showMessageDialog(null, "Marco la habitacion como limpia");
                    }
                    break;
                case 2:
                    if (estado[fila][columna].equalsIgnoreCase("Libre") || estado[fila][columna].equalsIgnoreCase("Sucia") || estado[fila][columna].equalsIgnoreCase("Ocupada")) {
                        estado[fila][columna] = "Sucia";//Para poner como sucio
                        JOptionPane.showMessageDialog(null, "La habitación fue marcada como sucia");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Piso o habitación fuera de rango.");
        }
    }

    public void cambiarPrecio() {
        int precioNuevo = 0;
        int pisoIngresado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del piso:"));//Ingresar piso y habitacion
        int habitacionIngresada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la habitacion:"));

        int fila = pisoIngresado - 1; //Para que no de error se le resta 1
        int columna = habitacionIngresada - 1;

        if (fila >= 0 && fila < numeroHabitacion.length && columna >= 0 && columna < numeroHabitacion[0].length) {
            if (estado[fila][columna].equalsIgnoreCase("Libre") || estado[fila][columna].equalsIgnoreCase("Sucia") || estado[fila][columna].equalsIgnoreCase("Limpia")) {
                precioNuevo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
                precio[fila][columna] = precioNuevo;//Para poder cambiar el precio

            } else {
                JOptionPane.showMessageDialog(null, "Este piso o habitacion no existe");
            }
        }
    }

    public void resumen() { //Intenta contar

        int contadorLibres = 0;
        int contadorOcupadas = 0;
        int contadorSucio = 0;

        for (int i = 0; i < numeroHabitacion.length; i++) {
            for (int j = 0; j < numeroHabitacion.length; j++) {
                if (estado[i][j].equalsIgnoreCase("Libre")) {
                    contadorLibres++;
                    break;
                }

            }

        }
        for (int i = 0; i < numeroHabitacion.length; i++) {
            for (int j = 0; j < numeroHabitacion.length; j++) {
                if (estado[i][j].equalsIgnoreCase("Ocupada")) {
                    contadorOcupadas++;
                    break;
                }

            }

        }
        for (int i = 0; i < numeroHabitacion.length; i++) {
            for (int j = 0; j < numeroHabitacion.length; j++) {
                if (estado[i][j].equalsIgnoreCase("Sucia")) {
                    contadorSucio++;
                    break;
                }

            }
        }
        String resumen = "Habitaciones Libres: " + contadorLibres + "\n\n" + "Habitaciones ocupadas: " + contadorOcupadas + "\n\n" + "Habitaciones sucias: " + contadorSucio;

        JOptionPane.showMessageDialog(null, resumen);
    }
}
