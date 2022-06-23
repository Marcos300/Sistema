/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mcaj.modelos;

/**
 *
 * @author Marcos
 */
import br.com.mcaj.bean.BeanProduto;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloAtualizarTabela extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList<BeanProduto> linhas = null;
	private String[] colunas = null;

	@SuppressWarnings("rawtypes")
	public ModeloAtualizarTabela(ArrayList linhas, String[] colunas) {
		setLinhas(linhas);
		setColunas(colunas);
	}

    public ModeloAtualizarTabela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@SuppressWarnings("rawtypes")
	public ArrayList getLinhas() {
		return linhas;

	}

	@SuppressWarnings("unchecked")
	public void setLinhas(@SuppressWarnings("rawtypes") ArrayList dados) {
		linhas = dados;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] cabecalho) {
		colunas = cabecalho;
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public int getRowCount() {
		return linhas.size();
	}

	public void LimparTabela() {
		linhas.clear();
		fireTableDataChanged();
	}

	public String getColumnName(int numeroColunas) {
		return colunas[numeroColunas];
	}

	public Object getValueAt(int numeroLinhas, int numeroColunas) {
		Object[] linhas = (Object[]) getLinhas().get(numeroLinhas);
		fireTableCellUpdated(numeroLinhas, numeroColunas);
		return linhas[numeroColunas];

	}

	public void setValueAt(BeanProduto produtos, int numeroLinhas) {
		linhas.set(numeroLinhas, produtos);
		this.fireTableDataChanged();

	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	
	public void addItem(BeanProduto produtos) {
		this.linhas.add(produtos);
		this.fireTableDataChanged();
	}

	public void notifyUpdated(BeanProduto p) {
		int index = linhas.indexOf(p);
		fireTableRowsUpdated(index, index);
	}

	/**
	 * retorna o valor da linha indicada
	 * 
	 * @param rowIndex
	 * @return
	 */

	public BeanProduto getValue(int rowIndex) {
		return linhas.get(rowIndex);
	}

	public int indexOf(BeanProduto produtos) {
		return linhas.indexOf(produtos);
	}

	public void RemoverProduto(BeanProduto produtos) {
		int indexBefore = indexOf(produtos);// pega o indice antes de apagar
		linhas.remove(produtos);
		fireTableRowsDeleted(indexBefore, indexBefore);
	}

	public void adicionarProduto(BeanProduto produtos) {
		linhas.add(produtos);
		fireTableRowsInserted(indexOf(produtos), indexOf(produtos));
	}

}

