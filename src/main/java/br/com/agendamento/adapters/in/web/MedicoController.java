package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.MedicoJava;
import br.com.agendamento.domain.ports.in.MedicoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@Schema(description="classe Medico para requisições HTTP")
public class MedicoController {

    private final MedicoUseCase useCase;

    public MedicoController(MedicoUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(summary="registra um médico", description="salva os dados cadastrais de um médico")
    @PostMapping
    public ResponseEntity<MedicoJava> salvar(@Valid @RequestBody MedicoJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @Operation(summary="busca um médico por id", description="retorna os dados cadastrais do médico buscado")
    @GetMapping("/{id}")
    public ResponseEntity<MedicoJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @Operation(summary="lista todos os médicos", description="retorna uma lista de todos os médicos")
    @GetMapping
    public ResponseEntity<List<MedicoJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @Operation(summary="deleta um médico por id", description="deleta os dados cadastrais do médico removido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
