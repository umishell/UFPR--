package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.connection.ClienteDaoSql;
import model.dto.Cliente;
import view.Frame;

public class ClientesTabController {

    private Frame view;
    private ClienteDaoSql cliDao;

    public ClientesTabController(Frame view, ClienteDaoSql cliDao) {
        this.view = view;
        this.cliDao = cliDao;
    }

    public ClientesTabController() {
    }

    public void newCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            if (!cliDao.clienteCpfExists(cliente)) {
                view.addClienteToCtm(cliente);
                cliDao.add(cliente);
                view.clearFieldsCliente();
            } else {
                view.apresentaInfo("client already exists");
            }
        } catch (IOException | SQLException | NullPointerException e) {
            view.apresentaErro("Erro ao incluir Cliente.");
            e.printStackTrace();
        }
    }

    public void updateCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            int row = view.getSelectedRowAtClienteTable();
            view.updateClienteAtCtm(row, cliente);
            cliDao.update(cliente);
            view.clearFieldsCliente();

        } catch (IOException | SQLException | NullPointerException e) {
            view.apresentaErro("Erro ao atualizar Cliente.");
            e.printStackTrace();
        }
    }

    public void deleteCliente() {
        try {
            ArrayList<Cliente> clientes = view.removeClientesFromSelectedRowsAtCtm();
            for (Cliente c : clientes) {
                cliDao.delete(c);
                view.removeSelectedRowsAtClienteTable();
            }
            view.clearFieldsCliente();

        } catch (IOException | SQLException | NullPointerException e) {
            view.apresentaErro("Erro ao deletar Cliente.");
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> showClientes() {
        ClienteDaoSql c = new ClienteDaoSql();
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            clientes = c.getAll();
            view.ShowCtm(clientes);
        } catch (IOException | SQLException | NullPointerException e) {
            view.apresentaErro("Erro ao mostrar Clientes na tabela.");
            e.printStackTrace();
        }
        return clientes;
    }
    

    

    public void initTable() {

    }
}
