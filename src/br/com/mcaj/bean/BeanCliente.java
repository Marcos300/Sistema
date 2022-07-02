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
public class BeanCliente implements Serializable{
    
    private int codigo;
    private byte[] imgCliente;
    private String nome;
    private String documento;
    private String tipoDocumento;
    private Date dataNascimento;
    private String email;
    private String tel;
    private String cel;
    private String nomeRecado;
    private String telRecado;
    private String celRecado;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String numResidencia;
    private String complemento;
    private String referencia;
    private byte[] fotoFaxadaCliente;

    public BeanCliente() {
    }

    public BeanCliente(int codigo, byte[] imgCliente, String nome, String documento, String tipoDocumento, Date dataNascimento, String email, String tel, String cel, String nomeRecado, String telRecado, String celRecado, String cep, String endereco, String bairro, String cidade, String uf, String numResidencia, String complemento, String referencia, byte[] fotoFaxadaCliente) {
        this.codigo = codigo;
        this.imgCliente = imgCliente;
        this.nome = nome;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.tel = tel;
        this.cel = cel;
        this.nomeRecado = nomeRecado;
        this.telRecado = telRecado;
        this.celRecado = celRecado;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.numResidencia = numResidencia;
        this.complemento = complemento;
        this.referencia = referencia;
        this.fotoFaxadaCliente = fotoFaxadaCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public byte[] getImgCliente() {
        return imgCliente;
    }

    public void setImgCliente(byte[] imgCliente) {
        this.imgCliente = imgCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date date) {
        this.dataNascimento = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getNomeRecado() {
        return nomeRecado;
    }

    public void setNomeRecado(String nomeRecado) {
        this.nomeRecado = nomeRecado;
    }

    public String getTelRecado() {
        return telRecado;
    }

    public void setTelRecado(String telRecado) {
        this.telRecado = telRecado;
    }

    public String getCelRecado() {
        return celRecado;
    }

    public void setCelRecado(String celRecado) {
        this.celRecado = celRecado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumResidencia() {
        return numResidencia;
    }

    public void setNumResidencia(String numResidencia) {
        this.numResidencia = numResidencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public byte[] getFotoFaxadaCliente() {
        return fotoFaxadaCliente;
    }

    public void setFotoFaxadaCliente(byte[] fotoFaxadaCliente) {
        this.fotoFaxadaCliente = fotoFaxadaCliente;
    }

    @Override
    public String toString() {
        return "BeanCliente{" + "codigo=" + codigo + ", imgCliente=" + imgCliente + ", nome=" + nome + ", documento=" + documento + ", tipoDocumento=" + tipoDocumento + ", dataNascimento=" + dataNascimento + ", email=" + email + ", tel=" + tel + ", cel=" + cel + ", nomeRecado=" + nomeRecado + ", telRecado=" + telRecado + ", celRecado=" + celRecado + ", cep=" + cep + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", numResidencia=" + numResidencia + ", complemento=" + complemento + ", referencia=" + referencia + ", fotoFaxadaCliente=" + fotoFaxadaCliente + '}';
    }

    
   
    
}
