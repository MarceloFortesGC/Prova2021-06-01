package prova.tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import prova.tarefas.entity.Tarefa;
import prova.tarefas.repository.TarefaRepository;

public class TarefaService {

    @Autowired 
    TarefaRepository tarefaRepository;

    //  LISTANDO TAREFAS
    public List<Tarefa> getTarefa(){
        return tarefaRepository.findAll();
    }

    //  POSTANDO UMA TAREFA
    public void saveTarefa(Tarefa tarefa){
        tarefaRepository.save(tarefa);
    }

    //  ATUALIZANDO TAREFA
    public Tarefa updateTarefa(Long id, Tarefa tarefa){
        return tarefaRepository.findById(id).map(updatedTarefa -> {
            updatedTarefa.setTarefa(tarefa.getTarefa());

            return tarefaRepository.save(updatedTarefa);
        }).orElseGet(() -> {
            tarefa.setId(id);
            return tarefaRepository.save(tarefa);
        });
    }

    //  DELETE TAREFA
    public String deleteTarefa(Long id){
        tarefaRepository.deleteById(id);
        return "Tarefa deletada com sucesso";
    }
}
