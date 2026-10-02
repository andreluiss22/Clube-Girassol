package com.club_girassol.br.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
}