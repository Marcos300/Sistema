/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mcaj.gui;

import br.com.mcaj.dao.DaoLogin;
import javax.swing.JLabel;

/**
 *
 * @author Marcos
 */
public class Menu extends javax.swing.JFrame {
private JLabel pessoa;
	private String nomeUsuario = "Teste";
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnuItemProduto = new javax.swing.JMenu();
        itemMenuCadLote = new javax.swing.JMenuItem();
        itemMenuCadNormal = new javax.swing.JMenuItem();
        mnuCliente = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        imnuClienteN = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");

        MnuItemProduto.setText("Produto");

        itemMenuCadLote.setText("Lote");
        itemMenuCadLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCadLoteActionPerformed(evt);
            }
        });
        MnuItemProduto.add(itemMenuCadLote);

        itemMenuCadNormal.setText("Normal");
        itemMenuCadNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCadNormalActionPerformed(evt);
            }
        });
        MnuItemProduto.add(itemMenuCadNormal);

        jMenu1.add(MnuItemProduto);

        mnuCliente.setText("Cliente");

        jMenuItem1.setText("Lote");
        mnuCliente.add(jMenuItem1);

        imnuClienteN.setText("Normal");
        imnuClienteN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imnuClienteNActionPerformed(evt);
            }
        });
        mnuCliente.add(imnuClienteN);

        jMenu1.add(mnuCliente);

        barraDeMenu.add(jMenu1);

        jMenu2.setText("Consulta");
        barraDeMenu.add(jMenu2);

        jMenu4.setText("Estoque");
        barraDeMenu.add(jMenu4);

        jMenu5.setText("Venda");
        barraDeMenu.add(jMenu5);

        jMenu3.setText("Relatorio");
        barraDeMenu.add(jMenu3);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuCadLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCadLoteActionPerformed
        // TODO add your handling code here:
  
        CarregarProdutos cadLote = new CarregarProdutos();
        cadLote.setVisible(true);
         
    }//GEN-LAST:event_itemMenuCadLoteActionPerformed

    private void itemMenuCadNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCadNormalActionPerformed
        // TODO add your handling code here:
      CadProduto app = new CadProduto();
      app.setVisible(true);
    }//GEN-LAST:event_itemMenuCadNormalActionPerformed

    private void imnuClienteNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imnuClienteNActionPerformed
        // TODO add your handling code here:
        CadastroCliente app = new CadastroCliente();
        app.setVisible(true);
    }//GEN-LAST:event_imnuClienteNActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    	public String verificarAcesso(String nome, String senha) {
		
		DaoLogin vacesso = new DaoLogin();
		String meuAcesso = vacesso.checkAcesso(nome, senha);
		
	    nomeUsuario = nome;
	    String nomeMaiusculo =  nomeUsuario.toUpperCase();
	    pessoa.setText(nomeMaiusculo);
	    
	    String vAcessoFinal = meuAcesso.toLowerCase();
	    
		if(vAcessoFinal.equals("adm"))
		
		if(vAcessoFinal.equals("oper"))
		
		if(vAcessoFinal.equals("gestao"))
		
		System.out.println("Acesso Menu: " + meuAcesso);
		return meuAcesso;

	}

//	public void setMenu(boolean menuCadastro, boolean menuConsulta, boolean menuBuscar,boolean nFilmes, boolean cLogin) {
//
//		subFilmes.setEnabled(menuCadastro);
//		subConsultaSQL.setEnabled(menuConsulta);
//		subBuscarFilmes.setEnabled(menuBuscar);
//		subNavegaFilmes.setEnabled(nFilmes);
//		subCadastroLogin.setEnabled(cLogin);
//	}
//    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MnuItemProduto;
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JMenuItem imnuClienteN;
    private javax.swing.JMenuItem itemMenuCadLote;
    private javax.swing.JMenuItem itemMenuCadNormal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mnuCliente;
    // End of variables declaration//GEN-END:variables
}
