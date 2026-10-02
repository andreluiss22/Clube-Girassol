package com.club_girassol.br.Controladores;

import com.club_girassol.br.Entidades.Produto;
import com.club_girassol.br.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    private ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.ok().body(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Produto> buscarProdutoPorId(@PathVariable String id){
        Optional<Produto> produtoPorId = produtoService.buscarProdutoPorId(id);
        if(produtoPorId.isPresent()){
            return ResponseEntity.ok(produtoPorId.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    private ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto produtoNovo = produtoService.criarProduto(produto);
        return ResponseEntity.status(201).body(produtoNovo);
    }


    @PostMapping("/lote")
    private ResponseEntity<List<Produto>> criarProdutos(@RequestBody List<Produto> produtos){
        return ResponseEntity.status(201).body(produtoService.criarProdutos(produtos));
    }


    @PutMapping("/{id}")
    private ResponseEntity<Produto> atualizarProduto(@PathVariable String id, @RequestBody Produto produto){
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.status(200).body(produtoAtualizado);
    }


    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarProduto(@PathVariable String id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/consulta/tipo")
    private ResponseEntity<List<Produto>> buscarPorTipo(@RequestParam String tipo){
        return ResponseEntity.ok(produtoService.buscarPorTipo(tipo));
    }


    @GetMapping("/consulta/gt")
    private ResponseEntity<List<Produto>> precoMaiorQue(@RequestParam Double valor){
        return ResponseEntity.ok(produtoService.precoMaiorQue(valor));
    }


    @GetMapping("/consulta/gte")
    private ResponseEntity<List<Produto>> precoMaiorOuIgual(@RequestParam Double valor){
        return ResponseEntity.ok(produtoService.precoMaiorOuIgual(valor));
    }


    @GetMapping("/consulta/lt")
    private ResponseEntity<List<Produto>> precoMenorQue(@RequestParam Double valor){
        return ResponseEntity.ok(produtoService.precoMenorQue(valor));
    }


    @GetMapping("/consulta/lte")
    private ResponseEntity<List<Produto>> precoMenorOuIgual(@RequestParam Double valor){
        return ResponseEntity.ok(produtoService.precoMenorOuIgual(valor));
    }


    @GetMapping("/consulta/faixa")
    private ResponseEntity<List<Produto>> precoEntre(@RequestParam Double min, @RequestParam Double max){
        return ResponseEntity.ok(produtoService.precoEntre(min, max));
    }
}