package application.record;

import java.util.Set;
import java.util.stream.Collectors;

import application.model.Aluno;

public record AlunoDTO(
    Long id,
    String nomeDoAluno,
    String email,
    Set<CursoDTO> cursos
) {
    public AlunoDTO(Aluno aluno) {
        this(
            aluno.getId(),
            aluno.getNomeDoAluno(),
            aluno.getEmail(),
            aluno.getCursos() != null ? 
                aluno.getCursos().stream().map(CursoDTO::new).collect(Collectors.toSet()) 
                : Set.of()
        );
    }
}