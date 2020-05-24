package com.uece.trabalhofilme.web.dto;

import com.uece.trabalhofilme.entity.avaliacao;
import lombok.Data;

@Data
public class avaliacaoDto {
    private String id;
    private String usuario;
    private String comentario;
    private String voto;
    private String filme;

    public avaliacaoDto() { }

    public avaliacaoDto(avaliacao avaliacao) {
        this.id = avaliacao.getId().toString();
        this.usuario = avaliacao.getUsuario();
        this.comentario = avaliacao.getComentario();
        this.voto = avaliacao.getVoto().toString();
        this.filme = avaliacao.getFilme().toString();
    }

}

