package application.record;

import application.model.Modulo;

public record ModuloDTO(
    Long id,
    String tituloDoModulo,
    String descricao,
    Long cursoId  // ID do curso (evita recursão no JSON)
) {
    public ModuloDTO(Modulo modulo) {
        this(
            modulo.getId(),
            modulo.getTituloDoModulo(),
            modulo.getDescricao(),
            modulo.getCurso().getId()
        );
    }
}