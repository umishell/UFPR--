package model.dto;

import model.dto.Locacao;
import java.util.Calendar;

import model.dto.Cliente;
import model.enums.Categoria;
import model.enums.Categoria;
import model.enums.Estado;
import model.enums.Estado;
import model.enums.Marca;
import model.enums.Marca;
import model.enums.ModeloMotocicleta;
import model.enums.ModeloMotocicleta;

public class Motocicleta extends Veiculo {

    private ModeloMotocicleta modelo;

    public Motocicleta(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valorDeCompra, String placa, int ano, ModeloMotocicleta m) {
        super(marca, estado, locacao, categoria, valorDeCompra, placa, ano);
        modelo = m;
    }

    public ModeloMotocicleta getModelo() {
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
                return 70;
            }
            case "INTERMEDIARIO" -> {
                return 200;
            }
            case "LUXO" -> {
                return 350;
            }
        }
        return 0;
    }

}