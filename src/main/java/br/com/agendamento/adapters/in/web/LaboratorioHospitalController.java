package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import br.com.agendamento.domain.ports.in.LaboratorioHospitalUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratorios-hospitais")
@Schema(description="classe LaboratorioHospital para requisições HTTP")
public class LaboratorioHospitalController {

    private final LaboratorioHospitalUseCase useCase;

    public LaboratorioHospitalController(LaboratorioHospitalUseCase useCase) {
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
    @Operation(summary="", description="")
    @PostMapping
    public ResponseEntity<LaboratorioHospitalJava> salvar(@Valid @RequestBody LaboratorioHospitalJava entidade) {
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
    @Operation=(summary="busca um laboratório ou hospital por id", description="retorna os dados cadastrais do laboratório ou hospital buscado por id")
    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioHospitalJava> buscarPorId(@PathVariable Long id) {
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
    @Operation(summary="lista os laboratórios ou hospitais", description="retorna uma lista de laboratórios ou hospitais")
    @GetMapping
    public ResponseEntity<List<LaboratorioHospitalJava>> listarTodos() {
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
    @Operation(summary="deleta um laboratório ou hospital por id", description="remove os dados cadastrais do laboratório ou hospital removido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build().HttpStatus.OK;
    }
}
