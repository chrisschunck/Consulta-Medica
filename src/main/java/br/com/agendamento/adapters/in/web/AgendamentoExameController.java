package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.AgendamentoExameJava;
import br.com.agendamento.domain.ports.in.AgendamentoExameUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import java.util.List;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @PostMapping
    public ResponseEntity<AgendamentoExameJava> salvar(@Valid @RequestBody AgendamentoExameJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }
    
    
    @Operation(summary="busca um agendamento de exame por id", description="retorna os dados cadastrais do agendamento de exame")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoExameJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id), HttpStatus.OK);
    }

   
    @Operation(summary="lista todos os agendamentos de exames", description="retorna uma lista de todos os agendamentos de exame disponiveis")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @GetMapping
    public ResponseEntity<List<AgendamentoExameJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos(), HttpStatus.OK);
    }

    @Operation(summary="deleta um agendamento de exame por id", description="deleta os dados cadastrais do agendamento de examge removido por id")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build().HttpStatus.OK;
    }
}
