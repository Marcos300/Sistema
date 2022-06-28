/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
public class MetodosCadClientes {

    public void AbrirWhatsWeb(String linker) {
        try {
            URI link = new URI(linker);
            Desktop.getDesktop().browse(link);
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }
    
    
    public void acessarWhatapp(JTextField txtCel){
            String cel = txtCel.getText();  
            cel = cel.replace("(","");
            cel = cel.replace(")","");
            cel = cel.replace("-","");
            cel = cel.trim();
            
          if (cel.equals("")) {
              JOptionPane.showMessageDialog(null, "Whatsapp Invalido!!! ","Erro no Whatsapp",JOptionPane.ERROR_MESSAGE);
              return;
          }else {
              String whats =  "https://api.whatsapp.com/send?1=pt_BR&phone="+cel;
              System.out.println(whats);
              MetodosCadClientes app = new MetodosCadClientes();
              app.AbrirWhatsWeb(whats);
          }            
    }
    
    
    //não funciona
    public void abrirTel(JTextField txtTel){
            String tel = txtTel.getText();  
            tel = tel.replace("(","");
            tel = tel.replace(")","");
            tel = tel.replace("-","");
            tel = tel.trim();
            
          if (tel.equals("")) {
              JOptionPane.showMessageDialog(null, "Tel Invalido!!! ","Erro no Tel",JOptionPane.ERROR_MESSAGE);
              return;
          }else {
              String abrirTel =  "tel:"+tel;
              System.out.println(abrirTel);
              MetodosCadClientes app = new MetodosCadClientes();
              app.AbrirWhatsWeb(abrirTel);
          }            
    }
}
