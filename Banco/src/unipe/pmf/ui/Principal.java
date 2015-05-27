package unipe.pmf.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import unipe.mpf.contas.Conta;
import unipe.mpf.contas.ContaCorrente;

public class Principal {

	public static void main(String[] args) {
		JFrame jfrm = new JFrame();
		jfrm.setSize(800, 600);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Menu
		
		JMenuBar jMenuBar = new JMenuBar();
		jfrm.setJMenuBar(jMenuBar);
		
		JMenu jMenuFerramenta = new JMenu("Ferrementa");
		jMenuBar.add(jMenuFerramenta);
		
		JMenu jMenuAbout = new JMenu("About");
		jMenuBar.add(jMenuAbout);
		
		JMenu jMenuAjuda = new JMenu("Ajuda");
		jMenuBar.add(jMenuAjuda);
		
		JMenuItem jmenuItemInserir = new JMenuItem("Inserir");
		jMenuFerramenta.add(jmenuItemInserir);
		
		//Table
		Conta conta = new ContaCorrente("36665", 60.0f);
		List<Conta> contas = new ArrayList<>();
		contas.add(conta);
		JTable jtableConta = new JTable(new ContaTableModel(contas));
		
		JScrollPane jspane = new JScrollPane(jtableConta);
		jspane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		jfrm.add(jspane, BorderLayout.CENTER);
		
		
		//Mostrar na tela
		jfrm.setVisible(true);
	}

}
