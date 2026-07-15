package br.com.agendamento.adapters.out.persistence;

import br.com.agendamento.domain.model.LaboratorioHospitalJava;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratorioHospitalJpaRepository extends JpaRepository<LaboratorioHospitalJava, Long> {
}
