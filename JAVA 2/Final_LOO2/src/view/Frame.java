package view;

import controller.Main;
import controller.ClientesTabController;
import controller.VeiculosTabController;
import model.tables.ClienteLocacaoTableModel;
import model.enums.Categoria;
import model.enums.Marca;
import model.tables.ClienteTableModel;
import model.dto.Cliente;
import model.tables.LocarVeiculoTableModel;
import model.tables.TableFilter;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.combo.ComboBox;
import model.dto.Automovel;
import model.dto.Motocicleta;
import model.dto.Van;
import model.dto.Veiculo;
import model.tables.VeiculoDevolverTableModel;
import model.tables.VeiculoVenderTableModel;
import model.tables.VeiculosTableModel;

public class Frame extends javax.swing.JFrame {

    private Main main;

    private ClientesTabController ctrlClientes;
    private VeiculosTabController ctrlVeiculos;
    //LocacaoTabController ctrlLocacao;
    //DevolucaoTabController ctrlDevolucao;
    //VendaTabController ctrlVenda;

    private ClienteTableModel ctm;
    private LocarVeiculoTableModel lvtm;
    private ClienteLocacaoTableModel cltm;
    private VeiculoDevolverTableModel vdtm;
    private VeiculoVenderTableModel vvtm;
    private VeiculosTableModel vtm;
    private TableFilter filtroVeiculoTable, f1;

    public Frame() {

        //TABLE MODELS
        ctm = new ClienteTableModel();
        vtm = new VeiculosTableModel();
        lvtm = new LocarVeiculoTableModel();
        cltm = new ClienteLocacaoTableModel();
        vdtm = new VeiculoDevolverTableModel();
        vvtm = new VeiculoVenderTableModel();

        initComponents();

        loadAllCategoriaMarcaCboxes();//falta  cboxes!!!

        //FILTERS
        filtroVeiculoTable = new TableFilter();
        filtroVeiculoTable.initFilter(veiculoTable);
        //f1 = new FiltroDeTabela();
        //f1.criarTabela(VendaTable);

        //SET SINGLE SELECTION
        vtm.setSingleSelection(veiculoTable);

    }

