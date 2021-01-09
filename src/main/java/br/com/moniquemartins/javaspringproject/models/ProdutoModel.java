package br.com.moniquemartins.javaspringproject.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * O model é um objeto que será a representação do recurso na URI da API. Este model
 * será um Produto com atributos como: idProduto, nome e valor.
 */
@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduto;
    private String nome;
    private BigDecimal valor;

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}