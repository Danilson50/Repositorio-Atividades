package com.uece.trabalhofilme.web;

import com.uece.trabalhofilme.entity.filme;
import com.uece.trabalhofilme.repository.filmeRepository;
import com.uece.trabalhofilme.web.dto.filmeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(filmeController.RESOURCE)
public class filmeController {

    protected static final String RESOURCE = "/filmes";

    private filmeRepository filmeRepository;

    public filmeController(filmeRepository filmeRepository) {

        this.filmeRepository = filmeRepository;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<filmeDto>> getAll() {
        List<filme> filme = filmeRepository.findAll();
        if (isEmpty(filme)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(filme.stream().map(filmeDto::new).collect(toList()));
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<filmeDto> getById(@PathVariable Integer id) {
        Optional<filme> optional = filmeRepository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new filmeDto(optional.get()));
    }

    @Transactional
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody filmeDto filmeDto, UriComponentsBuilder uriComponentsBuilder) {
        filme filme = filmeRepository.save(new filme(filmeDto));
        URI uri = uriComponentsBuilder.path(RESOURCE + "/{id}").buildAndExpand(filme.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<filme> filme = filmeRepository.findById(id);
        if (filme.isPresent()) {
            filmeRepository.delete(filme.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable Integer id, @RequestBody filmeDto filmeDto) {
        Optional<filme> optional = filmeRepository.findById(id);
        if (optional.isPresent()) {
            filme filme = optional.get();
            filme.setTitulo(filmeDto.getTitulo());
            filme.setSinopse(filmeDto.getSinopse());
            filme.setLancamento(filmeDto.getLancamento());
            filme.setProdutores(filmeDto.getProdutores());
            filme.setArtistas(filmeDto.getArtistas());
            filmeRepository.save(filme);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
