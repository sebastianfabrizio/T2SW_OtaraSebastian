package pe.com.cibertec.t2sw_otarasebastian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.t2sw_otarasebastian.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
