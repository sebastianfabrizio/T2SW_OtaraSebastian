package pe.com.cibertec.t2sw_otarasebastian.service;

import pe.com.cibertec.t2sw_otarasebastian.dto.EspecialidadDto;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    List<EspecialidadDto> getEspecialidades();
    Optional<EspecialidadDto> findById(int id);
    EspecialidadDto save(EspecialidadDto especialidadDto);
}
