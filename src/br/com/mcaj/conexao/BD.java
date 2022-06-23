/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mcaj.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
	public Connection connection = null;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DBNAME = "BANCO";
	private final String URL = "jdbc:mysql://192.168.0.4:3306/" + DBNAME;
	private final String LOGIN = "TesteDB";
	private final String SENHA = "123456";
	
	

	
	
	public boolean getConnection() {
		

		try {

			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, LOGIN, SENHA);
		
			System.out.println("Conectou");
			return true;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver não encontrado " + erro.toString());
			return false;
		} catch (SQLException erro) {
			// TODO Auto-generated catch block
			System.out.println("Falha ao Conectar " + erro.toString());
			
			return false;
		}

	}

	public void close() {
		try {
			connection.close();
			System.out.println("Fechou Conexao");
		} catch (SQLException erro) {
		}

	}

}
