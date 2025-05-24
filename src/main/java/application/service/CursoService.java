package application.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Aluno;
import application.model.Curso;
import application.record.CursoDTO;
import application.repository.AlunoRepository;
import application.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepo;

    @Autowired
    private AlunoRepository alunoRepo;

    public Set<CursoDTO> getAll() {
        return cursoRepo.findAll().stream().map(CursoDTO::new).collect(Collectors.toSet());
    }

    public CursoDTO getById(Long id) {
        Optional<Curso> curso = cursoRepo.findById(id);
        if (curso.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }
        return new CursoDTO(curso.get());
    }

    public CursoDTO create(CursoDTO cursoDTO) {
        Curso curso = new Curso(cursoDTO);
        curso = cursoRepo.save(curso);
        return new CursoDTO(curso);
    }

    public CursoDTO update(Long id, CursoDTO cursoDTO) {
        Optional<Curso> cursoExistente = cursoRepo.findById(id);
        if (cursoExistente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }
        Curso curso = cursoExistente.get();
        curso.setNomeDoCurso(cursoDTO.nomeDoCurso());
        curso.setDescricao(cursoDTO.descricao());
        curso.setCargaHoraria(cursoDTO.cargaHoraria());
        curso = cursoRepo.save(curso);
        return new CursoDTO(curso);
    }

    public void delete(Long id) {
        if (!cursoRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado");
        }
        cursoRepo.deleteById(id);
    }
    public CursoDTO matricularAluno(Long cursoId, Long alunoId) {
    // Busca o curso e o aluno (simulando dependências)
    Curso curso = cursoRepo.findById(cursoId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));
    
    Aluno aluno = alunoRepo.findById(alunoId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));

    // Verifica se o aluno já está matriculado
    if (curso.getAlunos().contains(aluno)) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno já matriculado neste curso");
    }

    // Adiciona o aluno ao curso (JPA atualiza automaticamente a tabela `matriculas`)
    curso.getAlunos().add(aluno);
    cursoRepo.save(curso);

    return new CursoDTO(curso);
    }
} 