package com.club_girassol.br.Services;

import com.club_girassol.br.Entidades.Cliente;
import com.club_girassol.br.Repositores.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarClientePorId(String id){
        return clienteRepository.findById(id);
    }

    public Cliente criarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> criarClientes(List<Cliente> clientes){
        return clienteRepository.saveAll(clientes);
    }

    public Cliente atualizarCliente(String id, Cliente clienteNovo){
        Cliente clienteAntigo = clienteRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
        if(clienteNovo.getNome() != null){
            clienteAntigo.setNome(clienteNovo.getNome());
        }
        if(clienteNovo.getEndereco() != null){
            clienteAntigo.setEndereco(clienteNovo.getEndereco());
        }
        if(clienteNovo.getCpf() != null){
            clienteAntigo.setCpf(clienteNovo.getCpf());
        }
        if(clienteNovo.getTelefone() != null){
            clienteAntigo.setTelefone(clienteNovo.getTelefone());
        }
        if(clienteNovo.getEmail() != null){
            clienteAntigo.setEmail(clienteNovo.getEmail());
        }
        return clienteRepository.save(clienteAntigo);
    }

    public void deletarCliente(String id){
        clienteRepository.deleteById(id);
    }


    public List<Cliente> buscarPorCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> nomeIgual(String nome){
        return clienteRepository.buscarNomeIgual(nome);
    }

    public List<Cliente> nomeDiferente(String nome){
        return clienteRepository.buscarNomeDiferente(nome);
    }

    public List<Cliente> nomeEm(List<String> nomes){
        return clienteRepository.buscarNomeEm(nomes);
    }

    public List<Cliente> nomeNaoEm(List<String> nomes){
        return clienteRepository.buscarNomeNaoEm(nomes);
    }

    public List<Cliente> nomeOuEmail(String nome, String email){
        return clienteRepository.buscarPorNomeOuEmail(nome, email);
    }

    public List<Cliente> nomeEEndereco(String nome, String endereco){
        return clienteRepository.buscarPorNomeEEndereco(nome, endereco);
    }

    public List<Cliente> existenciaDeEmail(boolean existe){
        return clienteRepository.buscarPorExistenciaDeEmail(existe);
    }
}