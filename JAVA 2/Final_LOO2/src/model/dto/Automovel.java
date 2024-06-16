package model.dto;

import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Automovel{" + "modelo=" + modelo + '}';
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void setEstadoLocado() {
        super.setEstado("locado");
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

    public double getValorDiariaLocacao(String categoria) {

        switch (categoria) {
            case "Popular" -> {
                return 70;
            }
            case "Intermediario" -> {
                return 200;
            }
            case "Luxo" -> {
                return 350;
            }
        }
        return 0;
    }

}
