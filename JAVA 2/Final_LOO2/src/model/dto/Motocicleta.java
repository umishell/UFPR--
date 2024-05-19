package model.dto;

import java.util.Calendar;

public class Motocicleta extends Veiculo {

    private String modelo;

    public Motocicleta(String marca, String estado, Locacao locacao, String categoria, double valorDeCompra, String placa, int ano, String m) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        modelo = m;
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


/*
@Override
public double getValorDiariaLocacao(){
        
        switch () {
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
 */
}