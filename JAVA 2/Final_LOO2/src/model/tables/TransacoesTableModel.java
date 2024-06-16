package model.tables;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.dto.Automovel;
import model.dto.Motocicleta;
import model.dto.Van;
import model.dto.Veiculo;

public class TransacoesTableModel extends DefaultTableModel {

    private ArrayList<Van> listaVans = new ArrayList<>();
    private ArrayList<Motocicleta> listaMotos = new ArrayList<>();
    private ArrayList<Automovel> listaAutos = new ArrayList<>();
    private final String[] colunas;
    private int tipoVeiculo; // 1 = Moto, 2 = Auto, 3 = Van
    private int tipoTransacao; // 1 = Locacao, 2 = Devolução, 3 = Venda

    public TransacoesTableModel() {
        this.colunas = new String[]{"Placa", "Marca", "Categoria", "Modelo", "Ano"};
    }

    public TransacoesTableModel(ArrayList<Van> v, ArrayList<Motocicleta> m, ArrayList<Automovel> a) {
        this.colunas = new String[]{"Placa", "Marca", "Categoria", "Modelo", "Ano"};
        this.listaMotos = m;
        this.listaAutos = a;
        this.listaVans = v;
    }

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
            this.listaMotos.add(moto);
            this.fireTableDataChanged();
            this.fireTableRowsInserted(listaMotos.size() - 1, listaMotos.size() - 1);//update JTable
        } else if (v instanceof Automovel auto) {
            this.listaAutos.add(auto);
            this.fireTableDataChanged();
            this.fireTableRowsInserted(listaAutos.size() - 1, listaAutos.size() - 1);//update JTable
        } else if (v instanceof Van van) {
            this.listaVans.add(van);
            this.fireTableDataChanged();
            this.fireTableRowsInserted(listaVans.size() - 1, listaVans.size() - 1);//update JTable
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public int getRowCount() {
        switch (tipoVeiculo) {
            case 1 -> {
                return (this.listaMotos != null) ? this.listaMotos.size() : 0;
            }
            case 2 -> {
                return (this.listaAutos != null) ? this.listaAutos.size() : 0;
            }
            case 3 -> {
                return (this.listaVans != null) ? this.listaVans.size() : 0;
            }
        }
        return 0;
    }

    /**
     *
     * @param rowCount
     */
    @Override
    public void setRowCount(int rowCount) {
        switch (tipoVeiculo) {
            case 1 ->
                listaMotos = new ArrayList<>(rowCount);
            case 2 ->
                listaAutos = new ArrayList<>(rowCount);
            case 3 ->
                listaVans = new ArrayList<>(rowCount);
        }
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int col) {
        if (row < 0 || row >= getRowCount()) {
            throw new IndexOutOfBoundsException("Row index " + row + " out of bounds for length " + getRowCount());
        }

        switch (tipoVeiculo) {
            case 1: {
                Motocicleta moto = listaMotos.get(row);
                return switch (col) {
                    case 0 ->
                        moto.getPlaca();
                    case 1 ->
                        moto.getMarca();
                    case 2 ->
                        moto.getCategoria();
                    case 3 ->
                        moto.getModelo();
                    case 4 ->
                        moto.getAno();
                    default ->
                        null;
                };
            }
            case 2: {
                Automovel auto = listaAutos.get(row);
                return switch (col) {
                    case 0 ->
                        auto.getPlaca();
                    case 1 ->
                        auto.getMarca();
                    case 2 ->
                        auto.getCategoria();
                    case 3 ->
                        auto.getModelo();
                    case 4 ->
                        auto.getAno();
                    default ->
                        null;
                };
            }
            case 3: {
                Van van = listaVans.get(row);
                return switch (col) {
                    case 0 ->
                        van.getPlaca();
                    case 1 ->
                        van.getMarca();
                    case 2 ->
                        van.getCategoria();
                    case 3 ->
                        van.getModelo();
                    case 4 ->
                        van.getAno();
                    default ->
                        null;
                };
            }
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        switch (tipoVeiculo) {
            case 1 -> {
                Motocicleta moto = listaMotos.get(row);
                switch (col) {
                    case 0 ->
                        moto.setPlaca((String) value);
                    case 1 ->
                        moto.setMarca((String) value);
                    case 2 ->
                        moto.setCategoria((String) value);
                    case 3 ->
                        moto.setModelo((String) value);
                    case 4 ->
                        moto.setAno((int) value);

                    default -> {
                    }
                }
                this.fireTableCellUpdated(row, col);
            }
            case 2 -> {
                Automovel auto = listaAutos.get(row);
                switch (col) {
                    case 0 ->
                        auto.setPlaca((String) value);
                    case 1 ->
                        auto.setMarca((String) value);
                    case 2 ->
                        auto.setCategoria((String) value);
                    case 3 ->
                        auto.setModelo((String) value);
                    case 4 ->
                        auto.setAno((int) value);
                    default -> {
                    }
                }
                this.fireTableCellUpdated(row, col);
            }
            case 3 -> {
                Van van = listaVans.get(row);
                switch (col) {
                    case 0 ->
                        van.setPlaca((String) value);
                    case 1 ->
                        van.setMarca((String) value);
                    case 2 ->
                        van.setCategoria((String) value);
                    case 3 ->
                        van.setModelo((String) value);
                    case 4 ->
                        van.setAno((int) value);
                    default -> {
                    }
                }
                this.fireTableCellUpdated(row, col);
            }
        }
    }

    @Override
    public void removeRow(int row) {
        switch (tipoVeiculo) {
            case 1 -> {
                listaVans.remove(row);
                fireTableRowsDeleted(row, row);
            }
            case 2 -> {
                listaMotos.remove(row);
                fireTableRowsDeleted(row, row);
            }
            case 3 -> {
                listaAutos.remove(row);
                fireTableRowsDeleted(row, row);
            }
        }
    }

    public void removeSelectedRows(JTable myJTable) {

        int[] selectedRows = myJTable.getSelectedRows();
        TransacoesTableModel tableModel = (TransacoesTableModel) myJTable.getModel();
        switch (tipoVeiculo) {
            case 1 -> {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int row = selectedRows[i];
                    // Convert row index to model index
                    int modelRow = myJTable.convertRowIndexToModel(row);
                    tableModel.removeRow(modelRow);
                }
            }
            case 2 -> {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int row = selectedRows[i];
                    // Convert row index to model index
                    int modelRow = myJTable.convertRowIndexToModel(row);
                    tableModel.removeRow(modelRow);
                }
            }
            case 3 -> {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int row = selectedRows[i];
                    // Convert row index to model index
                    int modelRow = myJTable.convertRowIndexToModel(row);
                    tableModel.removeRow(modelRow);
                }
            }
        }
        myJTable.clearSelection(); // Clear the selection after removal
    }

    public void setListaMotos(ArrayList<Motocicleta> motos) {
        this.listaMotos = motos;
        if (!listaMotos.isEmpty()) {
            this.fireTableDataChanged();
            this.fireTableRowsInserted(0, listaMotos.size() - 1);//update JTable
        }
    }

    public void setListaAutos(ArrayList<Automovel> autos) {
        this.listaAutos = autos;
        if (!listaAutos.isEmpty()) {
            this.fireTableDataChanged();
            this.fireTableRowsInserted(0, listaAutos.size() - 1);//update JTable
        }
    }

    public void setListaVans(ArrayList<Van> vans) {
        this.listaVans = vans;
        if (!listaVans.isEmpty()) {
            this.fireTableDataChanged();
            this.fireTableRowsInserted(0, listaVans.size() - 1);//update JTable
        }
    }

    public void clearTable() {
        switch (tipoVeiculo) {
            case 1 -> {
                int indice = listaMotos.size() - 1;
                if (indice < 0) {
                    indice = 0;
                }
                this.listaMotos = new ArrayList();
                this.fireTableRowsDeleted(0, indice);//update JTable
            }
            case 2 -> {
                int indice = listaAutos.size() - 1;
                if (indice < 0) {
                    indice = 0;
                }
                this.listaAutos = new ArrayList();
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

    public ArrayList<Van> getListaVans() {
        return listaVans;
    }

    public ArrayList<Motocicleta> getListaMotos() {
        return listaMotos;
    }

    public ArrayList<Automovel> getListaAutos() {
        return listaAutos;
    }

    public int getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(int tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Veiculo getSelectedVeiculo(JTable table) {
        int selectedRow = table.getSelectedRow();

        // Check for valid selection
        if (selectedRow < 0) {
            return null; // No row selected
        }

        // Convert row index to model index (consider sorting)
        int modelRow = table.convertRowIndexToModel(selectedRow);

        return switch (tipoVeiculo) {
            case 1 ->
                listaMotos.get(modelRow);
            case 2 ->
                listaAutos.get(modelRow);
            case 3 ->
                listaVans.get(modelRow);
            default ->
                null;
        }; // Unexpected vehicle type
    }

    public double getValorDiariaLocacao(JTable table) {
        int selectedRow = table.getSelectedRow();

        // Check for valid selection
        if (selectedRow < 0) {
            return 0; // No row selected
        }

        // Convert row index to model index (consider sorting)
        int modelRow = table.convertRowIndexToModel(selectedRow);

        System.out.println("categoria: "+listaMotos.get(modelRow).getCategoria());
        System.out.println("moto: "+listaMotos.get(modelRow).getValorDiariaLocacao(listaMotos.get(modelRow).getCategoria()));
        return switch (tipoVeiculo) {
            case 1 ->
                listaMotos.get(modelRow).getValorDiariaLocacao(listaMotos.get(modelRow).getCategoria());
            case 2 ->
                listaAutos.get(modelRow).getValorDiariaLocacao(listaAutos.get(modelRow).getCategoria());
            case 3 ->
                listaVans.get(modelRow).getValorDiariaLocacao(listaVans.get(modelRow).getCategoria());
            default ->
                0;
        }; // Unexpected vehicle type
    }

    public int getIdOfSelectedVeiculo(JTable table) {
        int selectedRow = table.getSelectedRow();

        // Check for valid selection
        if (selectedRow < 0) {
            return 0; // No row selected
        }

        // Convert row index to model index (consider sorting)
        int modelRow = table.convertRowIndexToModel(selectedRow);

        return switch (tipoVeiculo) {
            case 1 ->
                listaMotos.get(modelRow).getIdveiculo();
            case 2 ->
                listaAutos.get(modelRow).getIdveiculo();
            case 3 ->
                listaVans.get(modelRow).getIdveiculo();
            default ->
                0;
        }; // Unexpected vehicle type
    }
    
    

}
