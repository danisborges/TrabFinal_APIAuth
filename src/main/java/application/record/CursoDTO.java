package application.record;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import application.model.Curso;

public record CursoDTO(
    Long id,
    String nomeDoCurso,
    String descricao,
    Integer cargaHoraria,
    Set<ModuloDTO> modulos,
    Set<AlunoDTO> alunos
) {
    public CursoDTO(Curso curso) {
        this(
            curso.getId(),
            curso.getNomeDoCurso(),
            curso.getDescricao(),
            curso.getCargaHoraria(),
            curso.getModulos().stream().map(ModuloDTO::new).collect(Collectors.toSet()),
            curso.getAlunos().stream().map(AlunoDTO::new).collect(Collectors.toSet())
        );
    }
}