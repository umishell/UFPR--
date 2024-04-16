package shoppingCart_4;

public class ItemDePedido {
        private String nome;
        private double preco;
        private int quantidade;
    public ItemDePedido(String nome, double preco, int quantidade) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
