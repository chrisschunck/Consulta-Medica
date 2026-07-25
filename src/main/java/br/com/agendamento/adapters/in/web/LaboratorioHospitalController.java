package br.com.agendamento.adapters.in.web;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import br.com.agendamento.domain.ports.in.LaboratorioHospitalUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Operation(summary="", description="")
    @PostMapping
    public ResponseEntity<LaboratorioHospitalJava> salvar(@Valid @RequestBody LaboratorioHospitalJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @Operation=(summary="busca um laboratório ou hospital por id", description="retorna os dados cadastrais do laboratório ou hospital buscado por id")
    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioHospitalJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @Operation(summary="lista os laboratórios ou hospitais", description="retorna uma lista de laboratórios ou hospitais")
    @GetMapping
    public ResponseEntity<List<LaboratorioHospitalJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @Operation(summary="deleta um laboratório ou hospital por id", description="remove os dados cadastrais do laboratório ou hospital removido")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
