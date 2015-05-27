package unipe.mpf.dados;

import java.util.List;

import unipe.mpf.contas.Conta;

public interface IRepositorioContas {
	void Inserir(Conta conta) throws ContaJaCadastradaException;
	Conta Procura(Conta conta)throws ContaNaoEcontradaException;
	List<Conta> RecuperTodos();
	void Atualizar(Conta conta)throws ContaNaoEcontradaException;
	void Remover(Conta conta)throws ContaNaoEcontradaException;
	void Existe(Conta conta)throws ContaNaoEcontradaException;
}
