package view;

import controller.Main;
import controller.ClientesTabController;
import controller.TransacoesTabController;
import controller.VeiculosTabController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import model.tables.ClientesTableModel;
import model.dto.Cliente;
import java.awt.Point;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.combo.ComboBox;
import model.dto.Automovel;
import model.dto.Locacao;
import model.dto.Motocicleta;
import model.dto.Van;
import model.dto.Veiculo;
import model.tables.ClientesTransacoesTableModel;
import model.tables.TransacoesTableModel;
import model.tables.VeiculosTableModel;

public class Frame extends javax.swing.JFrame {

    private Main main;

    private ClientesTabController ctrlClientes;
    private VeiculosTabController ctrlVeiculos;
    private TransacoesTabController ctrlTransacoes;

    private ClientesTableModel ctm;
    private VeiculosTableModel vtm;
    private ClientesTransacoesTableModel cttm;
    private TransacoesTableModel ttm;

    //private TableFilter filtroVeiculoTable, filtroClientesTransacoesTable;
    private Color originalBtnColor;
    private Font monospace;

    private boolean notEnteredClientes;
    private boolean notEnteredVeiculos;
    private boolean notEnteredTransacoes;

    public Frame() {

        //TABLE MODELS
        ctm = new ClientesTableModel();
        vtm = new VeiculosTableModel();
        cttm = new ClientesTransacoesTableModel();
        ttm = new TransacoesTableModel();

        initComponents();

        //BUTTON VISUALS
        monospace = new Font("Monospace", Font.BOLD, 14);
        originalBtnColor = btnMotocicletasVeiculos.getBackground();

        //FIRST TIME ENTERING TABS 
        notEnteredClientes = true;
        notEnteredVeiculos = true;
        notEnteredTransacoes = true;

    }

    public void initView(Frame frame) {
        //frame.setSize(1455, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Example
        frame.setVisible(true);
    }

    public void setControllers(ClientesTabController ctrlClientes, VeiculosTabController ctrlVeiculos,
            TransacoesTabController ctrlTransacoes) {

        this.ctrlClientes = ctrlClientes;
        this.ctrlVeiculos = ctrlVeiculos;
        this.ctrlTransacoes = ctrlTransacoes;
    }

    ///TEST/// maybe unnecessary ?
    public void setTableModels(ClientesTableModel ctm, VeiculosTableModel vtm, ClientesTransacoesTableModel cttm, TransacoesTableModel ttm) {
        this.ctm = ctm;
        this.vtm = vtm;
        this.cttm = cttm;
        this.ttm = ttm;

    }

    public ClientesTableModel getCtm() {
        return ctm;
    }

    public VeiculosTableModel getVtm() {
        return vtm;
    }

    public ClientesTransacoesTableModel getCttm() {
        return cttm;
    }

