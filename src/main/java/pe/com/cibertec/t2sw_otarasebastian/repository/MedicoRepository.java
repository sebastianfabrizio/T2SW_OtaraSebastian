package pe.com.cibertec.t2sw_otarasebastian.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.t2sw_otarasebastian.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
