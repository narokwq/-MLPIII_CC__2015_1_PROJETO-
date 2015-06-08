package unipe.mpf.contas;

public abstract class Conta {
	protected int id;
	protected String conta;
	protected double saldo;
	protected String nome;
	protected float taxa;
	
	public Conta(String numero, double saldo, float taxa){
		this.conta = numero;
		this.taxa = taxa;
		creditar(saldo);		
	}
	
	public Conta(String numero, double saldo){
		this(numero, saldo, 0);
	}
	
	public Conta(String numero){
		this(numero, 0, 0);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String nConta) {
		this.conta = nConta;
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
		return "Conta [nConta=" + conta + ", saldo=" + saldo + "]";
	}
	
}
