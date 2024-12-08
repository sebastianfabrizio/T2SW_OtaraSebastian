package pe.com.cibertec.t2sw_otarasebastian.service;

import pe.com.cibertec.t2sw_otarasebastian.model.Especialidad;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    List<Especialidad> getEspecialidades();
    Optional<Especialidad> findById(int id);
    Especialidad save(Especialidad especialidad);
}
