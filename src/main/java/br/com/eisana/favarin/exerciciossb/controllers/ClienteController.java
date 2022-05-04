package br.com.eisana.favarin.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eisana.favarin.exerciciossb.model.entities.Cliente;

@RestController
@RequestMapping("/clientes") //quando usa esse, não usa completo aqui: //@GetMapping(path="/clientes/qualquer")
/* Toda a classe abaixo fica mapeada para usar o /cliente*/
public class ClienteController {
	
	//@GetMapping(path="/clientes/qualquer") usar assim quando não tem o @RequestMapping 
	@GetMapping(path="/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28,"Pedro","123.456.789-09");
	}
	
	@GetMapping("/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		return new Cliente (id,"maria","987.654.321-00");
	} /*http://localhost:8080/clientes/123*/
	
	@GetMapping
	public Cliente obterClientePorId2(@RequestParam(name = "id", defaultValue = "55") int id) {
		return new Cliente (id,"João Augusto","111.222.333-44");
	} /* http://localhost:8080/clientes?id=123 */
	/*com o defaultValue, não precisa passar parâmetro, pois vai assumir o padrão 55:
	 *  http://localhost:8080/clientes  */

}
