package br.com.alurachallengebackend7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/depoimentos")
@CrossOrigin // Habilitar CORS para todo o controlador
public class Depoimento_Controller {
    private List<Depoimento> depoimentos = new ArrayList<>();

    // Métodos existentes omitidos para maior clareza

    @GetMapping("/home")
    public ResponseEntity<List<Depoimento>> obterDepoimentosHome() {
        int totalDepoimentos = depoimentos.size();
        int quantidadeExibicao = 3;

        // Verifica se há depoimentos suficientes para a quantidade de exibição
        if (totalDepoimentos <= quantidadeExibicao) {
            return new ResponseEntity<>(depoimentos, HttpStatus.OK);
        }

        List<Depoimento> depoimentosExibicao = new ArrayList<>(depoimentos);
        Collections.shuffle(depoimentosExibicao);

        // Limita o número de depoimentos exibidos
        depoimentosExibicao = depoimentosExibicao.subList(0, quantidadeExibicao);

        return new ResponseEntity<>(depoimentosExibicao, HttpStatus.OK);
    }
}
