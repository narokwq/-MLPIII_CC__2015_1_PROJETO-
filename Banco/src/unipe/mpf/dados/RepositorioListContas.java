package unipe.mpf.dados;

import java.util.ArrayList;
import java.util.List;

import unipe.mpf.contas.Conta;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.dados.exceptions.ContaNaoEcontradaException;

public class RepositorioListContas implements IRepositorioContas {

	List<Conta> contas = new ArrayList<>();
	
	public void inserir(Conta conta) throws ContaJaCadastradaException {
		contas.add(conta);

	}

	@Override
	public Conta procura(Conta conta) throws ContaNaoEcontradaException {
		for(Conta aux: contas)
			if(conta.getConta() == aux.getConta())
				return aux;
		throw new ContaNaoEcontradaException("Conta não encontrada");
	}

	@Override
	public List<Conta> listar() {
		return contas;
	}

	@Override
	public void atualizar(Conta conta) throws ContaNaoEcontradaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Conta conta) throws ContaNaoEcontradaException {
		contas.remove(conta);

	}

	@Override
	public void existe(Conta conta) throws ContaNaoEcontradaException {
		

	}

}
