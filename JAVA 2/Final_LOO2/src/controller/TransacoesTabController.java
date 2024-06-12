package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.combo.ComboBox;
import model.connection.AutomovelDaoSql;
import model.connection.ClienteDaoSql;
import model.connection.LocacaoDaoSql;
import model.connection.MotocicletaDaoSql;
import model.connection.VanDaoSql;
import model.dto.Automovel;
import model.dto.Cliente;
import model.dto.Motocicleta;
import model.dto.Van;
import model.dto.Veiculo;
import model.tables.ClientesTransacoesTableModel;
import model.tables.TableFilter;
import model.tables.TransacoesTableModel;
import view.Frame;

public class TransacoesTabController {

    private Frame view;
    private TransacoesTableModel ttm;
    private ClientesTransacoesTableModel cttm;
    private MotocicletaDaoSql motoDao;
    private TableFilter filtroVeiculoTable;
    private AutomovelDaoSql autoDao;
    private VanDaoSql vanDao;
    private LocacaoDaoSql locDao;

    public TransacoesTabController(Frame view, TransacoesTableModel ttm, ClientesTransacoesTableModel cttm, TableFilter f,
            MotocicletaDaoSql motoDao, AutomovelDaoSql autoDao, VanDaoSql vanDao, LocacaoDaoSql locDao) {
        this.view = view;
        this.ttm = ttm;
        this.cttm = cttm;
        filtroVeiculoTable = f;
        this.motoDao = motoDao;
        this.autoDao = autoDao;
        this.vanDao = vanDao;
        this.locDao = locDao;
    }

    public TransacoesTabController() {
    }
/*
    public void newVeiculo() {
        try {
            Veiculo v = view.getVeiculoFormulario();

            if (v instanceof Motocicleta moto) {
                if (!motoDao.motoExists(moto)) {
                    showMotos();
                    ttm.addVeiculo(moto);//view.addVeiculoToVtm(moto);
                    motoDao.add(moto);
                    view.clearFieldsVeiculo();
                } else {
                    view.apresentaInfo("vehicle already exists");
                }
            } else if (v instanceof Automovel) {
                Automovel auto = (Automovel) v;
                if (!autoDao.autoExists(auto)) {
                    ttm.addVeiculo(auto);//view.addVeiculoToVtm(auto);
                    autoDao.add(auto);
                    view.clearFieldsVeiculo();
                } else {
                    view.apresentaInfo("vehicle already exists");
                }
            } else if (v instanceof Van) {
                Van van = (Van) v;
                if (!vanDao.vanExists(van)) {
                    ttm.addVeiculo(van);//view.addVeiculoToVtm(van);
                    vanDao.add(van);
                    view.clearFieldsVeiculo();
                } else {
                    view.apresentaInfo("vehicle already exists");
                }
            }

        } catch (IOException | SQLException | NullPointerException e) {
            view.apresentaErro("Erro ao incluir Veiculo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            view.apresentaErro("preencha corretamente o ano.");
            e.printStackTrace();
        }
    }

    
    public void updateVeiculo() {
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

    public void deleteVeiculo() {
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
     */
    public void showMotos() {
        try {
            MotocicletaDaoSql motoDao = new MotocicletaDaoSql();
            ArrayList<Motocicleta> motos = new ArrayList<>();
            ttm.setListaMotos(motos);
            ttm.fireTableDataChanged();
            filtroVeiculoTable.getSorter().setRowFilter(null);
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
        // }
    }

    public void showAutos() {
        try {
            AutomovelDaoSql autoDao = new AutomovelDaoSql();
            ArrayList<Automovel> autos = new ArrayList<>();
            ttm.setListaAutos(autos);
            ttm.fireTableDataChanged();
            filtroVeiculoTable.getSorter().setRowFilter(null);
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
            filtroVeiculoTable.getSorter().setRowFilter(null);
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

    public void setSingleSelectionOnVtm_Ttm() {
        ttm.setSingleSelection(view.getTransacoesTable());
        cttm.setSingleSelection(view.getClientesTransacoesTable());
    }

    public void activateCboxCategoriaTransacoes() {
        String categoria = (String) view.getCboxCategoriaTransacoes().getSelectedItem();
        String marca = (String) view.getCboxMarcaTransacoes().getSelectedItem();

        if (categoria != null && !categoria.isBlank() && (marca == null || marca.isBlank())) {
            // Filter by category only
            filtroVeiculoTable.filtrarPorCategoria(categoria);
        } else if (categoria != null && !categoria.isBlank() && marca != null && !marca.isBlank()) {
            // Filter by both category and brand
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca, categoria);
        } else if ((categoria == null || categoria.isBlank()) && marca != null && !marca.isBlank()) {
            // Filter by brand only
            filtroVeiculoTable.filtrarPorMarca(marca);
        } else {
            // Reset filters and repopulate the table
            // view.getVeiculoTable().setRowSorter(null);
            filtroVeiculoTable.getSorter().setRowFilter(null);
            //ttm.setRowCount(0);

            switch (ttm.getTipoVeiculo()) {
                case 1 -> {
                    showMotos();
                    ttm.fireTableDataChanged();
                }
                case 2 -> {
                    showAutos();
                    ttm.fireTableDataChanged();
                }
                case 3 -> {
                    showVans();
                    ttm.fireTableDataChanged();
                }
            }

            view.getVeiculosTable().setRowSorter(filtroVeiculoTable.getSorter());
        }
    }

    public void activateCboxMarcaTransacoes() {
        String marca = (String) view.getCboxMarcaTransacoes().getSelectedItem();
        String categoria = (String) view.getCboxCategoriaTransacoes().getSelectedItem();

        if (marca != null && !marca.isBlank() && (categoria == null || categoria.isBlank())) {
            // Filter by brand only
            filtroVeiculoTable.filtrarPorMarca(marca);
        } else if (marca != null && !marca.isBlank() && categoria != null && !categoria.isBlank()) {
            // Filter by both brand and category
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca, categoria);
        } else if ((marca == null || marca.isBlank()) && categoria != null && !categoria.isBlank()) {
            // Filter by category only
            filtroVeiculoTable.filtrarPorCategoria(categoria);
        } else {
            // Reset filters and repopulate the table
            //view.getVeiculoTable().setRowSorter(null);
            filtroVeiculoTable.getSorter().setRowFilter(null);
            //ttm.setRowCount(0);
            switch (ttm.getTipoVeiculo()) {
                case 1 -> {
                    showMotos();
                    ttm.fireTableDataChanged();
                }
                case 2 -> {
                    showAutos();
                    ttm.fireTableDataChanged();
                }
                case 3 -> {
                    showVans();
                    ttm.fireTableDataChanged();
                }
            }

            view.getVeiculosTable().setRowSorter(filtroVeiculoTable.getSorter());
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
}
