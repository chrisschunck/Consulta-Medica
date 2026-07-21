package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import org.springframework.data.jpa.repository.JpaRepository;

@Schema(description="interface LaboratorioHospital para repository Spring Data JPA")
public interface LaboratorioHospitalJpaRepository extends JpaRepository<LaboratorioHospitalJava, Long> {
}
