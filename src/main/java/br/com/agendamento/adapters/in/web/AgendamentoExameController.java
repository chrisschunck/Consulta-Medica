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

    @Operation(summary="registra um agendamento de exame", description="salva os dados cadastrais do agendamento de exame")
    @PostMapping
    public ResponseEntity<AgendamentoExameJava> salvar(@Valid @RequestBody AgendamentoExameJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @Operation(summary="busca um agendamento de exame por id", description="retorna os dados cadastrais do agendamento de exame")
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoExameJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @Operation(summary="lista todos os agendamentos de exames", description="retorna uma lista de todos os agendamentos de exame disponiveis")
    @GetMapping
    public ResponseEntity<List<AgendamentoExameJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @Operation(summary="deleta um agendamento de exame por id", description="deleta os dados cadastrais do agendamento de examge removido por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
