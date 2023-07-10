package br.com.alurachallengebackend7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depoimento {
    private String foto;
    private String depoimento;
    private String nome;
}
