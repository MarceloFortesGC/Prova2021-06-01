package prova.tarefas.entity;

import java.util.List;

import javax.persistence.*;
import lombok.*;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "cliente") //UM CLIENTE PODE TER VÁRIAS TAREFAS
    private List<Tarefa> tarefa;
}
