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
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="201", description="Evento válidado", name="Response validado")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation(summary="", description="")
    @PostMapping
    public ResponseEntity<LaboratorioHospitalJava> salvar(@Valid @RequestBody LaboratorioHospitalJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="201", description="Evento válidado", name="Response validado")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation=(summary="busca um laboratório ou hospital por id", description="retorna os dados cadastrais do laboratório ou hospital buscado por id")
    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioHospitalJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="201", description="Evento válidado", name="Response validado")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation(summary="lista os laboratórios ou hospitais", description="retorna uma lista de laboratórios ou hospitais")
    @GetMapping
    public ResponseEntity<List<LaboratorioHospitalJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Evento com sucesso", name="Response sucesso, "ok"")
        @ApiResponse(responseCode="201", description="Evento válidado", name="Response validado")
        @ApiResponse(responseCode="400", description="Response com data invalidada", name="Requisição ruim")
        @ApiResponse(responseCode="401", description="Evento inválido ou token inacessivel", name="Response não autorizado")
        @ApiResponse(responseCode="404", description="Evento não encontrado", name="Response não encontrato")
        @ApiResponse(responseCode="500", description="Evento sem servidor no ar", name="Response com erro no servidor")
    })
    @Operation(summary="deleta um laboratório ou hospital por id", description="remove os dados cadastrais do laboratório ou hospital removido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
