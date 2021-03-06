package unipe.mpf.contas;

import java.io.File;
import java.util.List;

import unipe.mpf.dados.IRepositorioContas;
import unipe.mpf.dados.RelatorioArquivo;
import unipe.mpf.dados.RelatorioEmail;
import unipe.mpf.dados.exceptions.ContaJaCadastradaException;
import unipe.mpf.dados.exceptions.ContaNaoEcontradaException;
import unipe.mpf.dados.exceptions.RelatorioNaoCriadoException;

public class ContaBancaria {

	IRepositorioContas persitencia;
	
	public ContaBancaria(IRepositorioContas persitencia) {
		this.persitencia = persitencia;
	}
	
	public void cadastrarConta(Conta conta) throws ContaJaCadastradaException {		
		if(!persitencia.existe(conta)){
			persitencia.inserir(conta);
		}else{
			throw new ContaJaCadastradaException("Conta j� existe!");
		}
	}
	
	public Conta procurarConta(Conta conta) throws ContaNaoEcontradaException{	
		if(persitencia.existe(conta)){
			return persitencia.procura(conta);
		}else{
			throw new ContaNaoEcontradaException("Conta n�o encontrada!");
		}
	}
	
	public void atualizarConta(Conta conta) throws ContaNaoEcontradaException {		
		if(persitencia.existe(conta)){
			persitencia.atualizar(conta);
		}else{
			throw new ContaNaoEcontradaException("Conta n�o encontrada!");
		}
	}
	
	public void removerConta(Conta conta) throws ContaNaoEcontradaException {
		if(persitencia.existe(conta)){
			persitencia.remover(conta);
		}else{
			throw new ContaNaoEcontradaException("Conta n�o encontrada!");
		}
	}
	
//	public List<Conta> listarConta() {
//		return persitencia.listar();
//	}

	public List<Conta> procurarContas(String nome) {
		return persitencia.listar(nome);
	}

	public File gerar(Conta conta, File file) throws RelatorioNaoCriadoException {
		RelatorioArquivo relatorio = new RelatorioArquivo(conta, file);
		relatorio.enviar();
		return relatorio.getFile();
	}
	
	public void gerarEmail(String email, File file) throws RelatorioNaoCriadoException {
		RelatorioEmail relatorio = new RelatorioEmail(file, email);
		relatorio.enviar();
	}
	
}
