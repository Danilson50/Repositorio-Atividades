package com.uece.trabalhofilme.web.dto;

import com.uece.trabalhofilme.entity.filme;
import lombok.Getter;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class filmeDto {

    private String id;
    private String titulo;
    private String sinopse;
    private Integer lancamento;
    private String produtores;
    private String artistas;
    private List<avaliacaoDto> avaliacoes;

    public filmeDto() { }

    public filmeDto(filme filme) {
        this.id = filme.getId().toString();
        this.titulo = filme.getTitulo();
        this.sinopse = filme.getSinopse();
        this.lancamento = filme.getLancamento();
        this.produtores = filme.getProdutores();
        this.artistas = filme.getArtistas();
        this.avaliacoes = filme.getAvaliacaofilme().stream().map(avaliacaoDto::new).collect(toList());
    }
}
