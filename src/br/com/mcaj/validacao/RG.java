/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.validacao;

import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Marcos
 */
public class RG {

    private String rg;
    private boolean mascara;
    private static final String Formato = "##.###.###-#";
    private static final String RG_PATTERN = "\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d-\\d";

    public RG(String rg, boolean mask) {
        this.mascara = mask;
        this.rg = this.Format(rg, false);
    }

    public boolean isRG(String rg) {

        if (this.rg.equals("000000000")
                || this.rg.equals("111111111")
                || this.rg.equals("222222222")
                || this.rg.equals("333333333")
                || this.rg.equals("444444444")
                || this.rg.equals("555555555")
                || this.rg.equals("666666666")
                || this.rg.equals("777777777")
                || this.rg.equals("888888888")
                || this.rg.equals("999999999")
                || this.rg.length() != 9) {
            return false;

        } else {

            return true;
        }

    }

    //Formato = "##.###.###-#";
    private String Format(String rg, boolean Mascara) {
        if (Mascara) {
            return (rg.substring(0, 1) + "." + rg.substring(2, 5) + "."
                    + rg.substring(6, 9) + "-" + rg.substring(10, 11));
        } else {
            rg = rg.replace(".", "");
            rg = rg.replace("-", "");
            return rg;
        }
    }

    public static DefaultFormatterFactory getFormat() {
        try {
            return new DefaultFormatterFactory(new MaskFormatter(Formato));
        } catch (Exception e) {
            return null;
        }
    }

    public void verificarRG(String rg) {
        String mensagem = null;
        int d1;
        int d2;
        int d3;
        int d4;
        int d5;
        int d6;
        int d7;
        int d8;
        int UltDig;
        int DV;
        int d9;

        rg = rg.replace(".", "");
        rg = rg.replace("-", "");
        rg = rg.replace("_", "");
        rg = rg.replace("/", "");
        rg = rg.replace("+", "");
        rg = rg.replace("`", "");
        rg = rg.replace(" ", "");

        //Pega a posição do último dígito 
        UltDig = rg.length();
        d1 = Integer.parseInt(rg.substring(UltDig - 8, 1));
        d2 = Integer.parseInt(rg.substring(UltDig - 7, 1));
        d3 = Integer.parseInt(rg.substring(UltDig - 6, 1));
        d4 = Integer.parseInt(rg.substring(UltDig - 5, 1));
        d5 = Integer.parseInt(rg.substring(UltDig - 4, 1));
        d6 = Integer.parseInt(rg.substring(UltDig - 3, 1));
        d7 = Integer.parseInt(rg.substring(UltDig - 2, 1));
        d8 = Integer.parseInt(rg.substring(UltDig - 1, 1));

//        if (rg.substring(UltDig, 1) == "") {
//            d9 = 10;
//        } else {
        d9 = Integer.parseInt(rg.substring(UltDig, 1));
        //}

        DV = (d1 * 2) + (d2 * 3) + (d3 * 4) + (d4 * 5) + (d5 * 6) + (d6 * 7) + (d7 * 8) + (d8 * 9);
        DV = DV % 11;
        DV = 11 - DV;

        if (d9 == DV) {
            mensagem = "RG Válido";
        } else if (DV == 11 & d9 == 0) {
            mensagem = "RG Válido";
        } else {
            mensagem = "RG Inválido";
        }

        JOptionPane.showMessageDialog(null, mensagem, "Teste", JOptionPane.INFORMATION_MESSAGE);
    }
    
//https://www.devmedia.com.br/forum/verificar-se-rg-e-valido-ajuda/569055
    
    public boolean checkRG(String rg) {
        // rg = "ab.cde.fgh-i"
        // testar formato (opcional)
        if (!rg.matches(RG_PATTERN)) {
            System.err.println(rg + " formato");
            return false;
        }

        if (this.rg.equals("000000000")
                || this.rg.equals("111111111")
                || this.rg.equals("222222222")
                || this.rg.equals("333333333")
                || this.rg.equals("444444444")
                || this.rg.equals("555555555")
                || this.rg.equals("666666666")
                || this.rg.equals("777777777")
                || this.rg.equals("888888888")
                || this.rg.equals("999999999")
                || this.rg.length() != 9) {
            return false;

        }

        int a = rg.charAt(0) - '0';
        int b = rg.charAt(1) - '0';
        //  . = rg.charAt(2)
        int c = rg.charAt(3) - '0';
        int d = rg.charAt(4) - '0';
        int e = rg.charAt(5) - '0';
        //  . = rg.charAt(6)
        int f = rg.charAt(7) - '0';
        int g = rg.charAt(8) - '0';
        int h = rg.charAt(9) - '0';
        //  - = rg.charAt(10)
        int i = rg.charAt(11) - '0';

        int result = 2 * a + 3 * b + 4 * c + 5 * d + 6 * e + 7 * f + 8 * g + 9 * h + 100 * i;
        return (result % 11) == 0;
    }

}
