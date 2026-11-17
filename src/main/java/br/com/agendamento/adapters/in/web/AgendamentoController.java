package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.AgendamentoJava;
import br.com.agendamento.domain.ports.in.AgendamentoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

   
    @Operation(summary="registra um agendamento", description="salva os dados cadastrais do agendamento")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @PostMapping
    public ResponseEntity<AgendamentoJava> salvar(@Valid @RequestBody AgendamentoJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    
    @Operation(summary="busca um agendamento por id", description="retorna os dados cadastrais do agendamento buscado por id")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id), HttpStatus.OK);
    }

    
    @Operation(summary="lista todos os agendamentos", description="retorna uma lista de todos os agendamentos disponiveis")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @GetMapping
    public ResponseEntity<List<AgendamentoJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos(), HttpStatus.OK);
    }

    
    @Operation(summary="deleta um agendamento por id", description="deleta os dados cadastrais de agendamento removido por id")
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
