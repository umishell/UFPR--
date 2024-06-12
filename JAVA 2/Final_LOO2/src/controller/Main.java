package controller;

import model.connection.AutomovelDaoSql;
import model.connection.ClienteDaoSql;
import model.connection.DaoFactory;
import model.connection.DaoType;
import model.connection.LocacaoDaoSql;
import model.connection.MotocicletaDaoSql;
import model.connection.VanDaoSql;
import model.tables.ClientesTableModel;
import model.tables.ClientesTransacoesTableModel;
import model.tables.TableFilter;
import model.tables.TransacoesTableModel;
import model.tables.VeiculosTableModel;
import view.Frame;

public class Main {

    public static void main(String[] args) {

        Frame view = new Frame();

        //TABLE MODELS
        ClientesTableModel ctm = view.getCtm();
        VeiculosTableModel vtm = view.getVtm();
        ClientesTransacoesTableModel cttm = view.getCttm();
        TransacoesTableModel ttm = view.getTtm();
        
        //FILTERS
        TableFilter filtroVeiculoTable = new TableFilter();
        filtroVeiculoTable.initFilter(view.getVeiculosTable());
        TableFilter filtroTransacoesTable = new TableFilter();
        filtroVeiculoTable.initFilter(view.getTransacoesTable());

        if (filtroVeiculoTable.getSorter() != null) {
            System.out.println("Sorter is initialized successfully!");
        } else {
            System.out.println("Something went wrong during initialization.");
        }

        ClienteDaoSql cliDao = DaoFactory.getClienteDao(DaoType.SQL);
        MotocicletaDaoSql motoDao = MotocicletaDaoSql.getMotocicletaDaoSql();//DaoFactory.getMotocicletaDao(DaoType.SQL);
        AutomovelDaoSql autoDao = AutomovelDaoSql.getAutomovelDaoSql();//DaoFactory.getAutomovelDao(DaoType.SQL);
        VanDaoSql vanDao = VanDaoSql.getVanDaoSql();//DaoFactory.getVanDao(DaoType.SQL);
        LocacaoDaoSql locDao = LocacaoDaoSql.getLocacaoDaoSql();

        ClientesTabController ctrlClientes = new ClientesTabController(view, cliDao);
        VeiculosTabController ctrlVeiculos = new VeiculosTabController(view, vtm, filtroVeiculoTable, motoDao, autoDao, vanDao);
        TransacoesTabController ctrlTransacoes = new TransacoesTabController(view, ttm, cttm, filtroVeiculoTable, motoDao, autoDao, vanDao, locDao);

        view.setControllers(ctrlClientes, ctrlVeiculos, ctrlTransacoes);
        
        ctrlVeiculos.loadAllCategoriaMarcaCboxes();
        ctrlVeiculos.setSingleSelectionOnVtm();
        ctrlTransacoes.loadAllCategoriaMarcaCboxes();
        ctrlTransacoes.setSingleSelectionOnVtm_Ttm();
        

        view.initView(view);

    }
}
