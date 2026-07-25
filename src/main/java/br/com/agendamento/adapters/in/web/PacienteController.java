package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.PacienteJava;
import br.com.agendamento.domain.ports.in.PacienteUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@Schema(description="classe Paciente para requisições HTTP")
public class PacienteController {

    private final PacienteUseCase useCase;

    public PacienteController(PacienteUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(summary="registra um paciente", description="salva os dados cadastrais do paciente registrado")
    @PostMapping
    public ResponseEntity<PacienteJava> salvar(@Valid @RequestBody PacienteJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @Operation(summary="busca um paciente por id", description="retorna os dados cadastrais do paciente")
    @GetMapping("/{id}")
    public ResponseEntity<PacienteJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @Operation(summary="lista todos os pacientes", description="retorna os dados cadastrais do paciente")
    @GetMapping
    public ResponseEntity<List<PacienteJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @Operation(summary="deleta o usuário por id", description="deleta os dados cadastrais do usuário removido por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
