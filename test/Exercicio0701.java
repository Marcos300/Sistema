/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * https://www.clubedohardware.com.br/forums/topic/1168600-exercicio-java-validar-um-nome-completo/
 * @author Marcos
 */

//
import javax.swing.JOptionPane;
public class Exercicio0701
{
 public static void main(String[] args)
 {
    String st = "Informe seu nome:";
    st = JOptionPane.showInputDialog(null,st);
    
    if (st.length() < 5 || st.length() > 50)
    {
        st = "Nome invalido";
        JOptionPane.showMessageDialog(null,st,"Erro",0);
        System.exit(0);
    }
    
    
    if(st.indexOf(" ") == -1)
    {
        st = "O nome deve conter o seu nome e sobrenome";
        JOptionPane.showMessageDialog(null,st,"Erro",0);
        System.exit(0);
    }
    
    
    
    if(st.substring(0,st.indexOf(" ")).length() < 2 || st.substring(st.lastIndexOf(" ") + 1).length() < 2)
    {
        st = "O nome e o sobrenome deve contrer pelo menos 2 caracteres";
        JOptionPane.showMessageDialog(null,st,"Erro",0);
        System.exit(0);
    }
    
    st = "Nome valido: " + st;
    JOptionPane.showMessageDialog(null,st,"mensagem",1);
    System.exit(0);
 }
}
