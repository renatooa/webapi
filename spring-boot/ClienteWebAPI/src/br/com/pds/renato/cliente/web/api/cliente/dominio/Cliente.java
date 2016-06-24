package br.com.pds.renato.cliente.web.api.cliente.dominio;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.orm.jpa.EntityScan;

@EntityScan
@XmlRootElement
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome = null;
	private String cpfOuCnpj = null;
	private List<Endereco> enderecos = null;

	public Cliente() {
	}
	
	

	public Cliente(String nome, String cpfOuCnpj) {
		super();
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
