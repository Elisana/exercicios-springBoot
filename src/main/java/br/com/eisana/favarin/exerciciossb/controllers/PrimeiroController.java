package br.com.eisana.favarin.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	//@RequestMapping :por padrão, usa o método get	
	//@RequestMapping
	
	@GetMapping(path={"/ola","/oi"})
	public String ola() {
		return "Olá Spring Boot2";
	}

	@RequestMapping(method = RequestMethod.GET,path = "/tchao")
	public String Tchao() {
		return "Tchao Spring Boot";
	}
}
