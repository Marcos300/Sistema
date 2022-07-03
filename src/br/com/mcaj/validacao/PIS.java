/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
//https://zlivro.com.br/text/9r90vv8j9pr6/guia-de-validaao-de-dados-em-java/41
 */
package br.com.mcaj.validacao;

/**
 *
 * @author Marcos
 */
import java.util.regex.*;

import java.io.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class PIS {

    private static String Formato = "###########";
    private  String  pis;

    public PIS(String pis) {
        this.pis = pis;
    }


    static public boolean ValidarPIS(String pis) {

        int total = 0;

        int[] peso = new int[]{3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        String parteNumerica = pis.replaceAll("\\.", "").replaceAll("\\-", "");

        while (parteNumerica.length() < 11) {
            parteNumerica = "0" + parteNumerica;
        }

        if (Long.valueOf(parteNumerica).longValue() == 0) {
            return false;
        }

        for (int i = 1; i <= 10; i++) {

            total += Integer.valueOf(parteNumerica.substring(i - 1, i)).intValue() * peso[i - 1];

        }

        int resto = Integer.valueOf(total % 11).intValue();

        if (resto != 0) {

            resto = 11 - resto;

        }

        if (resto != Integer.valueOf(parteNumerica.substring(10, 11)).intValue()) {

            return false;

        } else {

            return true;

        }

    }

    public static void main(String[] args) {

        String padrao = "^\\d{3}\\.?\\d{5}\\.?\\d{2}-?\\d$";

        Pattern regex = Pattern.compile(padrao);

        String resposta = "";

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (!(resposta.equals("FIM"))) {

                System.out.print("PIS: ");

                resposta = reader.readLine().trim();

                if (resposta.toUpperCase().equals("FIM")) {
                    break;
                }

                Matcher resultado = regex.matcher(resposta);

                if (resultado.matches() && ValidarPIS(resposta)) {

                    System.out.println("O valor " + resposta + " é válido!");

                } else {

                    System.out.println("O valor " + resposta + " não é válido!");

                }

                System.out.println();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static DefaultFormatterFactory getFormat() {
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }
    }

}//fim da classe
