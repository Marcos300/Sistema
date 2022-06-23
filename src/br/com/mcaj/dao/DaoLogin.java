/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mcaj.dao;

import br.com.mcaj.bean.BeanLogin;
import br.com.mcaj.conexao.BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class DaoLogin {
	
	public BeanLogin beanLogin;
	public BD bd;
	private PreparedStatement statement;
	private ResultSet resultSet;
	private String men, sql;

	public static final byte INCLUSAO = 1;
	public static final byte ALTERACAO = 2;
	public static final byte EXCLUSAO = 3;
	
	public DaoLogin (){
		bd = new BD();
		beanLogin = new BeanLogin();
	}

	public boolean checkLogin(String nome, String senha) {
		boolean check = false;
		if (bd.getConnection()) {
			try {
				sql = "SELECT NOME,SENHA FROM login WHERE NOME=? AND SENHA=?";
				PreparedStatement statement = bd.connection
						.prepareStatement(sql);
				statement.setString(1, nome);
				statement.setString(2, senha);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {

					String nomeUsuario = resultSet.getString("nome");
					String senhaUsuario = resultSet.getString("senha");
					System.out.println("Usuario: " + nomeUsuario + " "
							+ "Senha: " + senhaUsuario);
					check = true;
				}
				resultSet.close();
				statement.close();
				bd.close();

			} catch (SQLException erro) {
				System.out.println(erro.toString());

			}

		} else
			System.out.println("Erro ao Conectar");

		return check;
	}

	public int getProximoCodigo() {

		sql = "SELECT (MAX(CODIGO)+1) AS NOVO_CODIGO_LOGIN FROM LOGIN";

		int novoCodigo = 1;
		try {
			statement = bd.connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {

				novoCodigo = resultSet.getInt("NOVO_CODIGO_LOGIN");
			}
		} catch (SQLException e) {

		}
		return novoCodigo;
	}

	
	public boolean Localizar() {// inicio localizar
		sql = "select* from login where codigo =?";

		try {
			statement = bd.connection.prepareStatement(sql);
			statement.setString(1, beanLogin.getCodigo());
			resultSet = statement.executeQuery();
			resultSet.first();
			beanLogin.setCodigo(resultSet.getString(1));
			beanLogin.setNome(resultSet.getString(2));
			beanLogin.setSenha(resultSet.getString(3));
			beanLogin.setAcesso(resultSet.getString(4));
			beanLogin.setDataAcesso("" + resultSet.getString(5));
			return true;

		} catch (SQLException erro) {
			return false;

		}

	}// fim localizar
	
	public String CRUD(int operacao) {// inicio atualizar
		men = "Operacao realizada com sucesso!";

		try {
			if (operacao == INCLUSAO) {
				sql = "insert into login values(?,?,?,?,?)";
				statement = bd.connection.prepareStatement(sql);
				statement.setString(1, beanLogin.getCodigo());
				statement.setString(2, beanLogin.getNome());
				statement.setString(3, beanLogin.getSenha());
				statement.setString(4, beanLogin.getAcesso());
				statement.setString(5, beanLogin.getDataAcesso());


			} else if (operacao == ALTERACAO) {

				sql = "update login set nome=?, senha=?, acesso=?, dataAcesso=? where codigo=?";
				statement = bd.connection.prepareStatement(sql);
				statement.setString(5, beanLogin.getCodigo());
				statement.setString(1, beanLogin.getNome());
				statement.setString(2, beanLogin.getSenha());
				statement.setString(3, beanLogin.getAcesso());
				statement.setString(4, beanLogin.getDataAcesso());

			}

			else if (operacao == EXCLUSAO) {
				sql = "delete from login where codigo=?";
				statement = bd.connection.prepareStatement(sql);
				statement.setString(1, beanLogin.getCodigo());
			}

			if (statement.executeUpdate() == 0) {
				men = "falha na operacao!";
			}
		} catch (SQLException erro) {
			men = "Falha na Operacao!" + erro.toString();

		}
		return men;
	}// fim atualizar
	
	
	public String checkAcesso(String nome, String senha) {
		String acesso = null;
		if (bd.getConnection()) {
			try {
				sql = "select acesso from login where nome=? and senha=?";
				PreparedStatement statement = bd.connection
						.prepareStatement(sql);
				statement.setString(1, nome);
				statement.setString(2, senha);
				resultSet = statement.executeQuery();

				while (resultSet.next()) {
					acesso = resultSet.getString("acesso");				
				}
				resultSet.close();
				statement.close();
				bd.close();

			} catch (SQLException erro) {
				System.out.println(erro.toString());

			}

		} else
			System.out.println("Erro ao Conectar");

		return acesso;
	}
	
}
