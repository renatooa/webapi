package br.com.pds.renato.cliente.web.api.cliente.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.orm.jpa.EntityScan;

@EntityScan
@XmlRootElement
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private static ArrayList<Cliente> clientes;

	private int id = 0;
	private String nome = null;
	private String cpfOuCnpj = null;
	private List<Endereco> enderecos = null;

	public Cliente() {
	}

	public Cliente(int id, String nome, String cpfOuCnpj, List<Endereco> enderecos) {
		super();
		this.id = id;
		set(nome, cpfOuCnpj, enderecos);
	}

	public void set(Cliente cliente) {
		set(cliente.getNome(), cliente.getCpfOuCnpj(), cliente.enderecos);
	}

	public void set(String nome, String cpfOuCnpj, List<Endereco> enderecos) {
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		if (enderecos != null && !enderecos.isEmpty()) {
			this.enderecos = enderecos;
		}
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

	public static ArrayList<Cliente> getClientes() {
		if (clientes == null) {
			criarClientesDemostracao();
		}

		return clientes;
	}

	private static void criarClientesDemostracao() {

		clientes = new ArrayList<>();

		List<Endereco> enderecos = criarEnderecos();

		for (int i = 1; i <= 100; i++) {
			clientes.add(new Cliente(i * 65, "Cliente " + i, Long.toString(i * 6589712), enderecos));
		}
	}

	private static List<Endereco> criarEnderecos() {
		List<Endereco> enderecos = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			enderecos.add(new Endereco(i, "rua " + i, Integer.toString(i * 3), "Bairro " + i,
					(i % 2 == 0 ? "BH" : "Santa Luzia"), Integer.toString(i * 12335), "MG"));

		}

		return enderecos;
	}
}
