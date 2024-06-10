package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.combo.ComboBox;
import model.connection.MotocicletaDaoSql;
import model.dto.Motocicleta;
import model.dto.Veiculo;
import model.tables.TableFilter;
import model.tables.VeiculosTableModel;
import view.Frame;

public class VeiculosTabController {

    private Frame view;
    private VeiculosTableModel vtm;
    private MotocicletaDaoSql motoDao;
    private TableFilter filtroVeiculoTable;
    //private AutomovelDaoSql autoDao;
    //private VanDaoSql vanDao;

    public VeiculosTabController(Frame view, VeiculosTableModel vtm, TableFilter f, MotocicletaDaoSql motoDao/*,AutomovelDaoSql autoDao, VanDaoSql vanDao*/) {
        this.view = view;
        this.vtm = vtm;
        filtroVeiculoTable = f;
        this.motoDao = motoDao;
        //this.autoDao = autoDao;
        //this.vanDao = vanDao;
    }

    public VeiculosTabController() {
    }

    public void newVeiculo() {
        try {
            Veiculo v = view.getVeiculoFormulario();

            if (v instanceof Motocicleta moto) {
                if (!motoDao.motoExists(moto)) {
                    showMotocicletas();
                    vtm.addVeiculo(moto);//view.addVeiculoToVtm(moto);
                    motoDao.add(moto);
                    view.clearFieldsVeiculo();
                } else {
                    view.apresentaInfo("vehicle already exists");
                }
            }
            /* else if (v instanceof Automovel) {
            Automovel auto = (Automovel) v;
            if (!motoDao.automovelExists(auto)) {
            vtm.addVeiculo(auto);//view.addVeiculoToVtm(auto);
            autoDao.add(auto);
            view.clearFieldsVeiculo();
            } else {
            view.apresentaInfo("vehicle already exists");
            }
            } else if (v instanceof Van) {
            Van van = (Van) v;
            if (!motoDao.vanExists(van)) {
            vtm.addVeiculo(van);//view.addVeiculoToVtm(van);
            vanDao.add(van);
            view.clearFieldsVeiculo();
            } else {
            view.apresentaInfo("vehicle already exists");
            }
            }*/

        } catch (IOException | SQLException | NullPointerException e) {
            view.apresentaErro("Erro ao incluir Veiculo.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            view.apresentaErro("preencha corretamente o ano.");
            e.printStackTrace();
        }
    }

    /*
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
    public void showMotocicletas() {
        MotocicletaDaoSql motoDao = new MotocicletaDaoSql();
        ArrayList<Motocicleta> motos = new ArrayList<>();
        try {
            motos = motoDao.getAll();
            vtm.setListaMotos(motos);//view.showVtmMotos(motos);
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar motocicletas na tabela.");
            e.printStackTrace(); 
        }
    }
    
    public void resetFiltersVeiculosTable(){
        //filtroVeiculoTable.resetFilters(vtm.getTipoVeiculo(), vtm, ArrayList v);
    }
    /*
    public void showAutomoveis() {
        AutomovelDaoSql autoDao = new AutomovelDaoSql();
        ArrayList<Automovel> autos = new ArrayList<>();
        try {
            autos = autoDao.getAll();
            view.showVtmAutos(autos);
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar automoveis na tabela.");
            e.printStackTrace();
        }
    }
    
    public void showVans() {
        MotocicletaDaoSql vanDao = new MotocicletaDaoSql();
        ArrayList<Motocicleta> vans = new ArrayList<>();
        try {
            vans = vanDao.getAll();
            view.showVtmVans(vans);
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar vans na tabela.");
            e.printStackTrace();
        }
    }
     */
    public void loadAllCategoriaMarcaCboxes() {
        ComboBox.loadCboxMarca(view.getCboxMarcaVeiculo());
        ComboBox.loadCboxCategoria(view.getCboxCategoriaVeiculo());
        //...the rest of cboxes implement
    }
    
    public void setSingleSelectionOnVtm(){
        vtm.setSingleSelection(view.getVeiculoTable());
    }


    public void activateCboxCategoriaVeiculos(){
        String marca = (String) view.getCboxMarcaVeiculo().getSelectedItem();
        String categoria = (String) view.getCboxCategoriaVeiculo().getSelectedItem();

        if (!categoria.isBlank() && (marca == null || marca.isBlank())) {
            filtroVeiculoTable.filtrarPorCategoria(categoria);
        } else if (!categoria.isBlank() && (marca != null || !marca.isBlank())) {
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca, categoria);
        } else if (categoria.isBlank() && (marca != null || !marca.isBlank())) {
            filtroVeiculoTable.filtrarPorMarca(marca);
        } else if (categoria.isBlank() && marca.isBlank()) {
            /*//veiculoTable.setRowSorter(null);
            //filtroVeiculoTable.clearFilters();
            //vtm.fireTableDataChanged();*/
        }
    }
    public void activateCboxMarcaVeiculos(){
        String marca = (String) view.getCboxMarcaVeiculo().getSelectedItem();
        String categoria = (String) view.getCboxCategoriaVeiculo().getSelectedItem();

        if (!marca.isBlank() && (categoria == null || categoria.isBlank())) {
            filtroVeiculoTable.filtrarPorMarca(marca);
        } else if (!marca.isBlank() && (categoria != null || !categoria.isBlank())) {
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca, categoria);
        } else if (marca.isBlank() && (categoria != null || !categoria.isBlank())) {
            filtroVeiculoTable.filtrarPorCategoria(categoria);
        } else if (marca.isBlank() && categoria.isBlank()) {
            //veiculoTable.setRowSorter(null);
            /*
            switch (vtm.getTipoVeiculo()) {
                case 1 -> {
                    ctrlVeiculos.showMotocicletas();
                }
                case 2 -> {
                    //ctrlVeiculos.showAutomoveis();
                }
                case 3 -> {
                    //ctrlVeiculos.showVans();
                }
            }*/
        }
    }
}
