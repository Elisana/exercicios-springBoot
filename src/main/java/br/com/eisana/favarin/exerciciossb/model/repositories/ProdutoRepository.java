package br.com.eisana.favarin.exerciciossb.model.repositories;

//import org.springframework.data.repository.CrudRepository;
/*o repositório CrudRepository não tem controle de paginação, por isso trocamos pelo PagingAndSortingRepository
 * que tem os metodos do CrudRepository, mais os de paginação e ordenação
 * */
import org.springframework.data.repository.PagingAndSortingRepository;
import br.com.eisana.favarin.exerciciossb.model.entities.Produto;

/*Essa classe é responsável por fazer a persistência de um produto. Abstrai os dados
 * Ese repositório pode ser um arquivo, um arquivo texto, uma planilha excel, um banco de dados */

/*no contexto do Generics, não é possível usar tipos primitivos*/
//public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

}
