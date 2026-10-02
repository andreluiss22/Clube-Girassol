package com.club_girassol.br.Repositores;

import com.club_girassol.br.Entidades.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String> {


    List<Cliente> findByCpf(String cpf);

    @Query("{ 'nome': { $eq: ?0 } }")
    List<Cliente> buscarNomeIgual(String nome);

    @Query("{ 'nome': { $ne: ?0 } }")
    List<Cliente> buscarNomeDiferente(String nome);

    @Query("{ 'nome': { $in: ?0 } }")
    List<Cliente> buscarNomeEm(List<String> nomes);

    @Query("{ 'nome': { $nin: ?0 } }")
    List<Cliente> buscarNomeNaoEm(List<String> nomes);

    @Query("{ $or: [ { 'nome': ?0 }, { 'email': ?1 } ] }")
    List<Cliente> buscarPorNomeOuEmail(String nome, String email);

    @Query("{ $and: [ { 'nome': ?0 }, { 'endereco': ?1 } ] }")
    List<Cliente> buscarPorNomeEEndereco(String nome, String endereco);

    @Query("{ 'email': { $exists: ?0 } }")
    List<Cliente> buscarPorExistenciaDeEmail(boolean existe);
}