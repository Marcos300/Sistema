/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.dao;

import br.com.mcaj.bean.BeanCliente;

import br.com.mcaj.conexao.BD;
import br.com.mcaj.metodos.TratamentoData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    
    //caso voce feche a conexao e o result, não retorna mais o proximo codigo, caso o campo de codigo seja usado para pesquisa.
    public int getProximoCodigo() throws SQLException {

        sql = "SELECT (MAX(CODIGO)+1) AS NOVO_CODIGO_CLIENTE FROM CLIENTE";

        int novoCodigo = 0;
        try {
            stmt = bd.connection.prepareStatement(sql);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {

                novoCodigo = resultSet.getInt("NOVO_CODIGO_CLIENTE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return novoCodigo;
    }

    public void inserir(BeanCliente beanCliente) throws SQLException {

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
            TratamentoData trataData = new TratamentoData();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = trataData.getSqlDate(beanCliente.getDataNascimento());
            statement.setDate(6, data);
            statement.setString(7, beanCliente.getEmail().trim().toLowerCase().replace(";", "").replace(";", ""));
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
            statement.close();

        }
    }

    //Atualizar os dados no bd
    public void atualizar(BeanCliente beanCliente) throws SQLException {

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        String sqlAtualiza = "UPDATE CLIENTE SET IMGCLIENTE=?, NOME=?, DOCUMENTO=?,TIPODOCUMENTO=?,DATANASC=?, EMAIL=?, TEL=?, CEL=?, NOMERECADO=?, TELRECADO=?, CELRECADO=?,"
                + "CEP=?,ENDERECO=?, BAIRRO=?, CIDADE=?, UF=?, NUMRESIDENCIA=?, COMPLEMENTO=?, REFERENCIA=?, FOTOFAXADACLIENTE=? WHERE CODIGO=?;";

        PreparedStatement statement = null;

        try {
            statement = bd.connection.prepareStatement(sqlAtualiza);

            statement.setInt(21, beanCliente.getCodigo());
            statement.setBytes(1, beanCliente.getImgCliente());
            statement.setString(2, beanCliente.getNome().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(3, beanCliente.getDocumento().trim().toUpperCase().replace(";", "").replace(";", ""));
            statement.setString(4, beanCliente.getTipoDocumento().trim().toUpperCase().replace(";", "").replace(";", ""));

            TratamentoData trataData = new TratamentoData();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = trataData.getSqlDate(beanCliente.getDataNascimento());
            statement.setDate(5, data);

            statement.setString(6, beanCliente.getEmail().trim().toLowerCase().replace(";", "").replace(";", ""));
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
            System.out.println(statement);
        } finally {
            bd.close();
            statement.close();

        }
    }

    public void deletar(BeanCliente beanCliente) throws SQLException {

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
            statement.close();

        }
    }

    public static ArrayList<BeanCliente> buscarTodos() throws SQLException {
        String PESQUISA_BUSCA_POR_TODOS = "SELECT * FROM CLIENTE ORDER BY CODIGO";
        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }
        PreparedStatement statement = null;
        ResultSet result = null;
        ArrayList<BeanCliente> listaTodos = new ArrayList<>();
        try {

            statement = bd.connection.prepareStatement(PESQUISA_BUSCA_POR_TODOS);
            result = statement.executeQuery();
            while (result.next()) {
                BeanCliente cliente = new BeanCliente();
                cliente.setCodigo(result.getInt("CODIGO"));
                cliente.setImgCliente(result.getBytes("IMGCLIENTE"));
                cliente.setNome(result.getString("NOME"));
                cliente.setDocumento(result.getString("DOCUMENTO"));

                listaTodos.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
            statement.close();
            result.close();
        }
        return listaTodos;
    }


   //busca por um unico cliente
    public BeanCliente buscarPorCodigo(int codigo) throws SQLException {

        String PESQUISA_BUSCA_POR_CODIGO = "SELECT * FROM CLIENTE WHERE CODIGO=?";
        BeanCliente cliente = new BeanCliente();

        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }
        PreparedStatement statement = null;
        ResultSet result = null;
        BeanCliente listaTodos = new BeanCliente();

        try {

            statement = bd.connection.prepareStatement(PESQUISA_BUSCA_POR_CODIGO);
            statement.setInt(1, codigo);
            result = statement.executeQuery();
            while (result.next()) {

                cliente.setCodigo(result.getInt("CODIGO"));
                cliente.setImgCliente(result.getBytes("IMGCLIENTE"));
                cliente.setNome(result.getString("NOME"));
                cliente.setDocumento(result.getString("DOCUMENTO"));
                cliente.setTipoDocumento(result.getString("TIPODOCUMENTO"));
                cliente.setDataNascimento(result.getDate("DATANASC"));
                cliente.setEmail(result.getString("EMAIL"));
                cliente.setTel(result.getString("TEL"));
                cliente.setCel(result.getString("CEL"));
                cliente.setNomeRecado(result.getString("NOMERECADO"));
                cliente.setTelRecado(result.getString("TELRECADO"));
                cliente.setCelRecado(result.getString("CELRECADO"));
                cliente.setCep(result.getString("CEP"));
                cliente.setEndereco(result.getString("ENDERECO"));
                cliente.setBairro(result.getString("BAIRRO"));
                cliente.setCidade(result.getString("CIDADE"));
                cliente.setUf(result.getString("UF"));
                cliente.setNumResidencia(result.getString("NUMRESIDENCIA"));
                cliente.setComplemento(result.getString("COMPLEMENTO"));
                cliente.setReferencia(result.getString("REFERENCIA"));
                cliente.setFotoFaxadaCliente(result.getBytes("FOTOFAXADACLIENTE"));
                System.out.println("Buscar: " + cliente);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
            result.close();
            statement.close();
        }
        return cliente;

    }
    
        public ArrayList<BeanCliente> buscarPorNome(String nome) throws SQLException {

        String PESQUISA_BUSCA_POR_NOME = "SELECT * FROM CLIENTES ORDER BY CODIGO";

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }
        PreparedStatement statement = null;
        ResultSet result = null;
        ArrayList<BeanCliente> listaTodos = new ArrayList<BeanCliente>();
        nome = "%" + nome + "%";
        try {

            statement = bd.connection.prepareStatement(PESQUISA_BUSCA_POR_NOME);
            statement.setString(1, nome);
            result = statement.executeQuery();
            while (result.next()) {

                BeanCliente cliente = new BeanCliente();
                cliente.setCodigo(result.getInt("CODIGO"));
                cliente.setImgCliente(result.getBytes("IMGCLIENTE"));
                cliente.setNome(result.getString("NOME"));
                cliente.setDocumento(result.getString("DOCUMENTO"));
                cliente.setTipoDocumento(result.getString("TIPODOCUMENTO"));
                cliente.setDataNascimento(result.getDate("DATANASC"));
                cliente.setEmail(result.getString("EMAIL"));
                cliente.setTel(result.getString("TEL"));
                cliente.setCel(result.getString("CEL"));
                cliente.setNomeRecado(result.getString("NOMERECADO"));
                cliente.setTelRecado(result.getString("TELRECADO"));
                cliente.setCelRecado(result.getString("CELRECADO"));
                cliente.setCep(result.getString("CEP"));
                cliente.setEndereco(result.getString("ENDERECO"));
                cliente.setBairro(result.getString("BAIRRO"));
                cliente.setCidade(result.getString("CIDADE"));
                cliente.setUf(result.getString("UF"));
                cliente.setNumResidencia(result.getString("NUMRESIDENCIA"));
                cliente.setComplemento(result.getString("COMPLEMENTO"));
                cliente.setReferencia(result.getString("REFERENCIA"));
                cliente.setFotoFaxadaCliente(result.getBytes("FOTOFAXADACLIENTE"));

                listaTodos.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
            result.close();
            statement.close();
        }
        return listaTodos;
    }

}
