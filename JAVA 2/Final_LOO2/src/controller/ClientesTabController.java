/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.connection.ClienteDao;
import model.dto.Cliente;
import view.Frame;

/**
 *
 * @author Pichau
 */
public class ClientesTabController {
    
    private Frame view;
    private ClienteDao cliDao;
    
    
    public ClientesTabController(Frame view, ClienteDao cliDao) {
        this.view = view;
        this.cliDao = cliDao;
    }
    
  public void criarCliente() {
        try{
            Cliente cliente = view.getClienteFormulario();
            modelDao.add(contato);
            view.inserirContatoView(contato);
            view.apresentaInfo("Adicionado com sucesso!!!");
            
        }catch(Exception ex){
            view.apresentaErro("Erro ao criar contato.");
        }
    }

    
}
