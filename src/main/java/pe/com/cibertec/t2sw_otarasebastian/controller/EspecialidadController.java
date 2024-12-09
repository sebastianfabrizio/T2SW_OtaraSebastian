package pe.com.cibertec.t2sw_otarasebastian.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.cibertec.t2sw_otarasebastian.dto.EspecialidadDto;
import pe.com.cibertec.t2sw_otarasebastian.exception.ResourceNotFoundException;
import pe.com.cibertec.t2sw_otarasebastian.service.IEspecialidadService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/especialidad")
public class EspecialidadController {
    private final IEspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<EspecialidadDto>> listarEspecialidades() {
        List<EspecialidadDto> especialidades = especialidadService.getEspecialidades();
        if(especialidades.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
        public ResponseEntity<EspecialidadDto> ObtenerIdEspecialidad(@PathVariable Integer id) {
        EspecialidadDto valorId = especialidadService.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("La especialidad con el identificador número " + id + " no existe"));
        return new ResponseEntity<>(valorId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EspecialidadDto> GuardarEspecialidad(@RequestBody EspecialidadDto especialidadDto){
        return new ResponseEntity<>(especialidadService.save(especialidadDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadDto> ActualizarEspecialidad(@PathVariable int id, @RequestBody EspecialidadDto especialidadDto){

    }

}
