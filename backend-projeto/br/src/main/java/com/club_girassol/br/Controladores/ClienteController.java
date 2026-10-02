package com.club_girassol.br.Controladores;

import com.club_girassol.br.Entidades.Cliente;
import com.club_girassol.br.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @GetMapping
    private ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.ok().body(clienteService.listarClientes());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Cliente> buscarClientePorId(@PathVariable String id){
        Optional<Cliente> clientePorId = clienteService.buscarClientePorId(id);
        if(clientePorId.isPresent()){
            return ResponseEntity.ok(clientePorId.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    private ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        Cliente clienteNovo = clienteService.criarCliente(cliente);
        return ResponseEntity.status(201).body(clienteNovo);
    }


    @PostMapping("/lote")
    private ResponseEntity<List<Cliente>> criarClientes(@RequestBody List<Cliente> clientes){
        return ResponseEntity.status(201).body(clienteService.criarClientes(clientes));
    }


    @PutMapping("/{id}")
    private ResponseEntity<Cliente> atualizarCliente(@PathVariable String id, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.status(200).body(clienteAtualizado);
    }


    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarCliente(@PathVariable String id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/consulta/cpf")
    private ResponseEntity<List<Cliente>> buscarPorCpf(@RequestParam String cpf){
        return ResponseEntity.ok(clienteService.buscarPorCpf(cpf));
    }


    @GetMapping("/consulta/eq")
    private ResponseEntity<List<Cliente>> nomeIgual(@RequestParam String nome){
        return ResponseEntity.ok(clienteService.nomeIgual(nome));
    }


    @GetMapping("/consulta/ne")
    private ResponseEntity<List<Cliente>> nomeDiferente(@RequestParam String nome){
        return ResponseEntity.ok(clienteService.nomeDiferente(nome));
    }


    @GetMapping("/consulta/in")
    private ResponseEntity<List<Cliente>> nomeEm(@RequestParam List<String> nomes){
        return ResponseEntity.ok(clienteService.nomeEm(nomes));
    }


    @GetMapping("/consulta/nin")
    private ResponseEntity<List<Cliente>> nomeNaoEm(@RequestParam List<String> nomes){
        return ResponseEntity.ok(clienteService.nomeNaoEm(nomes));
    }


    @GetMapping("/consulta/or")
    private ResponseEntity<List<Cliente>> nomeOuEmail(@RequestParam String nome, @RequestParam String email){
        return ResponseEntity.ok(clienteService.nomeOuEmail(nome, email));
    }


    @GetMapping("/consulta/and")
    private ResponseEntity<List<Cliente>> nomeEEndereco(@RequestParam String nome, @RequestParam String endereco){
        return ResponseEntity.ok(clienteService.nomeEEndereco(nome, endereco));
    }

    @GetMapping("/consulta/exists")
    private ResponseEntity<List<Cliente>> existenciaDeEmail(@RequestParam(defaultValue = "true") boolean existe){
        return ResponseEntity.ok(clienteService.existenciaDeEmail(existe));
    }
}