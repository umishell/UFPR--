/*package model.tables;

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
*/package model.tables;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.*;

public class TableFilter {

    private TableRowSorter<TableModel> sorter;
    private static final int COL_MARCA = 0;
    private static final int COL_CATEGORIA = 1;

    public void initFilter(JTable table) {
        TableModel model = table.getModel();
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
    }

    public void filtrarPorMarcaECategoria(String marca, String categoria) {
        if (sorter == null) {
            throw new IllegalStateException("Sorter has not been initialized. Call criarTabela() first.");
        }
        if (marca == null || categoria == null) {
            throw new IllegalArgumentException("Marca and categoria must not be null.");
        }

        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                return entry.getStringValue(COL_MARCA).equals(marca) && entry.getStringValue(COL_CATEGORIA).equals(categoria);
            }
        });
    }

    public void filtrarPorMarca(String marca) {
        if (sorter == null) {
            throw new IllegalStateException("Sorter has not been initialized. Call criarTabela() first.");
        }
        if (marca == null) {
            throw new IllegalArgumentException("Marca must not be null.");
        }

        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                return entry.getStringValue(COL_MARCA).equals(marca);
            }
        });
    }

    public void filtrarPorCategoria(String categoria) {
        if (sorter == null) {
            throw new IllegalStateException("Sorter has not been initialized. Call criarTabela() first.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria must not be null.");
        }

        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                return entry.getStringValue(COL_CATEGORIA).equals(categoria);
            }
        });
    }

    public void clearFilters() {
        if (sorter == null) {
            throw new IllegalStateException("Sorter has not been initialized. Call criarTabela() first.");
        }
        sorter.setRowFilter(null);
    }
}

