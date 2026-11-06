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
@Schema(description="classe Agendamento para requisições HTTP")
public class AgendamentoController {

    private final AgendamentoUseCase useCase;

    public AgendamentoController(AgendamentoUseCase useCase) {
        this.useCase = useCase;
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation(summary="registra um agendamento", description="salva os dados cadastrais do agendamento")
    @PostMapping
    public ResponseEntity<AgendamentoJava> salvar(@Valid @RequestBody AgendamentoJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation(summary="busca um agendamento por id", description="retorna os dados cadastrais do agendamento buscado por id")
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation(summary="lista todos os agendamentos", description="retorna uma lista de todos os agendamentos disponiveis")
    @GetMapping
    public ResponseEntity<List<AgendamentoJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation(summary="deleta um agendamento por id", description="deleta os dados cadastrais de agendamento removido por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
