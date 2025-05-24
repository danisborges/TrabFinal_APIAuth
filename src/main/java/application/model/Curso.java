package application.model;

import java.util.HashSet;
import java.util.Set;

import application.record.CursoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDoCurso;
    private String descricao;
    private Integer cargaHoraria;

    @OneToMany(mappedBy = "curso")
    private Set<Modulo> modulos = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "matriculas",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Aluno> alunos = new HashSet<>();

    public Curso(CursoDTO dto) {
        this.id = dto.id();
        this.nomeDoCurso = dto.nomeDoCurso();
        this.descricao = dto.descricao();
        this.cargaHoraria = dto.cargaHoraria();
    }
}