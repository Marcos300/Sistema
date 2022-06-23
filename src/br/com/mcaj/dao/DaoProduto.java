/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.dao;

/**
 *
 * @author Marcos
 */
import br.com.mcaj.bean.BeanProduto;
import br.com.mcaj.conexao.BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoProduto {

    private PreparedStatement statement;
    private Connection connection = null;
    private String sql = null;
    private BD bd = null;
    private ResultSet resultSet;
    private final String BUSCAR_POR_TODOS = "SELECT * FROM PRODUTO";
    //bean se tornou publico
    public BeanProduto beanProduto;
    private ArrayList<BeanProduto> listaTodos;
   

    public static final byte INCLUSAO = 1;
    public static final byte ALTERACAO = 2;
    public static final byte EXCLUSAO = 3;

    private String jdbcURL = "jdbc:mysql://192.168.0.4:3306/banco";
    private String username = "TesteDB";
    private String password = "123456";

    public DaoProduto() {
        bd = new BD();
        beanProduto = new BeanProduto();
    }
    /*DAO PARA INSERIR EM MASSA OS REGISTROS NO SISTEMA*/

    public void deleteBatch(ArrayList<BeanProduto> listaDeProdutos) {

        connection = null;

        try {
            connection = (Connection) DriverManager.getConnection(jdbcURL,
                    username, password);
            connection.setAutoCommit(false);

            sql = "DELETE FROM PRODUTO WHERE NOME =?;";

            PreparedStatement statement = connection.prepareStatement(sql);

            for (BeanProduto produto : listaDeProdutos) {

                statement.setString(1, produto.getName().trim());

                statement.addBatch();
                System.out.println(statement);
            }

            statement.executeBatch();
            connection.commit();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(statement);

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateBatch(ArrayList<BeanProduto> listaDeProdutos) {

        connection = null;

        try {
            connection = (Connection) DriverManager.getConnection(jdbcURL,
                    username, password);
            connection.setAutoCommit(false);

            sql = "UPDATE PRODUTO SET PRECO=?, QUANTIDADE=? WHERE NOME=?;";

            statement = connection.prepareStatement(sql);

            for (BeanProduto produto : listaDeProdutos) {

                statement.setDouble(1, produto.getPrice());
                statement.setInt(2, produto.getQuantity());
                statement.setString(3, produto.getName().trim().toUpperCase());

                statement.addBatch();
                System.out.println(statement);
            }

            statement.executeBatch();
            connection.commit();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(statement);

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void AtualizarPorNome(List<BeanProduto> listaDeProdutos) {

        java.sql.Connection connection = null;
        String sql = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, username,
                    password);
            connection.setAutoCommit(false);

            sql = "UPDATE PRODUTO SET PRECO=?, QUANTIDADE=? WHERE NOME=?;";

            statement = connection.prepareStatement(sql);

            for (BeanProduto p : listaDeProdutos) {

                statement.setString(3, p.getName().trim().toUpperCase());
                statement.setDouble(1, p.getPrice());
                statement.setInt(2, p.getQuantity());
                statement.addBatch();

            }

            System.out.println(sql);

            statement.executeBatch();
            connection.commit();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(sql);
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(sql);
            }
        }

    }

    public void insertBatch(List<BeanProduto> listaDeProdutos) throws SQLException {

        java.sql.Connection connection = null;

        String sql = null;

        try {
            connection = DriverManager.getConnection(jdbcURL, username,
                    password);
            connection.setAutoCommit(false);

            sql = "INSERT INTO produto VALUES (?, ?, ?)";

            statement = connection.prepareStatement(sql);

            for (BeanProduto p : listaDeProdutos) {
                statement.setString(1, p.getName().trim().toUpperCase());
                statement.setDouble(2, p.getPrice());
                statement.setInt(3, p.getQuantity());

                System.out.println(statement);

                statement.addBatch();
            }

            System.out.println(sql);
            statement.executeBatch();
            connection.commit();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public  ArrayList<BeanProduto> buscarTodos() throws SQLException {
     
        bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        listaTodos = new ArrayList<BeanProduto>();
     
        try {

            statement = bd.connection.prepareStatement(BUSCAR_POR_TODOS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BeanProduto produto = new BeanProduto();
                produto.setName(resultSet.getString("NOME"));
                produto.setPrice(resultSet.getDouble("PRECO"));
                produto.setQuantity(resultSet.getInt("QUANTIDADE"));

                listaTodos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();
            resultSet.close();
            statement.close();
        }
        return listaTodos;
    }

}//fim da classe
