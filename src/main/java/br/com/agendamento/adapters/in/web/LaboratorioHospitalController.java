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

    @PostMapping
    public ResponseEntity<LaboratorioHospitalJava> salvar(@Valid @RequestBody LaboratorioHospitalJava entidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(useCase.salvar(entidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioHospitalJava> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<LaboratorioHospitalJava>> listarTodos() {
        return ResponseEntity.ok(useCase.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        useCase.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
