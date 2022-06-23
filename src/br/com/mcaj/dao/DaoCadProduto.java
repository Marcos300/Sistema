/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.dao;
//import dos pacotes das classes criadas
import br.com.mcaj.bean.BeanProduto;
import br.com.mcaj.conexao.BD;
//import das classes do java
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class DaoCadProduto {
    	private String men, sql;
        public BeanProduto beanProduto;
        private BD bd;
        private PreparedStatement stmt;

	public  static final int INCLUSAO = 1;
	public  static final int ALTERACAO = 2;
	public  static final int EXCLUSAO = 3;

    public DaoCadProduto() {
        bd = new BD();
        beanProduto = new BeanProduto();
    }

    public void inserir(BeanProduto produto) {

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        String sqlInsere = "INSERT INTO produto VALUES (?, ?, ?);";

        PreparedStatement statement = null;

        try {
            statement = bd.connection.prepareStatement(sqlInsere);
            statement.setString(1, produto.getName().trim().toUpperCase());
            statement.setDouble(2, produto.getPrice());
            statement.setInt(3, produto.getQuantity());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();

        }
    }

    public void atualizar(BeanProduto produto) {

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        String sqlAtualiza = "UPDATE PRODUTO SET PRECO=?, QUANTIDADE=? WHERE NOME=?;";

        PreparedStatement statement = null;

        try {
            statement = bd.connection.prepareStatement(sqlAtualiza);
            statement.setString(3, produto.getName().trim().toUpperCase());
            statement.setDouble(1, produto.getPrice());
            statement.setInt(2, produto.getQuantity());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();

        }
    }

    public void deletar(BeanProduto produto) {

        BD bd = new BD();
        if (!bd.getConnection()) {

            JOptionPane.showMessageDialog(null,
                    "Falha na conexao, o sistema será fechado!");
            System.exit(0);
        }

        String sqlDeleta = "DELETE FROM PRODUTO WHERE NOME =?;";

        PreparedStatement statement = null;

        try {
            statement = bd.connection.prepareStatement(sqlDeleta);
            statement.setString(1, produto.getName().trim().toUpperCase());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            bd.close();

        }
    }
    
    
    public String Atualizar(int operacao) {// inicio atualizar
		men = "Operacao realizada com sucesso!";

		try {
			if (operacao == INCLUSAO) {
				sql = "insert into produto values(?,?,?)";
				stmt = bd.connection.prepareStatement(sql);
				stmt.setString(1, beanProduto.getName());
				stmt.setDouble(2, beanProduto.getPrice());
				stmt.setInt(3, beanProduto.getQuantity());
			
				
			} else if (operacao == ALTERACAO) {
				
				sql = "update produto set preco=?, genero=? , produtora=?, datacompra=? where codigo=?";
				stmt = bd.connection.prepareStatement(sql);				
				stmt.setString(3,beanProduto.getName());
				stmt.setDouble(1, beanProduto.getPrice());
				stmt.setInt(2, beanProduto.getQuantity());
			

			}
			
			else if(operacao== EXCLUSAO){
				sql = "delete from produto where nome=?";
				stmt = bd.connection.prepareStatement(sql);
				stmt.setString(1,beanProduto.getName());
			}

			if(stmt.executeUpdate()==0){
				men = "falha na operacao!";
			}
		} catch (SQLException erro) {
			men = "Falha na Operacao!" + erro.toString();

		}
		return men;
	}// fim atualizar

}
