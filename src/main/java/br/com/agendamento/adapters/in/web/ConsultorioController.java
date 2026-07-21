package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.ports.in.ConsultorioUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultorios")
@Schema(description="classe Consultorio para requisições HTTP")
public class ConsultorioController {

    private final ConsultorioUseCase useCase;

    public ConsultorioController(ConsultorioUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<ConsultorioJava> salvar(@Valid @RequestBody ConsultorioJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsultorioJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
