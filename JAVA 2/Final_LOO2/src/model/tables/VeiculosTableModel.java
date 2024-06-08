package model.tables;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.dto.Automovel;
import model.dto.Motocicleta;
import model.dto.Van;
import model.dto.Veiculo;

public class VeiculosTableModel extends DefaultTableModel {

    private ArrayList<Van> listaVans = new ArrayList<>();
    private ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();
    private ArrayList<Automovel> listaAutomoveis = new ArrayList<>();
    private final String[] colunas;
    private int tipoVeiculo; // 1 = Moto, 2 = Auto, 3 = Van

    public VeiculosTableModel() {
        this.colunas = new String[]{"Placa", "Marca", "Modelo", "Ano", "Preço da diária"};
    }

    public VeiculosTableModel(ArrayList<Van> v, ArrayList<Motocicleta> m, ArrayList<Automovel> a) {
        this.colunas = new String[]{"Placa", "Marca", "Modelo", "Ano", "Preço da diária"};
        this.listaMotocicletas = m;
        this.listaAutomoveis = a;
        this.listaVans = v;
    }

    /*public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
        switch (tipoVeiculo) {
            case 1 ->
                colunas = new String[]{"Marca", "Modelo", "Ano", "Preço da diária", "Placa"};
            case 2 ->
                colunas = new String[]{"Marca", "Modelo", "Ano", "Preço da diária", "Placa"};
            case 3 ->
                colunas = new String[]{"Marca", "Modelo", "Ano", "Preço da diária", "Placa"};
        }
        fireTableStructureChanged(); // notifica a JTable que a estrutura mudou
    }*/
    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // permite a edição em todas as células
        return false;
    }

    public void setSingleSelection(JTable tabela) {
        ListSelectionModel selectionModel = tabela.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addVeiculo(Veiculo v) {
        if (v instanceof Motocicleta moto) {
            this.listaMotocicletas.add(moto);
            this.fireTableDataChanged();
            this.fireTableRowsInserted(listaMotocicletas.size() - 1, listaMotocicletas.size() - 1);//update JTable
        } else if (v instanceof Automovel auto) {
            this.listaAutomoveis.add(auto);
            this.fireTableDataChanged();
            this.fireTableRowsInserted(listaAutomoveis.size() - 1, listaAutomoveis.size() - 1);//update JTable
        } else if (v instanceof Van van) {
            this.listaVans.add(van);
            this.fireTableDataChanged();
            this.fireTableRowsInserted(listaVans.size() - 1, listaVans.size() - 1);//update JTable
        }
    }

    public void addVan(Van v) {
        this.listaVans.add(v);
        this.fireTableDataChanged();
        this.fireTableRowsInserted(listaVans.size() - 1, listaVans.size() - 1);//update JTable
    }

    public void addMotocicleta(Motocicleta m) {
        this.listaMotocicletas.add(m);
        this.fireTableDataChanged();
        this.fireTableRowsInserted(listaMotocicletas.size() - 1, listaMotocicletas.size() - 1);//update JTable
    }

    public void addAutomovel(Automovel a) {
        this.listaAutomoveis.add(a);
        this.fireTableDataChanged();
        this.fireTableRowsInserted(listaAutomoveis.size() - 1, listaAutomoveis.size() - 1);//update JTable
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        switch (tipoVeiculo) {
            case 1 -> {
                return (this.listaMotocicletas != null) ? this.listaMotocicletas.size() : 0;
            }
            case 2 -> {
                return (this.listaAutomoveis != null) ? this.listaAutomoveis.size() : 0;
            }
            case 3 -> {
                return (this.listaVans != null) ? this.listaVans.size() : 0;
            }
        }
        return 0;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (tipoVeiculo) {
            case 1 -> {
                Motocicleta moto = listaMotocicletas.get(row);
                return switch (col) {
                    case 0 ->
                        moto.getPlaca();
                    case 1 ->
                        moto.getMarca();
                    case 2 ->
                        moto.getModelo();
                    case 3 ->
                        moto.getAno();
                    case 4 ->
                        moto.getValorDeCompra();
                    default ->
                        null;
                };
            }
            case 2 -> {
                Automovel auto = listaAutomoveis.get(row);
                return switch (col) {
                    case 0 ->
                        auto.getPlaca();
                    case 1 ->
                        auto.getMarca();
                    case 2 ->
                        auto.getModelo();
                    case 3 ->
                        auto.getAno();
                    case 4 ->
                        auto.getValorDeCompra();
                    default ->
                        null;
                };
            }
            case 3 -> {
                Van van = listaVans.get(row);
                return switch (col) {
                    case 0 ->
                        van.getPlaca();
                    case 1 ->
                        van.getMarca();
                    case 2 ->
                        van.getModelo();
                    case 3 ->
                        van.getAno();
                    case 4 ->
                        van.getValorDeCompra();
                    default ->
                        null;
                };
            }
        }
        return null;
    }

    /*
    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (tipoVeiculo) {
            case 1 -> {
                Van van = listaVans.get(row);
                switch (col) {
                    case 0 ->
                        van.setMarca(Marca.HONDA);
                    case 1 ->
                        van.getModelo();
                    case 2 ->
                        van.getAno();
                    case 3 ->
                        van.getValorDeCompra();
                    case 4 ->
                        van.getPlaca();
                    default ->
                        null;
                };
                this.fireTableCellUpdated(row, col);
            }
            case 2 -> {
                Motocicleta moto = listaMotocicletas.get(row);
                switch (col) {
                    case 0 ->
                        moto.getMarca();
                    case 1 ->
                        moto.getModelo();
                    case 2 ->
                        moto.getAno();
                    case 3 ->
                        moto.getValorDeCompra();
                    case 4 ->
                        moto.getPlaca();
                    default ->
                        null;
                };
                this.fireTableCellUpdated(row, col);
            }
            case 3 -> {
                Automovel auto = listaAutomoveis.get(row);
                switch (col) {
                    case 0 ->
                        auto.getMarca();
                    case 1 ->
                        auto.getModelo();
                    case 2 ->
                        auto.getAno();
                    case 3 ->
                        auto.getValorDeCompra();
                    case 4 ->
                        auto.getPlaca();
                    default ->
                        null;
                };
                this.fireTableCellUpdated(row, col);
            }
        }
    }
     */
    @Override
    public void removeRow(int row) {
        switch (tipoVeiculo) {
            case 1 -> {
                listaVans.remove(row);
                fireTableRowsDeleted(row, row);
            }
            case 2 -> {
                listaMotocicletas.remove(row);
                fireTableRowsDeleted(row, row);
            }
            case 3 -> {
                listaAutomoveis.remove(row);
                fireTableRowsDeleted(row, row);
            }
        }
    }

    public void removeSelectedRows(JTable myJTable) {

        int[] selectedRows = myJTable.getSelectedRows();
        VeiculosTableModel tableModel = (VeiculosTableModel) myJTable.getModel();
        switch (tipoVeiculo) {
            case 1 -> {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int row = selectedRows[i];
                    //rep.apagarVan(row);
                    // Convert row index to model index
                    int modelRow = myJTable.convertRowIndexToModel(row);
                    tableModel.removeRow(modelRow);
                }
            }
            case 2 -> {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int row = selectedRows[i];
                    //rep.apagarMotocicleta(row);
                    // Convert row index to model index
                    int modelRow = myJTable.convertRowIndexToModel(row);
                    tableModel.removeRow(modelRow);
                }
            }
            case 3 -> {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int row = selectedRows[i];
                    //rep.apagarAutomovel(row);
                    // Convert row index to model index
                    int modelRow = myJTable.convertRowIndexToModel(row);
                    tableModel.removeRow(modelRow);
                }
            }
        }
        myJTable.clearSelection(); // Clear the selection after removal
    }

    public void setListaMotos(ArrayList<Motocicleta> motos) {
        this.listaMotocicletas = motos;
        if (!listaMotocicletas.isEmpty()) {
            this.fireTableDataChanged();
            this.fireTableRowsInserted(0, listaMotocicletas.size() - 1);//update JTable
        }
    }
    
    public void setListaAutos(ArrayList<Automovel> autos) {
        this.listaAutomoveis = autos;
        if (!listaAutomoveis.isEmpty()) {
            this.fireTableDataChanged();
            this.fireTableRowsInserted(0, listaAutomoveis.size() - 1);//update JTable
        }
    }
    
    public void setListaVans(ArrayList<Van> vans) {
        this.listaVans = vans;
        if (!listaVans.isEmpty()) {
            this.fireTableDataChanged();
            this.fireTableRowsInserted(0, listaVans.size() - 1);//update JTable
        }
    }

    public void limpaTabela() {
        switch (tipoVeiculo) {
            case 1 -> {
                int indice = listaMotocicletas.size() - 1;
                if (indice < 0) {
                    indice = 0;
                }
                this.listaMotocicletas = new ArrayList();
                this.fireTableRowsDeleted(0, indice);//update JTable
            }
            case 2 -> {
                int indice = listaAutomoveis.size() - 1;
                if (indice < 0) {
                    indice = 0;
                }
                this.listaAutomoveis = new ArrayList();
                this.fireTableRowsDeleted(0, indice);//update JTable
            }
            case 3 -> {
                int indice = listaVans.size() - 1;
                if (indice < 0) {
                    indice = 0;
                }
                this.listaVans = new ArrayList();
                this.fireTableRowsDeleted(0, indice);//update JTable
            }
        }
    }
}
