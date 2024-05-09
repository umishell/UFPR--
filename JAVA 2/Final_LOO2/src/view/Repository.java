package view;

import java.util.ArrayList;
import java.util.List;
import model.dto.Cliente;
import model.dto.Automovel;
import model.dto.Motocicleta;
import model.dto.Van;

public class Repository {

    private List<Cliente> listaClientes = new ArrayList();
    private List<Van> listaVans = new ArrayList();
    private List<Motocicleta> listaMotocicletas = new ArrayList();
    private List<Automovel> listaAutomoveis = new ArrayList();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Van> getListaVans() {
        return listaVans;
    }

    public List<Motocicleta> getListaMotocicletas() {
        return listaMotocicletas;
    }

    public List<Automovel> getListaAutomoveis() {
        return listaAutomoveis;
    }

    public void gravarCliente(Cliente c) {
        listaClientes.add(c);
    }

    public void gravarVan(Van v) {
        listaVans.add(v);
    }

    public void gravarAutomovel(Automovel a) {
        listaAutomoveis.add(a);
    }

    public void gravarMotocicleta(Motocicleta m) {
        listaMotocicletas.add(m);
    }

    public void apagarCliente(int row) {
        listaClientes.remove(row);
    }

    public void apagarVan(int row) {
        listaVans.remove(row);
    }

    public void apagarMotocicleta(int row) {
        listaMotocicletas.remove(row);
    }

    public void apagarAutomovel(int row) {
        listaAutomoveis.remove(row);
    }

    public void updateRowCliente(int row, Cliente cliente) {
        listaClientes.set(row, cliente);
    }

}
