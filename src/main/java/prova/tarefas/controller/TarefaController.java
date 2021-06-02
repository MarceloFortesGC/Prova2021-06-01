package prova.tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prova.tarefas.entity.Tarefa;
import prova.tarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    //  ENCONTRANDO TODAS AS TAREFAS
    @GetMapping("/")
    public List<Tarefa>findAll(){
        return tarefaService.getTarefa();
    }

    //  POSTANDO TAREFA
    @PostMapping("/")
    public Tarefa novaTarefa(@RequestBody Tarefa tarefa){
        tarefaService.saveTarefa(tarefa);
        return tarefa;
    }
    
    // DELETANDO TAREFA
    @DeleteMapping("/{id}")
    public String deleteTarefa(@PathVariable Long id){
        return tarefaService.deleteTarefa(id);
    }
}
