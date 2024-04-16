package tela1;

import frame.Repository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteTableModel extends DefaultTableModel {

    private Repository rep;
    private String[] colunas = new String[]{"Nome", "Sobrenome", "RG", "CPF", "Endereço"};
    private List<Cliente> listaClientes = new ArrayList();

    public void repRef(Repository rep) {
        this.rep = rep;
    }

    public ClienteTableModel() {
    }

    public ClienteTableModel(List<Cliente> c) {
        this.listaClientes = c;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    @Override
    public int getRowCount() {
        return (this.listaClientes != null) ? this.listaClientes.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = listaClientes.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                cliente.getNome();
            case 1 ->
                cliente.getSobrenome();
            case 2 ->
                cliente.getRg();
            case 3 ->
                cliente.getCpf();
            case 4 ->
                cliente.getEndereco();
            default ->
                null;
        };
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Cliente cliente = listaClientes.get(row);
        switch (col) {
            case 0 ->
                cliente.setNome((String) value);
            case 1 ->
                cliente.setSobrenome((String) value);
            case 2 ->
                cliente.setRg((String) value);
            case 3 ->
                cliente.setCpf((String) value);
            case 4 ->
                cliente.setEndereco((String) value);
            default -> {
            }

        }
        this.fireTableCellUpdated(row, col);
    }

    @Override
    public void removeRow(int row) {
        listaClientes.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void removeSelectedRows(JTable myJTable) {
        int[] selectedRows = myJTable.getSelectedRows();
        ClienteTableModel tableModel = (ClienteTableModel) myJTable.getModel();

        for (int i = selectedRows.length - 1; i >= 0; i--) {
            int row = selectedRows[i];
            rep.apagarCliente(row);
            // Convert row index to model index
            int modelRow = myJTable.convertRowIndexToModel(row);
            tableModel.removeRow(modelRow);
        }
        // Clear the selection after removal
        myJTable.clearSelection();
    }

    public void addCliente(Cliente c) {
        this.listaClientes.add(c);
        rep.gravarCliente(c);
        this.fireTableDataChanged();
        this.fireTableRowsInserted(listaClientes.size() , listaClientes.size() );//update JTable
    }

    public void setListaCliente() {
        this.listaClientes = rep.getListaClientes();
        if (!listaClientes.isEmpty()) {
            this.fireTableDataChanged();
            this.fireTableRowsInserted(0, listaClientes.size() - 1);//update JTable
        }
    }

    public void limpaTabela() {
        int indice = listaClientes.size() - 1;
        if (indice < 0) {
            indice = 0;
        }
        this.listaClientes = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // permite a edição em todas as células
        return true;
    }

}
