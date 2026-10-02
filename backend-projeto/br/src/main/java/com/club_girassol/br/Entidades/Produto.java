package com.club_girassol.br.Entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "produtos")
public class Produto {
    @Id
    private String id;
    private String tipo;
    private String tamanho;
    private String cor;
    private Double preco;
}