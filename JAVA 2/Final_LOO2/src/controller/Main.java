package controller;

import model.connection.ClienteDaoSql;
import model.connection.DaoFactory;
import model.connection.DaoType;
import view.Frame;

public class Main {

    public static void main(String[] args) {

        Frame view = new Frame();
        

        ClienteDaoSql cliDao = DaoFactory.getClienteDao(DaoType.SQL);
        //MotocicletaDao motoDao = DaoFactory.getMotocicletaDao(DaoType.SQL);
        //AutomovelDao autoDao = DaoFactory.getAutomovelDao(DaoType.SQL);
        //VanDao vanDao = DaoFactory.getVanDao(DaoType.SQL);
        //LocacaoDao locDao = DaoFactory.getLocacaoDao(DaoType.SQL);

        ClientesTabController ctrlClientes = new ClientesTabController(view, cliDao);
        // VeiculosTabController ctrlVeiculos = new VeiculosTabController(frame, motoDao, autoDao, vanDao, locDao);
        //LocacaoTabController ctrlLocacao = new LocacaoTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);
        //DevolucaoTabController ctrlDevolucao = new DevolucaoTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);
        // VendaTabController ctrlVenda= new VendaTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);

        //frame.setControllers(ctrlClientes, ctrlVeiculos, ctrlLocacao, ctrlDevolucao, ctrlVenda);
       
        view.setControllers(ctrlClientes);
        
        view.initView(view);

    }
}
