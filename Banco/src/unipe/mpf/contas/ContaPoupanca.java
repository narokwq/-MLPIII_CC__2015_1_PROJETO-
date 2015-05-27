package unipe.mpf.contas;

public class ContaPoupanca extends Conta {
	private static int TAXA_CONTA_POUPANCA = 3;
	
	public ContaPoupanca(String numero) {
		super(numero);
	}
	public ContaPoupanca(String numero, double saldo, float taxa) {
		super(numero, saldo, taxa);
	}
	public ContaPoupanca(String numero, double saldo) {
		super(numero, saldo);
	}
	
	public void atualizar() {
		this.saldo += TAXA_CONTA_POUPANCA*taxa*this.saldo;
	}
}
