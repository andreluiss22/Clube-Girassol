package com.club_girassol.br.Repositores;

import com.club_girassol.br.Entidades.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {


    List<Produto> findByTipo(String tipo);

    @Query("{ 'preco': { $gt: ?0 } }")
    List<Produto> buscarPrecoMaiorQue(Double valor);

    @Query("{ 'preco': { $gte: ?0 } }")
    List<Produto> buscarPrecoMaiorOuIgual(Double valor);

    @Query("{ 'preco': { $lt: ?0 } }")
    List<Produto> buscarPrecoMenorQue(Double valor);

    @Query("{ 'preco': { $lte: ?0 } }")
    List<Produto> buscarPrecoMenorOuIgual(Double valor);

    @Query("{ 'preco': { $gt: ?0, $lt: ?1 } }")
    List<Produto> buscarPrecoEntre(Double min, Double max);
}