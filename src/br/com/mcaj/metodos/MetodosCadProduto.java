/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import br.com.mcaj.bean.BeanProduto;
import br.com.mcaj.dao.DaoCadProduto;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class MetodosCadProduto {

    public void Gravar(JTextField nome, JTextField preco, JTextField qtde) {
        System.out.println(nome.getText());
        System.out.println(preco.getText());
        System.out.println(qtde.getText());

        DaoCadProduto dao = new DaoCadProduto();
        BeanProduto bean = new BeanProduto();

        bean.setName(nome.getText());
        bean.setPrice(Double.parseDouble(preco.getText()));
        bean.setQuantity(Integer.parseInt(qtde.getText()));

        dao.inserir(bean);
    }

    public void Atualizar(JTextField nome, JTextField preco, JTextField qtde) {
        System.out.println(nome.getText());
        System.out.println(preco.getText());
        System.out.println(qtde.getText());

        DaoCadProduto dao = new DaoCadProduto();
        BeanProduto bean = new BeanProduto();

        bean.setName(nome.getText());
        bean.setPrice(Double.parseDouble(preco.getText()));
        bean.setQuantity(Integer.parseInt(qtde.getText()));

        dao.atualizar(bean);
    }

    public void deletar(JTextField nome) {

        System.out.println(nome.getText());
        DaoCadProduto dao = new DaoCadProduto();
        BeanProduto bean = new BeanProduto();

        bean.setName(nome.getText());
        dao.deletar(bean);
    }

    public void cmdRdGravar(JRadioButton selecaoDoRadio, JButton cmdGravar) {
// TODO add your handling code here:
        // TODO add your handling code here:
      
        
        // setBotoes(false, true, true, false, true, true, true, false, false, false);
        if (selecaoDoRadio.isSelected() == true) {
            cmdGravar.setText("Gravar");

        }
       
    }

    public void cmdRdAtualizar( JRadioButton selecaoDoRadio, JButton cmdGravar) {
// TODO add your handling code here:
        // TODO add your handling code here:
  
        // setBotoes(false, true, true, false, true, true, true, false, false, false);
        if (selecaoDoRadio.isSelected() == true) {
            cmdGravar.setText("Atualizar");

        }
    }

}
