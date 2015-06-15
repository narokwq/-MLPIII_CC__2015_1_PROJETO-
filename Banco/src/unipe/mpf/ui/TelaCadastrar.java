package unipe.mpf.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import unipe.mpf.contas.ContaBancaria;
import unipe.mpf.contas.ContaCorrente;
import unipe.mpf.dados.RepositorioContas;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.facade.Banco;

public class TelaCadastrar {
	private JDialog fDialog;
	private JPanel jPanelCadastro;
	private JTextField jFieldNumero;
	private JTextField jFieldNome;
	private JFormattedTextField jFieldSaldo;
//	private JTextField jFieldSaldo;
	private JPanel jPanelButton;
	
	public TelaCadastrar(JFrame pai){
		fDialog = new JDialog(pai, "Cadastrar Conta",true);
		fDialog.setResizable(false);
		fDialog.setSize(300, 160);
		fDialog.setLocationRelativeTo(pai);
		
		preparaPanelCadastro();
		GridBagConstraints gridBag = new GridBagConstraints();
		gridBag.weightx = 1;
		gridBag.weighty = 0.1;
		
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.fill = GridBagConstraints.NONE;
		gridBag.anchor = GridBagConstraints.LINE_END;
		gridBag.insets = new Insets(20, 10, 0, 3);
		preparaLabel("Numero:", gridBag);
		
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		gridBag.anchor = GridBagConstraints.LINE_START;
		preparaFieldNumero(gridBag);
		
		gridBag.weightx = 1;
		gridBag.weighty = 0.1;
		gridBag.gridx = 0;
		gridBag.gridy = 1;
		gridBag.anchor = GridBagConstraints.LINE_END;
		gridBag.insets = new Insets(3, 10, 0, 3);
		preparaLabel("Nome:", gridBag);
		
		gridBag.gridx = 1;
		gridBag.gridy = 1;
		gridBag.anchor = GridBagConstraints.LINE_START;
		preparaFieldNome(gridBag);
		
		gridBag.weightx = 1;
		gridBag.weighty = 2;
		gridBag.gridx = 0;
		gridBag.gridy = 2;
		gridBag.anchor = GridBagConstraints.FIRST_LINE_END;
		gridBag.insets = new Insets(3, 10, 0, 3);
		preparaLabel("Saldo:", gridBag);
		
		gridBag.gridx = 1;
		gridBag.gridy = 2;
		gridBag.anchor = GridBagConstraints.FIRST_LINE_START;
		preparaFieldSaldo(gridBag);
		
		
		preparaPanelButton();
		preparaButtonSalvar();
		preparaButtonCancelar();
		
	}
	
	public void MostarTela(){	
		fDialog.setVisible(true);
	}
	
	private void preparaPanelCadastro(){
		jPanelCadastro = new JPanel();
		jPanelCadastro.setLayout(new GridBagLayout());
		fDialog.add(jPanelCadastro, BorderLayout.WEST);
	}
	private void preparaFieldNumero(GridBagConstraints gc){
		jFieldNumero = new JTextField(6);	
		jFieldNumero.setDocument(new LimitarCharater(10));
		jPanelCadastro.add(jFieldNumero, gc);
	}
	
	private void preparaFieldNome(GridBagConstraints gc){
		jFieldNome = new JTextField(15);
		jPanelCadastro.add(jFieldNome, gc);
	}
	
	private void preparaFieldSaldo(GridBagConstraints gc){
		jFieldSaldo = new JFormattedTextField(new DecimalFormat("#.##"));
		jFieldSaldo.setColumns(6);
		jPanelCadastro.add(jFieldSaldo, gc);
	}
	
	private void preparaLabel(String texto, GridBagConstraints gc){
		JLabel label = new JLabel(texto);
		jPanelCadastro.add(label, gc);
	}
	
	private void preparaPanelButton(){
		jPanelButton = new JPanel();
		jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fDialog.add(jPanelButton, BorderLayout.SOUTH);
	}
	
	private void preparaButtonSalvar(){
		JButton jBSalvar = new JButton("Salvar");
		jPanelButton.add(jBSalvar);
		jBSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Banco banco = new Banco(new ContaBancaria(new RepositorioContas()));
				String nConta = jFieldNumero.getText().trim();
				String nome = jFieldNome.getText().trim();
				double saldo = Double.parseDouble(jFieldSaldo.getText().trim());
				try {
					banco.cadastrarConta(new ContaCorrente(nConta, nome, saldo));
					JOptionPane.showMessageDialog(fDialog, "Conta Cadastrada Com Sucesso!!");
					
				} catch (ContaJaCadastradaException e1) {
					JOptionPane.showMessageDialog(fDialog, e1.getMessage());
				}			
			}
		});
	}
	
	private void preparaButtonCancelar(){
		JButton jBCancelar = new JButton("Cancelar");
		jPanelButton.add(jBCancelar);
		jBCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fDialog.dispose();
				
			}
		});
	}
}
