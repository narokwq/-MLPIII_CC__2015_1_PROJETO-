package unipe.mpf.dados;

import java.util.Collections;
import java.util.List;

import unipe.mpf.contas.Conta;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.dados.exceptions.ContaNaoEcontradaException;

public class RepositorioContas implements IRepositorioContas {

	@Override
	public void inserir(Conta conta) throws ContaJaCadastradaException {
		throw new ContaJaCadastradaException("Conta j� existe!");
		
	}

	@Override
	public Conta procura(Conta conta) throws ContaNaoEcontradaException {
		//throw new ContaNaoEcontradaException("Conta n�o encontrada!");
		return null;
	}

	@Override
	public void atualizar(Conta conta) throws ContaNaoEcontradaException {
		throw new ContaNaoEcontradaException("Conta n�o encontrada!");
		
	}

	@Override
	public void remover(Conta conta) throws ContaNaoEcontradaException {
		throw new ContaNaoEcontradaException("Conta n�o encontrada!");
		
	}

	@Override
	public void existe(Conta conta) throws ContaNaoEcontradaException {
		throw new ContaNaoEcontradaException("Conta n�o encontrada!");
		
	}

	@Override
	public List<Conta> listar() {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	

}
