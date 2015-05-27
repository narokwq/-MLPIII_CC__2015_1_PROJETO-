package unipe.mpf.ui;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import unipe.mpf.contas.Conta;



public class ContaTableModel extends AbstractTableModel{

    private static final int COL_NUMERO = 0;
    private static final int COL_SALDO = 1;

    
    private List<Conta> valores;
    
	public ContaTableModel(List<Conta> contas) {
		valores = contas;
	}
	public ContaTableModel() {

	}

	public String getColumnName(int column) {  
        		   
	    if (column == COL_NUMERO) return "Numero";
	    if (column == COL_SALDO) return "Saldo";	   
	    
	    return "";   
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return valores.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Conta mod = valores.get(row);  
        if (column == COL_NUMERO) return mod.getConta();
        else if (column == COL_SALDO) return String.format("%.2f", mod.getSaldo());
        

        
        return "";  
	}

}
