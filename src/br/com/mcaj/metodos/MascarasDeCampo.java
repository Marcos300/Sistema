/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Marcos
 */
public class MascarasDeCampo {

    public void MascCep(JFormattedTextField cep) {
        try {
            MaskFormatter mascaraDeCep = new MaskFormatter("#####-###");
            mascaraDeCep.install(cep);
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }

    public void MascCpf(JFormattedTextField cpf) {
        try {
            MaskFormatter mascaraDeCpf = new MaskFormatter("###.###.###-##");
            mascaraDeCpf.install(cpf);
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }

    public void MascCNPJ(JFormattedTextField cnpj) {
        try {
            MaskFormatter mascaraDeCnpj = new MaskFormatter("##.###.###/####-##");
            mascaraDeCnpj.install(cnpj);
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }

    public void MascTel(JFormattedTextField tel) {
        try {
            MaskFormatter mascaraDeTel = new MaskFormatter("(##)####-####");
            mascaraDeTel.install(tel);
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }

    public void MascCel(JFormattedTextField tel) {
        try {
            MaskFormatter mascaraDeTel = new MaskFormatter("(##)#####-####");
            mascaraDeTel.install(tel);
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }



}//fim da classe

