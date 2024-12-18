package pe.com.cibertec.t2sw_otarasebastian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.cibertec.t2sw_otarasebastian.dto.EspecialidadDto;
import pe.com.cibertec.t2sw_otarasebastian.dto.MedicoDto;
import pe.com.cibertec.t2sw_otarasebastian.exception.ResourceNotFoundException;
import pe.com.cibertec.t2sw_otarasebastian.model.Especialidad;
import pe.com.cibertec.t2sw_otarasebastian.model.Medico;
import pe.com.cibertec.t2sw_otarasebastian.repository.EspecialidadRepository;
import pe.com.cibertec.t2sw_otarasebastian.repository.MedicoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EspecialidadService implements IEspecialidadService {

    private final EspecialidadRepository especialidadRepository;
    private final MedicoRepository medicoRepository;


    @Override
    public List<EspecialidadDto> getEspecialidades() {
        List<Especialidad> especialidades = especialidadRepository.findAll();
        List<EspecialidadDto> especialidadDtos = new ArrayList<>();
        for (Especialidad especialidad : especialidades) {
            especialidadDtos.add(EspecialidadDto.builder()
                    .idespecialidad(especialidad.getIdespecialidad())
                    .titulo(especialidad.getTitulo())
                    .funcion(especialidad.getFuncion())
                    .fechgraduacion(especialidad.getFechgraduacion())
                    .idmedico(especialidad.getMedico() != null ? especialidad.getMedico().getIdmedico() : null)
                    .build());
        }
        return especialidadDtos;
    }

    @Override
    public Optional<EspecialidadDto> findById(int id) {
        Optional<Especialidad> especialidad = especialidadRepository.findById(id);
        return especialidad.map(e -> EspecialidadDto.builder()
                .idespecialidad(e.getIdespecialidad())
                .titulo(e.getTitulo())
                .funcion(e.getFuncion())
                .fechgraduacion(e.getFechgraduacion())
                .idmedico(e.getMedico() != null ? e.getMedico().getIdmedico() : null)
                .build());
    }

    @Override
    public EspecialidadDto save(EspecialidadDto especialidadDto) {
        Especialidad especialidad;

        Medico medico = medicoRepository.findById(especialidadDto.getIdmedico())
                .orElseThrow(() -> new ResourceNotFoundException("Médico no encontrado con el id: " + especialidadDto.getIdmedico()));

        if (especialidadDto.getIdespecialidad() != null && especialidadRepository.existsById(especialidadDto.getIdespecialidad())) {
            especialidad = especialidadRepository.findById(especialidadDto.getIdespecialidad()).orElseThrow(() ->
                    new ResourceNotFoundException("Especialidad no encontrada con el id: " + especialidadDto.getIdespecialidad()));
            especialidad.setTitulo(especialidadDto.getTitulo());
            especialidad.setFuncion(especialidadDto.getFuncion());
            especialidad.setFechgraduacion(especialidadDto.getFechgraduacion());
        } else {
            especialidad = new Especialidad();
            especialidad.setTitulo(especialidadDto.getTitulo());
            especialidad.setFuncion(especialidadDto.getFuncion());
            especialidad.setFechgraduacion(especialidadDto.getFechgraduacion());
        }

        especialidad.setMedico(medico);
        Especialidad savedEspecialidad = especialidadRepository.save(especialidad);

        return EspecialidadDto.builder()
                .idespecialidad(savedEspecialidad.getIdespecialidad())
                .titulo(savedEspecialidad.getTitulo())
                .funcion(savedEspecialidad.getFuncion())
                .fechgraduacion(savedEspecialidad.getFechgraduacion())
                .idmedico(savedEspecialidad.getMedico().getIdmedico())
                .build();
    }

}
