/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import java.awt.event.KeyEvent;

/**
 *
 * @author Marcos
 */
public class BloqueiaLetrasEnumeros {

    public void bloqueiaLetras(KeyEvent evt) {
//para evitar que digitem letras
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')) {
            evt.consume();
        }

    }

    public void bloqueiaNumeros(KeyEvent evt) {
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (((caracter < 'A') || (caracter > 'Z')) && ((caracter < 'a') || (caracter > 'z')) && (caracter != 32)) {
            evt.consume();
        }

    }

    //bloqueia caracteres especiais
    public void bloqueiaCE(KeyEvent evt) {
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
            if (((caracter < 'A') || (caracter > 'Z')) && ((caracter < 'a') || (caracter > 'z')) && (caracter != 32)) {
                 if ((caracter < '0') || (caracter > '9')) {
            evt.consume();
                 }
            }
        }

}