    public void initView(Frame frame) {
        frame.setSize(1455, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Example
        frame.setVisible(true);
    }

    public void setControllers(ClientesTabController ctrlClientes, VeiculosTabController ctrlVeiculos/*,
            LocacaoTabController ctrlLocacao, DevolucaoTabController ctrlDevolucao,
            VendaTabController ctrlVenda*/) {

        this.ctrlClientes = ctrlClientes;
        this.ctrlVeiculos = ctrlVeiculos;
        //this.ctrlLocacao = ctrlLocacao;
        //this.ctrlDevolucao = ctrlDevolucao;
        //this.ctrlVenda = ctrlVenda;
    }

    //FOR TESTING
    // public void setControllers(ClientesTabController ctrlClientes) {
    //   this.ctrlClientes = ctrlClientes;
    //}
    public ClienteTableModel getCtm() {
        return ctm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneAllTabs = new javax.swing.JTabbedPane();
        tabVeiculos = new javax.swing.JPanel();
        paneVeiculoTable = new javax.swing.JScrollPane();
        veiculoTable = new javax.swing.JTable();
        btnIncluirVeiculo = new javax.swing.JButton();
        lblValorDaCompra = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        cboxTipo = new javax.swing.JComboBox<>();
        cboxModelo = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel();
        ftxtPlaca = new javax.swing.JFormattedTextField();
        ftxtAno = new javax.swing.JFormattedTextField();
        ftxtValorDeCompra = new javax.swing.JFormattedTextField();
        cboxMarca = new javax.swing.JComboBox<>();
        cboxCategoria = new javax.swing.JComboBox<>();
        btnVansVeiculos = new javax.swing.JButton();
        btnMotocicletasVeiculos = new javax.swing.JButton();
        btnAutomoveisVeiculos = new javax.swing.JButton();
        cboxMarcaVeiculos = new javax.swing.JComboBox<>();
        cboxCategoriaVeiculos = new javax.swing.JComboBox<>();
        tabCliente = new javax.swing.JPanel();
        lblNomeCliente = new javax.swing.JLabel();
        lblSobrenomeCliente = new javax.swing.JLabel();
        lblRgCliente = new javax.swing.JLabel();
        lblCpfCliente = new javax.swing.JLabel();
        lblEnderecoCliente = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtSobrenomeCliente = new javax.swing.JTextField();
        ftxtRgCliente = new javax.swing.JFormattedTextField();
        ftxtCpfCliente = new javax.swing.JFormattedTextField();
        txtEndereco = new javax.swing.JTextField();
        btnIncluirCliente = new javax.swing.JButton();
        btnListarCliente = new javax.swing.JButton();
        btnRemoverCliente = new javax.swing.JButton();
        btnLimparCliente = new javax.swing.JButton();
        btnAtualizarCliente = new javax.swing.JButton();
        paneClienteTable = new javax.swing.JScrollPane();
        clienteTable = new javax.swing.JTable();
        tabLocacao = new javax.swing.JPanel();
        btnVansLocacao = new javax.swing.JButton();
        btnMotocicletasLocacao = new javax.swing.JButton();
        paneVeiculoTableLocacao = new javax.swing.JScrollPane();
        veiculoTableLocacao = new javax.swing.JTable();
        btnAutomoveisLocacao = new javax.swing.JButton();
        cbxMarcaVeiculos = new javax.swing.JComboBox<>();
        cbxCategoriaVeiculos = new javax.swing.JComboBox<>();
        txtPesquisarClientes = new javax.swing.JTextField();
        btnLocar = new javax.swing.JButton();
        paneClienteLocacaoTable = new javax.swing.JScrollPane();
        clienteLocacaoTable = new javax.swing.JTable();
        lblPesquisarClientes = new javax.swing.JLabel();
        ftxtDataLocacao = new javax.swing.JFormattedTextField();
        lblNumDiasLocacao = new javax.swing.JLabel();
        lblDataLocacao = new javax.swing.JLabel();
        txtDiasLocacao = new javax.swing.JFormattedTextField();
        cboxMarcaLocacao = new javax.swing.JComboBox<>();
        cboxCategoriaLocacao = new javax.swing.JComboBox<>();
        tabDevolucao = new javax.swing.JPanel();
        paneDevolverTable = new javax.swing.JScrollPane();
        DevolverTable = new javax.swing.JTable();
        btnVansDevolver = new javax.swing.JButton();
        btnMotocicletasDevolver = new javax.swing.JButton();
        btnAutomoveisDevolver = new javax.swing.JButton();
        tabVenda = new javax.swing.JPanel();
        paneVendaTable = new javax.swing.JScrollPane();
        VendaTable = new javax.swing.JTable();
        cbxCategoriaVeiculosVenda = new javax.swing.JComboBox<>();
        cbxMarcaVeiculosVenda = new javax.swing.JComboBox<>();
        btnAutomoveisVenda = new javax.swing.JButton();
        btnMotocicletasVenda = new javax.swing.JButton();
        btnVansVenda = new javax.swing.JButton();
        cboxMarcaVenda = new javax.swing.JComboBox<>();
        cboxCategoriaVenda = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneAllTabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabVeiculos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabVeiculosComponentShown(evt);
            }
        });

        veiculoTable.setModel(vtm);
        paneVeiculoTable.setViewportView(veiculoTable);
        clienteTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // Verifique se há uma linha selecionada
                if (clienteTable.getSelectedRow() != -1) {
                    // Obtenha o valor da célula na coluna que você está interessado
                    Object nome = clienteTable.getValueAt(clienteTable.getSelectedRow(), 0); // Altere o 0 para o índice da coluna que você deseja
                    Object sobrenome = clienteTable.getValueAt(clienteTable.getSelectedRow(), 1);
                    Object rg = clienteTable.getValueAt(clienteTable.getSelectedRow(), 2);
                    Object cpf = clienteTable.getValueAt(clienteTable.getSelectedRow(), 3);
                    Object endereco = clienteTable.getValueAt(clienteTable.getSelectedRow(), 4);
                    // Defina o valor no JTextField
                    txtNomeCliente.setText(nome.toString());
                    txtSobrenomeCliente.setText(sobrenome.toString());
                    ftxtRgCliente.setText(rg.toString());
                    ftxtCpfCliente.setText(cpf.toString());
                    txtEndereco.setText(endereco.toString());

                }
            }
        });

        btnIncluirVeiculo.setText("Incluir");
        btnIncluirVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirVeiculoActionPerformed(evt);
            }
        });

        lblValorDaCompra.setText("valor de compra");

        lblPlaca.setText("placa");

        lblModelo.setText("modelo");

        lblMarca.setText("marca");

        lblCategoria.setText("categoria");

        lblAno.setText("ano");

        cboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Motocicleta", "Automovel", "Van" }));
        cboxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTipoActionPerformed(evt);
            }
        });

        cboxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cboxModeloMouseReleased(evt);
            }
        });
        cboxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxModeloActionPerformed(evt);
            }
        });

        lblTipo.setText("tipo");

        try {
            ftxtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            ftxtAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ftxtValorDeCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));

        cboxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMarcaActionPerformed(evt);
            }
        });

        cboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaActionPerformed(evt);
            }
        });

        btnVansVeiculos.setText("Vans");
        btnVansVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVansVeiculosActionPerformed(evt);
            }
        });

        btnMotocicletasVeiculos.setText("Motocicletas");
        btnMotocicletasVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotocicletasVeiculosActionPerformed(evt);
            }
        });

        btnAutomoveisVeiculos.setText("Automoveis");
        btnAutomoveisVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutomoveisVeiculosActionPerformed(evt);
            }
        });

        cboxMarcaVeiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxMarcaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMarcaVeiculosActionPerformed(evt);
            }
        });

        cboxCategoriaVeiculos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxCategoriaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaVeiculosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabVeiculosLayout = new javax.swing.GroupLayout(tabVeiculos);
        tabVeiculos.setLayout(tabVeiculosLayout);
        tabVeiculosLayout.setHorizontalGroup(
            tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVeiculosLayout.createSequentialGroup()
                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblModelo)
                                .addGroup(tabVeiculosLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(lblValorDaCompra)
                                    .addGap(18, 18, 18)
                                    .addComponent(ftxtValorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(tabVeiculosLayout.createSequentialGroup()
                                    .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblAno)
                                        .addComponent(lblPlaca))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ftxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ftxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(tabVeiculosLayout.createSequentialGroup()
                                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                                        .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabVeiculosLayout.createSequentialGroup()
                                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboxMarca, 0, 118, Short.MAX_VALUE)
                                        .addComponent(cboxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cboxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnIncluirVeiculo)))
                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(paneVeiculoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnMotocicletasVeiculos)
                        .addGap(63, 63, 63)
                        .addComponent(btnAutomoveisVeiculos)
                        .addGap(69, 69, 69)
                        .addComponent(btnVansVeiculos)
                        .addGap(72, 72, 72)
                        .addComponent(cboxMarcaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cboxCategoriaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        tabVeiculosLayout.setVerticalGroup(
            tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVeiculosLayout.createSequentialGroup()
                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModelo)
                            .addComponent(cboxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValorDaCompra)
                            .addComponent(ftxtValorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlaca)
                            .addComponent(ftxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAno)
                            .addComponent(ftxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnIncluirVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboxMarcaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboxCategoriaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVansVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMotocicletasVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAutomoveisVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(paneVeiculoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        paneAllTabs.addTab("Veículos", tabVeiculos);

        lblNomeCliente.setText("Nome");

        lblSobrenomeCliente.setText("Sobrenome");

        lblRgCliente.setText("RG");

        lblCpfCliente.setText("CPF");

        lblEnderecoCliente.setText("Endereço");

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        try {
            ftxtRgCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtRgCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtRgClienteActionPerformed(evt);
            }
        });

        try {
            ftxtCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtCpfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtCpfClienteActionPerformed(evt);
            }
        });

        btnIncluirCliente.setText("Incluir");
        btnIncluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirClienteActionPerformed(evt);
            }
        });

        btnListarCliente.setText("Listar");
        btnListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarClienteActionPerformed(evt);
            }
        });

        btnRemoverCliente.setText("Remover");
        btnRemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverClienteActionPerformed(evt);
            }
        });

        btnLimparCliente.setText("Limpar");
        btnLimparCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparClienteActionPerformed(evt);
            }
        });

        btnAtualizarCliente.setText("Atualizar");
        btnAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarClienteActionPerformed(evt);
            }
        });

        clienteTable.setModel(ctm);
        paneClienteTable.setViewportView(clienteTable);
        clienteTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // Verifique se há uma linha selecionada
                if (clienteTable.getSelectedRow() != -1) {
                    // Obtenha o valor da célula na coluna que você está interessado
                    Object nome = clienteTable.getValueAt(clienteTable.getSelectedRow(), 0); // Altere o 0 para o índice da coluna que você deseja
                    Object sobrenome = clienteTable.getValueAt(clienteTable.getSelectedRow(), 1);
                    Object rg = clienteTable.getValueAt(clienteTable.getSelectedRow(), 2);
                    Object cpf = clienteTable.getValueAt(clienteTable.getSelectedRow(), 3);
                    Object endereco = clienteTable.getValueAt(clienteTable.getSelectedRow(), 4);
                    // Defina o valor no JTextField
                    txtNomeCliente.setText(nome.toString());
                    txtSobrenomeCliente.setText(sobrenome.toString());
                    ftxtRgCliente.setText(rg.toString());
                    ftxtCpfCliente.setText(cpf.toString());
                    txtEndereco.setText(endereco.toString());

                }
            }
        });

        javax.swing.GroupLayout tabClienteLayout = new javax.swing.GroupLayout(tabCliente);
        tabCliente.setLayout(tabClienteLayout);
        tabClienteLayout.setHorizontalGroup(
            tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabClienteLayout.createSequentialGroup()
                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabClienteLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCpfCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEnderecoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSobrenomeCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSobrenomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtCpfCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tabClienteLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblNomeCliente)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabClienteLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblRgCliente)
                            .addGap(18, 18, 18)
                            .addComponent(ftxtRgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabClienteLayout.createSequentialGroup()
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabClienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnIncluirCliente)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizarCliente))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabClienteLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnRemoverCliente)))
                        .addGap(53, 53, 53)
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnListarCliente)
                            .addComponent(btnLimparCliente))))
                .addGap(30, 30, 30)
                .addComponent(paneClienteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        tabClienteLayout.setVerticalGroup(
            tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabClienteLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabClienteLayout.createSequentialGroup()
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeCliente)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSobrenomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSobrenomeCliente))
                        .addGap(18, 18, 18)
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtRgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRgCliente))
                        .addGap(18, 18, 18)
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpfCliente))
                        .addGap(18, 18, 18)
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEnderecoCliente))
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabClienteLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnIncluirCliente)
                                    .addComponent(btnAtualizarCliente)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListarCliente)))
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabClienteLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnRemoverCliente))
                            .addGroup(tabClienteLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnLimparCliente))))
                    .addComponent(paneClienteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141))
        );

        paneAllTabs.addTab("Clientes", tabCliente);

        tabLocacao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabLocacaoComponentShown(evt);
            }
        });

        btnVansLocacao.setText("Vans");
        btnVansLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVansLocacaoActionPerformed(evt);
            }
        });

        btnMotocicletasLocacao.setText("Motocicletas");
        btnMotocicletasLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotocicletasLocacaoActionPerformed(evt);
            }
        });

        veiculoTableLocacao.setModel(lvtm);
        veiculoTableLocacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                veiculoTableLocacaoMousePressed(evt);
            }
        });
        paneVeiculoTableLocacao.setViewportView(veiculoTableLocacao);

        btnAutomoveisLocacao.setText("Automoveis");
        btnAutomoveisLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutomoveisLocacaoActionPerformed(evt);
            }
        });

        cbxMarcaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarcaVeiculosActionPerformed(evt);
            }
        });

        cbxCategoriaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaVeiculosActionPerformed(evt);
            }
        });

        txtPesquisarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarClientesActionPerformed(evt);
            }
        });
        txtPesquisarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarClientesKeyReleased(evt);
            }
        });

        btnLocar.setText("Locar");
        btnLocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocarActionPerformed(evt);
            }
        });

        clienteLocacaoTable.setModel(cltm);
        paneClienteLocacaoTable.setViewportView(clienteLocacaoTable);

        lblPesquisarClientes.setText("Pesquisar Clientes");

        try {
            ftxtDataLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtDataLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtDataLocacaoActionPerformed(evt);
            }
        });

        lblNumDiasLocacao.setText("numDiasLocacao");

        lblDataLocacao.setText("data");

        try {
            txtDiasLocacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cboxMarcaLocacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxMarcaLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMarcaLocacaoActionPerformed(evt);
            }
        });

        cboxCategoriaLocacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout tabLocacaoLayout = new javax.swing.GroupLayout(tabLocacao);
        tabLocacao.setLayout(tabLocacaoLayout);
        tabLocacaoLayout.setHorizontalGroup(
            tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabLocacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabLocacaoLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(paneClienteLocacaoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabLocacaoLayout.createSequentialGroup()
                        .addComponent(lblPesquisarClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisarClientes))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabLocacaoLayout.createSequentialGroup()
                        .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabLocacaoLayout.createSequentialGroup()
                                .addComponent(lblNumDiasLocacao)
                                .addGap(33, 33, 33))
                            .addGroup(tabLocacaoLayout.createSequentialGroup()
                                .addComponent(lblDataLocacao)
                                .addGap(43, 43, 43)))
                        .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabLocacaoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtDiasLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(btnLocar))
                            .addGroup(tabLocacaoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(ftxtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabLocacaoLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnVansLocacao)
                        .addGap(72, 72, 72)
                        .addComponent(btnMotocicletasLocacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutomoveisLocacao)
                        .addGap(38, 38, 38)
                        .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMarcaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxMarcaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxCategoriaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCategoriaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabLocacaoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(paneVeiculoTableLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107))
        );
        tabLocacaoLayout.setVerticalGroup(
            tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabLocacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxMarcaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCategoriaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVansLocacao)
                    .addComponent(btnMotocicletasLocacao)
                    .addComponent(btnAutomoveisLocacao)
                    .addComponent(cbxMarcaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoriaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesquisarClientes))
                .addGap(18, 18, 18)
                .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabLocacaoLayout.createSequentialGroup()
                        .addComponent(paneVeiculoTableLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(tabLocacaoLayout.createSequentialGroup()
                        .addComponent(paneClienteLocacaoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLocar)
                            .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNumDiasLocacao)
                                .addComponent(txtDiasLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(tabLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataLocacao))
                        .addGap(54, 54, 54))))
        );

        paneAllTabs.addTab("Locação", tabLocacao);

        tabDevolucao.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabDevolucaoComponentShown(evt);
            }
        });

        DevolverTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DevolverTableMousePressed(evt);
            }
        });
        paneDevolverTable.setViewportView(DevolverTable);

        btnVansDevolver.setText("Vans");
        btnVansDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVansDevolverActionPerformed(evt);
            }
        });

        btnMotocicletasDevolver.setText("Motocicletas");
        btnMotocicletasDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotocicletasDevolverActionPerformed(evt);
            }
        });

        btnAutomoveisDevolver.setText("Automoveis");
        btnAutomoveisDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutomoveisDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabDevolucaoLayout = new javax.swing.GroupLayout(tabDevolucao);
        tabDevolucao.setLayout(tabDevolucaoLayout);
        tabDevolucaoLayout.setHorizontalGroup(
            tabDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDevolucaoLayout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addGroup(tabDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneDevolverTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabDevolucaoLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnVansDevolver)
                        .addGap(28, 28, 28)
                        .addComponent(btnMotocicletasDevolver)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutomoveisDevolver)
                        .addGap(231, 231, 231)))
                .addGap(270, 270, 270))
        );
        tabDevolucaoLayout.setVerticalGroup(
            tabDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDevolucaoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(tabDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVansDevolver)
                    .addComponent(btnMotocicletasDevolver)
                    .addComponent(btnAutomoveisDevolver))
                .addGap(18, 18, 18)
                .addComponent(paneDevolverTable, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        paneAllTabs.addTab("Devolução", tabDevolucao);

        VendaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                VendaTableMousePressed(evt);
            }
        });
        paneVendaTable.setViewportView(VendaTable);

        cbxCategoriaVeiculosVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaVeiculosVendaActionPerformed(evt);
            }
        });

        cbxMarcaVeiculosVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMarcaVeiculosVendaActionPerformed(evt);
            }
        });

        btnAutomoveisVenda.setText("Automoveis");
        btnAutomoveisVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutomoveisVendaActionPerformed(evt);
            }
        });

        btnMotocicletasVenda.setText("Motocicletas");
        btnMotocicletasVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotocicletasVendaActionPerformed(evt);
            }
        });

        btnVansVenda.setText("Vans");
        btnVansVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVansVendaActionPerformed(evt);
            }
        });

        cboxMarcaVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        cboxCategoriaVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout tabVendaLayout = new javax.swing.GroupLayout(tabVenda);
        tabVenda.setLayout(tabVendaLayout);
        tabVendaLayout.setHorizontalGroup(
            tabVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVendaLayout.createSequentialGroup()
                .addContainerGap(376, Short.MAX_VALUE)
                .addGroup(tabVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneVendaTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabVendaLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnVansVenda)
                        .addGap(28, 28, 28)
                        .addComponent(btnMotocicletasVenda)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutomoveisVenda)
                        .addGap(38, 38, 38)
                        .addGroup(tabVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabVendaLayout.createSequentialGroup()
                                .addComponent(cboxMarcaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxCategoriaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabVendaLayout.createSequentialGroup()
                                .addComponent(cbxMarcaVeiculosVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cbxCategoriaVeiculosVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(251, 251, 251))
        );
        tabVendaLayout.setVerticalGroup(
            tabVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxMarcaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCategoriaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVansVenda)
                    .addComponent(btnMotocicletasVenda)
                    .addComponent(btnAutomoveisVenda)
                    .addComponent(cbxMarcaVeiculosVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoriaVeiculosVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(paneVendaTable, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        paneAllTabs.addTab("Venda", tabVenda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneAllTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneAllTabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void btnIncluirVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirVeiculoActionPerformed
        //String tipoVeiculo = (String) cboxTipo.getSelectedItem();
        ctrlVeiculos.newVeiculo();
        /*      Marca marca = (Marca) cbxMarca.getSelectedItem();
        Estado estado = (Estado) cbxEstado.getSelectedItem();
        Locacao locacao = null;
        Categoria categoria = (Categoria) cbxCategoria.getSelectedItem();
        //valor de compra
        String str = ftxtValorDeCompra.getText();
        double valorDeCompra = 0;
        try {
            if (str != null && !str.isEmpty()) {
                valorDeCompra = Double.parseDouble(str);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
        }

        String placa = ftxtPlaca.getText();
        //ano
        String str0 = ftxtAno.getText();
        int ano = 0;
        try {
            if (str0 != null && !str0.isEmpty()) {
                ano = Integer.parseInt(ftxtAno.getText());
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
        }

        //model,contructors,adding
        if ("Motocicleta".equals(cbxTipo.getSelectedItem())) {
            ModeloMotocicleta modeloMoto = (ModeloMotocicleta) cboxModelo.getSelectedItem();
            Motocicleta motocicleta = new Motocicleta(marca, estado, locacao, categoria, valorDeCompra, placa, ano, modeloMoto);
            SwingUtilities.invokeLater(() -> {
                lvtm.addMotocicleta(motocicleta);
            });

        } else if ("Automóvel".equals(cbxTipo.getSelectedItem())) {
            ModeloAutomovel modeloAuto = (ModeloAutomovel) cboxModelo.getSelectedItem();
            Automovel automovel = new Automovel(marca, estado, locacao, categoria, valorDeCompra, placa, ano, modeloAuto);
            lvtm.addAutomovel(automovel);
        } else if ("Van".equals(cbxTipo.getSelectedItem())) {
            ModeloVan modeloVan = (ModeloVan) cboxModelo.getSelectedItem();
            Van van = new Van(marca, estado, locacao, categoria, valorDeCompra, placa, ano, modeloVan);
            lvtm.addVan(van);
        }
        ftxtValorDeCompra.setText("");
        ftxtPlaca.setText("");
        ftxtAno.setText("");
         */
    }//GEN-LAST:event_btnIncluirVeiculoActionPerformed

    private void tabVeiculosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabVeiculosComponentShown
        // Cmarca.setModel(cm.getMarcaModel());
        //Ccategoria.setModel(cm.getCategoriaModel());

    }//GEN-LAST:event_tabVeiculosComponentShown

    private void ftxtCpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtCpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtCpfClienteActionPerformed


    private void veiculoTableLocacaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_veiculoTableLocacaoMousePressed
        JTable table = (JTable) evt.getSource();
        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        if (evt.getClickCount() == 2) {
            // Your code here
        }
    }//GEN-LAST:event_veiculoTableLocacaoMousePressed

    private void btnVansLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansLocacaoActionPerformed
        lvtm.setTipoVeiculo(1);
        lvtm.setListaVeiculos();
    }//GEN-LAST:event_btnVansLocacaoActionPerformed

    private void btnMotocicletasLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasLocacaoActionPerformed
        lvtm.setTipoVeiculo(2);
        lvtm.setListaVeiculos();
    }//GEN-LAST:event_btnMotocicletasLocacaoActionPerformed

    private void btnAutomoveisLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisLocacaoActionPerformed
        lvtm.setTipoVeiculo(3);
        lvtm.setListaVeiculos();
    }//GEN-LAST:event_btnAutomoveisLocacaoActionPerformed

    private void tabLocacaoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabLocacaoComponentShown
        ClienteLocacaoTableModel modeloTabela = (ClienteLocacaoTableModel) clienteLocacaoTable.getModel();
        modeloTabela.filtrarClientes("");
    }//GEN-LAST:event_tabLocacaoComponentShown

    private void cbxMarcaVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarcaVeiculosActionPerformed
        String marca = (String) cbxMarcaVeiculos.getSelectedItem();
        filtroVeiculoTable.filtrarPorMarca(marca);
    }//GEN-LAST:event_cbxMarcaVeiculosActionPerformed

    private void cbxCategoriaVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaVeiculosActionPerformed
        String categoria = (String) cbxCategoriaVeiculos.getSelectedItem();
        filtroVeiculoTable.filtrarPorMarca(categoria);
    }//GEN-LAST:event_cbxCategoriaVeiculosActionPerformed

    private void txtPesquisarClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarClientesKeyReleased
        String textoPesquisa = txtPesquisarClientes.getText();
        //filtrarPesquisa(textoPesquisa);
    }//GEN-LAST:event_txtPesquisarClientesKeyReleased

    private void txtPesquisarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarClientesActionPerformed

    private void btnLocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocarActionPerformed
        //setComVeiculoLocado
