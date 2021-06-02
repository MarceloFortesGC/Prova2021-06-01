package prova.tarefas.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Tarefa {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarefa;

    @JsonIgnore
    @ManyToOne // MUITAS TAREFAS PODEM ESTAR COM UM ÚNICO CLIENTE
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
