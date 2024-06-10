package controller;

import model.connection.ClienteDaoSql;
import model.connection.DaoFactory;
import model.connection.DaoType;
import model.connection.MotocicletaDao;
import model.connection.MotocicletaDaoSql;
import model.tables.ClienteLocacaoTableModel;
import model.tables.ClienteTableModel;
import model.tables.LocarVeiculoTableModel;
import model.tables.TableFilter;
import model.tables.VeiculoDevolverTableModel;
import model.tables.VeiculoVenderTableModel;
import model.tables.VeiculosTableModel;
import view.Frame;

public class Main {

    public static void main(String[] args) {

        Frame view = new Frame();

        //TABLE MODELS
        ClienteTableModel ctm = view.getCtm();
        VeiculosTableModel vtm = view.getVtm();
        ClienteLocacaoTableModel cltm = view.getCltm();
        LocarVeiculoTableModel lvtm = view.getLvtm();
        VeiculoDevolverTableModel vdtm = view.getVdtm();
        VeiculoVenderTableModel vvtm = view.getVvtm();

        //FILTERS
        TableFilter filtroVeiculoTable = new TableFilter();
        filtroVeiculoTable.initFilter(view.getVeiculoTable());

        if (filtroVeiculoTable.getSorter() != null) {
            System.out.println("Sorter is initialized successfully!");
        } else {
            System.out.println("Something went wrong during initialization.");
        }

        ClienteDaoSql cliDao = DaoFactory.getClienteDao(DaoType.SQL);
        MotocicletaDaoSql motoDao = MotocicletaDaoSql.getMotocicletaDaoSql();//DaoFactory.getMotocicletaDao(DaoType.SQL);
        //AutomovelDao autoDao = DaoFactory.getAutomovelDao(DaoType.SQL);
        //VanDao vanDao = DaoFactory.getVanDao(DaoType.SQL);
        //LocacaoDao locDao = DaoFactory.getLocacaoDao(DaoType.SQL);

        ClientesTabController ctrlClientes = new ClientesTabController(view, cliDao);
        VeiculosTabController ctrlVeiculos = new VeiculosTabController(view, vtm, filtroVeiculoTable, motoDao/*, autoDao, vanDao*/);
        //LocacaoTabController ctrlLocacao = new LocacaoTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);
        //DevolucaoTabController ctrlDevolucao = new DevolucaoTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);
        // VendaTabController ctrlVenda= new VendaTabController(frame,cliDao, motoDao, autoDao, vanDao, locDao);

        view.setControllers(ctrlClientes, ctrlVeiculos/*, ctrlLocacao, ctrlDevolucao, ctrlVenda*/);
        
        ctrlVeiculos.loadAllCategoriaMarcaCboxes();//falta  cboxes!!!
        ctrlVeiculos.setSingleSelectionOnVtm();
        

        view.initView(view);

    }
}
