/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class TratarTexto {

    public void validarNome(String texto) {

        if (texto.length() < 5 || texto.length() > 50) {
            texto = "Nome invalido\n";
            JOptionPane.showMessageDialog(null, texto, "Erro", 0);

        }

        if (texto.indexOf(" ") == -1) {
            texto = "O nome deve conter o seu nome e sobrenome\n";
            JOptionPane.showMessageDialog(null, texto, "Erro", 0);

        }

        if (texto.substring(0, texto.indexOf(" ")).length() < 2 || texto.substring(texto.lastIndexOf(" ") + 1).length() < 2) {
            texto = "O nome e o sobrenome deve contrer pelo menos 2 caracteres\n";
            JOptionPane.showMessageDialog(null, texto, "Erro", 0);

        }

    }

    public void validarRua(String rua) {

        if (rua.length() < 5 || rua.length() > 50) {
            rua = "Endereco invalido\n";
            JOptionPane.showMessageDialog(null, rua, "Erro", 0);

        }

        if (rua.indexOf(" ") == -1) {
            rua = "nome de rua curto demais\n";
            JOptionPane.showMessageDialog(null, rua, "Erro", 0);

        }

        if (rua.substring(0, rua.indexOf(" ")).length() < 2 || rua.substring(rua.lastIndexOf(" ") + 1).length() < 2) {
            rua = "A rua deve Conter Tipo e Logradouro\n Exempo: Tipo(Rua,Estrada,Avenida)\nLogradouro(são luiz, acácias)";
            JOptionPane.showMessageDialog(null, rua, "Erro", 0);

        }

    }

}
