package br.com.eisana.favarin.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eisana.favarin.exerciciossb.model.entities.Produto;
import br.com.eisana.favarin.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos") //define a url
public class ProdutoController {
	
	//Injeção de dependência (só funciona nas classes que estão sendo controladas pelo controller
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	/*@PostMapping //esse método será chamado sempre que for feita uma requisição do tipo post
	public @ResponseBody Produto novoProduto(@RequestParam String nome, @RequestParam double valor, @RequestParam double desconto) {
		Produto produto = new Produto(nome, valor, desconto);
		produtoRepository.save(produto);	
		return produto;
	}*/
	
	/*desta forma, é passado por parâmetro o objeto produto, e não os seus atributos.
	 * O spring instancia e insere o valor de cada parâmetro nos atrinutos do objeto */
	/*@PostMapping //esse método será chamado sempre que for feita uma requisição do tipo post	
	public @ResponseBody Produto novoProduto(@Valid Produto produto) { //@valida o objeto produto
		produtoRepository.save(produto);	
		return produto;
	}*/
		
	
	/*@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}*/
	
	/*os 2 metodos acima podem ser substituidos por um único método, abaixo*/
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Produto salvarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	
	@GetMapping
	public Iterable<Produto> obterProdutos(){
		return produtoRepository.findAll();
	}
	
    @GetMapping(path="/nome/{parteNome}")
    public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome){
    	return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
    }
	
	//consulta paginada
	@GetMapping(path="/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina){
		if(qtdePagina >=5 ) qtdePagina = 5; //limita o tamanho de 5 elementos
		Pageable page = PageRequest.of(numeroPagina,qtdePagina);
		return produtoRepository.findAll(page);
	}
	
	@GetMapping(path="/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		   return produtoRepository.findById(id);	
		}
	
	//pesquisar soft delete
	@DeleteMapping(path="/{id}")
	public void excluirProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
}
