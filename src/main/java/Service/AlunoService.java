package Service;

import Entities.AlunoEntity;
import Repository.AlunoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AlunoService {
    @Autowired
     private AlunoRepository alunoRepository;

    public List<AlunoEntity> listarTodos(){
        return alunoRepository.findAll();
    }

    public Optional<AlunoEntity> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public AlunoEntity salvarAluno(AlunoEntity aluno) {
        if (aluno.getNome() == null && aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do aluno é obrigatorio");
        }
        return alunoRepository.save(aluno);
    }
    public void deletarAlunoPorId(Long id){
        alunoRepository.deleteById(id);
    }


}
