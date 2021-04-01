package br.com.projetobuscacep.util;

import java.io.IOException;
import java.io.BufferedReader;

/**
 * @author Marcos Paulo Paixão
 *
 */
public class Util {

	/**
	 * @param buffereReader
	 * @return
	 * @throws IOException
	 */
	public static String converteJsonEmString(final BufferedReader buffereReader) throws IOException {
		String jsonEmString = "";
		String resposta;
		while ((resposta = buffereReader.readLine()) != null) {
			jsonEmString += resposta;
		}
		return jsonEmString;
	}
}