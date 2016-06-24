package br.com.pds.renato.cliente.web;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MetaDados implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String valor;

	public MetaDados() {
	}

	public MetaDados(String nome, String valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
