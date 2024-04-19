package tela2;

import tela3.Locacao;
import java.util.Calendar;

import tela1.Cliente;

public class Automovel extends Veiculo {

    private ModeloAutomovel modelo;

    public Automovel(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloAutomovel a) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        modelo = a;
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        super.setEstado(Estado.LOCADO);
        super.setLocacao(new Locacao(dias, this.getValorDiariaLocacao(), data, cliente));

    }

    @Override
    public double getValorDiariaLocacao() {
        switch (this.getCategoria().name()) {
            case "POPULAR" -> {
                return 100;
            }
            case "INTERMEDIARIO" -> {
                return 300;
            }
            case "LUXO" -> {
                return 450;
            }
        }
        return 0;
    }

}