/*      Cliente c = null;
        int lscliente = clienteLocacaoTable.getSelectedRow();
        if (lscliente != -1) {
            Cliente clienteSelecionado = rep.getListaClientes().get(lscliente);
            clienteSelecionado.setComVeiculoLocado(true);
            c = clienteSelecionado;
        }

        int dias = Integer.parseInt(txtDiasLocacao.getText());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Altere para o formato da sua data
        Date dataDate;
        try {
            dataDate = formato.parse(ftxtDataLocacao.getText());
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        Calendar data = Calendar.getInstance();
        data.setTime(dataDate);

        locarVeiculo(dias, data, c);
         */
    }//GEN-LAST:event_btnLocarActionPerformed

    private void VendaTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VendaTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_VendaTableMousePressed

    private void cbxCategoriaVeiculosVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaVeiculosVendaActionPerformed
        Marca marca = (Marca) cbxCategoriaVeiculosVenda.getSelectedItem();
        f1.filtrarPorMarca(marca.name());
    }//GEN-LAST:event_cbxCategoriaVeiculosVendaActionPerformed

    private void cbxMarcaVeiculosVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMarcaVeiculosVendaActionPerformed
        Marca marca = (Marca) cbxMarcaVeiculosVenda.getSelectedItem();
        f1.filtrarPorMarca(marca.name());
    }//GEN-LAST:event_cbxMarcaVeiculosVendaActionPerformed

    private void btnAutomoveisVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisVendaActionPerformed
        //vvtm.setTipoVeiculo(3);
        //vvtm.setListaVeiculos();
    }//GEN-LAST:event_btnAutomoveisVendaActionPerformed

    private void btnMotocicletasVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasVendaActionPerformed
        // vvtm.setTipoVeiculo(2);
        //vvtm.setListaVeiculos();
    }//GEN-LAST:event_btnMotocicletasVendaActionPerformed

    private void btnVansVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansVendaActionPerformed
        //vvtm.setTipoVeiculo(1);
        //vvtm.setListaVeiculos();
    }//GEN-LAST:event_btnVansVendaActionPerformed

    private void DevolverTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DevolverTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DevolverTableMousePressed

    private void btnVansDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansDevolverActionPerformed
        //vdtm.setTipoVeiculo(1);
        //vdtm.setListaVeiculos();
    }//GEN-LAST:event_btnVansDevolverActionPerformed

    private void btnMotocicletasDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasDevolverActionPerformed
        //vdtm.setTipoVeiculo(2);
        //vdtm.setListaVeiculos();
    }//GEN-LAST:event_btnMotocicletasDevolverActionPerformed

    private void btnAutomoveisDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisDevolverActionPerformed
        //vdtm.setTipoVeiculo(3);
        //vdtm.setListaVeiculos();
    }//GEN-LAST:event_btnAutomoveisDevolverActionPerformed

    private void ftxtDataLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtDataLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtDataLocacaoActionPerformed

    private void tabDevolucaoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabDevolucaoComponentShown

    }//GEN-LAST:event_tabDevolucaoComponentShown

    private void cboxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaActionPerformed
        boolean cboxCategoriaIsEmpty = cboxMarca.getModel().getSize() == 0;
        if (!cboxCategoriaIsEmpty) {
            String type = (String) cboxTipo.getSelectedItem();
            String marca = (String) cboxMarca.getSelectedItem();
            String categoria = (String) cboxCategoria.getSelectedItem();
            if (!"".equals(type) && !"".equals(marca)) {
                ComboBox.loadCboxModelo(cboxModelo, type, marca, categoria);
            }
        }
    }//GEN-LAST:event_cboxMarcaActionPerformed

    private void ftxtRgClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtRgClienteActionPerformed

    }//GEN-LAST:event_ftxtRgClienteActionPerformed

    private void cboxModeloMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboxModeloMouseReleased

    }//GEN-LAST:event_cboxModeloMouseReleased

    private void cboxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTipoActionPerformed
        boolean cboxMarcaIsEmpty = cboxMarca.getModel().getSize() == 0;
        boolean cboxCategoriaIsEmpty = cboxMarca.getModel().getSize() == 0;

        if (cboxMarcaIsEmpty) {
            ComboBox.loadCboxMarca(cboxMarca);
        }
        if (cboxCategoriaIsEmpty)
            ComboBox.loadCboxCategoria(cboxCategoria);
    }//GEN-LAST:event_cboxTipoActionPerformed

    private void cboxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaActionPerformed
        String type = (String) cboxTipo.getSelectedItem();
        String marca = (String) cboxMarca.getSelectedItem();
        String categoria = (String) cboxCategoria.getSelectedItem();
        if (!"".equals(type) && !"".equals(marca)) {
            ComboBox.loadCboxModelo(cboxModelo, type, marca, categoria);
        }
    }//GEN-LAST:event_cboxCategoriaActionPerformed

    private void btnLimparClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparClienteActionPerformed
        ctm.limpaTabela();
        clearFieldsCliente();
    }//GEN-LAST:event_btnLimparClienteActionPerformed

    private void btnListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarClienteActionPerformed
        ctrlClientes.showClientes();
    }//GEN-LAST:event_btnListarClienteActionPerformed

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed
        ctrlClientes.updateCliente();
    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    private void btnRemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverClienteActionPerformed
        ctrlClientes.deleteCliente();
    }//GEN-LAST:event_btnRemoverClienteActionPerformed

    private void btnIncluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirClienteActionPerformed
        ctrlClientes.newCliente();
    }//GEN-LAST:event_btnIncluirClienteActionPerformed

    private void cboxMarcaLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxMarcaLocacaoActionPerformed

    private void btnVansVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansVeiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVansVeiculosActionPerformed

    private void btnMotocicletasVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasVeiculosActionPerformed
        vtm.setTipoVeiculo(1);//tipo 1 moto
        ctrlVeiculos.showMotocicletas();
    }//GEN-LAST:event_btnMotocicletasVeiculosActionPerformed

    private void btnAutomoveisVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisVeiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAutomoveisVeiculosActionPerformed

    private void cboxMarcaVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaVeiculosActionPerformed
        /*        if (cboxCategoriaVeiculos.getSelectedItem() == null){
            String marca = (String) cbxMarcaVeiculos.getSelectedItem();
            filtroVeiculoTable.filtrarPorMarca(marca);
        }else{
            String marca = (String) cbxMarcaVeiculos.getSelectedItem();
             String categoria = (String) cbxCategoriaVeiculos.getSelectedItem();
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca,categoria);
        }
         */
        String marca = (String) cbxMarcaVeiculos.getSelectedItem();
        String categoria = (String) cbxCategoriaVeiculos.getSelectedItem();

        if (marca != null && (categoria == null || categoria.isEmpty())) {
            filtroVeiculoTable.filtrarPorMarca(marca);
        } else if (marca != null && categoria != null) {
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca, categoria);
        }
    }//GEN-LAST:event_cboxMarcaVeiculosActionPerformed

    private void cboxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxModeloActionPerformed

    private void cboxCategoriaVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaVeiculosActionPerformed
        /*if (cboxMarcaVeiculos.getSelectedItem() == null) {
            String categoria = (String) cbxCategoriaVeiculos.getSelectedItem();
            filtroVeiculoTable.filtrarPorCategoria(categoria);
        } else {
            String categoria = (String) cbxCategoriaVeiculos.getSelectedItem();
            String marca = (String) cbxMarcaVeiculos.getSelectedItem();
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca, categoria);
        }*/
        String marca = (String) cbxMarcaVeiculos.getSelectedItem();
        String categoria = (String) cbxCategoriaVeiculos.getSelectedItem();

        if (categoria != null && (marca == null || marca.isEmpty())) {
            filtroVeiculoTable.filtrarPorCategoria(categoria);
        } else if (categoria != null && marca != null) {
            filtroVeiculoTable.filtrarPorMarcaECategoria(marca, categoria);
        }
    }//GEN-LAST:event_cboxCategoriaVeiculosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DevolverTable;
    private javax.swing.JTable VendaTable;
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnAutomoveisDevolver;
    private javax.swing.JButton btnAutomoveisLocacao;
    private javax.swing.JButton btnAutomoveisVeiculos;
    private javax.swing.JButton btnAutomoveisVenda;
    private javax.swing.JButton btnIncluirCliente;
    private javax.swing.JButton btnIncluirVeiculo;
    private javax.swing.JButton btnLimparCliente;
    private javax.swing.JButton btnListarCliente;
    private javax.swing.JButton btnLocar;
    private javax.swing.JButton btnMotocicletasDevolver;
    private javax.swing.JButton btnMotocicletasLocacao;
    private javax.swing.JButton btnMotocicletasVeiculos;
    private javax.swing.JButton btnMotocicletasVenda;
    private javax.swing.JButton btnRemoverCliente;
    private javax.swing.JButton btnVansDevolver;
    private javax.swing.JButton btnVansLocacao;
    private javax.swing.JButton btnVansVeiculos;
    private javax.swing.JButton btnVansVenda;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxCategoriaLocacao;
    private javax.swing.JComboBox<String> cboxCategoriaVeiculos;
    private javax.swing.JComboBox<String> cboxCategoriaVenda;
    private javax.swing.JComboBox<String> cboxMarca;
    private javax.swing.JComboBox<String> cboxMarcaLocacao;
    private javax.swing.JComboBox<String> cboxMarcaVeiculos;
    private javax.swing.JComboBox<String> cboxMarcaVenda;
    private javax.swing.JComboBox<Object> cboxModelo;
    private javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JComboBox<Categoria> cbxCategoriaVeiculos;
    private javax.swing.JComboBox<Categoria> cbxCategoriaVeiculosVenda;
    private javax.swing.JComboBox<Marca> cbxMarcaVeiculos;
    private javax.swing.JComboBox<Marca> cbxMarcaVeiculosVenda;
    private javax.swing.JTable clienteLocacaoTable;
    private javax.swing.JTable clienteTable;
    private javax.swing.JFormattedTextField ftxtAno;
    private javax.swing.JFormattedTextField ftxtCpfCliente;
    private javax.swing.JFormattedTextField ftxtDataLocacao;
    private javax.swing.JFormattedTextField ftxtPlaca;
    private javax.swing.JFormattedTextField ftxtRgCliente;
    private javax.swing.JFormattedTextField ftxtValorDeCompra;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCpfCliente;
    private javax.swing.JLabel lblDataLocacao;
    private javax.swing.JLabel lblEnderecoCliente;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNumDiasLocacao;
    private javax.swing.JLabel lblPesquisarClientes;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblRgCliente;
    private javax.swing.JLabel lblSobrenomeCliente;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValorDaCompra;
    private javax.swing.JTabbedPane paneAllTabs;
    private javax.swing.JScrollPane paneClienteLocacaoTable;
    private javax.swing.JScrollPane paneClienteTable;
    private javax.swing.JScrollPane paneDevolverTable;
    private javax.swing.JScrollPane paneVeiculoTable;
    private javax.swing.JScrollPane paneVeiculoTableLocacao;
    private javax.swing.JScrollPane paneVendaTable;
    private javax.swing.JPanel tabCliente;
    private javax.swing.JPanel tabDevolucao;
    private javax.swing.JPanel tabLocacao;
    private javax.swing.JPanel tabVeiculos;
    private javax.swing.JPanel tabVenda;
    private javax.swing.JFormattedTextField txtDiasLocacao;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtPesquisarClientes;
    private javax.swing.JTextField txtSobrenomeCliente;
    private javax.swing.JTable veiculoTable;
    private javax.swing.JTable veiculoTableLocacao;
    // End of variables declaration//GEN-END:variables

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void addClienteToCtm(Cliente cliente) {
        ctm.add(cliente);
    }

    public Cliente getClienteFormulario() {
        String nome = txtNomeCliente.getText();
        String sobrenome = txtSobrenomeCliente.getText();
        String rg = ftxtRgCliente.getText();
        String cpf = ftxtCpfCliente.getText();
        String endereco = txtEndereco.getText();
        if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "preencha o nome, sobrenome e cpf.");
        } else {
            return new Cliente(nome, sobrenome, rg, cpf, endereco);
        }
        return null;
    }

    public void addVeiculoToVtm(Veiculo v) {
        vtm.addVeiculo(v);
    }

    public Veiculo getVeiculoFormulario() throws NumberFormatException {
        String tipo = (String) cboxTipo.getSelectedItem();
        String marca = (String) cboxMarca.getSelectedItem();
        String categoria = (String) cboxCategoria.getSelectedItem();
        String modelo = (String) cboxModelo.getSelectedItem();

        Double valorDeCompra = Double.parseDouble(ftxtValorDeCompra.getText());
        String placa = ftxtPlaca.getText();
        int ano = Integer.parseInt(ftxtAno.getText());
        if (modelo.isBlank() || placa.isBlank()) {
            JOptionPane.showMessageDialog(null, "escolha marca, categoria e modelo, e preencha a placa do veiculo.");
        } else {
            return switch (tipo) {
                case "Motocicleta" ->
                    new Motocicleta(marca, categoria, valorDeCompra, placa, ano, modelo);
                case "Automovel" ->
                    new Automovel(marca, categoria, valorDeCompra, placa, ano, modelo);
                case "Van" ->
                    new Van(marca, categoria, valorDeCompra, placa, ano, modelo);
                default ->
                    null;
            };
        }
        return null;
    }

    public void updateClienteAtCtm(int row, Cliente cliente) {
        ctm.setValuesAtRow(row, cliente);
    }

    public int getSelectedRowAtClienteTable() {
        return clienteTable.getSelectedRow();
    }

    public ArrayList<Cliente> removeClientesFromSelectedRowsAtCtm() {
        return ctm.removeSelectedRows(clienteTable);
    }

    public void removeSelectedRowsAtClienteTable() {

        ctm.removeSelectedRows(clienteTable);
    }

    public void clearFieldsCliente() {
        txtNomeCliente.setText("");
        txtSobrenomeCliente.setText("");
        ftxtRgCliente.setText("");
        ftxtCpfCliente.setText("");
        txtEndereco.setText("");
        txtNomeCliente.requestFocus();
    }

    public void clearFieldsVeiculo() {
        ftxtValorDeCompra.setText("");
        ftxtPlaca.setText("");
        ftxtAno.setText("");
        //ftxtValorDeCompra.requestFocus();
    }

    public void showCtm(ArrayList<Cliente> clientes) {
        ctm.setListaCliente(clientes);
    }

    public void showVtmMotos(ArrayList<Motocicleta> motos) {
        vtm.setListaMotos(motos);
    }

    public void showVtmAutos(ArrayList<Automovel> autos) {
        vtm.setListaAutos(autos);
    }

    public void showVtmVans(ArrayList<Van> vans) {
        vtm.setListaVans(vans);
    }

    private void filtrarPesquisa(String textoPesquisa) {
        ClienteLocacaoTableModel modeloTabela = (ClienteLocacaoTableModel) clienteLocacaoTable.getModel();
        modeloTabela.filtrarClientes(textoPesquisa);
    }

    /*private void locarVeiculo(int dias, Calendar data, Cliente cliente) {
        int t = lvtm.getTipoVeiculo();
        int veiculoSelecionado = veiculoTable.getSelectedRow();

        switch (t) {
            case 1 -> {
                if (veiculoSelecionado != -1) {
                    Van v = rep.getListaVans().get(veiculoSelecionado);
                    v.locar(dias, data, cliente);
                }
            }
            case 2 -> {
                if (veiculoSelecionado != -1) {
                    Motocicleta m = rep.getListaMotocicletas().get(veiculoSelecionado);
                    m.locar(dias, data, cliente);
                }
            }
            case 3 -> {
                if (veiculoSelecionado != -1) {
                    Automovel a = rep.getListaAutomoveis().get(veiculoSelecionado);
                    a.locar(dias, data, cliente);
                }
            }
        }

    }*/
 /*private void loadModeloBox(String veiculoTipo) {

        if ("Motocicleta".equals(cbxTipo.getSelectedItem().toString())) {
            try {
                ResultSet rs = ComboBox.showCboxModeloMotocicleta();
                while (rs.next()) {
                    cboxModelo.addItem(rs.getString("description"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "@Frame.loadModeloBox(): failed loading modelo comboBox motocicleta" + e.getMessage());
            }
        } else if ("Automóvel".equals(cbxTipo.getSelectedItem().toString())) {
            try {
                ResultSet rs = ComboBox.showCboxModeloAutomovel();
                while (rs.next()) {
                    cboxModelo.addItem(rs.getString("description"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "@Frame.loadModeloBox(): failed loading modelo comboBox automovel" + e.getMessage());
            }
        } else if ("Van".equals(cbxTipo.getSelectedItem().toString())) {
            try {
                ResultSet rs = ComboBox.showCboxModeloVan();
                while (rs.next()) {
                    cboxModelo.addItem(rs.getString("description"));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "@Frame.loadModeloBox(): failed loading modelo comboBox van" + e.getMessage());
            }
        }
    }*/
    public JComboBox<Object> getCboxModelo() {
        return cboxModelo;
    }

    private void loadAllCategoriaMarcaCboxes() {
        ComboBox.loadCboxMarca(cboxMarcaVeiculos);
        ComboBox.loadCboxCategoria(cboxCategoriaVeiculos);
    }
}
