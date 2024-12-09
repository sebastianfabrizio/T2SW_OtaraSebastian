package pe.com.cibertec.t2sw_otarasebastian.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.com.cibertec.t2sw_otarasebastian.service.IFileService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    private final IFileService fileService;


        @PostMapping("/imagen")
        public ResponseEntity<String> subirArchivo(@RequestParam("file") MultipartFile file) {
            try {
                if (file.isEmpty()) {
                    return new ResponseEntity<>("El archivo está vacío.", HttpStatus.BAD_REQUEST);
                }

                fileService.guardarArchivo(file);
                return new ResponseEntity<>("Se subió un archivo.", HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>("Error en servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }



    }