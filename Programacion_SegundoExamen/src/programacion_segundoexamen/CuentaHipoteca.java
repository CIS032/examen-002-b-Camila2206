/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_segundoexamen;

import javax.swing.JOptionPane;

/**
 *
 * @author Camila Cueva
 */
public class CuentaHipoteca extends Cuenta{
    
    int depositos = 0;
    int meses = 0;

    public CuentaHipoteca(String cliente) {
        super(cliente);
    }
    
    public CuentaHipoteca() {
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getDepositos() {
        return depositos;
    }

    public void setDepositos(int depositos) {
        this.depositos = depositos;
    }

    public CuentaHipoteca(String cliente, String tipoCliente, double balance, double tasaInteres) {
        super(cliente, tipoCliente, balance, tasaInteres);
    }

    @Override
    public double calcularInteres(int meses) {
        return meses * this.getTasaInteres();
    }

    @Override
    public double depositar(double monto) {
        double total = monto + this.getBalance();
        this.setBalance(total);
        return total;
    }

    public void depositarTazaInteres() {
        if (depositos == meses) {
            JOptionPane.showMessageDialog(null, "Fin del Prestamo", "Prestamo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (depositos <= 12 && this.getTipoCliente().equalsIgnoreCase("Empresa")) {
                depositos++;
                double pagar = this.getBalance() / meses;
                JOptionPane.showMessageDialog(null, "Valor a Pagar"+pagar,"Deposito Realizado "+getDepositos(), JOptionPane.INFORMATION_MESSAGE);
                
            } else if (depositos > 12 && this.getTipoCliente().equalsIgnoreCase("Empresa")) {
                depositos++;
                double pagar = this.getBalance() / meses + calcularInteres(meses);
                JOptionPane.showMessageDialog(null, "Valor a Pagar"+pagar, "Deposito Realizado "+getDepositos(), JOptionPane.INFORMATION_MESSAGE);
                
            }
            if (depositos <= 12 && this.getTipoCliente().equalsIgnoreCase("Natural")) {
                depositos++;
                double pagar = this.getBalance() / meses;
                JOptionPane.showMessageDialog(null,"Valor a Pagar"+pagar, "Deposito Realizado "+getDepositos(), JOptionPane.INFORMATION_MESSAGE);
                
            } else if (depositos > 12 && this.getTipoCliente().equalsIgnoreCase("Natural")) {
                depositos++;
                double pagar = this.getBalance() / meses + (calcularInteres(meses) / 2);
                JOptionPane.showMessageDialog(null, "Valor a Pagar"+pagar, "Deposito Realizado "+getDepositos(), JOptionPane.INFORMATION_MESSAGE);
                
            }
        }

    }
}
