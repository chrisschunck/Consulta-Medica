package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.ReceitaExamesJava;
import br.com.agendamento.domain.ports.in.ReceitaExamesUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas-exames")
@Schema(description="classe ReceitaExames para requisições HTTP")
public class ReceitaExamesController {

    private final ReceitaExamesUseCase useCase;

    public ReceitaExamesController(ReceitaExamesUseCase useCase) {
        this.useCase = useCase;
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
    @Operation(summary="registra um usuário", description="salva os dados cadastrais do usuário registrado")
    @PostMapping
    public ResponseEntity<ReceitaExamesJava> salvar(@Valid @RequestBody ReceitaExamesJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
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
    @Opeariton(summary="busca um usuário por id", description="retorna os dados cadastrais do usuário buscado por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ReceitaExamesJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id), HttpStatus.OK);
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
    @Operation(summary="lista todos os usuários", description="retorna os dados cadastrais do usuário")
    @GetMapping
    public ResponseEntity<List<ReceitaExamesJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
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
    @Operation(summary="deleta um usuário por id", description="remove os dados cadastrais do usuário removido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build().HttpStatus.OK;
    }
}
