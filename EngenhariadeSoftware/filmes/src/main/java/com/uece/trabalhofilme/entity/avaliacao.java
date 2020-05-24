package com.uece.trabalhofilme.entity;

import com.sun.istack.NotNull;
import com.uece.trabalhofilme.web.dto.avaliacaoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import static org.springframework.util.ObjectUtils.isEmpty;


@Entity
@Table(name = "avaliacao")
public class avaliacao {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @NotNull
    @Column(name = "usuario")
    private String usuario;

    @Getter
    @Setter
    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Getter
    @Setter
    @Column(name = "voto")
    private Integer voto;

    @Getter
    @Setter
    @Column(name = "filme")
    private Long filme;

    public avaliacao() { }

    public avaliacao(avaliacaoDto avaliacaoDto) {
        this.id = isEmpty(avaliacaoDto.getId()) ? null : Integer.parseInt(avaliacaoDto.getId());
        this.usuario = avaliacaoDto.getUsuario();
        this.comentario = avaliacaoDto.getComentario();
        this.voto = isEmpty(avaliacaoDto.getVoto()) ? null : Integer.parseInt(avaliacaoDto.getVoto());
    }
}
