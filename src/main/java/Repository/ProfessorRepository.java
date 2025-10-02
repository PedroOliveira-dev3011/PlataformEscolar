package Repository;

import Entities.ProfessorEntity;
import Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long>  {
    List<ProfessorEntity> findByNome(String nome);

    Optional<ProfessorEntity> findByDisciplina(String disciplina);

    Optional<ProfessorEntity> findById (Long id);


}
