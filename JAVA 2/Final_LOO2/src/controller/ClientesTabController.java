/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import model.connection.ClienteDaoSql;
import model.dto.Cliente;
import view.Frame;

/**
 *
 * @author Pichau
 */
public class ClientesTabController {

    private Frame view;
    private ClienteDaoSql cliDao;

    public ClientesTabController(Frame view, ClienteDaoSql cliDao) {
        this.view = view;
        this.cliDao = cliDao;
    }

    public void criarCliente() {
        try {
            Cliente cliente = view.getClienteFormulario();
            if (!cliDao.clienteCpfExists(cliente)) {
                cliDao.add(cliente);
                view.addToCtm(cliente);
                view.clearFieldsCliente();
            } else {
                view.apresentaInfo("client already exists");
            }
        } catch (IOException | SQLException e) {
            view.apresentaErro("Erro ao criar Cliente.");
            e.getStackTrace();
        }
    }

}
