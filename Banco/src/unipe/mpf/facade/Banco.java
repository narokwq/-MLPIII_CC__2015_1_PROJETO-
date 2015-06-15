package unipe.mpf.facade;



import java.util.List;

import unipe.mpf.contas.Conta;
import unipe.mpf.contas.ContaBancaria;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.dados.exceptions.ContaNaoEcontradaException;


/**
 * Classe Facade para Contas Bancárias.
 * @author jefferson
 * @date 
 */
public class Banco {
	
	private ContaBancaria contaBancaria;
	
	public Banco(ContaBancaria bancaria) {
		this.contaBancaria = bancaria;
	}
	
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException {
		contaBancaria.cadastrarConta(conta);
	}
	
	public Conta procurarConta(Conta conta) throws ContaNaoEcontradaException{
		return contaBancaria.procurarConta(conta);
	}
	
	public void atualizarConta(Conta conta) throws ContaNaoEcontradaException{
		contaBancaria.atualizarConta(conta);
	}
	
	public void removerConta(Conta conta) throws ContaNaoEcontradaException{
		contaBancaria.removerConta(conta);
	}

	public List<Conta> getContas(String nome) {
		return contaBancaria.procurarContas(nome);
		
	}
}
