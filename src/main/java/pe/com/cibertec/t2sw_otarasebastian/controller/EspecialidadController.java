package pe.com.cibertec.t2sw_otarasebastian.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cibertec.t2sw_otarasebastian.dto.EspecialidadDto;
import pe.com.cibertec.t2sw_otarasebastian.service.IEspecialidadService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/especialidad")
public class EspecialidadController {
    private final IEspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<EspecialidadDto>> listarEspecialidades() {
        return null;
    }
}
