/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Marcos
 */
public class LimitaTextArea extends DocumentFilter {
    //esta classe que faz a limitação de caracteres

    int maxCharacters;
    boolean DEBUG = false;

    public LimitaTextArea(int maxChars) {
        maxCharacters = maxChars;
    }

    public void insertString(DocumentFilter.FilterBypass fb, int offs,
            String str, AttributeSet a)
            throws BadLocationException {
        if (DEBUG) {
            System.out.println("in DocumentSizeFilter's insertString method");
        }

        //Isto rejeita novas inserções de caracteres se
        //a string for muito grande. Outra opção seria
        //truncar a string inserida, de forma que seja
        //adicionado somente o necessário para atingir
        //o limite máximo permitido
        if ((fb.getDocument().getLength() + str.length()) <= maxCharacters) {
            super.insertString(fb, offs, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void replace(DocumentFilter.FilterBypass fb, int offs,
            int length,
            String str, AttributeSet a)
            throws BadLocationException {
        if (DEBUG) {
            System.out.println("in DocumentSizeFilter's replace method");
        }
        //Isto rejeita novas inserções de caracteres se
        //a string for muito grande. Outra opção seria
        //truncar a string inserida, de forma que seja
        //adicionado somente o necessário para atingir
        //o limite máximo permitido
        if ((fb.getDocument().getLength() + str.length() - length) <= maxCharacters) {
            super.replace(fb, offs, length, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

}
