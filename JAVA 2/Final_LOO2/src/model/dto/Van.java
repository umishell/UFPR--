package model.dto;

import java.util.ArrayList;
import java.util.Calendar;

public class Van extends Veiculo {

    private String modelo;

    public Van(String marca, String categoria,
            double valorDeCompra, String placa, int ano, String modelo) {
        super("Van", marca, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public Van(int id, String tipo, String marca, String estado, ArrayList<Locacao> locacoes, String categoria,
            double valorDeCompra, String placa, int ano, String modelo) {
        super(id, tipo, marca, estado, locacoes, categoria, valorDeCompra, placa, ano);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
