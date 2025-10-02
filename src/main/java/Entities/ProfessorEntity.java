package Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_professor")
    private String nome;
    @Column(name = "disciplina")
    private String disciplina;

    @OneToOne
    @JoinColumn(name = "usuarios_id")
    private UsuarioEntity usuario;
}
