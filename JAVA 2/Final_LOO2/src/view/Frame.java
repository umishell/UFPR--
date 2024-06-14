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
import model.tables.TableFilter;
import java.awt.Point;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
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
        costumizeButtons();
        
        //vtm.setTipoVeiculo(1);//tipo 1 moto
        ttm.setTipoVeiculo(1);//tipo 1 moto
        ttm.setTipoTransacao(1);//tipo 1 locacao

    }

    public void initView(Frame frame) {
        frame.setSize(1455, 800);
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
        tabTransacoes = new javax.swing.JPanel();
        btnVansTransacoes = new javax.swing.JButton();
        btnMotocicletasTransacoes = new javax.swing.JButton();
        paneVeiculoTableLocacao = new javax.swing.JScrollPane();
        TransacoesTable = new javax.swing.JTable();
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
        tabDevolucao = new javax.swing.JPanel();
        paneDevolverTable = new javax.swing.JScrollPane();
        DevolverTable = new javax.swing.JTable();
        btnVansDevolver = new javax.swing.JButton();
        btnMotocicletasDevolver = new javax.swing.JButton();
        btnAutomoveisDevolver = new javax.swing.JButton();
        tabVenda = new javax.swing.JPanel();
        paneVendaTable = new javax.swing.JScrollPane();
        VendaTable = new javax.swing.JTable();
        btnAutomoveisVenda = new javax.swing.JButton();
        btnMotocicletasVenda = new javax.swing.JButton();
        btnVansVenda = new javax.swing.JButton();
        cboxMarcaVenda = new javax.swing.JComboBox<>();
        cboxCategoriaVenda = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneAllTabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabTransacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTransacoesMouseClicked(evt);
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

        TransacoesTable.setModel(ttm);
        TransacoesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TransacoesTableMousePressed(evt);
            }
        });
        paneVeiculoTableLocacao.setViewportView(TransacoesTable);

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

        lblNumDiasTransacoes.setText("numDiasLocacao");

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

        javax.swing.GroupLayout tabTransacoesLayout = new javax.swing.GroupLayout(tabTransacoes);
        tabTransacoes.setLayout(tabTransacoesLayout);
        tabTransacoesLayout.setHorizontalGroup(
            tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransacoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabTransacoesLayout.createSequentialGroup()
                            .addComponent(lblPesquisarClientes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTransacoesLayout.createSequentialGroup()
                            .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(tabTransacoesLayout.createSequentialGroup()
                                    .addComponent(lblNumDiasTransacoes)
                                    .addGap(33, 33, 33))
                                .addGroup(tabTransacoesLayout.createSequentialGroup()
                                    .addComponent(lblDataTransacoes)
                                    .addGap(43, 43, 43)))
                            .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(tabTransacoesLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(txtDiasTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(175, 175, 175)
                                    .addComponent(btnLocar))
                                .addGroup(tabTransacoesLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(ftxtDataTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(paneClientesTransacoesTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnMotocicletasTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnAutomoveisTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnVansTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(paneVeiculoTableLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(114, 114, 114))
            .addGroup(tabTransacoesLayout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addComponent(btnLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVenda)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTransacoesLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btnListarTransacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboxMarcaTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboxCategoriaTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        tabTransacoesLayout.setVerticalGroup(
            tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTransacoesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolucao)
                    .addComponent(btnLocacao)
                    .addComponent(btnVenda))
                .addGap(24, 24, 24)
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxMarcaTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxCategoriaTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarTransacoes))
                .addGap(18, 18, 18)
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabTransacoesLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnMotocicletasTransacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesquisarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPesquisarClientes))
                    .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVansTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAutomoveisTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneClientesTransacoesTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneVeiculoTableLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLocar)
                    .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNumDiasTransacoes)
                        .addComponent(txtDiasTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(tabTransacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtDataTransacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataTransacoes))
                .addGap(54, 54, 54))
        );

        paneAllTabs.addTab("Transacoes", tabTransacoes);

        tabVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabVeiculos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabVeiculosComponentShown(evt);
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
                        .addGap(62, 62, 62)
                        .addComponent(cboxMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(cboxCategoriaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabVeiculosLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxCategoriaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(tabVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnVansVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMotocicletasVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAutomoveisVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(tabVeiculosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cboxMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(paneVeiculoTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(268, Short.MAX_VALUE))
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
                .addContainerGap(67, Short.MAX_VALUE))
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
                .addContainerGap(375, Short.MAX_VALUE)
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
                .addContainerGap(208, Short.MAX_VALUE))
        );

        paneAllTabs.addTab("Devolução", tabDevolucao);

        VendaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                VendaTableMousePressed(evt);
            }
        });
        paneVendaTable.setViewportView(VendaTable);

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
                .addContainerGap(394, Short.MAX_VALUE)
                .addGroup(tabVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabVendaLayout.createSequentialGroup()
                        .addComponent(btnVansVenda)
                        .addGap(28, 28, 28)
                        .addComponent(btnMotocicletasVenda)
                        .addGap(18, 18, 18)
                        .addComponent(btnAutomoveisVenda)
                        .addGap(38, 38, 38)
                        .addComponent(cboxMarcaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cboxCategoriaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paneVendaTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnAutomoveisVenda))
                .addGap(18, 18, 18)
                .addComponent(paneVendaTable, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
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
        ctrlVeiculos.newVeiculo();
    }//GEN-LAST:event_btnIncluirVeiculoActionPerformed

    private void tabVeiculosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabVeiculosComponentShown
        // Cmarca.setModel(cm.getMarcaModel());
        //Ccategoria.setModel(cm.getCategoriaModel());

    }//GEN-LAST:event_tabVeiculosComponentShown

    private void ftxtCpfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtCpfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtCpfClienteActionPerformed


    private void TransacoesTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransacoesTableMousePressed
        JTable table = (JTable) evt.getSource();
        Point p = evt.getPoint();
        int row = table.rowAtPoint(p);
        if (evt.getClickCount() == 2) {
            // Your code here
        }
    }//GEN-LAST:event_TransacoesTableMousePressed

    private void btnVansTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansTransacoesActionPerformed
        setBtnColors("Vans", "Transacoes");
        ttm.setTipoVeiculo(3);//tipo 3 van
        ctrlTransacoes.showVans();
    }//GEN-LAST:event_btnVansTransacoesActionPerformed

    private void btnMotocicletasTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasTransacoesActionPerformed
        setBtnColors("Motocicletas", "Transacoes");
        ttm.setTipoVeiculo(1);//tipo 1 moto
        ctrlTransacoes.showMotos();
    }//GEN-LAST:event_btnMotocicletasTransacoesActionPerformed

    private void btnAutomoveisTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisTransacoesActionPerformed
        setBtnColors("Automoveis", "Transacoes");
        ttm.setTipoVeiculo(2);//tipo 2 auto
        ctrlTransacoes.showAutos();
    }//GEN-LAST:event_btnAutomoveisTransacoesActionPerformed

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

    private void VendaTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VendaTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_VendaTableMousePressed

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

    private void ftxtDataTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtDataTransacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtDataTransacoesActionPerformed

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

    private void cboxMarcaTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaTransacoesActionPerformed
        ctrlTransacoes.activateCboxMarcaTransacoes();
    }//GEN-LAST:event_cboxMarcaTransacoesActionPerformed

    private void btnVansVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVansVeiculosActionPerformed
        setBtnColors("Vans", "Veiculos");
        vtm.setTipoVeiculo(3);//tipo 3 van
        ctrlVeiculos.showVans();
    }//GEN-LAST:event_btnVansVeiculosActionPerformed

    private void btnMotocicletasVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotocicletasVeiculosActionPerformed
        setBtnColors("Motocicletas", "Veiculos");
        vtm.setTipoVeiculo(1);//tipo 1 moto
        ctrlVeiculos.showMotos();
    }//GEN-LAST:event_btnMotocicletasVeiculosActionPerformed

    private void btnAutomoveisVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomoveisVeiculosActionPerformed
        setBtnColors("Automoveis", "Veiculos");
        vtm.setTipoVeiculo(2);//tipo 2 auto
        ctrlVeiculos.showAutos();
    }//GEN-LAST:event_btnAutomoveisVeiculosActionPerformed

    private void cboxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxModeloActionPerformed

    private void cboxCategoriaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaVeiculoActionPerformed
        ctrlVeiculos.activateCboxCategoriaVeiculos();
    }//GEN-LAST:event_cboxCategoriaVeiculoActionPerformed

    private void cboxMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMarcaVeiculoActionPerformed
        ctrlVeiculos.activateCboxMarcaVeiculos();
    }//GEN-LAST:event_cboxMarcaVeiculoActionPerformed

    private void btnLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocacaoActionPerformed
        ttm.setTipoTransacao(1);//tipo 1 locacao
    }//GEN-LAST:event_btnLocacaoActionPerformed

    private void btnDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucaoActionPerformed
        ttm.setTipoTransacao(2);//tipo 2 devolução
    }//GEN-LAST:event_btnDevolucaoActionPerformed

    private void btnVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendaActionPerformed
        ttm.setTipoTransacao(3);//tipo 3 venda
    }//GEN-LAST:event_btnVendaActionPerformed

    private void btnListarTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarTransacoesActionPerformed
        ctrlTransacoes.showClientes();
    }//GEN-LAST:event_btnListarTransacoesActionPerformed

    private void tabTransacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTransacoesMouseClicked
        
    }//GEN-LAST:event_tabTransacoesMouseClicked

    private void txtPesquisarClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarClientesKeyReleased
        ctrlTransacoes.filterCtt(txtPesquisarClientes.getText());
    }//GEN-LAST:event_txtPesquisarClientesKeyReleased

    private void txtDiasTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasTransacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasTransacoesActionPerformed

    private void clientesTransacoesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesTransacoesTableMouseClicked
        ctrlTransacoes.showAllMotos();
    }//GEN-LAST:event_clientesTransacoesTableMouseClicked

    private void cboxCategoriaTransacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaTransacoesActionPerformed
        ctrlTransacoes.activateCboxCategoriaTransacoes();
    }//GEN-LAST:event_cboxCategoriaTransacoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DevolverTable;
    private javax.swing.JTable TransacoesTable;
    private javax.swing.JTable VendaTable;
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnAutomoveisDevolver;
    private javax.swing.JButton btnAutomoveisTransacoes;
    private javax.swing.JButton btnAutomoveisVeiculos;
    private javax.swing.JButton btnAutomoveisVenda;
    private javax.swing.JButton btnDevolucao;
    private javax.swing.JButton btnIncluirCliente;
    private javax.swing.JButton btnIncluirVeiculo;
    private javax.swing.JButton btnLimparCliente;
    private javax.swing.JButton btnListarCliente;
    private javax.swing.JButton btnListarTransacoes;
    private javax.swing.JButton btnLocacao;
    private javax.swing.JButton btnLocar;
    private javax.swing.JButton btnMotocicletasDevolver;
    private javax.swing.JButton btnMotocicletasTransacoes;
    private javax.swing.JButton btnMotocicletasVeiculos;
    private javax.swing.JButton btnMotocicletasVenda;
    private javax.swing.JButton btnRemoverCliente;
    private javax.swing.JButton btnVansDevolver;
    private javax.swing.JButton btnVansTransacoes;
    private javax.swing.JButton btnVansVeiculos;
    private javax.swing.JButton btnVansVenda;
    private javax.swing.JButton btnVenda;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JComboBox<String> cboxCategoriaTransacoes;
    private javax.swing.JComboBox<String> cboxCategoriaVeiculo;
    private javax.swing.JComboBox<String> cboxCategoriaVenda;
    private javax.swing.JComboBox<String> cboxMarca;
    private javax.swing.JComboBox<String> cboxMarcaTransacoes;
    private javax.swing.JComboBox<String> cboxMarcaVeiculo;
    private javax.swing.JComboBox<String> cboxMarcaVenda;
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
    private javax.swing.JScrollPane paneDevolverTable;
    private javax.swing.JScrollPane paneVeiculoTable;
    private javax.swing.JScrollPane paneVeiculoTableLocacao;
    private javax.swing.JScrollPane paneVendaTable;
    private javax.swing.JPanel tabCliente;
    private javax.swing.JPanel tabDevolucao;
    private javax.swing.JPanel tabTransacoes;
    private javax.swing.JPanel tabVeiculos;
    private javax.swing.JPanel tabVenda;
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
        return TransacoesTable;
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
    private void costumizeButtons() {
        for (Component component : paneAllTabs.getComponents()) {
            if (component instanceof JButton) {
                String name = component.getName();
                if (name != null) {
                    System.out.println(name);
                } else {
                    System.out.println("Button has no name"); // Or handle the case without a name
                }
                ((JButton) component).setFont(monospace);
                ((JButton) component).setFocusable(false);
            }
        }
    }

    private void setBtnColors(String btn, String tab) {
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
            /*case "Devolucao" -> {
                Color m = btnMotocicletasDevolver.getBackground();
                Color a = btnAutomoveisDevolver.getBackground();
                Color v = btnVansDevolver.getBackground();
                switch (btn) {
                    case "Motocicletas" -> {
                        btnMotocicletasDevolver.setBackground(new Color(118, 181, 197));
                        if (a != o) {
                            btnAutomoveisDevolver.setBackground(o);
                        } else if (v != o) {
                            btnVansDevolver.setBackground(o);
                        }
                    }
                    case "Automoveis" -> {
                        btnAutomoveisDevolver.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasDevolver.setBackground(o);
                        } else if (v != o) {
                            btnVansDevolver.setBackground(o);
                        }
                    }
                    case "Vans" -> {
                        btnVansDevolver.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasDevolver.setBackground(o);
                        } else if (a != o) {
                            btnAutomoveisDevolver.setBackground(o);
                        }
                    }
                }
            }
            case "Venda" -> {
                Color m = btnMotocicletasVenda.getBackground();
                Color a = btnAutomoveisVenda.getBackground();
                Color v = btnVansVenda.getBackground();
                switch (btn) {
                    case "Motocicletas" -> {
                        btnMotocicletasVenda.setBackground(new Color(118, 181, 197));
                        if (a != o) {
                            btnAutomoveisVenda.setBackground(o);
                        } else if (v != o) {
                            btnVansVenda.setBackground(o);
                        }
                    }
                    case "Automoveis" -> {
                        btnAutomoveisVenda.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasVenda.setBackground(o);
                        } else if (v != o) {
                            btnVansVenda.setBackground(o);
                        }
                    }
                    case "Vans" -> {
                        btnVansVenda.setBackground(new Color(118, 181, 197));
                        if (m != o) {
                            btnMotocicletasVenda.setBackground(o);
                        } else if (a != o) {
                            btnAutomoveisVenda.setBackground(o);
                        }
                    }
                }
            }*/
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

    public Locacao getLocacaoFormulario() {
        try {
            int dias = Integer.parseInt(txtDiasTransacoes.getText());
            String dateString = ftxtDataTransacoes.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dateString, formatter);
            double valorDiariaLocacao = ttm.getValorDiariaLocacao(TransacoesTable);
            double valor = valorDiariaLocacao * dias;
            if (dias == 0 || localDate == null) {
                apresentaErro("Preencha a data e a quantidade de dias.");
            } else {
                return new Locacao(dias, valor, localDate);
            }
        } catch (DateTimeParseException e) {
            apresentaErro("Invalid date format. Please use YYYY-MM-DD.");
        }
        return null;
    }

    public javax.swing.JButton getBtnMotocicletasTransacoes() {
        return btnMotocicletasTransacoes;
    }

    public javax.swing.JButton getBtnMotocicletasVeiculos() {
        return btnMotocicletasVeiculos;
    }

}
