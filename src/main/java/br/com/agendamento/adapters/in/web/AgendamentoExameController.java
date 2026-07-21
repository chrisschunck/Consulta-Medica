package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.AgendamentoExameJava;
import br.com.agendamento.domain.ports.in.AgendamentoExameUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/agendamentos-exames")
@Schema(description="classe AgendamentoExame para requisições HTTP")
public class AgendamentoExameController {

    private final AgendamentoExameUseCase useCase;

    public AgendamentoExameController(AgendamentoExameUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<AgendamentoExameJava> salvar(@Valid @RequestBody AgendamentoExameJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoExameJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoExameJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
