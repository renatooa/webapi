package br.com.pds.renato.cliente.web.api.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo = 200;
	private String mensagemUsuario;
	private String mensagemDesenvovedor;
	private String urlDetalhesErro;

	public Mensagem() {
	}

	public Mensagem(int codigo, String mensagemUsuario, String mensagemDesenvovedor, String urlDetalhesErro) {
		super();
		this.codigo = codigo;
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvovedor = mensagemDesenvovedor;
		this.urlDetalhesErro = urlDetalhesErro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}

	public String getMensagemDesenvovedor() {
		return mensagemDesenvovedor;
	}

	public void setMensagemDesenvovedor(String mensagemDesenvovedor) {
		this.mensagemDesenvovedor = mensagemDesenvovedor;
	}

	public String getUrlDetalhesErro() {
		return urlDetalhesErro;
	}

	public void setUrlDetalhesErro(String urlDetalhesErro) {
		this.urlDetalhesErro = urlDetalhesErro;
	}
}
