package projeto_app_college.plataforma_estudantil.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_professor", nullable = false)
    private String nome;

    @Column(name = "disciplina")
    private String disciplina;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<AlunoEntity> alunos = new ArrayList<>();

}
