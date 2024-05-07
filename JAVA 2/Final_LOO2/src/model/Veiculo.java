package model;

import model.Locacao;
import model.enums.Categoria;
import model.enums.Categoria;
import model.enums.Estado;
import model.enums.Estado;
import model.enums.Marca;
import model.enums.Marca;

public abstract class Veiculo implements VeiculoInterface {

    private Marca marca;
    private Estado estado;

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    private Locacao locacao;
    private Categoria categoria;
    private double valorDeCompra;

    public double getValorDeCompra() {
        return valorDeCompra;
    }
    private String placa;
    private int ano;

    public Veiculo(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
        this.categoria = categoria;
        this.valorDeCompra = valorDeCompra;
        this.placa = placa;
        this.ano = ano;
    }

    @Override
    public void vender() {
        if (this.estado == Estado.DISPONIVEL) {
            this.estado = Estado.VENDIDO;
        }

    }

    @Override
    public void devolver() {
        this.locacao = null;
    }

    @Override
    public double getValorParaVenda() {
        return 0;
    }

    @Override
    public abstract double getValorDiariaLocacao();

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    @Override
    public Locacao getLocacao() {
        return locacao;
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }

    @Override
    public Categoria getCategoria() {
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

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setCategoria(Categoria categoria) {
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

}
