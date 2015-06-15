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
		if(!persitencia.existe(conta)){
			persitencia.inserir(conta);
		}else{
			throw new ContaJaCadastradaException("Conta já existe!");
		}
	}
	
	public Conta procurarConta(Conta conta) throws ContaNaoEcontradaException{	
		if(persitencia.existe(conta)){
			return persitencia.procura(conta);
		}else{
			throw new ContaNaoEcontradaException("Conta não encontrada!");
		}
	}
	
	public void atualizarConta(Conta conta) throws ContaNaoEcontradaException {		
		if(persitencia.existe(conta)){
			persitencia.atualizar(conta);
		}else{
			throw new ContaNaoEcontradaException("Conta não encontrada!");
		}
	}
	
	public void removerConta(Conta conta) throws ContaNaoEcontradaException {
		if(persitencia.existe(conta)){
			persitencia.remover(conta);
		}else{
			throw new ContaNaoEcontradaException("Conta não encontrada!");
		}
	}
	
//	public List<Conta> listarConta() {
//		return persitencia.listar();
//	}

	public List<Conta> procurarContas(String nome) {
		return persitencia.listar(nome);
	}

}
