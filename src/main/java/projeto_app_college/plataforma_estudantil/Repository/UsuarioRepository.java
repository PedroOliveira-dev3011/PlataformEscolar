package projeto_app_college.plataforma_estudantil.Repository;

import projeto_app_college.plataforma_estudantil.Entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    List<UsuarioEntity> findByNome(String nome);

   Optional<UsuarioEntity> findByEmail(String email);

    List<UsuarioEntity> findByNomeContainingIgnoreCase(String nome);

}
