/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.bean;

import java.io.Serializable;

/**
 *
 * @author Marcos
 */
public class BeanLogin implements Serializable{

    private String codigo;
    private String nome, senha;
    private String acesso, dataAcesso;

    public BeanLogin() {
    }

    public BeanLogin(String codigo, String nome, String senha, String acesso, String dataAcesso) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.acesso = acesso;
        this.dataAcesso = dataAcesso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(String dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    @Override
    public String toString() {
        return "BeanLogin{" + "codigo=" + codigo + ", nome=" + nome + ", senha=" + senha + ", acesso=" + acesso + ", dataAcesso=" + dataAcesso + '}';
    }
}
