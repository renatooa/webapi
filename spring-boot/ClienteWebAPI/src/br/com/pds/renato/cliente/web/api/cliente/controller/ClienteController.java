package br.com.pds.renato.cliente.web.api.cliente.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pds.renato.cliente.web.api.cliente.dominio.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String incluir(@RequestBody Cliente cliente) {
		return "Inclui " + cliente.getNome();
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public String atualizar(@RequestBody Cliente cliente) {
		return "Atauliza " + cliente.getNome();
	}

	@RequestMapping(path = "/{codigo}", method = RequestMethod.DELETE)
	@ResponseBody
	public String excluir(@PathVariable(value = "codigo") int codigo) {
		return "Exclui";
	}

	@RequestMapping(path = "/{codigo}", method = RequestMethod.GET)
	@ResponseBody
	public Cliente getCliente(@PathVariable(value = "codigo") int codigo) {
		return new Cliente("Cli " + codigo, Long.toString(codigo * 99999));
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Cliente> getClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for (int i = 0; i < 10; i++) {
			clientes.add(new Cliente("Cli " + i, Long.toString(i * 99999)));
		}
		return clientes.stream().collect(Collectors.toList());
	}
}
