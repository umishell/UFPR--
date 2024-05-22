package model.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Veiculo implements VeiculoInterface {

    private String marca;
    private String estado;
    private ArrayList<Locacao> locacoes;
    private String categoria;
    private double valorDeCompra;
    private String placa;
    private int ano;

    public Veiculo(String marca, String estado, ArrayList<Locacao> locacoes, String categoria, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.locacoes = locacoes;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    ////@Override
    //public abstract double getValorDiariaLocacao();
    @Override
    public double getValorParaVenda() {
        return 0;
    }

    @Override
    public abstract void devolver();

    @Override
    public abstract void vender();

    @Override
    public abstract void locar(int dias, Calendar data, Cliente cliente);

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public int getAno() {
        return ano;
    }

    public double getValorDeCompra() {
        return valorDeCompra;
    }

}
