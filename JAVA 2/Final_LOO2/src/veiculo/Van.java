package veiculo;

import clienteLocacao.Locacao;
import java.util.Calendar;

import cliente.Cliente;

public class Van extends Veiculo {

    private ModeloVan modelo;

    public Van(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloVan v) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        modelo = v;
    }

    public ModeloVan getModelo() {
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
                return 200;
            }
            case "INTERMEDIARIO" -> {
                return 400;
            }
            case "LUXO" -> {
                return 600;
            }
        }
        return 0;
    }
}
