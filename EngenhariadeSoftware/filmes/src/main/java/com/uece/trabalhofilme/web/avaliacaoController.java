package com.uece.trabalhofilme.web;


import com.uece.trabalhofilme.entity.avaliacao;
import com.uece.trabalhofilme.repository.avaliacaoRepository;
import com.uece.trabalhofilme.web.dto.avaliacaoDto;
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
@RequestMapping(avaliacaoController.RESOURCE)
public class avaliacaoController {

    protected static final String RESOURCE = "/avaliacoes";

    private final avaliacaoRepository avaliacaoRepository;

    public avaliacaoController(avaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<avaliacaoDto>> getAll() {
        List<avaliacao> avaliacoes = avaliacaoRepository.findAll();
        if (isEmpty(avaliacoes)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(avaliacoes.stream().map(avaliacaoDto::new).collect(toList()));
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<avaliacaoDto> getById(@PathVariable Integer id) {
        Optional<avaliacao> optional = avaliacaoRepository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new avaliacaoDto(optional.get()));
    }
    @Transactional
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody avaliacaoDto avaliacaoDto, UriComponentsBuilder uriComponentsBuilder) {
        avaliacao avaliacao = avaliacaoRepository.save(new avaliacao(avaliacaoDto));
        URI uri = uriComponentsBuilder.path(RESOURCE + "/{id}").buildAndExpand(avaliacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<avaliacao> avaliacao = avaliacaoRepository.findById(id);
        if (avaliacao.isPresent()) {
            avaliacaoRepository.delete(avaliacao.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody avaliacaoDto avaliacaoDto) {
        Optional<avaliacao> optional = avaliacaoRepository.findById(Integer.parseInt(avaliacaoDto.getId()));
        if (optional.isPresent()) {
            avaliacao avaliacao = optional.get();
            avaliacao.setUsuario(avaliacaoDto.getUsuario());
            avaliacao.setComentario(avaliacaoDto.getComentario());
            avaliacao.setVoto(Integer.parseInt(avaliacaoDto.getVoto()));
            avaliacaoRepository.save(avaliacao);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
