package com.uece.trabalhofilme.entity;

import com.uece.trabalhofilme.web.dto.filmeDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import static org.springframework.util.ObjectUtils.isEmpty;

@Entity
@Table(name = "filme")
public class filme {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String titulo;

    @Getter
    @Setter
    @Column(nullable = false)
    private String sinopse;

    @Getter
    @Setter
    @Column(name = "lancamento", nullable = false)
    private Integer lancamento;

    @Getter
    @Setter
    @Column(name = "produtores", nullable = false)
    private String produtores;

    @Getter
    @Setter
    @Column(name = "artistas", nullable = false)
    private String artistas;

    @Getter
    @Setter
    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL)
    private List<avaliacao> avaliacaofilme;

    public filme() { }

    public filme(filmeDto filmeDto) {
        this.id = isEmpty(filmeDto.getId()) ? null : Integer.parseInt(filmeDto.getId());
        this.titulo = filmeDto.getTitulo();
        this.sinopse = filmeDto.getSinopse();
        this.lancamento = filmeDto.getLancamento();
        this.produtores = filmeDto.getProdutores();
        this.artistas = filmeDto.getArtistas();
    }

}
