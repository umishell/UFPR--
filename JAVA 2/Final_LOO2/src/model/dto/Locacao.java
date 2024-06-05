package model.dto;

import java.time.LocalDate;

public class Locacao {

    private boolean active;
    private int dias;
    private double valor;
    private final LocalDate date;
    private final int idCliente;
    private final int idVeiculo;

    public Locacao(int dias, double valor, LocalDate date, int idCliente, int idVeiculo) {
        active = true;
        this.dias = dias;
        this.valor = valor;
        this.date = date;
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
