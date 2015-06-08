package unipe.mpf.ui;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JTable;
import javax.swing.SwingWorker;

import unipe.mpf.contas.Conta;

public class CarregadorContaWorker extends SwingWorker<List<Conta>, Void> {

	private final JTable tabela;
	
	public CarregadorContaWorker(JTable tabela) {
		this.tabela = tabela;
	}

	@Override
	protected List<Conta> doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void done() {
	    ContaTableModel model;
		try {
			model = new ContaTableModel(get());
			tabela.setModel(model);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  }

}
