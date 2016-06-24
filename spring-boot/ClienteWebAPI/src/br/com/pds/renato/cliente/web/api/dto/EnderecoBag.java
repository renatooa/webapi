package br.com.pds.renato.cliente.web.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.pds.renato.cliente.web.MetaDados;
import br.com.pds.renato.cliente.web.api.cliente.dominio.Cliente;
import br.com.pds.renato.cliente.web.api.cliente.dominio.Endereco;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EnderecoBag implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name="enderecos")
	@XmlElementRef(type = Cliente.class)
	private ArrayList<Endereco> enderecos;
	
	@XmlElementWrapper(name="metaDados")
	@XmlElementRef(type = MetaDados.class)
	private ArrayList<MetaDados> metaDados;

	public EnderecoBag() {
	}

	public EnderecoBag(List<Endereco> enderecos, int limit, int offset) {

		this.enderecos = new ArrayList<>(enderecos);

		metaDados = new ArrayList<>();
		metaDados.add(new MetaDados("totalCount", Integer.toString(enderecos.size())));
		metaDados.add(new MetaDados("limit", Integer.toString(limit)));
		metaDados.add(new MetaDados("offset", Integer.toString(offset)));
	}
	
	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public ArrayList<MetaDados> getMetaDados() {
		return metaDados;
	}

	public void setMetaDados(ArrayList<MetaDados> metaDados) {
		this.metaDados = metaDados;
	}
}
