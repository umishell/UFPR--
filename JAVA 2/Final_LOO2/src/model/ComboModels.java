package model;

import model.enums.ModeloVan;
import model.enums.ModeloMotocicleta;
import model.enums.ModeloAutomovel;
import model.enums.Marca;
import model.enums.Estado;
import model.enums.Categoria;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

public class ComboModels {

    private final DefaultComboBoxModel<Estado> estadoModel;
    private final DefaultComboBoxModel<Marca> marcaModel;
    private final DefaultComboBoxModel<Marca> marcaLocacaoModel;
    private final DefaultComboBoxModel<Categoria> categoriaModel;
    private final DefaultComboBoxModel<Categoria> categoriaLocacaoModel;
    private final DefaultComboBoxModel<ModeloMotocicleta> motocicletaModel;
    private final DefaultComboBoxModel<ModeloVan> vanModel;
    private final DefaultComboBoxModel<ModeloAutomovel> automovelModel;
    private final Map<String, DefaultComboBoxModel<String>> comboModels;

    public ComboModels() {
        final Estado[] estados;
        final Marca[] marcas, marcasLocacao;
        final Categoria[] categorias, categoriasLocacao;
        final ModeloMotocicleta[] motocicletas;
        final ModeloVan[] vans;
        final ModeloAutomovel[] automoveis;

        estados = new Estado[Estado.values().length];
        int m = 0;
        for (Estado e : Estado.values()) {
            estados[m] = e;
            m++;
        }
        marcas = new Marca[Marca.values().length];

        int l = 0;
        for (Marca mc : Marca.values()) {
            marcas[l] = mc;
            l++;
        }
        categorias = new Categoria[Categoria.values().length];
        int z = 0;
        for (Categoria c : Categoria.values()) {
            categorias[z] = c;
            z++;
        }
        marcasLocacao = new Marca[Marca.values().length + 1];
        marcasLocacao[0] = null;
        int ll = 1;
        for (Marca mc : Marca.values()) {
            marcasLocacao[ll] = mc;
            ll++;
        }
        categoriasLocacao = new Categoria[Categoria.values().length + 1];
        categoriasLocacao[0] = null;
        int zz = 1;
        for (Categoria c : Categoria.values()) {
            categoriasLocacao[zz] = c;
            zz++;
        }
        motocicletas = new ModeloMotocicleta[ModeloMotocicleta.values().length];
        int i = 0;
        for (ModeloMotocicleta mt : ModeloMotocicleta.values()) {
            motocicletas[i] = mt;
            i++;
        }
        vans = new ModeloVan[ModeloVan.values().length];
        int k = 0;
        for (ModeloVan v : ModeloVan.values()) {
            vans[k] = v;
            k++;
        }
        automoveis = new ModeloAutomovel[ModeloAutomovel.values().length];
        int j = 0;
        for (ModeloAutomovel a : ModeloAutomovel.values()) {
            automoveis[j] = a;
            j++;
        }

        motocicletaModel = new DefaultComboBoxModel<>(motocicletas);
        automovelModel = new DefaultComboBoxModel<>(automoveis);
        vanModel = new DefaultComboBoxModel<>(vans);
        marcaModel = new DefaultComboBoxModel<>(marcas);
        marcaLocacaoModel = new DefaultComboBoxModel<>(marcas);
        categoriaModel = new DefaultComboBoxModel<>(categorias);
        categoriaLocacaoModel = new DefaultComboBoxModel<>(categorias);
        estadoModel = new DefaultComboBoxModel<>(estados);
        comboModels = new HashMap<>();
    }

    public DefaultComboBoxModel<Marca> getMarcaLocacaoModel() {
        return marcaLocacaoModel;
    }

    public DefaultComboBoxModel<Categoria> getCategoriaLocacaoModel() {
        return categoriaLocacaoModel;
    }

    public DefaultComboBoxModel<Categoria> getCategoriaModel() {
        return categoriaModel;
    }

    public DefaultComboBoxModel<Marca> getMarcaModel() {
        return marcaModel;
    }

    public DefaultComboBoxModel<ModeloMotocicleta> getMotocicletaModel() {
        return motocicletaModel;
    }

    public DefaultComboBoxModel<ModeloAutomovel> getAutomovelModel() {
        return automovelModel;
    }

    public DefaultComboBoxModel<ModeloVan> getVanModel() {
        return vanModel;
    }

    public Map<String, DefaultComboBoxModel<String>> getComboModels() {
        return comboModels;
    }

    public DefaultComboBoxModel<Estado> getEstadoModel() {
        return estadoModel;
    }

}
