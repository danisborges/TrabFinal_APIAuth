package application.record;

import application.model.Aluno;

public record AlunoDTO(long id, String nomeDoAluno, String email, String senha) {
    public AlunoDTO(Aluno model) {
        this(model.getId(), model.getNomeDoAluno(), model.getEmail(), model.getSenha());
    }
}