package pe.com.cibertec.t2sw_otarasebastian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.t2sw_otarasebastian.model.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository <Especialidad, Integer> {
}
