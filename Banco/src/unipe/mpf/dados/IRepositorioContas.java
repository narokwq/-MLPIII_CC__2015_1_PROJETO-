package unipe.mpf.dados;

import java.util.List;

import unipe.mpf.contas.Conta;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.dados.exceptions.ContaNaoEcontradaException;

public interface IRepositorioContas {
	void inserir(Conta conta) throws ContaJaCadastradaException;
	Conta procura(Conta conta)throws ContaNaoEcontradaException;
	List<Conta> listar();
	void atualizar(Conta conta)throws ContaNaoEcontradaException;
	void remover(Conta conta)throws ContaNaoEcontradaException;
	void existe(Conta conta)throws ContaNaoEcontradaException;
}
