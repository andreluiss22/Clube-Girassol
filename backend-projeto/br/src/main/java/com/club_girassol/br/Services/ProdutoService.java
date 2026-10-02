package com.club_girassol.br.Services;

import com.club_girassol.br.Entidades.Produto;
import com.club_girassol.br.Repositores.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(String id){
        return produtoRepository.findById(id);
    }

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> criarProdutos(List<Produto> produtos){
        return produtoRepository.saveAll(produtos);
    }

    public Produto atualizarProduto(String id, Produto produtoNovo){
        Produto produtoAntigo = produtoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        if(produtoNovo.getTipo() != null){
            produtoAntigo.setTipo(produtoNovo.getTipo());
        }
        if(produtoNovo.getTamanho() != null){
            produtoAntigo.setTamanho(produtoNovo.getTamanho());
        }
        if(produtoNovo.getCor() != null){
            produtoAntigo.setCor(produtoNovo.getCor());
        }
        if(produtoNovo.getPreco() != null){
            produtoAntigo.setPreco(produtoNovo.getPreco());
        }
        return produtoRepository.save(produtoAntigo);
    }

    public void deletarProduto(String id){
        produtoRepository.deleteById(id);
    }


    public List<Produto> buscarPorTipo(String tipo){
        return produtoRepository.findByTipo(tipo);
    }

    public List<Produto> precoMaiorQue(Double valor){
        return produtoRepository.buscarPrecoMaiorQue(valor);
    }

    public List<Produto> precoMaiorOuIgual(Double valor){
        return produtoRepository.buscarPrecoMaiorOuIgual(valor);
    }

    public List<Produto> precoMenorQue(Double valor){
        return produtoRepository.buscarPrecoMenorQue(valor);
    }

    public List<Produto> precoMenorOuIgual(Double valor){
        return produtoRepository.buscarPrecoMenorOuIgual(valor);
    }

    public List<Produto> precoEntre(Double min, Double max){
        return produtoRepository.buscarPrecoEntre(min, max);
    }
}