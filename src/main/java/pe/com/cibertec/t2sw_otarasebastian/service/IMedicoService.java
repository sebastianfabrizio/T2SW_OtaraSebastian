package pe.com.cibertec.t2sw_otarasebastian.service;

import pe.com.cibertec.t2sw_otarasebastian.dto.MedicoDto;

import java.util.List;
import java.util.Optional;

public interface IMedicoService {
    List<MedicoDto> getMedicos();

    Optional<MedicoDto> findById(int id);

    MedicoDto save(MedicoDto medicoDto);
}
