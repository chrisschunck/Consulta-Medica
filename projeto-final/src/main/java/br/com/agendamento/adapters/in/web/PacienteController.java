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
public class PacienteController {

    private final PacienteUseCase useCase;

    public PacienteController(PacienteUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<PacienteJava> salvar(@Valid @RequestBody PacienteJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PacienteJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
