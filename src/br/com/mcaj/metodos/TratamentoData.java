/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mcaj.metodos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class TratamentoData {

    public java.util.Date getJavaDate(ResultSet result, String nomeCampo) throws SQLException {
        Date dataFalecimento = result.getDate(nomeCampo);
        java.util.Date javaDate = null;
        if (dataFalecimento != null) {
            javaDate = new Date(dataFalecimento.getTime());
        }
        return javaDate;
    }

    public Date getSqlDate(java.util.Date date) {
        Date sqlDate = null;
        if (date != null) {
            sqlDate = new java.sql.Date(date.getTime());
        }
        return sqlDate;
    }
}
