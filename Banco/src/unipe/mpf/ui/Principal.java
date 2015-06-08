package unipe.mpf.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



import unipe.mpf.contas.Conta;
import unipe.mpf.contas.ContaBancaria;
import unipe.mpf.contas.ContaCorrente;
import unipe.mpf.dados.RepositorioListContas;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;

public class Principal {
	private JFrame jfrm;
	private JPanel jpanelBusca;
	private JTextField jTNumero;
	private JTable jtableConta;
	private ContaTableModel model;
	private JMenuBar jMenuBar;
	private JMenu jMenuFerramenta;
	private JPopupMenu popupMenu;
	private JMenu jMenuAjuda;

	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.montaTela();
	
		//--------------------Teste Tabela--------------------
		Conta conta = new ContaCorrente("36665", 60.0f);
		conta.setNome("Alex");
		ContaBancaria bancaria = new ContaBancaria(new RepositorioListContas());
		for(int i = 0; i < 10; i++)
			try {
				bancaria.cadastrarConta(conta);
			} catch (ContaJaCadastradaException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		principal.addModel(new ContaTableModel(bancaria.listarConta()));
		//--------------------Fim do Teste--------------------

	}


	private void montaTela() {
		preparaJanela();
		preparaMenuBar();
		preparaMenuFerramentas();
		preparaMenuItemInserir();
		preparaMenuItemModificar();
		preparaMenuAjuda();
		preparaMenuItemSobre();
		preparaPainelBusca();
		preparaLabel("Numero");
		preparaTextFieldBusca();
		preparaBotaoBusca();
		preparaBotaoRemover();
		preparaTable();
		preparaPopMenuTable();
		preparaPopMenuItemEditar();
		preparaPopMenuItemRelatorio();
		mostraJanela();		
	}
	
	private void mostraJanela() {	
		jfrm.setMinimumSize(new Dimension(460, 300));			
		jfrm.pack();
		jfrm.setSize(800, 600);
		jfrm.setLocationRelativeTo(null);
		jfrm.setVisible(true);
		
		
	}
	
	private void preparaJanela() {
		jfrm = new JFrame("Midas");
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void preparaMenuBar() {
		jMenuBar = new JMenuBar();
		jfrm.setJMenuBar(jMenuBar);
		
	}
	
	//--------------------Menu Ferramenta--------------------
	
	private void preparaMenuFerramentas() {
		jMenuFerramenta = new JMenu("Ferramentas");
		jMenuBar.add(jMenuFerramenta);
	}
	
	private void preparaMenuItemInserir() {
		JMenuItem jmenuItemInserir = new JMenuItem("Inserir");
		jMenuFerramenta.add(jmenuItemInserir);
		jmenuItemInserir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastrar(jfrm).MostarTela();
				
			}
		});
	}
	
	private void preparaMenuItemModificar() {
		JMenuItem jmenuItemModificar = new JMenuItem("Modificar");
		jMenuFerramenta.add(jmenuItemModificar);
		jmenuItemModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaModificar(jfrm).mostarTela();
				
			}
		});
	}
	
	//--------------------Menu Ajuda--------------------
	
	private void preparaMenuAjuda() {
		jMenuAjuda = new JMenu("Ajuda");
		jMenuBar.add(jMenuAjuda);
	}
	
	private void preparaMenuItemSobre() {
		JMenuItem jmenuItemSobre = new JMenuItem("Sobre");
		jMenuAjuda.add(jmenuItemSobre);
	}
	
	//--------------------Painel Busca--------------------
	
	private void preparaPainelBusca() {
		jpanelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
		jfrm.add(jpanelBusca, BorderLayout.NORTH);	
	}
	
	private void preparaLabel(String texto){
		JLabel jLabel = new JLabel(texto);
		jpanelBusca.add(jLabel);
	}
	
	private void preparaTextFieldBusca(){
		jTNumero = new JTextField(20);
		jpanelBusca.add(jTNumero);
	}
	
	private void preparaBotaoBusca(){
		JButton jBBusca = new JButton("Buscar");
		jBBusca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		jpanelBusca.add(jBBusca);
	}
	
	private void preparaBotaoRemover(){
		JButton jBRemover = new JButton("Remover");
		jBRemover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowSelecionada = jtableConta.getSelectedRow();
				if(rowSelecionada >= 0){
					model.removeRow(rowSelecionada);
				}else{
					JOptionPane.showMessageDialog(jfrm, "Nenhuma conta selecionada!");
				}
				
			}
		});
		jpanelBusca.add(jBRemover);
	}
	
	//--------------------Tabela--------------------
	
	private void preparaTable() {
		jtableConta = new JTable();
		JScrollPane jspane = new JScrollPane(jtableConta);
		
		jtableConta.addMouseListener(new TableMouseListener(jtableConta));
		
		jfrm.add(jspane, BorderLayout.CENTER);	
	}
	
	
	private void preparaPopMenuTable(){
		popupMenu = new JPopupMenu();
		jtableConta.setComponentPopupMenu(popupMenu);
	}
	
	private void preparaPopMenuItemEditar(){
		JMenuItem menuItemEdit = new JMenuItem("Edit");
		popupMenu.add(menuItemEdit);
		menuItemEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Conta conta = model.getContaAt(jtableConta.getSelectedRow());
				new TelaModificar(jfrm, conta).mostarTela();
				
			}
		});
	}
	
	private void preparaPopMenuItemRelatorio(){
		JMenuItem menuItemPopRelatorio = new JMenuItem("Gerar Relatorio");
		popupMenu.add(menuItemPopRelatorio);
		menuItemPopRelatorio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File("."));
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				
				int retorno = fileChooser.showOpenDialog(null);
				
				if(retorno == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
				}
				
				
			}
		});
	}
	
	
	
	public void addModel(ContaTableModel model){
		this.model = model;
		jtableConta.setModel(model);
	}
	
	
	//--------------------Listener--------------------
	
	public class TableMouseListener extends MouseAdapter {
	     
	    private JTable table;
	     
	    public TableMouseListener(JTable table) {
	        this.table = table;
	    }
	     
	    @Override
	    public void mousePressed(MouseEvent event) {
	        Point point = event.getPoint();
	        int currentRow = table.rowAtPoint(point);
	        table.setRowSelectionInterval(currentRow, currentRow);
	    }
	}
}
