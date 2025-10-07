package projeto_app_college.plataforma_estudantil.Service;


import org.springframework.beans.factory.annotation.Autowired;
import projeto_app_college.plataforma_estudantil.Entities.UsuarioEntity;
import projeto_app_college.plataforma_estudantil.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuario(UsuarioEntity usuario){

        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> listarTodosUsuario(){
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public List<UsuarioEntity> buscarPorNome(String nome){
        return usuarioRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Optional<UsuarioEntity> buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    public UsuarioEntity atualizarUsuario(Long id, UsuarioEntity novosDados) {
        UsuarioEntity usuarioExistente = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario Não Encontrado"));

        usuarioExistente.setNome(novosDados.getNome());
        usuarioExistente.setSobrenome(novosDados.getSobrenome());
        usuarioExistente.setEmail(novosDados.getEmail());
        usuarioExistente.setSenha(novosDados.getSenha());
        usuarioExistente.setCep(novosDados.getCep());
        usuarioExistente.setTelefone(novosDados.getTelefone());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
