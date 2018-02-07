/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_segundoexamen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Cueva
 */
public class Banco {

    static ArrayList<Cuenta> listaCuenta = new ArrayList<Cuenta>();
    static String archivo = "Cuentas.csv";

    public static void agregar(Cuenta cuenta) {
        listaCuenta.add(cuenta);
    }

    public static void grabar() {
        PrintWriter pw = null;
        try {
            // Examen002: La ruta y el nombre del 'archivo' debe ser 
            // establecido dinamicamente por el usuario en el lugar adecuado
            FileWriter fw = new FileWriter(archivo, true);
            pw = new PrintWriter(fw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (Cuenta cuenta : listaCuenta) {
            String linea = "";
            if (cuenta instanceof CuentaAhorro) {
                linea = "Cuenta Ahorro" + ";" + cuenta.toString();
            }
            if (cuenta instanceof CuentaHipoteca) {
                linea = "Cuenta Hipoteca" + ";" + cuenta.toString();
            }
            if (cuenta instanceof CuentaPrestamo) {
                linea = "Cuenta Prestamo" + ";" + cuenta.toString();
            }
            pw.println(linea);
        }
        pw.close();
    }

    public static Cuenta buscarCuentaAhorro() {
        String nombre = (JOptionPane.showInputDialog(null, "Ingrese nombre", "Verificar Cuenta", JOptionPane.INFORMATION_MESSAGE));
        CuentaAhorro cuentaAH = new CuentaAhorro(nombre);
        Cuenta c = (Cuenta) cuentaAH;
        if (listaCuenta.contains(c)) {
            return listaCuenta.get(listaCuenta.indexOf(c));
        }
        return null;
    }

    public static Cuenta buscarCuentaHipoteca() {
        String nombre = (JOptionPane.showInputDialog(null, "Ingrese nombre", "Verificar Cuenta", JOptionPane.INFORMATION_MESSAGE));
        CuentaHipoteca cuentaAH = new CuentaHipoteca(nombre);
        Cuenta c = (Cuenta) cuentaAH;
        if (listaCuenta.contains(c)) {
            return listaCuenta.get(listaCuenta.indexOf(c));
        }
        return null;
    }

    public static void leerCuentas() {

        try {
            FileReader archivo = new FileReader("cuenta.csv");
            BufferedReader leer = new BufferedReader(archivo);
            String linea = leer.readLine();
            String usuario[];
            while ((linea = leer.readLine()) != null) {
                usuario = linea.split(";");
                Cuenta us = new Cuenta(linea) {
                    @Override
                    public double calcularInteres(int meses) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public double depositar(double monto) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };

                listaCuenta.add(us);
            }
            leer.close();
            archivo.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }

    }

}
