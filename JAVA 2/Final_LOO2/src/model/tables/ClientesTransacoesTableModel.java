package model.tables;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.dto.Cliente;

public class ClientesTransacoesTableModel extends DefaultTableModel {

    private final String[] colunas;
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public ClientesTransacoesTableModel() {
        this.colunas = new String[]{"Nome", "Sobrenome", "RG", "CPF", "Endereço"};
    }

    public ClientesTransacoesTableModel(ArrayList<Cliente> c) {
        this.colunas = new String[]{"Nome", "Sobrenome", "RG", "CPF", "Endereço"};
        this.listaClientes = c;
    }

    public void add(Cliente c) {
        this.listaClientes.add(c);
        this.fireTableDataChanged();
        this.fireTableRowsInserted(listaClientes.size(), listaClientes.size());//update JTable
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
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
        return (this.listaClientes != null) ? this.listaClientes.size() : 0;
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

    public void setValuesAtRow(int row, Cliente c) {
        this.setValueAt(c.getNome(), row, 0);
        this.setValueAt(c.getSobrenome(), row, 1);
        this.setValueAt(c.getRg(), row, 2);
        this.setValueAt(c.getCpf(), row, 3);
        this.setValueAt(c.getEndereco(), row, 4);
    }

    @Override
    public void removeRow(int row) {

        listaClientes.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public ArrayList<Cliente> removeSelectedRows(JTable myJTable) {
        int[] selectedRows = myJTable.getSelectedRows();
        ClientesTransacoesTableModel tableModel = (ClientesTransacoesTableModel) myJTable.getModel();
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            int modelRow = myJTable.convertRowIndexToModel(selectedRows[i]);
            clientes.add(this.getListaClientes().get(modelRow));
            tableModel.removeRow(modelRow);
        }
        myJTable.clearSelection();
        return clientes;
    }

    public void setListaCliente(ArrayList<Cliente> clientes) {
        this.listaClientes = clientes;
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

    public void setSingleSelection(JTable tabela) {
        ListSelectionModel selectionModel = tabela.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
