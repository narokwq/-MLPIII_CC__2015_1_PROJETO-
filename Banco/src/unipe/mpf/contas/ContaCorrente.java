package unipe.mpf.contas;

public class ContaCorrente extends Conta{
	private static int TAXA_CONTA_CORRENTE = 2; 
	
	public ContaCorrente(String numero) {
		super(numero);
	}
	public ContaCorrente(String numero, double saldo, float taxa) {
		super(numero, saldo, taxa);
	}
	public ContaCorrente(String numero, double saldo) {
		super(numero, saldo);
	}


	public void creditar(double valor){
		if(valor>0){
			this.saldo += (valor-0.10f);
		}
	}
	
	public void atualizar() {
		this.saldo += TAXA_CONTA_CORRENTE*taxa*this.saldo;
	}
}
