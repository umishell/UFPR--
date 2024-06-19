package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import model.combo.ComboBox;
import model.connection.AutomovelDaoSql;
import model.connection.ClienteDaoSql;
import model.connection.GetId;
import model.connection.LocacaoDaoSql;
import model.connection.MotocicletaDaoSql;
import model.connection.VanDaoSql;
import model.connection.VendaDaoSql;
import model.dto.Automovel;
import model.dto.Cliente;
import model.dto.Locacao;
import model.dto.Motocicleta;
import model.dto.Van;
import model.dto.Venda;
import model.tables.ClientesTransacoesTableModel;
import model.tables.TableFilter;
import model.tables.TransacoesTableModel;
import view.Frame;

public class TransacoesTabController {

    private Frame view;
    private TransacoesTableModel ttm;
    private ClientesTransacoesTableModel cttm;
    private MotocicletaDaoSql motoDao;
    private TableFilter filtroTransacoesTable;
    private TableFilter filtroClientesTransacoesTable;
    private AutomovelDaoSql autoDao;
    private VanDaoSql vanDao;
    private LocacaoDaoSql locDao;
    private VendaDaoSql selDao;

    public TransacoesTabController(Frame view, TransacoesTableModel ttm, ClientesTransacoesTableModel cttm, TableFilter f, TableFilter f1,
            MotocicletaDaoSql motoDao, AutomovelDaoSql autoDao, VanDaoSql vanDao, LocacaoDaoSql locDao, VendaDaoSql selDao) {
        this.view = view;
        this.ttm = ttm;
        this.cttm = cttm;
        filtroTransacoesTable = f;
        filtroClientesTransacoesTable = f1;
        this.motoDao = motoDao;
        this.autoDao = autoDao;
        this.vanDao = vanDao;
        this.locDao = locDao;
        this.selDao = selDao;
    }

    public TransacoesTabController() {
    }

    public void newLocacao() {
        if (!view.getClientesTransacoesTable().getSelectionModel().isSelectionEmpty() && !view.getTransacoesTable().getSelectionModel().isSelectionEmpty()) {
            try {
                Locacao loc = view.getLocacaoFormulario();
                System.out.println("@newLocacao \n" + loc.toString());

                int idcliente = cttm.getIdOfSelectedClient(view.getClientesTransacoesTable());
                System.out.println("idcliente: " + idcliente);
                int idveiculo = ttm.getIdOfSelectedVeiculo(view.getTransacoesTable());
                System.out.println("idveiculo: " + idveiculo);
                if (!locDao.locacaoIsActive(loc.getDate(), idveiculo)) {
                    locDao.locar(loc, idcliente, idveiculo);
                    view.clearFieldsLocacao();
                    switch (ttm.getTipoVeiculo()) {
                        case 1 ->
                            showAllMotos();
                        case 2 ->
                            showAllAutos();
                        case 3 ->
                            showAllVans();
                    }
                    view.apresentaInfo("Locação Concluida.");

                } else {
                    view.apresentaInfo("Veiculo Alugado.");
                }
            } catch (IOException | SQLException | NullPointerException e) {
                view.apresentaErro("Erro ao criar locação.");
            } catch (DateTimeParseException e) {
                view.apresentaInfo("Invalid date format. Please use YYYY-MM-DD.");
            } catch (NumberFormatException e) {
                view.apresentaInfo("Preencha o numero de dias.");
            } catch (RuntimeException e) {
                view.apresentaInfo("Data é no Passado.");
            }
        } else {
            view.apresentaInfo("Selecione Cliente e Veiculo para locar.");
        }
    }

    public void vender() {
        if (!view.getClientesTransacoesTable().getSelectionModel().isSelectionEmpty() && !view.getTransacoesTable().getSelectionModel().isSelectionEmpty()) {
            try {
                int idcliente = cttm.getIdOfSelectedClient(view.getClientesTransacoesTable());
                System.out.println("idcliente: " + idcliente);
                int idveiculo = ttm.getIdOfSelectedVeiculo(view.getTransacoesTable());
                System.out.println("idveiculo: " + idveiculo);
                LocalDate today = LocalDate.now();
                Venda venda = new Venda(idveiculo, idcliente, today);
                selDao.efetivar(venda);
                switch (ttm.getTipoVeiculo()) {
                    case 1 ->
                        showAllMotos();
                    case 2 ->
                        showAllAutos();
                    case 3 ->
                        showAllVans();
                }
                view.apresentaInfo("Venda Concluida.");
            } catch (/*IOException | SQLException |*/NullPointerException e) {
                view.apresentaErro("Erro ao vender.");
                e.printStackTrace();
            } catch (DateTimeParseException e) {
                view.apresentaInfo("Invalid date format. Please use YYYY-MM-DD.");
            } catch (NumberFormatException e) {
                view.apresentaInfo("Preencha o numero de dias.");
            } catch (RuntimeException e) {
                view.apresentaInfo("Data é no Passado.");
            }
        } else {
            view.apresentaInfo("Selecione Cliente e Veiculo para locar.");
        }
    }

