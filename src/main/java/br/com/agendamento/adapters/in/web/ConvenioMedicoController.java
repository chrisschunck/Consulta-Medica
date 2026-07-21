package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.ConvenioMedicoJava;
import br.com.agendamento.domain.ports.in.ConvenioMedicoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/convenios")
@Schema(description="classe ConvenioMedico para requisições HTTP")
public class ConvenioMedicoController {

    private final ConvenioMedicoUseCase useCase;

    public ConvenioMedicoController(ConvenioMedicoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<ConvenioMedicoJava> salvar(@Valid @RequestBody ConvenioMedicoJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConvenioMedicoJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ConvenioMedicoJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
