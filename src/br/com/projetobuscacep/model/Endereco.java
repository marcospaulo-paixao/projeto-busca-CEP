package br.com.projetobuscacep.model;

/**
 * @author Marcos Paulo Paixão
 *
 */
public class Endereco {
	
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String ibge;
	private String uf;

	/**
	 * 
	 */
	public Endereco() {
		this("", "", "", "", "", "");
	}

	/**
	 * @param logradouro
	 * @param complemento
	 * @param bairro
	 * @param localidade
	 * @param ibge
	 * @param uf
	 */
	public Endereco(final String logradouro, final String complemento, final String bairro, final String localidade,
			final String ibge, final String uf) {
		this.cep = "";
		this.logradouro = "";
		this.complemento = "";
		this.bairro = "";
		this.localidade = "";
		this.ibge = "";
		this.uf = "";
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.ibge = ibge;
		this.uf = uf;
	}

	/**
	 * @return
	 */
	public String getLogradouro() {
		return this.logradouro;
	}

	/**
	 * @param logradouro
	 */
	public void setLogradouro(final String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return
	 */
	public String getComplemento() {
		return this.complemento;
	}

	/**
	 * @param complemento
	 */
	public void setComplemento(final String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return this.bairro;
	}

	/**
	 * @param bairro
	 */
	public void setBairro(final String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return
	 */
	public String getLocalidade() {
		return this.localidade;
	}

	/**
	 * @param localidade
	 */
	public void setLocalidade(final String localidade) {
		this.localidade = localidade;
	}

	/**
	 * @return
	 */
	public String getUf() {
		return this.uf;
	}

	/**
	 * @param uf
	 */
	public void setUf(final String uf) {
		this.uf = uf;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Endereco{cep=" + this.getCep() + ", logradouro=" + this.getLogradouro() + ", complemento="
				+ this.getComplemento() + ", bairro=" + this.getBairro() + ", localidade=" + this.getLocalidade()
				+ ", ibge=" + this.getIbge() + ", uf=" + this.getUf() + '}';
	}

	/**
	 * @return
	 */
	public String getIbge() {
		return this.ibge;
	}

	/**
	 * @param ibge
	 */
	public void setIbge(final String ibge) {
		this.ibge = ibge;
	}

	/**
	 * @return
	 */
	public String getCep() {
		return this.cep;
	}

	/**
	 * @param cep
	 */
	public void setCep(final String cep) {
		this.cep = cep;
	}
}