package cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.repositories;

import cat.itacademy.barcelonactiva.torres.kathya.s05.t01.n03.DTO.FlorDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class FlorRepository {
    private final WebClient webClient;

    public FlorRepository(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9001").build();
    }

    public Mono<FlorDTO> addFlor(FlorDTO florDTO) {
        return webClient.post()
                .uri("/add")
                .bodyValue(florDTO)
                .retrieve()
                .bodyToMono(FlorDTO.class);
    }

    public Mono<FlorDTO> updateFlor(Long id, FlorDTO florDTO) {
        return webClient.put()
                .uri("/update/{id}", id)
                .bodyValue(florDTO)
                .retrieve()
                .bodyToMono(FlorDTO.class);
    }

    public Mono<Void> deleteFlor(Long id) {
        return webClient.delete()
                .uri("/delete/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<FlorDTO> getOneFlor(Long id) {
        return webClient.get()
                .uri("/getOne/{id}", id)
                .retrieve()
                .bodyToMono(FlorDTO.class);
    }

    public Flux<FlorDTO> getAllFlores() {
        return webClient.get()
                .uri("/getAll")
                .retrieve()
                .bodyToFlux(FlorDTO.class);
    }
}

