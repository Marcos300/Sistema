/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.webservice;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class BuscarCep {

    public void buscarCep(JFormattedTextField cep, JTextField endereco, JTextField cidade, JTextField bairro, JTextField uf) {
        // Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep.getText().replace("-",""));
		// A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        // caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            endereco.setText(webServiceCep.getLogradouroFull());
            cidade.setText(webServiceCep.getCidade());
            bairro.setText(webServiceCep.getBairro());
            uf.setText(webServiceCep.getUf());
            JOptionPane.showMessageDialog(null, "CEP Encontrado!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            // caso haja problemas imprime as exce??es.
        } else {
            System.out.println("Erro numero: " + webServiceCep.getResulCode());
            System.out.println("Descrição do erro: "
                    + webServiceCep.getResultText());
            JOptionPane.showMessageDialog(null, "O CEP não foi Encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
