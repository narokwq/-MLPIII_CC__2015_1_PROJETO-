package unipe.mpf.dados.testes;


import unipe.mpf.contas.Conta;
import unipe.mpf.contas.ContaCorrente;
import junit.framework.TestCase;

public class ContaCorrenteTeste extends TestCase {
	Conta conta;
	protected void setUp(){
		conta = new ContaCorrente();
		conta.setConta("00001");
	}
	
	protected void tearDown(){
		conta = null;
	}
	
	public void testCreditarInicial(){
		conta.creditar(100.1);
		assertEquals(conta.getSaldo(), 100.1-0.1);
	}
	
	public void testCreditar(){
		conta.creditar(100.1);
		assertEquals(conta.getSaldo(), 100.1-0.1);
	}
	
	public void testDebitar(){
		conta.creditar(100.1f);
		assertTrue(conta.debitar(20));
	}
	
	public void testConta(){
		Conta conta = new ContaCorrente();
		conta.setConta("00001");
		assertNotSame(this.conta, conta);
	}
	
}
