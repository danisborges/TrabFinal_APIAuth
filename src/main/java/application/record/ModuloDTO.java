package application.record;

import application.model.Modulo;

public record ModuloDTO (long id, String tituloDoModulo, String descricao) {
    public ModuloDTO(Modulo model) {
        this(model.getId(), model.getTituloDoModulo(), model.getDescricao());

    }
}