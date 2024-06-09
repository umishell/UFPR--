package model.dto;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Veiculo implements VeiculoInterface {

    private int idveiculo;
    private String tipo;
    private String marca;
    private String estado;
    private ArrayList<Locacao> locacoes;
    private String categoria;
    private double valorDeCompra;
    private String placa;
    private int ano;

    public Veiculo(String tipo,String marca, String categoria, double valorDeCompra, String placa, int ano) {
        this.idveiculo = -1;
        this.tipo = tipo;
        this.marca = marca;
        this.estado = "disponivel";
        this.locacoes = new ArrayList<Locacao>();
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    public Veiculo(int id, String tipo, String marca, String estado, ArrayList<Locacao> locacoes, String categoria, double valorDeCompra, String placa, int ano) {
        idveiculo = id;
        this.tipo = tipo;
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

    public int getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setValorDeCompra(double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
