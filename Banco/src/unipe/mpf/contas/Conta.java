package unipe.mpf.contas;

public abstract class Conta {
	protected String nConta;
	protected double saldo;
	protected float taxa;
	
	public Conta(String numero, double saldo, float taxa){
		this.nConta = numero;
		this.taxa = taxa;
		creditar(saldo);		
	}
	
	public Conta(String numero, double saldo){
		this(numero, saldo, 0);
	}
	
	public Conta(String numero){
		this(numero, 0, 0);
	}
	
	public String getConta() {
		return nConta;
	}
	public void setConta(String nConta) {
		this.nConta = nConta;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public boolean debitar(float valor) {
		if(valor < saldo){
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public void creditar(double valor) {
		this.saldo += valor;
	}
	
	public float getTaxa() {
		return taxa;
	}
	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	public void atualizar() {
		this.saldo += this.saldo*taxa;
	}
	
	@Override
	public String toString() {
		return "Conta [nConta=" + nConta + ", saldo=" + saldo + "]";
	}
	
}
