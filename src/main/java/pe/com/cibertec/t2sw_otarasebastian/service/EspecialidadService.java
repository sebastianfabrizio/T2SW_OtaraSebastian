package pe.com.cibertec.t2sw_otarasebastian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.cibertec.t2sw_otarasebastian.model.Especialidad;
import pe.com.cibertec.t2sw_otarasebastian.repository.EspecialidadRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EspecialidadService implements IEspecialidadService {

    private final EspecialidadRepository especialidadRepository;


    @Override
    public List<Especialidad> getEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Optional<Especialidad> findById(int id) {
        return especialidadRepository.findById(id);
    }

    @Override
    public Especialidad save(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }
}
