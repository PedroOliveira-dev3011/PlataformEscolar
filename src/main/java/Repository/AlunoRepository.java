package Repository;

import Entities.AlunoEntity;
import Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
    List<AlunoEntity> findByNome (String nome);

    Optional<AlunoEntity> findById (Long id);

    List<AlunoEntity> findByNomeContainingIgnoreCase(String nome);


}
