package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.ReceitaExamesJava;
import br.com.agendamento.domain.ports.in.ReceitaExamesUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas-exames")
@Schema(description="classe ReceitaExames para requisições HTTP")
public class ReceitaExamesController {

    private final ReceitaExamesUseCase useCase;

    public ReceitaExamesController(ReceitaExamesUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(summary="registra um usuário", description="salva os dados cadastrais do usuário registrado")
    @PostMapping
    public ResponseEntity<ReceitaExamesJava> salvar(@Valid @RequestBody ReceitaExamesJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @Opeariton(summary="busca um usuário por id", description="retorna os dados cadastrais do usuário buscado por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ReceitaExamesJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @Operation(summary="lista todos os usuários", description="retorna os dados cadastrais do usuário")
    @GetMapping
    public ResponseEntity<List<ReceitaExamesJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @Operation(summary="deleta um usuário por id", description="remove os dados cadastrais do usuário removido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
