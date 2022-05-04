package br.com.eisana.favarin.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eisana.favarin.exerciciossb.model.entities.Cliente;


@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	//Desafio: criar 2 metodos:
	// /calculadora/somar/10/20
	// /calculadora/subtrair?a=100&b=39
	
	@GetMapping("/somar/{valor1}/{valor2}")
	public int somar(@PathVariable int valor1, @PathVariable int valor2) {
		return valor1 + valor2;
	} /*http://localhost:8080/calculadora/somar/10/20*/

	@GetMapping("/subtrair")
	public int subtrair(@RequestParam(name = "valor1") int valor1, 
			            @RequestParam(name = "valor2") int valor2) {
		return valor1 - valor2;
	} /* http://localhost:8080/calculadora/subtrair?valor1=300&valor2=200 */
	

}
