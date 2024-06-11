package model.dto;

import java.util.ArrayList;
import java.util.Calendar;

public class Automovel extends Veiculo {

    private String modelo;

    public Automovel(String marca, String categoria,
            double valorDeCompra, String placa, int ano, String modelo) {
        super("Automovel", marca, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public Automovel(int id, String tipo, String marca, String estado, ArrayList<Locacao> locacoes, String categoria,
            double valorDeCompra, String placa, int ano, String modelo) {
        super(id, tipo, marca, estado, locacoes, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public void to_String() {
        System.out.println("id " + this.getIdveiculo()
                + "\nano " + this.getAno()
                + "\nvalorDeCompra " + this.getValorDeCompra()
                + "\ncategoria " + this.getCategoria()
                + "\nestado " + this.getEstado()
                + "\ntipo " + this.getTipo()
                + "\nplaca " + this.getPlaca()
                + "\nmodelo " + this.getModelo()
                + "\n marca " + this.getMarca());
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        // super.setEstado("locado");
        //super.setLocacao(new Locacao(dias, this.getValorDiariaLocacao(), data, cliente));

    }

    @Override
    public void devolver() {

    }

    @Override
    public void vender() {
        //if (this.estado == Estado.DISPONIVEL) {
        //  this.estado = Estado.VENDIDO;
        //}
    }

    public double getValorDiariaLocacao(String s) {

        switch (s) {
            case "popular" -> {
                return 70;
            }
            case "intermediario" -> {
                return 200;
            }
            case "luxo" -> {
                return 350;
            }
        }
        return 0;
    }

}
