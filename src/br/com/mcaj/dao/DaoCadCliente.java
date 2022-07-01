/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.dao;

import br.com.mcaj.bean.BeanCliente;

import br.com.mcaj.conexao.BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class DaoCadCliente {

    private String men, sql;
    public BeanCliente beanCliente;
    public BD bd;
    private PreparedStatement stmt;
    private ResultSet resultSet;

    public DaoCadCliente() {
        bd = new BD();
        beanCliente = new BeanCliente();
    }

    public int getProximoCodigo() {

        sql = "SELECT (MAX(CODIGO)+1) AS NOVO_CODIGO_CLIENTE FROM CLIENTE";

        int novoCodigo = 0;
        try {
            stmt = bd.connection.prepareStatement(sql);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {

                novoCodigo = resultSet.getInt("NOVO_CODIGO_CLIENTE");
            }
        } catch (SQLException e) {

        }
        return novoCodigo;
    }

    public void inserir(BeanCliente beanCliente) {

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        String sqlInsere = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement statement = null;

        try {
            statement = bd.connection.prepareStatement(sqlInsere);

            statement.setInt(1, beanCliente.getCodigo());
            statement.setBytes(2, beanCliente.getImgCliente());
            statement.setString(3, beanCliente.getNome().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(4, beanCliente.getDocumento().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(5, beanCliente.getTipoDocumento().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setDate(6, (java.sql.Date) beanCliente.getDataNascimento());
            statement.setString(7, beanCliente.getEmail().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(8, beanCliente.getTel().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(9, beanCliente.getCel().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(10, beanCliente.getNomeRecado().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(11, beanCliente.getTelRecado().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(12, beanCliente.getCelRecado().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(13, beanCliente.getCep().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(14, beanCliente.getEndereco().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(15, beanCliente.getBairro().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(16, beanCliente.getCidade().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(17, beanCliente.getUf().trim().toUpperCase());
            statement.setString(18, beanCliente.getNumResidencia().trim().toUpperCase());
            statement.setString(19, beanCliente.getComplemento().trim().toUpperCase());
            statement.setString(20, beanCliente.getReferencia().trim().toUpperCase());
            statement.setBytes(21, beanCliente.getFotoFaxadaCliente());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();

        }
    }

    public void atualizar(BeanCliente beanCliente) {

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        String sqlAtualiza = "UPDATE PRODUTO SET IMGCLIENTE=?, NOME=? DOCUMENTO=?,TIPODOCUMENTO=?,DATANASC=?, EMAIL=?, TEL=?, CEL=?, NOMERECADO=?, TELRECADO=?, CELRECADO=?,"
                + "CEP=?,ENDERECO=?, BAIRRO=?, CIDADE=?, UF=?, NUMRESIDENCIA=?, COMPLEMENTO=?, REFERENCIA=?, FOTOFAXADACLIENTE=? WHERE CODIGO=?;";

        PreparedStatement statement = null;

        try {
            statement = bd.connection.prepareStatement(sqlAtualiza);

            statement.setInt(21, beanCliente.getCodigo());
            statement.setBytes(1, beanCliente.getImgCliente());
            statement.setString(2, beanCliente.getNome().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(3, beanCliente.getDocumento().trim().toUpperCase().replace(";", "").replace(";", ""));
             statement.setString(4, beanCliente.getTipoDocumento().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setDate(5, (java.sql.Date) beanCliente.getDataNascimento());
            statement.setString(6, beanCliente.getEmail().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(7, beanCliente.getTel().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(8, beanCliente.getCel().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(9, beanCliente.getNomeRecado().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(10, beanCliente.getTelRecado().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(11, beanCliente.getCelRecado().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(12, beanCliente.getCep().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(13, beanCliente.getEndereco().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(14, beanCliente.getBairro().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(15, beanCliente.getCidade().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(16, beanCliente.getUf().trim().toUpperCase());
            statement.setString(17, beanCliente.getNumResidencia().trim().toUpperCase());
            statement.setString(18, beanCliente.getComplemento().trim().toUpperCase());
            statement.setString(19, beanCliente.getReferencia().trim().toUpperCase());
            statement.setBytes(20, beanCliente.getFotoFaxadaCliente());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();

        }
    }

    public void deletar(BeanCliente beanCliente) {

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        String sqlDeleta = "DELETE FROM CLIENTE WHERE CODIGO =?;";

        PreparedStatement statement = null;

        try {
            statement = bd.connection.prepareStatement(sqlDeleta);

            statement.setInt(1, beanCliente.getCodigo());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();

        }
    }

}
