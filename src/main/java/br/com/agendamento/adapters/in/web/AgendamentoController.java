package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.AgendamentoJava;
import br.com.agendamento.domain.ports.in.AgendamentoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoUseCase useCase;

    public AgendamentoController(AgendamentoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<AgendamentoJava> salvar(@Valid @RequestBody AgendamentoJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
