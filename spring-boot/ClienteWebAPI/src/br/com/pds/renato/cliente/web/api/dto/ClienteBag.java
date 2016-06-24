package br.com.pds.renato.cliente.web.api.dto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.pds.renato.cliente.web.MetaDados;
import br.com.pds.renato.cliente.web.api.cliente.dominio.Cliente;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClienteBag implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name="clientes")
	@XmlElementRef(type = Cliente.class)
	private ArrayList<Cliente> clientes;
	
	@XmlElementWrapper(name="metaDados")
	@XmlElementRef(type = MetaDados.class)
	private ArrayList<MetaDados> metaDados;

	public ClienteBag() {
	}

	public ClienteBag(ArrayList<Cliente> clientes, int limit, int offset) {

		this.clientes = clientes;

		metaDados = new ArrayList<>();
		metaDados.add(new MetaDados("totalCount", Integer.toString(clientes.size())));
		metaDados.add(new MetaDados("limit", Integer.toString(limit)));
		metaDados.add(new MetaDados("offset", Integer.toString(offset)));
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<MetaDados> getMetaDados() {
		return metaDados;
	}

	public void setMetaDados(ArrayList<MetaDados> metaDados) {
		this.metaDados = metaDados;
	}
}
