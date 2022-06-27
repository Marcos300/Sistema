/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.validacao;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Marcos
 */
public class Email {
    //https://receitasdecodigo.com.br/java/validar-email-em-java
    
    public  boolean isValidEmailAddress(String email) {
    boolean result = true;
    try {
        InternetAddress emailAddr = new InternetAddress(email);
        emailAddr.validate();
    } catch (AddressException ex) {
        result = false;
    }
    return result;
}
    
}