    private long dateDifferenceFromNow(LocalDate date) {
        LocalDate today = LocalDate.now();
        //LocalDate today = LocalDate.parse("2024-06-17");   //TESTE
        return ChronoUnit.DAYS.between(date, today);
    }

    public void devolverLocacao() {
        if (!view.getTransacoesTable().getSelectionModel().isSelectionEmpty()) {
            try {
                int idveiculo = ttm.getIdOfSelectedVeiculo(view.getTransacoesTable());
                int idlocacao = GetId.getIdLocacaoFromRented(idveiculo);
                double valorDiaria = ttm.getValorDiariaLocacao(view.getTransacoesTable());
                int dias = GetId.getDiasFromRented(idveiculo);
                LocalDate date = ttm.getDateOfSelectedVeiculo(view.getTransacoesTable());
                System.out.println(date);
                long dif = dateDifferenceFromNow(date.plusDays(dias));
                System.out.println("@devolverLocacao(): dias " + dias + "\n Localdate " + date + "\n diff " + dif + "\n");
                System.out.println("idlocacao " + idlocacao + "\n idveiculo " + idveiculo);

                if (dif < 0) { // devolvendo antes da data prevista.
                    System.out.println("\n(dif < 0)devolvendo antes da data prevista.");
                    double pagamentoReduzido = (dias + dif) * valorDiaria;
                    System.out.println("\npagamentoreduzido " + pagamentoReduzido + " Reais\n");
                    locDao.devolverDataNaoPrevista(idlocacao, idveiculo, (int) (dias + dif), pagamentoReduzido);
                    view.apresentaInfo("Valor a pagar: " + pagamentoReduzido + " Reais.");
                    switch (ttm.getTipoVeiculo()) {
                        case 1 ->
                            showAllMotos();
                        case 2 ->
                            showAllAutos();
                        case 3 ->
                            showAllVans();
                    }
                    view.apresentaInfo("Veículo devolvido.");

                } else if (dif > 0) { // devolvendo atrasado.
                    System.out.println("(dif < 0)devolvendo atrasado.");
                    double pagamentoComMulta = (dias + dif) * valorDiaria;
                    System.out.println("\npagamentocommulta " + pagamentoComMulta + " Reais\n");

                    locDao.devolverDataNaoPrevista(idlocacao, idveiculo, (int) (dias + dif), pagamentoComMulta);
                    view.apresentaInfo("Valor a pagar: " + pagamentoComMulta + " Reais.");
                    switch (ttm.getTipoVeiculo()) {
                        case 1 ->
                            showAllMotos();
                        case 2 ->
                            showAllAutos();
                        case 3 ->
                            showAllVans();
                    }
                    view.apresentaInfo("Veículo devolvido.");

                } else { // devolvendo no dia certo.
                    System.out.println("\n(else)devolvendo no dia certo.");
                    locDao.devolver(idlocacao, idveiculo);
                    view.apresentaInfo("Valor a pagar: " + dias * valorDiaria + " Reais.");
                    switch (ttm.getTipoVeiculo()) {
                        case 1 ->
                            showAllMotos();
                        case 2 ->
                            showAllAutos();
                        case 3 ->
                            showAllVans();
                    }
                    view.apresentaInfo("Veículo devolvido.");
                }
            } catch (NullPointerException e) {
                view.apresentaErro("Erro ao mostrar motos na tabela.");
                e.printStackTrace();
            }
        }
    }

    public void showAllMotos() {
        try {
            MotocicletaDaoSql motoDao = new MotocicletaDaoSql();
            ArrayList<Motocicleta> motos = new ArrayList<>();
            ttm.setListaMotos(motos);
            ttm.fireTableDataChanged();
            filtroTransacoesTable.getSorter().setRowFilter(null);
            ttm.setRowCount(0);
            switch (ttm.getTipoTransacao()) {

                case 1 /*Locacao*/ -> {
                    motos = motoDao.getAllToRent();
                }
                case 2 /*Devolução*/ -> {
                    int idcliente = cttm.getIdOfSelectedClient(view.getClientesTransacoesTable());
                    motos = motoDao.getAllLocadasPorCliente(idcliente);
                }
                case 3 /*Venda*/ -> {
                    motos = motoDao.getAllToSell();
                }
            }
            if (motos.isEmpty()) {
                //view.apresentaInfo("não há motocicletas");
            } else {
                ttm.setListaMotos(motos);
                ttm.fireTableDataChanged();
            }
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar motos na tabela.");
            e.printStackTrace();
        }
    }

