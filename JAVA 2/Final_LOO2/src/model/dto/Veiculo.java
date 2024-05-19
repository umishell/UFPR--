package model.dto;

import java.util.Calendar;

public abstract class Veiculo implements VeiculoInterface {

    private String marca;
    private String estado;
    private Locacao locacao;
    private String categoria;
    private double valorDeCompra;
    private String placa;
    private int ano;

    public Veiculo(String marca, String estado, Locacao locacao, String categoria, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    ////@Override
    //public abstract double getValorDiariaLocacao();

    @Override
    public double getValorParaVenda(){
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
    public Locacao getLocacao() {
        return locacao;
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
