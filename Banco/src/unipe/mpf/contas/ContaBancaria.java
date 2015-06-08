package unipe.mpf.contas;

import java.util.List;

import unipe.mpf.dados.IRepositorioContas;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.dados.exceptions.ContaNaoEcontradaException;

public class ContaBancaria {

	IRepositorioContas persitencia;
	
	public ContaBancaria(IRepositorioContas persitencia) {
		this.persitencia = persitencia;
	}
	
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException {
		persitencia.inserir(conta);
	}
	
	public Conta procurarConta(Conta conta) throws ContaNaoEcontradaException{
		return persitencia.procura(conta);
	}
	
	public void atualizarConta(Conta conta) throws ContaNaoEcontradaException {
		persitencia.atualizar(conta);
	}
	
	public void removerConta(Conta conta) throws ContaNaoEcontradaException {
		persitencia.remover(conta);
	}
	
	public List<Conta> listarConta() {
		return persitencia.listar();
	}

}
