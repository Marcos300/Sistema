/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * https://www.youtube.com/watch?v=I54DuySunz8
 *
 * @author Marcos
 */
public class LimitaCaracteres extends PlainDocument {

    public enum TipoEntrada {
        NUMEROINTEIRO, NUMERODECIMAL, NOME, EMAIL, DATA, REFERENCIA, COMPLEMENTO;
    };

    private int qtdeCaracteres;
    private TipoEntrada tpEntrada;

    public LimitaCaracteres(int qtdeCaracteres, TipoEntrada tpEntrada) {
        this.qtdeCaracteres = qtdeCaracteres;
        this.tpEntrada = tpEntrada;
    }

    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
        if (string == null || getLength() == qtdeCaracteres) {
            return;
        }
        int totalCarac = getLength() + string.length();
        String regex = "";
        switch (tpEntrada) {
            case NUMEROINTEIRO:
                regex = "[^0-9]";
                break;
            case NUMERODECIMAL:
                regex = "[^0-9,.]";
                break;
            case NOME:
                regex = "[^\\p{IsLatin} ]";
                break;
            case EMAIL:
                regex = "[^\\p{IsLatin}@.\\-_] [^0-9].";
                break;
            case DATA:
                regex = "[^0-9/]";
                break;
            case REFERENCIA:
                regex = "[^\\p{IsLatin} @.\\-_] [^0-9].";
                break;
            case COMPLEMENTO:
                regex = "[^\\p{IsLatin} @.\\-_] [^0-9].";
                break;
        }

        string = string.replaceAll(regex, "");

        if (totalCarac <= qtdeCaracteres) {
            super.insertString(i, string, as);
        } else {
            String nova = string.substring(0, qtdeCaracteres);
            super.insertString(i, nova, as);
        }
    }
}//FIM DA CLASSE
