package unipe.mpf.dados;

import java.util.List;

import unipe.mpf.contas.Conta;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.dados.exceptions.ContaNaoEcontradaException;

public interface IRepositorioContas {
	void inserir(Conta conta);
	Conta procura(Conta conta);
	void atualizar(Conta conta);
	void remover(Conta conta);
	List<Conta> listar(String nome);
	boolean existe(Conta conta);
}
