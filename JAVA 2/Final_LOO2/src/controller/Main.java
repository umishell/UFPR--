package controller;

import model.connection.ClienteDao;
import model.connection.DaoFactory;
import model.connection.DaoType;
import model.connection.MotocicletaDao;
import view.Frame;

public class Main {

    public static void main(String[] args) {
        

        Frame frame = new Frame();
        frame.initView();
        
        ClienteDao cliDao = DaoFactory.getClienteDao(DaoType.SQL);
        //MotocicletaDao motoDao = DaoFactory.getMotocicletaDao(DaoType.SQL);
        //AutomovelDao autoDao = DaoFactory.getAutomovelDao(DaoType.SQL);
        //VanDao vanDao = DaoFactory.getVanDao(DaoType.SQL);
        //LocacaoDao locDao = DaoFactory.getLocacaoDao(DaoType.SQL);
        
        ClientesTabController ctrlClientes = new ClientesTabController(frame,cliDao);
        VeiculosTabController ctrlVeiculos = new VeiculosTabController(frame, motoDao, autoDao, vanDao, locDao);
        LocacaoTabController ctrlLocacao = new LocacaoTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);
        DevolucaoTabController ctrlDevolucao = new DevolucaoTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);
        VendaTabController ctrlVenda= new VendaTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);
        
        frame.setControllers(ctrlClientes, ctrlVeiculos, ctrlLocacao, ctrlDevolucao, ctrlVenda);

    }
}
