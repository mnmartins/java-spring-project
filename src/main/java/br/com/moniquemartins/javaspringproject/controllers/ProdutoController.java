package br.com.moniquemartins.javaspringproject.controllers;

import org.springframework.web.bind.annotation.RestController;

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
public class ProdutoController {
    
}