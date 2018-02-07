/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_segundoexamen;

/**
 *
 * @author Camila Cueva
 */
public class CuentaPrestamo extends Cuenta{
    
    public CuentaPrestamo(String cliente) {
        super(cliente);
    }
    
    public CuentaPrestamo(String cliente, String tipoCliente, double balance, double tasaInteres) {
        super(cliente, tipoCliente, balance, tasaInteres);
    }
    
    @Override
    public double calcularInteres(int meses) {
        return meses * this.getTasaInteres();
    }

    @Override
    public double depositar(double monto) {
        double total=monto + this.getBalance();
        this.setBalance(total);
        return total;
    }
}
