/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.gui;

import br.com.mcaj.bean.BeanProduto;
import br.com.mcaj.conexao.BD;
import br.com.mcaj.dao.DaoProduto;
import br.com.mcaj.modelos.ModeloAtualizarTabela;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Marcos
 */
public class CarregarProdutos extends javax.swing.JFrame {

    private ArrayList<Object> dados;
    private String[] colunas = {"nome", "Preço", "Quantidade"};
    private ModeloAtualizarTabela modelo;
    private boolean carregado = false;
    private BeanProduto pegaDaTabela;
    private ArrayList<BeanProduto> ListaDeProdutos;
    private String mensagemDesejaAtualizar = null;
    private String mensagemAtualizados = null;
    private String mensagemNãoAtualizar = null;
    private String mensagemCancelar = null;

    private ButtonGroup grupoDeRadiopButton;
    private ResultSet resultSet;

    private TableRowSorter<TableModel> trs;
    private int campoPesquisa;

    /**
     * Creates new form CarregarRegitros
     */
    public CarregarProdutos() {
        initComponents();
        ConfiguracaoRadioButton();
        setBotoes(true, false, false,
                false, false, false, false, false, false, false);
        definirEventos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        painel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        painelComandos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btGravar = new javax.swing.JButton();
        btDeletar = new javax.swing.JButton();
        painelEscolhaAcao = new javax.swing.JPanel();
        selecGrava = new javax.swing.JRadioButton();
        selecAtualiza = new javax.swing.JRadioButton();
        selecDeleta = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btCarregar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btConsulta = new javax.swing.JToggleButton();
        btExportar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JPanel();
        buscar = new javax.swing.JTextField();
        cboCampoEscolhido = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Carregar os Produtos");
        setBackground(new java.awt.Color(255, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("TelaCargaRegistro"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        painel.setBackground(new java.awt.Color(102, 102, 255));
        painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tabela.setAutoCreateRowSorter(true);
        tabela.setBackground(new java.awt.Color(255, 204, 255));
        tabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nome", "Preco", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setGridColor(new java.awt.Color(0, 0, 0));
        tabela.setSelectionBackground(new java.awt.Color(0, 153, 204));
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.setShowHorizontalLines(true);
        tabela.setShowVerticalLines(true);
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela);
        tabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        painelComandos.setBackground(new java.awt.Color(255, 255, 153));
        painelComandos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comandos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        painelComandos.setInheritsPopupMenu(true);
        painelComandos.setName("Comandos"); // NOI18N
        painelComandos.setLayout(new javax.swing.BoxLayout(painelComandos, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Executar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));

        btGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcaj/gui/imagens/savetheapplication_guardar_2958.png"))); // NOI18N
        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel1.add(btGravar);

        btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcaj/gui/imagens/delete_delete_exit_1577.png"))); // NOI18N
        btDeletar.setText("Deletar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(btDeletar);

        painelComandos.add(jPanel1);

        painelEscolhaAcao.setBackground(new java.awt.Color(51, 255, 51));
        painelEscolhaAcao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escolher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        painelEscolhaAcao.setForeground(new java.awt.Color(255, 0, 0));

        selecGrava.setText("Gravar");
        selecGrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecGravaActionPerformed(evt);
            }
        });
        painelEscolhaAcao.add(selecGrava);

        selecAtualiza.setText("Atualizar");
        selecAtualiza.setAlignmentX(0.5F);
        selecAtualiza.setAutoscrolls(true);
        selecAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecAtualizaActionPerformed(evt);
            }
        });
        painelEscolhaAcao.add(selecAtualiza);

        selecDeleta.setText("Deletar");
        selecDeleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecDeletaActionPerformed(evt);
            }
        });
        painelEscolhaAcao.add(selecDeleta);

        painelComandos.add(painelEscolhaAcao);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carregar Arquivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 0, 0));

        btCarregar.setBackground(new java.awt.Color(255, 51, 51));
        btCarregar.setForeground(new java.awt.Color(0, 0, 102));
        btCarregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcaj/gui/imagens/office_excel_csv_15865 (1).png"))); // NOI18N
        btCarregar.setText("Carregar");
        btCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarregarActionPerformed(evt);
            }
        });
        jPanel2.add(btCarregar);

        btLimpar.setBackground(new java.awt.Color(255, 51, 51));
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcaj/gui/imagens/1486503744-backspace-clean-clear-delete-remove-erase_81258.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });
        jPanel2.add(btLimpar);

        jPanel3.setBackground(new java.awt.Color(102, 0, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultar e Exportar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        btConsulta.setBackground(new java.awt.Color(102, 255, 102));
        btConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcaj/gui/imagens/business_application_download_downloaddatabase_thedatabase_2320.png"))); // NOI18N
        btConsulta.setText("Consulta no BD");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });
        jPanel3.add(btConsulta);

        btExportar.setBackground(new java.awt.Color(51, 255, 51));
        btExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/mcaj/gui/imagens/ext_csv_filetype_icon_176252.png"))); // NOI18N
        btExportar.setText("Exportar .CSV");
        btExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportarActionPerformed(evt);
            }
        });
        jPanel3.add(btExportar);

        txtBuscar.setBackground(new java.awt.Color(0, 102, 102));
        txtBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        cboCampoEscolhido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NOME", "PRECO", "QUANTIDADE" }));
        cboCampoEscolhido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCampoEscolhidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtBuscarLayout = new javax.swing.GroupLayout(txtBuscar);
        txtBuscar.setLayout(txtBuscarLayout);
        txtBuscarLayout.setHorizontalGroup(
            txtBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboCampoEscolhido, 0, 183, Short.MAX_VALUE)
                    .addComponent(buscar))
                .addContainerGap())
        );
        txtBuscarLayout.setVerticalGroup(
            txtBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboCampoEscolhido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(painelComandos, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelComandos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelComandos.getAccessibleContext().setAccessibleName("Teste");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        painel.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarregarActionPerformed
        // TODO add your handling code here:
        carregarArquivo();

    }//GEN-LAST:event_btCarregarActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, mensagemDesejaAtualizar);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                if (selecGrava.isSelected()) {
                    Gravar();
                    limparRadioSeleção();
                }
                if (selecAtualiza.isSelected()) {
                    Atualizar();
                    limparRadioSeleção();
                }

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, mensagemAtualizados);

            modelo.LimparTabela();
            carregado = false;

            setBotoes(true, false, false, false, false, false, false, false, false, false);
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null,
                    mensagemNãoAtualizar);

            modelo.LimparTabela();
            carregado = false;
            setBotoes(true, false, false, false, false, false, false, false, false, false);
        } else if (resposta == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null,
                    mensagemCancelar);
            carregado = false;
            return;
        }

    }//GEN-LAST:event_btGravarActionPerformed

    private void selecGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecGravaActionPerformed
        // TODO add your handling code here:
        mensagemDesejaAtualizar = "Deseja Gravar os Registros?";
        mensagemAtualizados = "Registros Gravados no Banco!!!";
        mensagemNãoAtualizar = "Os registros não serão Gravados!!!";
        mensagemCancelar = "Registros não foram Gravados!!!";

        setBotoes(false, true, true, false, true, true, true, false, false, false);

        if (selecGrava.isSelected() == true) {
            btGravar.setText("Gravar");

        }
    }//GEN-LAST:event_selecGravaActionPerformed

    private void selecDeletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecDeletaActionPerformed
        // TODO add your handling code here:
        // mensagemDesejaAtualizar = "Deseja Atualizar os Registros?";
        // mensagemAtualizados = "Registros Atualizados!!!";
        // mensagemNãoAtualizar =
        // "Os registros não serão Atualizados!!!";
        // mensagemCancelar = "Registros não Atualizados!!!";

        setBotoes(false, false, true, true, true, true, true, false, false, false);

        if (selecDeleta.isSelected() == true) {
            // btGravar.setText("Atualizar");

        }


    }//GEN-LAST:event_selecDeletaActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        // TODO add your handling code here:
        modelo.LimparTabela();
        carregado = false;
        limparRadioSeleção();

        setBotoes(true, false, false, false, false, false, false, false, false, false);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null,
                "Deseja Deletar os Registros?");
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                deletarPorNome();
                limparRadioSeleção();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,
                    "Registros Deletados!!!");

            modelo.LimparTabela();
            carregado = false;

            setBotoes(true, false, false, false, false, false, false, false, false, false);
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "Registros não serão Deletados!!!");

            modelo.LimparTabela();
            carregado = false;
            setBotoes(true, false, false, false, false, false, false, false, false, false);
        } else if (resposta == JOptionPane.CANCEL_OPTION) {
            carregado = false;
            return;
        }
    }//GEN-LAST:event_btDeletarActionPerformed

    private void selecAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecAtualizaActionPerformed
        // TODO add your handling code here:
        mensagemDesejaAtualizar = "Deseja Atualizar os Registros?";
        mensagemAtualizados = "Registros Atualizados!!!";
        mensagemNãoAtualizar = "Os registros não serão Atualizados!!!";
        mensagemCancelar = "Registros não Atualizados!!!";

        setBotoes(false, true, true, false, true, true, true, false, false, false);

        if (selecAtualiza.isSelected() == true) {
            btGravar.setText("Atualizar");

        }

    }//GEN-LAST:event_selecAtualizaActionPerformed

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        // TODO add your handling code here:
        boolean selected = btConsulta.getModel().isSelected();
        if (selected == true) {
            System.out.println("Verdadeiro");
            //modelo.LimparTabela();

            try {
                carregarTabelaBanco();
                setBotoes(false, false, false, false, false, false, false, true, true, true);
                buscar.setText(null);
                btConsulta.setBackground(Color.ORANGE);
            } catch (SQLException ex) {
                Logger.getLogger(CarregarProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            modelo.LimparTabela();
            buscar.setText(null);
            btConsulta.setBackground(Color.GREEN);

            setBotoes(true, false, false, false, false, false, false, false, false, false);
            System.out.println("Falso");

        }
    }//GEN-LAST:event_btConsultaActionPerformed

    private void btExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportarActionPerformed
        // TODO add your handling code here:
        JFileChooser fchoose = new JFileChooser();
        int opcao = fchoose.showSaveDialog(CarregarProdutos.this);

        if (opcao == JFileChooser.APPROVE_OPTION) {
            String name = fchoose.getSelectedFile().getName();
            String path = fchoose.getSelectedFile().getParentFile().getPath();
            String file = path + "\\" + name + ".csv";
            export(tabela, new File(file));
        }
    }//GEN-LAST:event_btExportarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:

        if (btConsulta.getModel().isSelected()) {
            int linha = tabela.getSelectedRow();

            String nome = tabela.getValueAt(linha, 0).toString();
            String preco = tabela.getValueAt(linha, 1).toString();
            String quantidade = tabela.getValueAt(linha, 2).toString();

            // dispose();
            CadProduto app = new CadProduto();
            app.setVisible(true);
            app.RecebeInformacao(nome, preco, quantidade);
            //app.setBotoes(false, false, false, true, true, true);
            //app.setCampos(true, true, true, true);

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void cboCampoEscolhidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCampoEscolhidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCampoEscolhidoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo fechar essa Tela?", "Atenção", JOptionPane.YES_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarregarProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarregarProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarregarProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarregarProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarregarProdutos().setVisible(true);
            }
        });
    }

    public void carregarArquivo() {

        dados = new ArrayList<>();
        colunas = new String[]{"Nome", "Preço", "Quantidade"};

        JFrame tela = new JFrame("Ler Arquivo");
        JFileChooser filex = new JFileChooser();

        filex.setDialogTitle("Escolha um Arquivo para realizar a Carga");

        filex.setFileFilter(new FileNameExtensionFilter("Arquivo(.txt | .csv)",
                "txt", "csv"));
        filex.setAcceptAllFileFilterUsed(false);

        int opcao = filex.showSaveDialog(tela);

        List<BeanProduto> list = new ArrayList<BeanProduto>();

        if (opcao == JFileChooser.APPROVE_OPTION) {// inicio da verificação de
            // carga dos arquivos
            String path = filex.getSelectedFile().getPath();
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {// inicio
                // da
                // leitura

                String line = br.readLine();
                line = br.readLine();
                while (line != null) {

                    String[] vect = line.split(",|;");
                    String name = vect[0].trim().toUpperCase();
                    Double price = Double.parseDouble(vect[1]);
                    Integer qtde = Integer.parseInt(vect[2]);

                    BeanProduto prod = new BeanProduto(name, price, qtde);
                    list.add(prod);

                    line = br.readLine();
                }

                // saber a quantidade
                System.out.println("PRODUTOS:");
                for (BeanProduto p : list) {
                    // System.out.println(p);
                    dados.add(new Object[]{p.getName(), p.getPrice(),
                        p.getQuantity()});
                    System.out.println("Nome: " + p.getName());
                    System.out.println("Preço: " + p.getPrice());
                    System.out.println("Quantidade:" + p.getQuantity() + "\n");

                }
                carregado = true;

                setBotoes(false, false, true, false, true, true, true, false, false, false);
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Arquivo não Carregado!!!");
            } // fim do try catch da leitura do arquivo
        }

        modelo = new ModeloAtualizarTabela(dados, colunas);
        tabela.setModel(modelo);

        // setBotoes(false,true, true);
        if (carregado == true) {
            JOptionPane.showMessageDialog(null, "Arquivo Carregado!!!");
            tabela.repaint();
        }

    }

    public void Gravar() throws SQLException {
        ListaDeProdutos = new ArrayList<>();
        DaoProduto produtoDao = new DaoProduto();

        int totalRows = tabela.getRowCount();
        for (int i = 0; i < totalRows; i++) {
            pegaDaTabela = new BeanProduto();
            pegaDaTabela.setName((String) tabela.getModel().getValueAt(i, 0));
            pegaDaTabela.setPrice((Double) tabela.getModel().getValueAt(i, 1));
            pegaDaTabela.setQuantity((int) tabela.getModel().getValueAt(i, 2));
            ListaDeProdutos.add(pegaDaTabela);

        }
        produtoDao.insertBatch(ListaDeProdutos);
    }

    // botao gravar correto
    public void Atualizar() throws SQLException {
        ListaDeProdutos = new ArrayList<>();
        DaoProduto dao = new DaoProduto();

        int totalRows = tabela.getRowCount();

        for (int i = 0; i < totalRows; i++) {
            pegaDaTabela = new BeanProduto();
            pegaDaTabela.setName(((String) tabela.getModel().getValueAt(i, 0))
                    .trim().toUpperCase());
            pegaDaTabela.setPrice((Double) tabela.getModel().getValueAt(i, 1));
            pegaDaTabela.setQuantity((int) tabela.getModel().getValueAt(i, 2));
            ListaDeProdutos.add(pegaDaTabela);

        }
        dao.updateBatch(ListaDeProdutos);
        System.out.println(ListaDeProdutos);

    }

    public void deletarPorNome() throws SQLException {
        ListaDeProdutos = new ArrayList<>();
        DaoProduto dao = new DaoProduto();

        int totalRows = tabela.getRowCount();

        for (int i = 0; i < totalRows; i++) {
            pegaDaTabela = new BeanProduto();
            pegaDaTabela.setName(((String) tabela.getModel().getValueAt(i, 0))
                    .trim().toUpperCase());
            pegaDaTabela.setPrice((Double) tabela.getModel().getValueAt(i, 1));
            pegaDaTabela.setQuantity((int) tabela.getModel().getValueAt(i, 2));
            ListaDeProdutos.add(pegaDaTabela);

        }
        dao.deleteBatch(ListaDeProdutos);
        System.out.println(ListaDeProdutos);

    }

    public void ConfiguracaoRadioButton() {
        grupoDeRadiopButton = new ButtonGroup();
        grupoDeRadiopButton.add(selecGrava);
        grupoDeRadiopButton.add(selecAtualiza);
        grupoDeRadiopButton.add(selecDeleta);

    }

    public void setBotoes(boolean carregar, boolean Gravar, boolean Limpar,
            boolean deletar, boolean atualiza, boolean grava, boolean deleta, boolean exportar, boolean cboEscolha, boolean busca) {

        btCarregar.setEnabled(carregar);
        btGravar.setEnabled(Gravar);
        btLimpar.setEnabled(Limpar);
        btDeletar.setEnabled(deletar);
        selecGrava.setEnabled(grava);
        selecAtualiza.setEnabled(atualiza);
        selecDeleta.setEnabled(deleta);
        btExportar.setEnabled(exportar);
        cboCampoEscolhido.setEnabled(cboEscolha);
        buscar.setEnabled(busca);
    }

    public void limparRadioSeleção() {
        grupoDeRadiopButton.clearSelection();
        modelo.LimparTabela();
        carregado = false;

    }

    public void carregarTabelaBanco() throws SQLException {
        buscarTodosProdutos();

        dados = new ArrayList<>();
        colunas = new String[]{"nome", "preco", "quantidade"};

        try {
            resultSet.first();

            do {

                dados.add(new Object[]{resultSet.getString("nome"),
                    resultSet.getString("preco"),
                    resultSet.getString("quantidade"),});

            } while (resultSet.next());

            JOptionPane.showMessageDialog(null, "Os registros do Banco foram Carregados!!!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sem produtos Cadastrados!!!");
            System.out.println("erro: " + e);

        }

        modelo = new ModeloAtualizarTabela(dados, colunas);
        tabela.setModel(modelo);

        tabela.repaint();
        btCarregar.setEnabled(true);

    }

    public ResultSet buscarTodosProdutos() throws SQLException {
        String BUSCAR_POR_TODOS = "select* from produto";
        PreparedStatement statement;
        BD bd = new BD();
        if (!bd.getConnection()) {
            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        statement = bd.connection.prepareStatement(BUSCAR_POR_TODOS);
        resultSet = statement.executeQuery();
        return resultSet;

    }

    public void export(JTable table, File file) {
        try {
            TableModel m = table.getModel();
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < m.getColumnCount(); i++) {
                fw.write(m.getColumnName(i) + ";");
            }
            fw.write("\n");
            for (int i = 0; i < m.getRowCount(); i++) {
                for (int j = 0; j < m.getColumnCount(); j++) {
                    fw.write(m.getValueAt(i, j).toString() + ";");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void habilitarFiltragemBuscaTabela() {
        // habilita a filtragem dos dados
        trs = new TableRowSorter<TableModel>(tabela.getModel());
        tabela.setRowSorter(trs);

    }

    public void definirEventos() {

        buscar.addKeyListener(new KeyAdapter() {

            public void keyReleased(final KeyEvent e) {

                if (cboCampoEscolhido.getSelectedIndex() == 0) {
                    campoPesquisa = 0; // codigo
                } else if (cboCampoEscolhido.getSelectedIndex() == 1) {
                    campoPesquisa = 1;// titulo
                } else if (cboCampoEscolhido.getSelectedIndex() == 2) {
                    campoPesquisa = 2;// genero
                }

                habilitarFiltragemBuscaTabela();

                trs.setRowFilter(RowFilter.regexFilter(
                        "(?i)" + buscar.getText(), campoPesquisa));
                if (buscar.getText().equals("")) {
                    limparFiltro();
                }

            }

        });
    }

    public void limparFiltro() {
        trs.setRowFilter(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCarregar;
    private javax.swing.JToggleButton btConsulta;
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btExportar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JTextField buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox cboCampoEscolhido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelComandos;
    private javax.swing.JPanel painelEscolhaAcao;
    private javax.swing.JRadioButton selecAtualiza;
    private javax.swing.JRadioButton selecDeleta;
    private javax.swing.JRadioButton selecGrava;
    private javax.swing.JTable tabela;
    private javax.swing.JPanel txtBuscar;
    // End of variables declaration//GEN-END:variables

    public void limparTabela() {
        //modelo.LimparTabela();
        btConsulta.getModel().setSelected(false);
        btConsulta.getModel().setSelected(true);
    }
}
