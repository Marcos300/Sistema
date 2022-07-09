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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class PIS {

    //999.99999.99-9
    private static String Formato = "###.#####.##-#";
    private String pis;
    private boolean mascara;

    public PIS(String pis, boolean mask) {
        this.mascara = mask;
        this.pis = this.Format(pis, false);
    }

    public boolean validarPIS(String pis) {

        int total = 0;
        int[] peso = new int[]{3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        String parteNumerica = pis.replaceAll("\\.", "").replaceAll("\\-", "");

        if (parteNumerica.equals("00000000000")
                || parteNumerica.equals("11111111111")
                || parteNumerica.equals("22222222222")
                || parteNumerica.equals("33333333333")
                || parteNumerica.equals("44444444444")
                || parteNumerica.equals("55555555555")
                || parteNumerica.equals("66666666666")
                || parteNumerica.equals("77777777777")
                || parteNumerica.equals("88888888888")
                || parteNumerica.equals("99999999999")
                || parteNumerica.length() != 11) {
            return (false);
        }

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

    //999.99999.99-9
    private String Format(String pis, boolean Mascara) {
        if (Mascara) {
            return (pis.substring(0, 2) + "." + pis.substring(4, 8) + "."
                    + pis.substring(9, 10) + "-" + pis.substring(11));
        } else {
            pis = pis.replace(".", "");
            pis = pis.replace("-", "");
            return pis;
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
