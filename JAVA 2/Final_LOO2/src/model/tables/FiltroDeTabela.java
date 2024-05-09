package model.tables;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.*;

public class FiltroDeTabela {

    private TableRowSorter<TableModel> sorter;

    public void criarTabela(JTable tabela) {
        TableModel modelo = tabela.getModel();
        sorter = new TableRowSorter<>(modelo);
        tabela.setRowSorter(sorter);
    }

    public void filtrarPorMarcaECategoria(String marca, String categoria) {
        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                // suponha que a coluna da marca é a 0 e a coluna da categoria é a 1
                return entry.getStringValue(0).equals(marca) && entry.getStringValue(1).equals(categoria);
            }
        });
    }

    public void filtrarPorMarca(String marca) {
        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                // suponha que a coluna da marca é a 0
                return entry.getStringValue(0).equals(marca);
            }
        });
    }

    public void filtrarPorCategoria(String categoria) {
        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                // suponha que a coluna da categoria é a 1
                return entry.getStringValue(1).equals(categoria);
            }
        });
    }
}
