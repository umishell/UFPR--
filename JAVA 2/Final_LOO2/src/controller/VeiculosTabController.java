package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.connection.ClienteDaoSql;
import model.connection.MotocicletaDaoSql;
import model.dto.Automovel;
import model.dto.Cliente;
import model.dto.Motocicleta;
import model.dto.Van;
import model.dto.Veiculo;
import view.Frame;

public class VeiculosTabController {

    private Frame view;
    private MotocicletaDaoSql motoDao;
    //private AutomovelDaoSql autoDao;
    //private VanDaoSql vanDao;

    public VeiculosTabController(Frame view, MotocicletaDaoSql motoDao/*,AutomovelDaoSql autoDao, VanDaoSql vanDao*/) {
        this.view = view;
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
                    view.addVeiculoToVtm(moto);
                    motoDao.add(moto);
                    view.clearFieldsVeiculo();
                } else {
                    view.apresentaInfo("vehicle already exists");
                }
            }
            /* else if (v instanceof Automovel) {
            Automovel auto = (Automovel) v;
            if (!motoDao.automovelExists(auto)) {
            view.addVeiculoToVtm(auto);
            autoDao.add(auto);
            view.clearFieldsVeiculo();
            } else {
            view.apresentaInfo("vehicle already exists");
            }
            } else if (v instanceof Van) {
            Van van = (Van) v;
            if (!motoDao.vanExists(van)) {
            view.addVeiculoToVtm(van);
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
            view.showVtmMotos(motos);
        } catch (NullPointerException e) {
            view.apresentaErro("Erro ao mostrar motocicletas na tabela.");
            e.printStackTrace();
        }
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
}
