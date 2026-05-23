package ms_hilos.ms_hilos.controller;

import ms_hilos.ms_hilos.dto.HiloRequestDTO;
import ms_hilos.ms_hilos.dto.HiloResponseDTO;
import ms_hilos.ms_hilos.service.HiloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hilos")
public class HiloController {

    @Autowired
    private HiloService service;

    @PostMapping
    public ResponseEntity<HiloResponseDTO> crear(@Valid @RequestBody HiloRequestDTO request) {
        HiloResponseDTO response = service.crearHilo(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Aquí está el blindaje del "id" para que no tire error 500
    @GetMapping("/{id}")
    public ResponseEntity<HiloResponseDTO> obtenerPorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.obtenerPorId(id), HttpStatus.OK);
    }
}
