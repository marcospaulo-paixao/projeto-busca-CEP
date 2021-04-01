package br.com.projetobuscacep.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import br.com.projetobuscacep.util.Util;

/**
 * @author Marcos Paulo Paixão
 *
 */
public class CepService {

	private static final String WEB_SERVICE = "http://viacep.com.br/ws/";
	private static final int CODIGO_SUCESSO = 200;

	/**
	 * @param cep
	 * @return
	 * @throws Exception
	 */
	public static Endereco buscar(String cep) throws Exception {
		try {
			cep = ValidaCEP(cep);
			final String urlParaChamada = WEB_SERVICE + cep + "/json";
			final URL url = new URL(urlParaChamada);
			final HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			if (conexao.getResponseCode() != CODIGO_SUCESSO) {
				throw new Exception("HTTP error code : " + conexao.getResponseCode());
			}
			final BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			final Endereco endereco = jsonToObject(resposta);
			if (endereco.getIbge().equals("")) {
				throw new Exception("Endereço não encontrado! Verifique o número do Cep!");
			}
			endereco.setCep(cep);
			return endereco;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param resposta
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Endereco jsonToObject(final BufferedReader resposta) throws Exception {
		try {
			final String jsonEmString = Util.converteJsonEmString(resposta);
			final Gson gson = new Gson();
			return (Endereco) gson.fromJson(jsonEmString, (Class) Endereco.class);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param cep
	 * @return
	 * @throws Exception
	 */
	private static String ValidaCEP(final String cep) throws Exception {
		String aux = cep.trim().replace(".", "");
		aux = aux.replace("-", "");
		if (aux.length() != 8) {
			throw new Exception("Cep inválido! Cep deve conter 8 dígitos numéricos!");
		}
		if (aux.equalsIgnoreCase("00000000") || aux.equalsIgnoreCase("11111111") || aux.equalsIgnoreCase("22222222")
				|| aux.equalsIgnoreCase("33333333") || aux.equalsIgnoreCase("44444444")
				|| aux.equalsIgnoreCase("55555555") || aux.equalsIgnoreCase("66666666")
				|| aux.equalsIgnoreCase("77777777") || aux.equalsIgnoreCase("88888888")
				|| aux.equalsIgnoreCase("99999999") || aux.equalsIgnoreCase("12345678")) {
			throw new Exception("Cep inválido!");
		}
		if (!aux.matches("[0-9]*")) {
			throw new Exception("Cep inválido! Digite apenas números!");
		}
		return aux;
	}
}