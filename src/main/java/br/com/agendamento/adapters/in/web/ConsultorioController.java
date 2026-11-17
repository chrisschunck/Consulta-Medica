package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.ConsultorioJava;
import br.com.agendamento.domain.ports.in.ConsultorioUseCase;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary="registra um consultório", description="salva os dados cadastrais do consultório")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @PostMapping
    public ResponseEntity<ConsultorioJava> salvar(@Valid @RequestBody ConsultorioJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    
    @Operation(summary="busca um consultório por id", description="retorna os dados cadastrais do consultório buscado por id")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id), HttpStatus.OK);
    }

    
    @Operation(summary="lista todos os consultórios", description="retorna uma lista de consultórios disponiveis")
    @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    @GetMapping
    public ResponseEntity<List<ConsultorioJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos(), HttpStatus.OK);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="OK")
    @ApiResponse(responseCode="201", description="CREATED")
    @ApiResponse(responseCode="204", description="NO CONTENT")
    @ApiResponse(responseCode="400", description="BAD REQUEST")
    @ApiResponse(responseCode="401", description="Unauthorized")
    @ApiResponse(responseCode="403", description="Forbidden")
    @ApiResponse(responseCode="404", description="Not Found")
    @ApiResponse(responseCode="500", description="Internal Error")
    })
    @Operation(summary="deleta um consultório por id", description="remove os dados cadastratis do consultório removido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build().HttpStatus.OK;
    }
}
