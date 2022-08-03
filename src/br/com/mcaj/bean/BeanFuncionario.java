/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Marcos
 */
public class BeanFuncionario extends BeanCliente implements Serializable{
    private String ra;
    private double salario;
    private Date dataContratacao;
    private Date dataDemissao;
    private boolean contrato;
    
    
}
