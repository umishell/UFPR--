
package model.dto;

import java.time.LocalDate;


public class Venda {
    
    private int idveiculo;
    private int idcliente;
    private LocalDate localDate;

    public int getIdveiculo() {
        return idveiculo;
    }

    public Venda(int idveiculo, int idcliente, LocalDate localDate) {
        this.idveiculo = idveiculo;
        this.idcliente = idcliente;
        this.localDate = localDate;
    }

    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    
}