    public void showAllAutos() {
        try {
            AutomovelDaoSql autoDao = new AutomovelDaoSql();
            ArrayList<Automovel> autos = new ArrayList<>();
            ttm.setListaAutos(autos);
            ttm.fireTableDataChanged();
            filtroTransacoesTable.getSorter().setRowFilter(null);
            ttm.setRowCount(0);
            switch (ttm.getTipoTransacao()) {

                case 1 /*Locacao*/ -> {
                    autos = autoDao.getAllToRent();
                }
                case 2 /*Devolução*/ -> {
                    int idcliente = cttm.getIdOfSelectedClient(view.getClientesTransacoesTable());
                    autos = autoDao.getAllLocadosPorCliente(idcliente);
                }
                case 3 /*Venda*/ -> {
                    autos = autoDao.getAllToSell();
                }
            }
            if (autos.isEmpty()) {
                // view.apresentaInfo("não há automoveis");
            } else {
                ttm.setListaAutos(autos);
                ttm.fireTableDataChanged();
            }
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar autos na tabela.");
            e.printStackTrace();
        }
    }

    public void showAllVans() {
        try {
            VanDaoSql vanDao = new VanDaoSql();
            ArrayList<Van> vans = new ArrayList<>();
            ttm.setListaVans(vans);
            ttm.fireTableDataChanged();
            filtroTransacoesTable.getSorter().setRowFilter(null);
            ttm.setRowCount(0);
            switch (ttm.getTipoTransacao()) {

                case 1 /*Locacao*/ -> {
                    vans = vanDao.getAllToRent();
                }
                case 2 /*Devolução*/ -> {
                    int idcliente = cttm.getIdOfSelectedClient(view.getClientesTransacoesTable());
                    vans = vanDao.getAllLocadasPorCliente(idcliente);
                }
                case 3 /*Venda*/ -> {
                    vans = vanDao.getAllToSell();
                }
            }
            if (vans.isEmpty()) {
                //view.apresentaInfo("não há vans");
            } else {
                ttm.setListaVans(vans);
                ttm.fireTableDataChanged();
            }
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar vans na tabela.");
            e.printStackTrace();
        }
    }

    public void showMotos() {
        try {
            MotocicletaDaoSql motoDao = new MotocicletaDaoSql();
            ArrayList<Motocicleta> motos = new ArrayList<>();
            ttm.setListaMotos(motos);
            ttm.fireTableDataChanged();
            filtroTransacoesTable.getSorter().setRowFilter(null);
            ttm.setRowCount(0);
            motos = motoDao.getAll();
            if (motos.isEmpty()) {
                view.apresentaInfo("não há motocicletas");
            } else {
                ttm.setListaMotos(motos);
                ttm.fireTableDataChanged();
            }
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar motos na tabela.");
            e.printStackTrace();
        }
    }

