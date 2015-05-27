package unipe.mpf.dados;

import java.util.List;

import unipe.mpf.contas.Conta;

public class RepositorioContas implements IRepositorioContas {

	@Override
	public void Inserir(Conta conta) throws ContaJaCadastradaException {
		throw new ContaJaCadastradaException("Conta já existe!");
		
	}

	@Override
	public Conta Procura(Conta conta) throws ContaNaoEcontradaException {
		//throw new ContaNaoEcontradaException("Conta não encontrada!");
		return null;
	}

	@Override
	public void Atualizar(Conta conta) throws ContaNaoEcontradaException {
		throw new ContaNaoEcontradaException("Conta não encontrada!");
		
	}

	@Override
	public void Remover(Conta conta) throws ContaNaoEcontradaException {
		throw new ContaNaoEcontradaException("Conta não encontrada!");
		
	}

	@Override
	public void Existe(Conta conta) throws ContaNaoEcontradaException {
		throw new ContaNaoEcontradaException("Conta não encontrada!");
		
	}

	@Override
	public List<Conta> RecuperTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
