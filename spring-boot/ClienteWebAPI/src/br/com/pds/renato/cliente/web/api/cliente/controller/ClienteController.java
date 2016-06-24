package br.com.pds.renato.cliente.web.api.cliente.controller;

import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pds.renato.cliente.web.api.cliente.dominio.Cliente;
import br.com.pds.renato.cliente.web.api.dto.ClienteBag;
import br.com.pds.renato.cliente.web.api.dto.EnderecoBag;
import br.com.pds.renato.cliente.web.api.dto.Mensagem;

@Controller
@RequestMapping("/v1/clientes")
public class ClienteController {

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object incluir(@RequestBody Cliente cliente) {

		try {

			if (cliente == null || cliente.getCpfOuCnpj() == null || cliente.getCpfOuCnpj().isEmpty()) {
				return new Mensagem(400, "Clinte invalido",
						"É necessario informar o cliente, Cpf Ou Cnpj para realizar o cadastro",
						"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
			}

			Random random = new Random();

			cliente.setId(random.nextInt());

			Cliente.getClientes().add(cliente);

			return cliente;

		} catch (Exception ex) {
			return new Mensagem(500, "Servidor com problemas", "Verifique o quanto antes",
					"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Object atualizar(@RequestBody Cliente cliente) {

		try {

			Cliente source = Cliente.getClientes().stream().filter(cli -> cli.getId() == cliente.getId()).findFirst()
					.get();

			source.set(cliente);

			return source;

		} catch (NoSuchElementException e) {
			return new Mensagem(404, "Cliente não encontrado", null,
					"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
		} catch (Exception ex) {
			return new Mensagem(500, "Servidor com problemas", "Verifique o quanto antes",
					"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
		}
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object excluir(@PathVariable(value = "id") int id) {

		Object obj = getCliente(id);

		if (obj instanceof Cliente) {
			Cliente.getClientes().remove(obj);

			return new Mensagem(200, "OK", null, null);
		}
		return obj;
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object getCliente(@PathVariable(value = "id") int id) {

		try {

			Cliente cliente = Cliente.getClientes().stream().filter(cli -> cli.getId() == id).findFirst().get();

			return cliente;

		} catch (NoSuchElementException e) {
			return new Mensagem(404, "Cliente não encontrado", null,
					"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
		} catch (Exception ex) {
			return new Mensagem(500, "Servidor com problemas", "Verifique o quanto antes",
					"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ClienteBag getClientes() {
		return new ClienteBag(Cliente.getClientes(), 25, 100);
	}

	@RequestMapping(path = "/{id}/enderecos", method = RequestMethod.GET)
	@ResponseBody
	public Object getClienteEndereco(@PathVariable(value = "id") int id) {

		Object obj = getCliente(id);

		if (obj instanceof Cliente) {
			return new EnderecoBag(((Cliente) obj).getEnderecos(), 5, 1);
		}

		return obj;
	}

	@RequestMapping(path = "/{id}/enderecos/{idEndereco}", method = RequestMethod.GET)
	@ResponseBody
	public Object getClienteEndereco(@PathVariable(value = "id") int id,
			@PathVariable(value = "idEndereco") int idEndereco) {

		Object obj = getCliente(id);

		if (obj instanceof Cliente) {
			try {

				return ((Cliente) obj).getEnderecos().stream().filter(end -> end.getId() == idEndereco).findFirst()
						.get();
			} catch (NoSuchElementException e) {
				return new Mensagem(404, "Endereço não encontrado", null,
						"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
			} catch (Exception ex) {
				return new Mensagem(500, "Servidor com problemas", "Verifique o quanto antes",
						"https://pt.wikipedia.org/wiki/Lista_de_c%C3%B3digos_de_status_HTTP");
			}
		}

		return obj;
	}
}
