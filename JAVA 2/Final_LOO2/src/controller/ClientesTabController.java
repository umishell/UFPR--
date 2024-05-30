package controller;

import java.io.IOException;
import java.sql.SQLException;
import model.connection.ClienteDaoSql;
import model.dto.Cliente;
import view.Frame;

public class ClientesTabController {

    private Frame view;
    private ClienteDaoSql cliDao;

    public ClientesTabController(Frame view, ClienteDaoSql cliDao) {
        this.view = view;
        this.cliDao = cliDao;
        // initController();
    }

    public ClientesTabController() {

    }

    private void initController() {
        view.setControllers(this);
        //this.view.initView();
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
        } catch (IOException | SQLException e) {
            view.apresentaErro("Erro ao criar Cliente.");
            e.getStackTrace();
        } catch (NullPointerException e) {
            //view.apresentaErro("preencha o nome, sobrenome e cpf.");
            e.getStackTrace();
        }
    }
    
    public void updateCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            int row = view.GetSelectedRow();
            view.updateClienteAtCtm(row, cliente);  System.out.println(cliente.getId());
            //cliente.setId(row);
            cliDao.update(cliente);
            view.clearFieldsCliente();
            
        } catch (IOException | SQLException e) {
            view.apresentaErro("Erro ao criar Cliente.");
            e.getStackTrace();
        } catch (NullPointerException e) {
            //view.apresentaErro("preencha o nome, sobrenome e cpf.");
            e.getStackTrace();
        }
    }

}