    public void showAutos() {
        try {
            AutomovelDaoSql autoDao = new AutomovelDaoSql();
            ArrayList<Automovel> autos = new ArrayList<>();
            ttm.setListaAutos(autos);
            ttm.fireTableDataChanged();
            filtroTransacoesTable.getSorter().setRowFilter(null);
            ttm.setRowCount(0);
            autos = autoDao.getAll();
            if (autos.isEmpty()) {
                view.apresentaInfo("nao há automoveis");
            } else {
                ttm.setListaAutos(autos);
                ttm.fireTableDataChanged();
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            view.apresentaErro("Erro ao mostrar autos na tabela.");
            e.printStackTrace();
        }
        //}
    }

    public void showVans() {
        try {
            VanDaoSql vanDao = new VanDaoSql();
            ArrayList<Van> vans = new ArrayList<>();
            ttm.setListaVans(vans);
            ttm.fireTableDataChanged();
            filtroTransacoesTable.getSorter().setRowFilter(null);
            ttm.setRowCount(0);
            vans = vanDao.getAll();
            if (vans.isEmpty()) {
                view.apresentaInfo("nao há vans");
            } else {
                ttm.setListaVans(vans);
                ttm.fireTableDataChanged();
            }
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar vans na tabela.");
            e.printStackTrace();
        }
    }

    public void loadAllCategoriaMarcaCboxes() {
        ComboBox.loadCboxMarca(view.getCboxMarcaTransacoes());
        ComboBox.loadCboxCategoria(view.getCboxCategoriaTransacoes());
    }

    public void setSingleSelectionOnCttm_Ttm() {
        ttm.setSingleSelection(view.getTransacoesTable());
        cttm.setSingleSelection(view.getClientesTransacoesTable());
    }

    public void activateCboxCategoriaTransacoes() {
        String categoria = (String) view.getCboxCategoriaTransacoes().getSelectedItem();
        String marca = (String) view.getCboxMarcaTransacoes().getSelectedItem();

        if (categoria != null && !categoria.isBlank() && (marca == null || marca.isBlank())) {
            // Filter by category only
            filtroTransacoesTable.filtrarPorCategoria(categoria);
        } else if (categoria != null && !categoria.isBlank() && marca != null && !marca.isBlank()) {
            // Filter by both category and brand
            filtroTransacoesTable.filtrarPorMarcaECategoria(marca, categoria);
        } else if ((categoria == null || categoria.isBlank()) && marca != null && !marca.isBlank()) {
            // Filter by brand only
            filtroTransacoesTable.filtrarPorMarca(marca);
        } else {
            // Reset filters and repopulate the table
            // view.getVeiculoTable().setRowSorter(null);
            filtroTransacoesTable.getSorter().setRowFilter(null);
            //ttm.setRowCount(0);

            if (view.getClientesTransacoesTable().getSelectionModel().isSelectionEmpty()) {
                switch (ttm.getTipoVeiculo()) {
                    case 1 -> {
                        showAllMotos();
                        ttm.fireTableDataChanged();
                    }
                    case 2 -> {
                        //showAllAutos();
                        ttm.fireTableDataChanged();
                    }
                    case 3 -> {
                        //showAllVans();
                        ttm.fireTableDataChanged();
                    }
                }
            } else {
                switch (ttm.getTipoVeiculo()) {
                    case 1 -> {
                        showAllMotos();
                        ttm.fireTableDataChanged();
                    }
                    case 2 -> {
                        //showAllAutos();
                        ttm.fireTableDataChanged();
                    }
                    case 3 -> {
                        //showAllVans();
                        ttm.fireTableDataChanged();
                    }
                }
            }

            view.getVeiculosTable().setRowSorter(filtroTransacoesTable.getSorter());
        }
    }

    public void activateCboxMarcaTransacoes() {
        String marca = (String) view.getCboxMarcaTransacoes().getSelectedItem();
        String categoria = (String) view.getCboxCategoriaTransacoes().getSelectedItem();

        if (marca != null && !marca.isBlank() && (categoria == null || categoria.isBlank())) {
            // Filter by brand only
            filtroTransacoesTable.filtrarPorMarca(marca);
        } else if (marca != null && !marca.isBlank() && categoria != null && !categoria.isBlank()) {
            // Filter by both brand and category
            filtroTransacoesTable.filtrarPorMarcaECategoria(marca, categoria);
        } else if ((marca == null || marca.isBlank()) && categoria != null && !categoria.isBlank()) {
            // Filter by category only
            filtroTransacoesTable.filtrarPorCategoria(categoria);
        } else {
            // Reset filters and repopulate the table
            //view.getVeiculoTable().setRowSorter(null);
            filtroTransacoesTable.getSorter().setRowFilter(null);
            //ttm.setRowCount(0);
            if (view.getClientesTransacoesTable().getSelectionModel().isSelectionEmpty()) {
                switch (ttm.getTipoVeiculo()) {
                    case 1 -> {
                        showAllMotos();
                        ttm.fireTableDataChanged();
                    }
                    case 2 -> {
                        //showAllAutos();
                        ttm.fireTableDataChanged();
                    }
                    case 3 -> {
                        //showAllVans();
                        ttm.fireTableDataChanged();
                    }
                }
            } else {
                switch (ttm.getTipoVeiculo()) {
                    case 1 -> {
                        showAllMotos();
                        ttm.fireTableDataChanged();
                    }
                    case 2 -> {
                        //showAllAutos();
                        ttm.fireTableDataChanged();
                    }
                    case 3 -> {
                        //showAllVans();
                        ttm.fireTableDataChanged();
                    }
                }
            }

            view.getVeiculosTable().setRowSorter(filtroTransacoesTable.getSorter());
        }
    }

    public void showClientes() {
        ClienteDaoSql c = new ClienteDaoSql();
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            clientes = c.getAll();
            view.showCttm(clientes);
        } catch (IOException | SQLException | NullPointerException e) {
            view.apresentaErro("Erro ao mostrar Clientes na tabela.");
            e.printStackTrace();
        }
    }

    public void filterCtt(String filterText) {
        filtroClientesTransacoesTable.filtrarPorTexto(filterText);
    }

    public void setVisibilityLocacaoOptions(boolean b) {
        view.getLblNumDiasTransacoes().setVisible(b);
        view.getTxtDiasTransacoes().setVisible(b);
        view.getLblDataTransacoes().setVisible(b);
        view.getFtxtDataTransacoes().setVisible(b);
        view.getBtnLocar().setVisible(b);
    }

    public void setVisibilityDevolucaoOptions(boolean b) {
        view.getBtnDevolver().setVisible(b);
    }
}
