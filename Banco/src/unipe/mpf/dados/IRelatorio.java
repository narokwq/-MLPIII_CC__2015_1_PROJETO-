package unipe.mpf.dados;

import unipe.mpf.dados.exceptions.RelatorioNaoCriadoException;

public interface  IRelatorio {
	void enviar() throws RelatorioNaoCriadoException;
}
