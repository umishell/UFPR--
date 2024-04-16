package shoppingCart_4;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final String nomeCliente;
    private final double valorTotalPermitido;
    private List<ItemDePedido> itens = new ArrayList<>();

    public Pedido(double valorTotalPermitido, String nomeCliente) {
        if (valorTotalPermitido <= 0) {
            throw new IllegalArgumentException("Cliente não tem nenhum crédito.");
        }

        this.valorTotalPermitido = valorTotalPermitido;
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<ItemDePedido> getItens() {
        return itens;
    }

    public void acrescentaItem(ItemDePedido itemDePedido) {
        if (itemDePedido == null) {
            throw new IllegalArgumentException("Item de Pedido não pode ser nulo.");
        }

        double novoValorTotal = getTotal() + itemDePedido.getValorTotal();
        if (novoValorTotal > valorTotalPermitido) {
            throw new IllegalArgumentException("Item de Pedido não incluído. Valor do pedido excedido.");
        }

        itens.removeIf(item -> item.getProduto().getNome().equals(itemDePedido.getProduto().getNome()));
        itens.add(itemDePedido);
    }

    public void retiraItem(String nomeProduto) {
        itens.removeIf(item -> item.getProduto().getNome().equals(nomeProduto));

        if (itens.isEmpty()) {
            throw new IllegalArgumentException("Item não encontrado no pedido.");
        }
    }

    public double getTotal() {
        return itens.stream()
                .mapToDouble(ItemDePedido::getValorTotal)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("-----------------------------------\n");
        builder.append("Nome do Cliente: ").append(nomeCliente).append("\n");
        builder.append("Total do Pedido: R$").append(String.format("%.2f", getTotal())).append("\n");
        builder.append("\nItem | Preço\n");

        for (ItemDePedido item : itens) {
            builder.append(item).append("\n");
        }

        builder.append("-----------------------------------");

        return builder.toString();
    }
}
