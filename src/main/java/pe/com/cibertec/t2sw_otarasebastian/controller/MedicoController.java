package pe.com.cibertec.t2sw_otarasebastian.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cibertec.t2sw_otarasebastian.dto.MedicoDto;
import pe.com.cibertec.t2sw_otarasebastian.exception.ResourceNotFoundException;
import pe.com.cibertec.t2sw_otarasebastian.model.Medico;
import pe.com.cibertec.t2sw_otarasebastian.service.IMedicoService;

import java.lang.module.ResolutionException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/medico")
public class MedicoController {

    private final IMedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoDto>> ListaMedicos() {
        List<MedicoDto> medicos = medicoService.getMedicos();
        if(medicos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDto> ObtenerIdMedico(@PathVariable Integer id) {
        MedicoDto valorId = medicoService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("El médico con el identificador número " + id + " no existe"));
        return new ResponseEntity<>(valorId, HttpStatus.OK);
    }


}
