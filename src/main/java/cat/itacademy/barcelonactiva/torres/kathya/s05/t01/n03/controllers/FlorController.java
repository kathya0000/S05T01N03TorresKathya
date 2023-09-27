package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.controllers;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping
public class FlorController {
    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public Mono<ResponseEntity<FlorDTO>> addFlor(@RequestBody FlorDTO florDTO) {
        return florService.saveFlor(florDTO)
                .map(savedFlor -> new ResponseEntity<>(savedFlor, HttpStatus.CREATED));
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<FlorDTO>> updateFlor(@PathVariable Long id, @RequestBody FlorDTO florDTO) {
        return florService.updateFlor(id, florDTO)
                .map(updatedFlor -> new ResponseEntity<>(updatedFlor, HttpStatus.OK));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> deleteFlor(@PathVariable Long id) {
        return florService.deleteFlor(id)
                .thenReturn(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/getOne/{id}")
    public Mono<ResponseEntity<FlorDTO>> getOneFlor(@PathVariable Long id) {
        return florService.getFlorById(id)
                .map(florDTO -> new ResponseEntity<>(florDTO, HttpStatus.OK));
    }

    @GetMapping("/getAll")
    public ResponseEntity<Flux<FlorDTO>> getAllFlores() {
        Flux<FlorDTO> flores = florService.getAllFlores();
        return ResponseEntity.ok(flores);
    }

}




