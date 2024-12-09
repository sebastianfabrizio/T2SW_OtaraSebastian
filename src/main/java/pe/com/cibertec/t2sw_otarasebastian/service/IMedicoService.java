package pe.com.cibertec.t2sw_otarasebastian.service;

import pe.com.cibertec.t2sw_otarasebastian.dto.MedicoDto;
import pe.com.cibertec.t2sw_otarasebastian.model.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    List<MedicoDto> getMedicos();
    Optional<MedicoDto> findById(int id);
    Medico save(Medico medico);
}
