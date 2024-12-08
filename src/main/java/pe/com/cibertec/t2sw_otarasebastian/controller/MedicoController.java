package pe.com.cibertec.t2sw_otarasebastian.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cibertec.t2sw_otarasebastian.model.Medico;
import pe.com.cibertec.t2sw_otarasebastian.service.IMedicoService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/medico")
public class MedicoController {

    private final IMedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> listaMedicos() {
        return null;
    }


}
