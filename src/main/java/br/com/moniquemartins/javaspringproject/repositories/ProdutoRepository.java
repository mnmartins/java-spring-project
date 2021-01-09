package br.com.moniquemartins.javaspringproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.moniquemartins.javaspringproject.models.ProdutoModel;
/**
 * A interface extende JpaRepository do Spring Data para utilizar sem a necessidade 
 * de implementação do zero os métodos já prontos para transações com o banco de 
 * dados (como findAll(), findById(Long id), save(S entity), delete(S entity)).
 * 
 * A anotação Repository mostra ao Spring que esse será um bean gerenciado por ele 
 * e como a interface tem como objetivo transações com o banco de dados, o melhor 
 * estereótipo neste caso é o Repository.
 */
@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoModel, Long> {

    
}