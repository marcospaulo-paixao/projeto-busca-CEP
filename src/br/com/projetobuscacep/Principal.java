package br.com.projetobuscacep;

import br.com.projetobuscacep.model.CepService;
import br.com.projetobuscacep.model.Endereco;

/**
 * @author Marcos Paulo Paixão
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		try {
			final Endereco endereco = CepService.buscar("74683680");
			System.out.println(endereco);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}