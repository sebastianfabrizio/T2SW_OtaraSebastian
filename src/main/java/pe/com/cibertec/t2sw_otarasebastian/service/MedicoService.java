package pe.com.cibertec.t2sw_otarasebastian.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.cibertec.t2sw_otarasebastian.dto.MedicoDto;
import pe.com.cibertec.t2sw_otarasebastian.model.Medico;
import pe.com.cibertec.t2sw_otarasebastian.repository.MedicoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicoService implements IMedicoService{

    private final MedicoRepository medicoRepository;

    @Override
    public List<MedicoDto> getMedicos() {
        List<Medico> medicos =  medicoRepository.findAll();
        List<MedicoDto> medicoDtos = new ArrayList<>();
        for(Medico medico : medicos){
            medicoDtos.add(MedicoDto.builder()
                    .idmedico(medico.getIdmedico())
                    .nommedico(medico.getNommedico())
                    .apemedico(medico.getApemedico())
                    .fechnacmedico(medico.getFechnacmedico())
                    .build());
        }
        return medicoDtos;
    }

    @Override
    public Optional<MedicoDto> findById(int id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.map(m -> MedicoDto.builder()
                .idmedico(m.getIdmedico())
                .nommedico(m.getNommedico())
                .apemedico(m.getApemedico())
                .fechnacmedico(m.getFechnacmedico())
                .build());
    }


    @Override
    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }
}