    public TransacoesTableModel getTtm() {
        return ttm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneAllTabs = new javax.swing.JTabbedPane();
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
        tabVeiculos = new javax.swing.JPanel();
        paneVeiculoTable = new javax.swing.JScrollPane();
        veiculosTable = new javax.swing.JTable();
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
        cboxMarcaVeiculo = new javax.swing.JComboBox<>();
        cboxCategoriaVeiculo = new javax.swing.JComboBox<>();
        tabTransacoes = new javax.swing.JPanel();
        btnVansTransacoes = new javax.swing.JButton();
        btnMotocicletasTransacoes = new javax.swing.JButton();
        paneVeiculoTableLocacao = new javax.swing.JScrollPane();
        transacoesTable = new javax.swing.JTable();
        btnAutomoveisTransacoes = new javax.swing.JButton();
        txtPesquisarClientes = new javax.swing.JTextField();
        btnLocar = new javax.swing.JButton();
        paneClientesTransacoesTable = new javax.swing.JScrollPane();
        clientesTransacoesTable = new javax.swing.JTable();
        lblPesquisarClientes = new javax.swing.JLabel();
        ftxtDataTransacoes = new javax.swing.JFormattedTextField();
        lblNumDiasTransacoes = new javax.swing.JLabel();
        lblDataTransacoes = new javax.swing.JLabel();
        cboxMarcaTransacoes = new javax.swing.JComboBox<>();
        cboxCategoriaTransacoes = new javax.swing.JComboBox<>();
        btnLocacao = new javax.swing.JButton();
        btnDevolucao = new javax.swing.JButton();
        btnVenda = new javax.swing.JButton();
        btnListarTransacoes = new javax.swing.JButton();
        txtDiasTransacoes = new javax.swing.JTextField();
        btnDevolver = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneAllTabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabClienteMouseEntered(evt);
            }
        });

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
                    .addGroup(tabClienteLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnIncluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoverCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(tabClienteLayout.createSequentialGroup()
                                    .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCpfCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblEnderecoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblSobrenomeCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSobrenomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ftxtCpfCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(tabClienteLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(lblNomeCliente)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabClienteLayout.createSequentialGroup()
                                .addComponent(lblRgCliente)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtRgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneClienteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabClienteLayout.createSequentialGroup()
                        .addComponent(btnListarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        tabClienteLayout.setVerticalGroup(
            tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabClienteLayout.createSequentialGroup()
                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarCliente)
                    .addComponent(btnLimparCliente))
                .addGap(19, 19, 19)
                .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabClienteLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
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
                        .addGap(93, 93, 93)
                        .addGroup(tabClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIncluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoverCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(paneClienteTable, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141))
        );

        paneAllTabs.addTab("Clientes", tabCliente);

        tabVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabVeiculosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabVeiculosMouseEntered(evt);
            }
        });

        veiculosTable.setModel(vtm);
        paneVeiculoTable.setViewportView(veiculosTable);
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
        ftxtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtAnoActionPerformed(evt);
            }
        });

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

        cboxMarcaVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxMarcaVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboxMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMarcaVeiculoActionPerformed(evt);
            }
        });

        cboxCategoriaVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxCategoriaVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboxCategoriaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaVeiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabVeiculosLayout = new javax.swing.GroupLayout(tabVeiculos);
        tabVeiculos.setLayout(tabVeiculosLayout);
        tabVeiculosLayout.setHorizontalGroup(
            tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVeiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabVeiculosLayout.createSequentialGroup()
                                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVeiculosLayout.createSequentialGroup()
                                        .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVeiculosLayout.createSequentialGroup()
                                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVeiculosLayout.createSequentialGroup()
                                        .addComponent(lblModelo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cboxModelo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboxMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboxCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnIncluirVeiculo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(tabVeiculosLayout.createSequentialGroup()
                            .addComponent(lblValorDaCompra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ftxtValorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPlaca)
                            .addComponent(lblAno))
                        .addGap(24, 24, 24)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ftxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnMotocicletasVeiculos)
                        .addGap(63, 63, 63)
                        .addComponent(btnAutomoveisVeiculos)
                        .addGap(69, 69, 69)
                        .addComponent(btnVansVeiculos)
                        .addGap(41, 41, 41)
                        .addComponent(cboxMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(cboxCategoriaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(paneVeiculoTable, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(156, 156, 156))
        );
        tabVeiculosLayout.setVerticalGroup(
            tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabVeiculosLayout.createSequentialGroup()
                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVansVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMotocicletasVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAutomoveisVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCategoriaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneVeiculoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabVeiculosLayout.createSequentialGroup()
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipo)
                            .addComponent(cboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMarca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModelo)
                            .addComponent(cboxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValorDaCompra)
                            .addComponent(ftxtValorDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlaca)
                            .addComponent(ftxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAno))
                        .addGap(27, 27, 27)
                        .addComponent(btnIncluirVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        paneAllTabs.addTab("Veículos", tabVeiculos);

        tabTransacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTransacoesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabTransacoesMouseEntered(evt);
            }
        });

        btnVansTransacoes.setText("Vans");
        btnVansTransacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVansTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVansTransacoesActionPerformed(evt);
            }
        });

        btnMotocicletasTransacoes.setText("Motocicletas");
        btnMotocicletasTransacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMotocicletasTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotocicletasTransacoesActionPerformed(evt);
            }
        });

        transacoesTable.setModel(ttm);
        transacoesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transacoesTableMousePressed(evt);
            }
        });
        paneVeiculoTableLocacao.setViewportView(transacoesTable);

        btnAutomoveisTransacoes.setText("Automoveis");
        btnAutomoveisTransacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAutomoveisTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutomoveisTransacoesActionPerformed(evt);
            }
        });

        txtPesquisarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarClientesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesquisarClientesKeyTyped(evt);
            }
        });

        btnLocar.setText("Locar");
        btnLocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocarActionPerformed(evt);
            }
        });

        clientesTransacoesTable.setModel(cttm);
        clientesTransacoesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesTransacoesTableMouseClicked(evt);
            }
        });
        paneClientesTransacoesTable.setViewportView(clientesTransacoesTable);

        lblPesquisarClientes.setText("Pesquisar Clientes");

        try {
            ftxtDataTransacoes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtDataTransacoes.setActionCommand("<Not Set>");
        ftxtDataTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtDataTransacoesActionPerformed(evt);
            }
        });

        lblNumDiasTransacoes.setText("Dias de Locação");

        lblDataTransacoes.setText("data");

        cboxMarcaTransacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxMarcaTransacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboxMarcaTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMarcaTransacoesActionPerformed(evt);
            }
        });

        cboxCategoriaTransacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboxCategoriaTransacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboxCategoriaTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaTransacoesActionPerformed(evt);
            }
        });

        btnLocacao.setText("Locação");
        btnLocacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocacaoActionPerformed(evt);
            }
        });

        btnDevolucao.setText("Devolução");
        btnDevolucao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucaoActionPerformed(evt);
            }
        });

        btnVenda.setText("Venda");
        btnVenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendaActionPerformed(evt);
            }
        });

        btnListarTransacoes.setText("Listar");
        btnListarTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarTransacoesActionPerformed(evt);
            }
        });

        txtDiasTransacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiasTransacoesActionPerformed(evt);
            }
        });

        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabTransacoesLayout = new javax.swing.GroupLayout(tabTransacoes);
        tabTransacoes.setLayout(tabTransacoesLayout);
        tabTransacoesLayout.setHorizontalGroup(
            tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTransacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tabTransacoesLayout.createSequentialGroup()
                                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(btnListarTransacoes))
                                    .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(tabTransacoesLayout.createSequentialGroup()
                                            .addComponent(btnLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnDevolucao)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(tabTransacoesLayout.createSequentialGroup()
                                            .addComponent(lblPesquisarClientes)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(26, 26, 26))
                            .addGroup(tabTransacoesLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumDiasTransacoes)
                                    .addComponent(lblDataTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiasTransacoes)
                                    .addComponent(ftxtDataTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(btnLocar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDevolver)
                                .addGap(18, 18, 18)
                                .addComponent(btnVender)
                                .addGap(17, 17, 17))))
                    .addComponent(paneClientesTransacoesTable))
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnMotocicletasTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnAutomoveisTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnVansTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cboxMarcaTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboxCategoriaTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(paneVeiculoTableLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        tabTransacoesLayout.setVerticalGroup(
            tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransacoesLayout.createSequentialGroup()
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(tabTransacoesLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(btnListarTransacoes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTransacoesLayout.createSequentialGroup()
                            .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(23, 23, 23)))
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnVansTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAutomoveisTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMotocicletasTransacoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxMarcaTransacoes)
                            .addComponent(cboxCategoriaTransacoes))
                        .addGap(23, 23, 23)))
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesquisarClientes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneClientesTransacoesTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabTransacoesLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiasTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumDiasTransacoes))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ftxtDataTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDataTransacoes)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTransacoesLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(tabTransacoesLayout.createSequentialGroup()
                                            .addComponent(btnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(1, 1, 1))
                                        .addComponent(btnLocar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(paneVeiculoTableLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        paneAllTabs.addTab("Transacoes", tabTransacoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneAllTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneAllTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed
        ctrlClientes.updateCliente();
    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    private void btnLimparClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparClienteActionPerformed
        ctm.limpaTabela();
        clearFieldsCliente();
    }//GEN-LAST:event_btnLimparClienteActionPerformed

    private void btnRemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverClienteActionPerformed
        ctrlClientes.deleteCliente();
    }//GEN-LAST:event_btnRemoverClienteActionPerformed

    private void btnListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarClienteActionPerformed
        ctrlClientes.showClientes();
    }//GEN-LAST:event_btnListarClienteActionPerformed

    private void btnIncluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirClienteActionPerformed
        ctrlClientes.newCliente();
    }//GEN-LAST:event_btnIncluirClienteActionPerformed

    private void ftxtCpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtCpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtCpfClienteActionPerformed

    private void ftxtRgClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtRgClienteActionPerformed

    }//GEN-LAST:event_ftxtRgClienteActionPerformed

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void cboxCategoriaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaVeiculoActionPerformed
        ctrlVeiculos.activateCboxCategoriaVeiculos();
    }//GEN-LAST:event_cboxCategoriaVeiculoActionPerformed

    private void cboxMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaVeiculoActionPerformed
        ctrlVeiculos.activateCboxMarcaVeiculos();
    }//GEN-LAST:event_cboxMarcaVeiculoActionPerformed

    private void btnAutomoveisVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisVeiculosActionPerformed
        setBtnColorsVeiculos("Automoveis", "Veiculos");
        vtm.setTipoVeiculo(2);//tipo 2 auto
        ctrlVeiculos.showAutos();
    }//GEN-LAST:event_btnAutomoveisVeiculosActionPerformed

    private void btnMotocicletasVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasVeiculosActionPerformed
        setBtnColorsVeiculos("Motocicletas", "Veiculos");
        vtm.setTipoVeiculo(1);//tipo 1 moto
        ctrlVeiculos.showMotos();
    }//GEN-LAST:event_btnMotocicletasVeiculosActionPerformed

    private void btnVansVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansVeiculosActionPerformed
        setBtnColorsVeiculos("Vans", "Veiculos");
        vtm.setTipoVeiculo(3);//tipo 3 van
        ctrlVeiculos.showVans();
    }//GEN-LAST:event_btnVansVeiculosActionPerformed

    private void cboxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaActionPerformed
        String type = (String) cboxTipo.getSelectedItem();
        String marca = (String) cboxMarca.getSelectedItem();
        String categoria = (String) cboxCategoria.getSelectedItem();
        if (!"".equals(type) && !"".equals(marca)) {
            ComboBox.loadCboxModelo(cboxModelo, type, marca, categoria);
        }
    }//GEN-LAST:event_cboxCategoriaActionPerformed

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

    private void cboxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxModeloActionPerformed

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

    private void btnIncluirVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirVeiculoActionPerformed
        ctrlVeiculos.newVeiculo();
    }//GEN-LAST:event_btnIncluirVeiculoActionPerformed

    private void tabTransacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTransacoesMouseClicked
        if (evt.getSource() != clientesTransacoesTable) {
            clientesTransacoesTable.getSelectionModel().clearSelection();
        }
        if (evt.getSource() != transacoesTable) {
            transacoesTable.getSelectionModel().clearSelection();
        }

    }//GEN-LAST:event_tabTransacoesMouseClicked

    private void txtDiasTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasTransacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasTransacoesActionPerformed

    private void btnListarTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTransacoesActionPerformed
        ctrlTransacoes.showClientes();
    }//GEN-LAST:event_btnListarTransacoesActionPerformed

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
        ttm.setTipoTransacao(3);//tipo 3 venda
        setBtnColorsTransacoes("Venda");
        ctrlTransacoes.setVisibilityLocacaoOptions(false);
        ctrlTransacoes.setVisibilityDevolucaoOptions(false);
        ctrlTransacoes.setVisibilityVendaOptions(true);
        switch (ttm.getTipoVeiculo()) {
            case 1 ->
                ctrlTransacoes.showAllMotos();
            case 2 ->
                ctrlTransacoes.showAllAutos();
            case 3 ->
                ctrlTransacoes.showAllVans();
        }
    }//GEN-LAST:event_btnVendaActionPerformed

    private void btnDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucaoActionPerformed
        ttm.setTipoTransacao(2);//tipo 2 devolução
        setBtnColorsTransacoes("Devolução");
        ctrlTransacoes.setVisibilityLocacaoOptions(false);
        ctrlTransacoes.setVisibilityDevolucaoOptions(true);
        ctrlTransacoes.setVisibilityVendaOptions(false);
        switch (ttm.getTipoVeiculo()) {
            case 1 ->
                ctrlTransacoes.showAllMotos();
            case 2 ->
                ctrlTransacoes.showAllAutos();
            case 3 ->
                ctrlTransacoes.showAllVans();
        }
    }//GEN-LAST:event_btnDevolucaoActionPerformed

    private void btnLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocacaoActionPerformed
        ttm.setTipoTransacao(1);//tipo 1 locacao
        setBtnColorsTransacoes("Locação");
        ctrlTransacoes.setVisibilityLocacaoOptions(true);
        ctrlTransacoes.setVisibilityDevolucaoOptions(false);
        ctrlTransacoes.setVisibilityVendaOptions(false);
    }//GEN-LAST:event_btnLocacaoActionPerformed

    private void cboxCategoriaTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaTransacoesActionPerformed
        ctrlTransacoes.activateCboxCategoriaTransacoes();
    }//GEN-LAST:event_cboxCategoriaTransacoesActionPerformed

    private void cboxMarcaTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaTransacoesActionPerformed
        ctrlTransacoes.activateCboxMarcaTransacoes();
    }//GEN-LAST:event_cboxMarcaTransacoesActionPerformed

    private void ftxtDataTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtDataTransacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtDataTransacoesActionPerformed

    private void clientesTransacoesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTransacoesTableMouseClicked
        switch (ttm.getTipoVeiculo()) {
            case 1 ->
                ctrlTransacoes.showAllMotos();
            case 2 ->
                ctrlTransacoes.showAllAutos();
            case 3 ->
                ctrlTransacoes.showAllVans();
        }

    }//GEN-LAST:event_clientesTransacoesTableMouseClicked

    private void btnLocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocarActionPerformed
        ctrlTransacoes.newLocacao();

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

    private void txtPesquisarClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarClientesKeyTyped

    }//GEN-LAST:event_txtPesquisarClientesKeyTyped

    private void txtPesquisarClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarClientesKeyReleased
        ctrlTransacoes.filterCtt(txtPesquisarClientes.getText());
    }//GEN-LAST:event_txtPesquisarClientesKeyReleased

    private void btnAutomoveisTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisTransacoesActionPerformed
        setBtnColorsVeiculos("Automoveis", "Transacoes");
        ttm.setTipoVeiculo(2);//tipo 2 auto
        ctrlTransacoes.showAllAutos();
    }//GEN-LAST:event_btnAutomoveisTransacoesActionPerformed

    private void transacoesTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transacoesTableMousePressed
        JTable table = (JTable) evt.getSource();
        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        if (evt.getClickCount() == 2) {
            // Your code here
        }
    }//GEN-LAST:event_transacoesTableMousePressed

    private void btnMotocicletasTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasTransacoesActionPerformed
        setBtnColorsVeiculos("Motocicletas", "Transacoes");
        ttm.setTipoVeiculo(1);//tipo 1 moto
        ctrlTransacoes.showAllMotos();
    }//GEN-LAST:event_btnMotocicletasTransacoesActionPerformed

    private void btnVansTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansTransacoesActionPerformed
        setBtnColorsVeiculos("Vans", "Transacoes");
        ttm.setTipoVeiculo(3);//tipo 3 van
        ctrlTransacoes.showAllVans();
    }//GEN-LAST:event_btnVansTransacoesActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        ctrlTransacoes.devolverLocacao();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        ctrlTransacoes.vender();
    }//GEN-LAST:event_btnVenderActionPerformed

    private void tabVeiculosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabVeiculosMouseEntered
        if (notEnteredVeiculos) {
            notEnteredVeiculos = false;
            setBtnColorsVeiculos("Motocicletas", "Veiculos");
            vtm.setTipoVeiculo(1);//tipo 1 moto
            ctrlVeiculos.showMotos();
        }
    }//GEN-LAST:event_tabVeiculosMouseEntered

    private void tabVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabVeiculosMouseClicked
        if (evt.getSource() != veiculosTable) {
            veiculosTable.getSelectionModel().clearSelection();
        }
    }//GEN-LAST:event_tabVeiculosMouseClicked

    private void tabClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClienteMouseClicked
        if (evt.getSource() != clienteTable) {
            clienteTable.getSelectionModel().clearSelection();
        }

    }//GEN-LAST:event_tabClienteMouseClicked

    private void tabTransacoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTransacoesMouseEntered
        if (notEnteredTransacoes) {
            notEnteredTransacoes = false;
            ttm.setTipoVeiculo(1);//tipo 1 moto
            ttm.setTipoTransacao(1);//tipo 1 locacao
            ctrlTransacoes.setVisibilityLocacaoOptions(true);
            ctrlTransacoes.setVisibilityDevolucaoOptions(false);
            ctrlTransacoes.setVisibilityVendaOptions(false);
            setBtnColorsTransacoes("Locação");
            setBtnColorsVeiculos("Motocicletas", "Transacoes");
            ctrlTransacoes.showClientes();
            switch (ttm.getTipoVeiculo()) {
                case 1 ->
                    ctrlTransacoes.showAllMotos();
                case 2 ->
                    ctrlTransacoes.showAllAutos();
                case 3 ->
                    ctrlTransacoes.showAllVans();
            }
        }
    }//GEN-LAST:event_tabTransacoesMouseEntered

    private void tabClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClienteMouseEntered
        if (notEnteredClientes) {
            notEnteredClientes = false;
            ctrlClientes.showClientes();
        }
    }//GEN-LAST:event_tabClienteMouseEntered

    private void ftxtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtAnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnAutomoveisTransacoes;
    private javax.swing.JButton btnAutomoveisVeiculos;
    private javax.swing.JButton btnDevolucao;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnIncluirCliente;
    private javax.swing.JButton btnIncluirVeiculo;
    private javax.swing.JButton btnLimparCliente;
    private javax.swing.JButton btnListarCliente;
    private javax.swing.JButton btnListarTransacoes;
    private javax.swing.JButton btnLocacao;
    private javax.swing.JButton btnLocar;
    private javax.swing.JButton btnMotocicletasTransacoes;
    private javax.swing.JButton btnMotocicletasVeiculos;
    private javax.swing.JButton btnRemoverCliente;
    private javax.swing.JButton btnVansTransacoes;
    private javax.swing.JButton btnVansVeiculos;
    private javax.swing.JButton btnVenda;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxCategoriaTransacoes;
    private javax.swing.JComboBox<String> cboxCategoriaVeiculo;
    private javax.swing.JComboBox<String> cboxMarca;
    private javax.swing.JComboBox<String> cboxMarcaTransacoes;
    private javax.swing.JComboBox<String> cboxMarcaVeiculo;
    private javax.swing.JComboBox<Object> cboxModelo;
    private javax.swing.JComboBox<String> cboxTipo;
    private javax.swing.JTable clienteTable;
    private javax.swing.JTable clientesTransacoesTable;
    private javax.swing.JFormattedTextField ftxtAno;
    private javax.swing.JFormattedTextField ftxtCpfCliente;
    private javax.swing.JFormattedTextField ftxtDataTransacoes;
    private javax.swing.JFormattedTextField ftxtPlaca;
    private javax.swing.JFormattedTextField ftxtRgCliente;
    private javax.swing.JFormattedTextField ftxtValorDeCompra;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCpfCliente;
    private javax.swing.JLabel lblDataTransacoes;
    private javax.swing.JLabel lblEnderecoCliente;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNumDiasTransacoes;
    private javax.swing.JLabel lblPesquisarClientes;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblRgCliente;
    private javax.swing.JLabel lblSobrenomeCliente;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValorDaCompra;
    private javax.swing.JTabbedPane paneAllTabs;
    private javax.swing.JScrollPane paneClienteTable;
    private javax.swing.JScrollPane paneClientesTransacoesTable;
    private javax.swing.JScrollPane paneVeiculoTable;
    private javax.swing.JScrollPane paneVeiculoTableLocacao;
    private javax.swing.JPanel tabCliente;
    private javax.swing.JPanel tabTransacoes;
    private javax.swing.JPanel tabVeiculos;
    private javax.swing.JTable transacoesTable;
    private javax.swing.JTextField txtDiasTransacoes;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtPesquisarClientes;
    private javax.swing.JTextField txtSobrenomeCliente;
    private javax.swing.JTable veiculosTable;
    // End of variables declaration//GEN-END:variables

    public JComboBox<Object> getCboxModelo() {
        return cboxModelo;
    }

    public JTable getVeiculosTable() {
        return veiculosTable;
    }

    public JTable getTransacoesTable() {
        return transacoesTable;
    }

    public JComboBox<String> getCboxCategoriaVeiculo() {
        return cboxCategoriaVeiculo;
    }

    public JComboBox<String> getCboxMarcaVeiculo() {
        return cboxMarcaVeiculo;
    }

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

    //public void addVeiculoToVtm(Veiculo v) {
    //   vtm.addVeiculo(v);
    //}
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
    }

    public void clearFieldsLocacao() {
        txtDiasTransacoes.setText("");
        ftxtDataTransacoes.setText("");
    }

    public void showCtm(ArrayList<Cliente> clientes) {
        ctm.setListaCliente(clientes);
    }

    public void showCttm(ArrayList<Cliente> clientes) {
        cttm.setListaCliente(clientes);
    }

    private void setBtnColorsVeiculos(String btn, String tab) {
        Color o = originalBtnColor;
        switch (tab) {
            case "Veiculos" -> {
                Color m = btnMotocicletasVeiculos.getBackground();
                Color a = btnAutomoveisVeiculos.getBackground();
                Color v = btnVansVeiculos.getBackground();
                switch (btn) {
                    case "Motocicletas" -> {
                        btnMotocicletasVeiculos.setBackground(new Color(118, 181, 197));
                        if (a != o) {
                            btnAutomoveisVeiculos.setBackground(o);
                        } else if (v != o) {
                            btnVansVeiculos.setBackground(o);
                        }
                    }
                    case "Automoveis" -> {
                        btnAutomoveisVeiculos.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasVeiculos.setBackground(o);
                        } else if (v != o) {
                            btnVansVeiculos.setBackground(o);
                        }
                    }
                    case "Vans" -> {
                        btnVansVeiculos.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasVeiculos.setBackground(o);
                        } else if (a != o) {
                            btnAutomoveisVeiculos.setBackground(o);
                        }
                    }
                }
            }
            case "Transacoes" -> {
                Color m = btnMotocicletasTransacoes.getBackground();
                Color a = btnAutomoveisTransacoes.getBackground();
                Color v = btnVansTransacoes.getBackground();
                switch (btn) {
                    case "Motocicletas" -> {
                        btnMotocicletasTransacoes.setBackground(new Color(118, 181, 197));
                        if (a != o) {
                            btnAutomoveisTransacoes.setBackground(o);
                        } else if (v != o) {
                            btnVansTransacoes.setBackground(o);
                        }
                    }
                    case "Automoveis" -> {
                        btnAutomoveisTransacoes.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasTransacoes.setBackground(o);
                        } else if (v != o) {
                            btnVansTransacoes.setBackground(o);
                        }
                    }
                    case "Vans" -> {
                        btnVansTransacoes.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasTransacoes.setBackground(o);
                        } else if (a != o) {
                            btnAutomoveisTransacoes.setBackground(o);
                        }
                    }

                }
            }
            default -> {
            }
        }

    }

    private void setBtnColorsTransacoes(String btn) {
        Color o = originalBtnColor;
        Color l = btnLocacao.getBackground();
        Color d = btnDevolucao.getBackground();
        Color v = btnVenda.getBackground();
        switch (btn) {
            case "Locação" -> {
                btnLocacao.setBackground(new Color(118, 181, 197));
                if (d != o) {
                    btnDevolucao.setBackground(o);
                } else if (v != o) {
                    btnVenda.setBackground(o);
                }
            }
            case "Devolução" -> {
                btnDevolucao.setBackground(new Color(118, 181, 197));
                if (l != o) {
                    btnLocacao.setBackground(o);
                } else if (v != o) {
                    btnVenda.setBackground(o);
                }
            }
            case "Venda" -> {
                btnVenda.setBackground(new Color(118, 181, 197));
                if (l != o) {
                    btnLocacao.setBackground(o);
                } else if (d != o) {
                    btnDevolucao.setBackground(o);
                }
            }
            default -> {
            }
        }
    }

    public javax.swing.JComboBox<String> getCboxCategoriaTransacoes() {
        return cboxCategoriaTransacoes;
    }

    public javax.swing.JComboBox<String> getCboxMarcaTransacoes() {
        return cboxMarcaTransacoes;
    }

    public javax.swing.JTable getClientesTransacoesTable() {
        return clientesTransacoesTable;
    }

    public Locacao getLocacaoFormulario() throws DateTimeParseException, NumberFormatException, RuntimeException {

        int dias = Integer.parseInt(txtDiasTransacoes.getText());
        //System.out.println("@getLocacaoFormulario.dias : "+dias);
        String dateString = ftxtDataTransacoes.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
//if (localDate.isBefore(LocalDate.now())) {
        //   throw new RuntimeException("Date is in the past");
        //}
        double valorDiariaLocacao = ttm.getValorDiariaLocacao(transacoesTable);
        System.out.println("@getLocacaoFormulario.valorDiarialocacao : " + valorDiariaLocacao);
        double valor = valorDiariaLocacao * dias;
        if (dias == 0 || localDate == null) {
            apresentaErro("Preencha a data e a quantidade de dias.");
        } else {
            System.out.println("@getLocacaoFormulario.valor locacao : " + valor);
            return new Locacao(dias, valor, localDate);
        }
        return null;
    }

    public javax.swing.JButton getBtnMotocicletasTransacoes() {
        return btnMotocicletasTransacoes;
    }

    public javax.swing.JButton getBtnMotocicletasVeiculos() {
        return btnMotocicletasVeiculos;
    }

    public javax.swing.JButton getBtnLocar() {
        return btnLocar;
    }

    public javax.swing.JFormattedTextField getFtxtDataTransacoes() {
        return ftxtDataTransacoes;
    }

    public javax.swing.JLabel getLblDataTransacoes() {
        return lblDataTransacoes;
    }

    public javax.swing.JLabel getLblNumDiasTransacoes() {
        return lblNumDiasTransacoes;
    }

    public javax.swing.JTextField getTxtDiasTransacoes() {
        return txtDiasTransacoes;
    }

    public javax.swing.JButton getBtnDevolver() {
        return btnDevolver;
    }

    public javax.swing.JButton getBtnVender() {
        return btnVender;
    }

}
