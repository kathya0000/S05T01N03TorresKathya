package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.service;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.repositories.FlorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class FlorService {
    private final FlorRepository florRepository;

    public FlorService(FlorRepository florRepository) {
        this.florRepository = florRepository;
    }

    public Mono<FlorDTO> saveFlor(FlorDTO florDTO) {
        return florRepository.addFlor(florDTO);
    }

    public Mono<FlorDTO> updateFlor(Long id, FlorDTO florDTO) {
        return florRepository.updateFlor(id, florDTO);
    }

    public Mono<Void> deleteFlor(Long id) {
        return florRepository.deleteFlor(id);
    }

    public Mono<FlorDTO> getFlorById(Long id) {
        return florRepository.getOneFlor(id);
    }

    public Flux<FlorDTO> getAllFlores() {
        return florRepository.getAllFlores();
    }
}
