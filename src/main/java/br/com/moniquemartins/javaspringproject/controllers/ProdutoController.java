package br.com.moniquemartins.javaspringproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.moniquemartins.javaspringproject.models.ProdutoModel;
import br.com.moniquemartins.javaspringproject.repositories.ProdutoRepository;

/**
 * A anotação RestController é um estereótipo específico para criar endpoints 
 * REST e mostra ao Spring que tal classe será um bean gerenciado por ele 
 * através da IoC/ID.
 * 
 * Como o ProdutoRepository (também um bean) já foi criado, é preciso criar um 
 * ponto de injeção dentro do Controller para que o Spring injete as dependências 
 * de ProdutoRepository quando necessário.
 */
@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoModel>> getAllProdutos() {
        List<ProdutoModel> produtosList = produtoRepository.findAll();
        if(produtosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<ProdutoModel>>(produtosList, HttpStatus.OK);
        }
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModel> getOneProduto(@PathVariable(value = "id") long id) {
        /* O Optional faz uma verificação do objeto (se está ou não nulo) e retorna um boolean, 
        caso o objeto não esteja nulo, é possível obter seu valor com o get().*/
        Optional<ProdutoModel> produtoO = produtoRepository.findById(id);
        if(!produtoO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<ProdutoModel>(produtoO.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModel> saveProduto(@RequestBody @Validated ProdutoModel produto) {
        /* Obs.: Anotação Valid não disponível nessa versão, foi substituída por sua variante Validated.*/
        return new ResponseEntity<ProdutoModel>(produtoRepository.save(produto), HttpStatus.CREATED);
    }

    @DeleteMapping("produtos/{id}")
    public ResponseEntity<ProdutoModel> deleteteProduto(@PathVariable(value = "id") long id) {
        Optional<ProdutoModel> produtoO = produtoRepository.findById(id);
        if(!produtoO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produtoRepository.delete(produtoO.get());
            return new ResponseEntity<ProdutoModel>(HttpStatus.OK);
        }
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModel> updateProduto(@PathVariable(value = "id") long id, @RequestBody @Validated ProdutoModel produto) {
        Optional<ProdutoModel> produtoO = produtoRepository.findById(id);
        if(!produtoO.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produto.setIdProduto(produtoO.get().getIdProduto());
            return new ResponseEntity<ProdutoModel>(produtoRepository.save(produto), HttpStatus.OK);
        }
    }

}