package model.tables;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.*;
import model.dto.Motocicleta;

public class TableFilter {

    private TableRowSorter<TableModel> sorter;
    private static final int COL_MARCA = 1;
    private static final int COL_CATEGORIA = 2;

    public void initFilter(JTable table) {
        TableModel model = table.getModel();
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
    }

    public TableRowSorter<TableModel> getSorter() {
        return sorter;
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

    public void filtrarPorTexto(String text) {
        if (sorter == null) {
            throw new IllegalStateException("Sorter has not been initialized. Call initFilter() first.");
        }
        if (text == null || text.isEmpty()) {
            sorter.setRowFilter(null); // Remove any existing filter
            return;
        }
        sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
            @Override
            public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                for (int i = 0; i < entry.getValueCount(); i++) {
                    String value = entry.getStringValue(i).toLowerCase();
                    if (value.contains(text.toLowerCase())) {
                        return true;
                    }
                }
                return false;
            }
        });
    }


    /*
    public void resetFilters(int tipoVeiculo, DefaultTableModel tableModel, ArrayList v) {
        switch (tipoVeiculo) {
            case 1 -> {

                ArrayList<Motocicleta> motos = new ArrayList<>(v);
                tableModel.setRowCount(0);
                for (Motocicleta moto : motos) {
                    tableModel.addRow(new Object[]{moto.getPlaca(), moto.getMarca(), moto.getCategoria(), moto.getModelo(), moto.getAno()});
                }
            }
            case 2 -> {

            }
            case 3 -> {

            }
        }
    }*/
}
