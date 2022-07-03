/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//https://ef3cinco.wordpress.com/2011/09/07/como-validar-titulo-de-eleitor-usando-java-netbeans/
package br.com.mcaj.validacao;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Marcos
 */
public class Titulo {

    private static final String Formato = "###########";
    //Validar Título de Eleitor

    public static String ValidarTitulo(String strTitulo) {
        int dig1;
        int dig2;
        int dig3;
        int dig4;
        int dig5;
        int dig6;
        int dig7;
        int dig8;
        int dig9;
        int dig10;
        int dig11;
        int dig12;
        int dv1;
        int dv2;
        int qDig;

        if (strTitulo.length() == 0) //Validação do preenchimento
        {
            return "Número não informado!"; //Caso não seja informado o Título
        } else {
            if (strTitulo.length() < 12) {                          //Completar 12 dígitos  strTitulo = "000000000000" + strTitulo;  strTitulo = strTitulo.substring(strTitulo.length() - 12);                  }         else if (strTitulo.length() > 12)
                {
                    return "Número inválido!"; //Caso tenha mais que 12 dígitos
                }
            }

            qDig = strTitulo.length(); //Total de caracteres

            //Gravar posição dos caracteres
            dig1 = Integer.parseInt(Mid(strTitulo, qDig - 11, 1));
            dig2 = Integer.parseInt(Mid(strTitulo, qDig - 10, 1));
            dig3 = Integer.parseInt(Mid(strTitulo, qDig - 9, 1));
            dig4 = Integer.parseInt(Mid(strTitulo, qDig - 8, 1));
            dig5 = Integer.parseInt(Mid(strTitulo, qDig - 7, 1));
            dig6 = Integer.parseInt(Mid(strTitulo, qDig - 6, 1));
            dig7 = Integer.parseInt(Mid(strTitulo, qDig - 5, 1));
            dig8 = Integer.parseInt(Mid(strTitulo, qDig - 4, 1));
            dig9 = Integer.parseInt(Mid(strTitulo, qDig - 3, 1));
            dig10 = Integer.parseInt(Mid(strTitulo, qDig - 2, 1));
            dig11 = Integer.parseInt(Mid(strTitulo, qDig - 1, 1));
            dig12 = Integer.parseInt(Mid(strTitulo, qDig, 1));

            //Cálculo para o primeiro dígito validador
            dv1 = (dig1 * 2) + (dig2 * 3) + (dig3 * 4) + (dig4 * 5) + (dig5 * 6)
                    + (dig6 * 7) + (dig7 * 8) + (dig8 * 9);
            dv1 = dv1 % 11;

            if (dv1 == 10) {
                dv1 = 0; //Se o resto for igual a 10, dv1 igual a zero
            }

            //Cálculo para o segundo dígito validador
            dv2 = (dig9 * 7) + (dig10 * 8) + (dv1 * 9);
            dv2 = dv2 % 11;

            if (dv2 == 10) {
                dv2 = 0; //Se o resto for igual a 10, dv1 igual a zero
            }

            //Validação dos dígitos validadores, após o cálculo realizado
            if (dig11 == dv1 && dig12 == dv2) {
                return "Título Válido!";
            } else {
                return "Título Inválido!";
            }

        }
    }

    //Função Mid
    public static String Mid(String texto, int inicio, int tamanho) {
        String strMid = texto.substring(inicio - 1, inicio + (tamanho - 1));
        return strMid;
    }

    public static DefaultFormatterFactory getFormat() {
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }
    }
}
