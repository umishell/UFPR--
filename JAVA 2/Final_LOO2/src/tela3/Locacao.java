package tela3;

import java.util.Calendar;

import tela1.Cliente;

public class Locacao {

    int dias;
    double valor;
    Calendar data;
    Cliente cliente;

    public Locacao(int dias, double valor, Calendar data, Cliente cliente) {
        this.dias = dias;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public int getDias() {
        return dias;
    }

    public double getValor() {
        return valor;
    }

    public Calendar getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

}